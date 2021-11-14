package fr.diginamic.openfoodfacts.manager;

import fr.diginamic.openfoodfacts.dao.IngredientDao;
import fr.diginamic.openfoodfacts.entity.Ingredient;

import javax.persistence.EntityManager;

/**
 * Service for Ingredient process functions.
 *
 * @author Tibo Pfeifer
 * @version 1.0
 * @date 14/11/2021
 */
public class IngredientService extends EntiteService<Ingredient>{


    /**
     * Instantiates a new Ingredient service.
     *
     * @param em the Entity Manager
     */
    public IngredientService(EntityManager em) {
        super(Ingredient.class, new IngredientDao(em));
    }
}