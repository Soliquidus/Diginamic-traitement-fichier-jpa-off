package fr.diginamic.openfoodfacts.entite;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Class Additif
 *
 * @author Tibo Pfeifer
 * @version 1.0
 * @date 13/11/2021
 */
@Entity
@Table(name = "Additif")
public class Additif extends Entite {

    /**
     * The Products.
     */
    @ManyToMany
    @JoinTable(name = "add_in_produit",
            joinColumns = @JoinColumn(name = "id_additif", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_produit", referencedColumnName = "id"))
    private List<Produit> produits = new ArrayList<>();

    /**
     * Instantiates a new Additif.
     *
     * @param nom the nom
     */
    public Additif(String nom) {
        super(nom);
    }

    /**
     * Instantiates a new Additif for Hibernate.
     */
    public Additif() {

    }

    /**
     * Gets produits.
     *
     * @return the produits
     */
    public List<Produit> getProduits() {
        return produits;
    }

    /**
     * Sets produits.
     *
     * @param produits the produits
     */
    public void setProduits(List<Produit> produits) {
        this.produits = produits;
    }
}