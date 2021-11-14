package fr.diginamic.openfoodfacts.manager;

import fr.diginamic.openfoodfacts.dao.ProduitDao;
import fr.diginamic.openfoodfacts.entity.Produit;

import javax.persistence.EntityManager;

/**
 * Service for products process functions.
 *
 * @author Tibo Pfeifer
 * @version 1.0
 * @date 14/11/2021
 */
public class ProduitService {

    /**
     * The Product DAO.
     */
    private final ProduitDao productDao;

    /**
     * Instantiates a new Product service.
     *
     * @param em the em
     */
    public ProduitService(EntityManager em) {
        this.productDao = new ProduitDao(em);
    }

    /**
     * Insert product in database.
     *
     * @param product the product to insert
     */
    public void insertProduct(Produit product) {
        Produit startEntity = productDao.findProduct(product.getNom(), product.getMarque());
        if(startEntity != null){
            return;
        }
        productDao.insertEntity(product);
    }
}