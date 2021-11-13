package fr.diginamic.petstore.entite;

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
 * @date 13/11/2021
 */
@Entity
@Table(name = "Categorie")
public class Categorie extends Entite {

    @OneToMany(mappedBy = "categorie")
    private List<Produit> produits = new ArrayList<>();

    /**
     * Instantiates a new Categorie.
     *
     * @param nom the nom
     */
    public Categorie(String nom) {
        super(nom);
    }

    /**
     * Instantiates a new Categorie for Hibernate.
     */
    public Categorie() {

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