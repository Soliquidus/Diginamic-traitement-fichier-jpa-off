package fr.diginamic.petstore.entite;

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
     * Instantiates a new Marque for Hibernate.
     */
    public Marque() {
    }

    /**
     * Instantiates a new Marque.
     *
     * @param nom the nom
     */
    public Marque(String nom) {
        super(nom);
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