package fr.diginamic.petstore.entite;

import javax.persistence.*;

/**
 * Entité métier
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
     * The Nom.
     */
    protected String nom;

    /**
     * Instantiates a new Entite.
     */
    public Entite() {
    }

    /**
     * Instantiates a new Entite.
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
     * Gets nom.
     *
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * Sets nom.
     *
     * @param nom the nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }
}