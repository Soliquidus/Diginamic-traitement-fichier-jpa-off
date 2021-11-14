package fr.diginamic.openfoodfacts.utils;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 * Util class to get an EntityManager instance without having to configure it each time
 *
 * @author Tibo Pfeifer
 * @version 1.0
 * @date 09/11/2021
 */
public class HibernateUtil {

    /** The em. */
    private static EntityManager em;

    /** The persistance. */
    private static String PERSISTANCE;

    {
        PERSISTANCE = "openFoodFacts";
    }

    /**
     * Instantiates a new connection DB.
     */
    private HibernateUtil() {
        em = Persistence.createEntityManagerFactory(PERSISTANCE).createEntityManager();
    }

    /**
     * Gets the single instance of ConnectionDB.
     *
     * @return single instance of ConnectionDB
     */
    public static EntityManager getInstance() {
        if (em == null || !em.isOpen())
            new HibernateUtil();
        return em;
    }
}
