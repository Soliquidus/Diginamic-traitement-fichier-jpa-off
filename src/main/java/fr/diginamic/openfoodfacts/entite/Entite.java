package fr.diginamic.openfoodfacts.entite;

import javax.persistence.*;

/**
 * Main Entity
 *
 * @author Tibo Pfeifer
 * @version 1.0
 * @date 13/11/2021
 */
@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Entite {

    /**
     * The Id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    /**
     * The Name.
     */
    protected String nom;

    /**
     * Instantiates a new Entity.
     */
    public Entite() {
    }

    /**
     * Instantiates a new Entity.
     *
     * @param nom the nom
     */
    public Entite(String nom) {
        this.nom = nom;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getNom() {
        return nom;
    }

    /**
     * Sets name.
     *
     * @param nom the name
     */
    public void setNom(String nom) {
        this.nom = nom;
    }
}