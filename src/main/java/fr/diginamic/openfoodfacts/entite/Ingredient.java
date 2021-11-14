package fr.diginamic.openfoodfacts.entite;

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
}