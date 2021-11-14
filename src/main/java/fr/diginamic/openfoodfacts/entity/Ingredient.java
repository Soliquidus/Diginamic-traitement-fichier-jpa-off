package fr.diginamic.openfoodfacts.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Class Ingredient
 *
 * @author Tibo Pfeifer
 * @version 1.0
 * @date 13/11/2021
 */
@Entity
@Table(name = "Ingredient")
public class Ingredient extends Entite{

    /**
     * Instantiates a new Ingredient.
     *
     * @param nom the name
     */
    public Ingredient(String nom) {
        super(nom);
    }

    /**
     * Instantiates a new Ingredient for Hibernate.
     */
    public Ingredient() {

    }

    //HashCode and equals function to solve the possible Primary Key issues.
    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(this.nom).toHashCode();
    }

    @Override
    public boolean equals(Object obj) {

        if (!(obj instanceof Ingredient)) {
            return false;
        }
        Ingredient autre = (Ingredient) obj;
        return new EqualsBuilder().append(this.nom, autre.getNom()).isEquals();
    }
}