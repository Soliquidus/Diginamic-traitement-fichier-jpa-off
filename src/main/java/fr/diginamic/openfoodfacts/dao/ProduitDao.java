package fr.diginamic.openfoodfacts.dao;

import fr.diginamic.openfoodfacts.entite.Marque;
import fr.diginamic.openfoodfacts.entite.Produit;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Products persistence management.
 *
 * @author Tibo Pfeifer
 * @version 1.0
 * @date 14 /11/2021
 */
public class ProduitDao extends EntiteDao<Produit> {

    /**
     * Instantiates a new Entity DAO.
     *
     * @param em the Entity Manager
     */
    public ProduitDao(EntityManager em) {
        super(em, Produit.class);
    }

    /**
     * Search a product with its given name et brand.
     *
     * @param name  the name
     * @param brand the brand
     * @return the produit
     */
    public Produit findProduct(String name, Marque brand){
        TypedQuery<Produit> query = em.createQuery("FROM Produit WHERE nom=:nom AND marque=:marque", eCLass);
        query.setParameter("nom", name);
        query.setParameter("marque", brand);

        List<Produit> produits = query.getResultList();
        if(produits.isEmpty()){
            return null;
        }
        return produits.get(0);
    }
}