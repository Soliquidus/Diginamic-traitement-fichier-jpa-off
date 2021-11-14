package fr.diginamic.openfoodfacts.manager;

import fr.diginamic.openfoodfacts.dao.AdditifDao;
import fr.diginamic.openfoodfacts.entity.Additif;

import javax.persistence.EntityManager;

/**
 * Service for Additif process functions.
 *
 * @author Tibo Pfeifer
 * @version 1.0
 * @date 14/11/2021
 */
public class AdditifService extends EntiteService<Additif>{


    /**
     * Instantiates a new Additif service.
     *
     * @param em the Entity Manager
     */
    public AdditifService(EntityManager em) {
        super(Additif.class, new AdditifDao(em));
    }
}