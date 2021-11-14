package fr.diginamic.openfoodfacts.manager;

import fr.diginamic.openfoodfacts.dao.EntiteDao;
import fr.diginamic.openfoodfacts.entity.Entite;

import java.util.HashMap;
import java.util.Map;

/**
 * Main service class containing several process functions in common
 * with entities like products, categories and other.
 *
 * @param <E> the Entity parameter
 * @author Tibo Pfeifer
 * @version 1.0
 * @date 14 /11/2021
 */
public abstract class EntiteService<E extends Entite> {

    /**
     * The Entity's class.
     */
    protected Class<E> eClass;
    /**
     * The Entity DAO.
     */
    protected EntiteDao<E> entityDao;
    /**
     * The Entities.
     */
    protected Map<String, E> entities = new HashMap<>();

    /**
     * Instantiates a new Entity service.
     *
     * @param eClass    the Entity's class
     * @param entityDao the Entity DAO
     */
    public EntiteService(Class<E> eClass, EntiteDao<E> entityDao) {
        super();
        this.eClass = eClass;
        this.entityDao = entityDao;
    }

    /**
     * Insert entity in database.
     *
     * @param entity the entity
     */
    public void insertEntity(E entity) {

        E startEntity = entities.get(entity.getNom());

        if (startEntity != null) {
            entity.setId(startEntity.getId());
        }
        startEntity = entityDao.find(entity.getNom());
        if (startEntity == null) {
            entityDao.insertEntity(entity);
            entities.put(entity.getNom(), entity);
        } else {
            entity.setId(startEntity.getId());
        }
    }
}