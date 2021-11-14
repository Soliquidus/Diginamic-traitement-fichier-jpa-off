package fr.diginamic.openfoodfacts.dao;

import fr.diginamic.openfoodfacts.entite.Allergene;

import javax.persistence.EntityManager;

/**
 * Allergen persistence management.
 *
 * @author Tibo Pfeifer
 * @version 1.0
 * @date 14/11/2021
 */
public class AllergeneDao extends EntiteDao<Allergene> {

    /**
     * Instantiates a new Allergen DAO.
     *
     * @param em the Entity Manager
     */
    public AllergeneDao(EntityManager em) {
        super(em, Allergene.class);
    }
}