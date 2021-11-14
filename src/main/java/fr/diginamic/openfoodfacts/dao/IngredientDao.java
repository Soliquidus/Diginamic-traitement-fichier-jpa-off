package fr.diginamic.openfoodfacts.dao;

import fr.diginamic.openfoodfacts.entite.Ingredient;

import javax.persistence.EntityManager;

/**
 * Ingredient persistence management.
 *
 * @author Tibo Pfeifer
 * @version 1.0
 * @date 14/11/2021
 */
public class IngredientDao extends EntiteDao<Ingredient> {

    /**
     * Instantiates a new Ingredient DAO.
     *
     * @param em the Entity Manager
     */
    public IngredientDao(EntityManager em) {
        super(em, Ingredient.class);
    }
}