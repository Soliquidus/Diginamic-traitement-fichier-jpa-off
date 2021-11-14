package fr.diginamic.openfoodfacts.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

/**
 * Class Marque
 *
 * @author Tibo Pfeifer
 * @version 1.0
 * @date 13/11/2021
 */
@Entity
@Table(name = "Marque")
public class Marque extends Entite{

    @OneToMany(mappedBy = "marque")
    private List<Produit> produits = new ArrayList<>();

    /**
     * Instantiates a new Brand for Hibernate.
     */
    public Marque() {
    }

    /**
     * Instantiates a new Brand.
     *
     * @param nom the name
     */
    public Marque(String nom) {
        super(nom);
    }

    /**
     * Gets products.
     *
     * @return the products
     */
    public List<Produit> getProduits() {
        return produits;
    }

    /**
     * Sets products.
     *
     * @param produits the products
     */
    public void setProduits(List<Produit> produits) {
        this.produits = produits;
    }

    //HashCode and equals function to solve the possible Primary Key issues.
    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(this.nom).toHashCode();
    }

    @Override
    public boolean equals(Object obj) {

        if (!(obj instanceof Marque)) {
            return false;
        }
        Marque autre = (Marque) obj;
        return new EqualsBuilder().append(this.nom, autre.getNom()).isEquals();
    }
}