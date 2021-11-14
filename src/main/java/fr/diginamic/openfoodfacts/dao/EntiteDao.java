package fr.diginamic.openfoodfacts.dao;

import fr.diginamic.openfoodfacts.entite.Entite;
import fr.diginamic.openfoodfacts.utils.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Main DAO class.
 *
 * @param <E> the type parameter
 * @author Tibo Pfeifer
 * @version 1.0
 * @date 14/11/2021
 */
public abstract class EntiteDao<E extends Entite> {

    /**
     * The Entity Manager.
     */
    protected static EntityManager em = HibernateUtil.getInstance();
    /**
     * The Entity class.
     */
    protected Class<E> eCLass;

    /**
     * Instantiates a new Entity DAO.
     *
     * @param em     the Entity Manager
     * @param eCLass the Entity Class
     */
    public EntiteDao(EntityManager em, Class<E> eCLass) {
        EntiteDao.em = em;
        this.eCLass = eCLass;
    }

    /**
     * Insert entity.
     *
     * @param entity the entity
     */
    public void insertEntity(E entity) {
        em.persist(entity);
    }

    /**
     * Find e.
     *
     * @param entityName the entity name
     * @return the e
     */
    public E find(String entityName) {
        TypedQuery<E> query = em.createQuery("FROM " + eCLass.getSimpleName() + " WHERE nom=:nom", eCLass);
        query.setParameter("nom", entityName);

        List<E> entity = query.getResultList();
        if (entity.isEmpty()) {
            return null;
        }
        return entity.get(0);
    }
}