package fr.diginamic.openfoodfacts.entite;

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
    private List<Produit> produits = new ArrayList<>();

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
}