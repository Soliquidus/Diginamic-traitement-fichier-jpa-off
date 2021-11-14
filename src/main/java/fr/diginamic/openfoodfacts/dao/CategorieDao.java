package fr.diginamic.openfoodfacts.dao;

import fr.diginamic.openfoodfacts.entite.Categorie;

import javax.persistence.EntityManager;

/**
 * Category persistence management.
 *
 * @author Tibo Pfeifer
 * @version 1.0
 * @date 14/11/2021
 */
public class CategorieDao extends EntiteDao<Categorie> {

    /**
     * Instantiates a new Category DAO.
     *
     * @param em the Entity Manager
     */
    public CategorieDao(EntityManager em) {
        super(em, Categorie.class);
    }
}