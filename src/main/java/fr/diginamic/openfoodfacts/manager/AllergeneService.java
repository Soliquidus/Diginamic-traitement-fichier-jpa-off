package fr.diginamic.openfoodfacts.manager;

import fr.diginamic.openfoodfacts.dao.AllergeneDao;
import fr.diginamic.openfoodfacts.entity.Allergene;

import javax.persistence.EntityManager;

/**
 * Service for Allergen process functions.
 *
 * @author Tibo Pfeifer
 * @version 1.0
 * @date 14/11/2021
 */
public class AllergeneService extends EntiteService<Allergene>{


    /**
     * Instantiates a new Allergen service.
     *
     * @param em the Entity Manager
     */
    public AllergeneService(EntityManager em) {
        super(Allergene.class, new AllergeneDao(em));
    }
}