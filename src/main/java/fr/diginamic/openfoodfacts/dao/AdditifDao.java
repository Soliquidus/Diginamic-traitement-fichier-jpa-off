package fr.diginamic.openfoodfacts.dao;

import fr.diginamic.openfoodfacts.entity.Additif;

import javax.persistence.EntityManager;

/**
 * Additif persistence management.
 *
 * @author Tibo Pfeifer
 * @version 1.0
 * @date 14/11/2021
 */
public class AdditifDao extends EntiteDao<Additif> {

    /**
     * Instantiates a new Additif DAO.
     *
     * @param em the Entity Manager
     */
    public AdditifDao(EntityManager em) {
        super(em, Additif.class);
    }
}