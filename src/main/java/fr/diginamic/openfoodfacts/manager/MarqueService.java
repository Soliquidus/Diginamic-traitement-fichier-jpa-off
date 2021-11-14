package fr.diginamic.openfoodfacts.manager;

import fr.diginamic.openfoodfacts.dao.MarqueDao;
import fr.diginamic.openfoodfacts.entity.Marque;

import javax.persistence.EntityManager;

/**
 * Service for Brand process functions.
 *
 * @author Tibo Pfeifer
 * @version 1.0
 * @date 14/11/2021
 */
public class MarqueService extends EntiteService<Marque>{


    /**
     * Instantiates a new Marque service.
     *
     * @param em the Entity Manager
     */
    public MarqueService(EntityManager em) {
        super(Marque.class, new MarqueDao(em));
    }
}