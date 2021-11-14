package fr.diginamic.openfoodfacts.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

/**
 * Entité catégorie d'un produit
 *
 * @author Tibo Pfeifer
 * @version 1.0
 * @date 13 /11/2021
 */
@Entity
@Table(name = "Categorie")
public class Categorie extends Entite {

    /**
     * The Products.
     */
    @OneToMany(mappedBy = "categorie")
    private List<Produit> products = new ArrayList<>();

    /**
     * Instantiates a new Category.
     *
     * @param nom the nom
     */
    public Categorie(String nom) {
        super(nom);
    }

    /**
     * Instantiates a new Category for Hibernate.
     */
    public Categorie() {

    }

    /**
     * Gets product.
     *
     * @return the product
     */
    public List<Produit> getProduits() {
        return products;
    }

    /**
     * Sets products.
     *
     * @param products the products
     */
    public void setProduits(List<Produit> products) {
        this.products = products;
    }

    //HashCode and equals function to solve the possible Primary Key issues.-
    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(this.nom).toHashCode();
    }

    @Override
    public boolean equals(Object obj) {

        if (!(obj instanceof Categorie)) {
            return false;
        }
        Categorie autre = (Categorie) obj;
        return new EqualsBuilder().append(this.nom, autre.getNom()).isEquals();
    }
}