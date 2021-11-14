package fr.diginamic.openfoodfacts.manager;

import fr.diginamic.openfoodfacts.entity.Additif;
import fr.diginamic.openfoodfacts.entity.Allergene;
import fr.diginamic.openfoodfacts.entity.Ingredient;
import fr.diginamic.openfoodfacts.entity.Produit;
import fr.diginamic.openfoodfacts.utils.HibernateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;

/**
 * Product process management.
 *
 * @author Tibo Pfeifer
 * @version 1.0
 * @date 14/11/2021
 */
public class ProduitManager {

    /**
     * The constant LOGGER.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(ProduitManager.class);
    /**
     * The Em.
     */
    private EntityManager em;
    /**
     * The Category service.
     */
    private final CategorieService categoryService;
    /**
     * The Brand service.
     */
    private final MarqueService brandService;
    /**
     * The Product service.
     */
    private final ProduitService productService;
    /**
     * The Additif service.
     */
    private final AdditifService additifService;
    /**
     * The Allergen service.
     */
    private final AllergeneService allergenService;
    /**
     * The Ingredient service.
     */
    private final IngredientService ingredientService;

    /**
     * Instantiates a new Produit manager.
     */
    public ProduitManager() {
        em = HibernateUtil.getInstance();
        categoryService = new CategorieService(em);
        brandService = new MarqueService(em);
        productService = new ProduitService(em);
        additifService = new AdditifService(em);
        allergenService = new AllergeneService(em);
        ingredientService = new IngredientService(em);
    }

    /**
     * Function for product process, including all the other data linked to it.
     *
     * @param product the product
     */
    public void processProduct(Produit product) {

        LOGGER.debug("Product " + product.getNom());

        em.getTransaction().begin();

        categoryService.insertEntity(product.getCategorie());
        brandService.insertEntity(product.getMarque());

        for (Ingredient ingredient : product.getIngredients()) {
            ingredientService.insertEntity(ingredient);
        }
        for (Additif additif : product.getAdditifs()) {
            additifService.insertEntity(additif);
        }
        for (Allergene allergen : product.getAllergenes()) {
            allergenService.insertEntity(allergen);
        }

        productService.insertProduct(product);

        em.getTransaction().commit();
    }

    /**
     * Close session.
     */
    public void close(){
        em.close();
    }
}