package fr.diginamic.openfoodfacts.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

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
     * Instantiates a new Allergen.
     *
     * @param nom the nom
     */
    public Allergene(String nom) {
        super(nom);
    }

    /**
     * Instantiates a new Allergen for Hibernate.
     */
    public Allergene() {

    }

    //HashCode and equals function to solve the possible Primary Key issues.
    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(this.nom).toHashCode();
    }

    @Override
    public boolean equals(Object obj) {

        if (!(obj instanceof Allergene)) {
            return false;
        }
        Allergene autre = (Allergene) obj;
        return new EqualsBuilder().append(this.nom, autre.getNom()).isEquals();
    }
}