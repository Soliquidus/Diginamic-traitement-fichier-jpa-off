package fr.diginamic.petstore.entite;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Class Allergene
 *
 * @author Tibo Pfeifer
 * @version 1.0
 * @date 13 /11/2021
 */
@Entity
@Table(name = "Allergene")
public class Allergene extends Entite{

    /**
     * Instantiates a new Allergene.
     *
     * @param nom the nom
     */
    public Allergene(String nom) {
        super(nom);
    }

    /**
     * Instantiates a new Allergene for Hibernate.
     */
    public Allergene() {

    }
}