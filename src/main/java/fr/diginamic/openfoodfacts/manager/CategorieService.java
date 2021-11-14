package fr.diginamic.openfoodfacts.manager;

import fr.diginamic.openfoodfacts.dao.CategorieDao;
import fr.diginamic.openfoodfacts.entity.Categorie;

import javax.persistence.EntityManager;

/**
 * Service for Category process functions.
 *
 * @author Tibo Pfeifer
 * @version 1.0
 * @date 14/11/2021
 */
public class CategorieService extends EntiteService<Categorie>{


    /**
     * Instantiates a new Category service.
     *
     * @param em the Entity Manager
     */
    public CategorieService(EntityManager em) {
        super(Categorie.class, new CategorieDao(em));
    }
}