package fr.diginamic.openfoodfacts.dao;

import fr.diginamic.openfoodfacts.entite.Marque;

import javax.persistence.EntityManager;

/**
 * Brand persistence management.
 *
 * @author Tibo Pfeifer
 * @version 1.0
 * @date 14/11/2021
 */
public class MarqueDao extends EntiteDao<Marque> {

    /**
     * Instantiates a new Brand DAO.
     *
     * @param em     the Entity Manager
     */
    public MarqueDao(EntityManager em) {
        super(em, Marque.class);
    }
}