package fr.diginamic.openfoodfacts.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Class Produit
 *
 * @author Tibo Pfeifer
 * @version 1.0
 * @date 13/11/2021
 */
@Entity
@Table(name = "Produit")
public class Produit extends Entite {

    /**
     * The Category.
     */
    @ManyToOne
    @JoinColumn(name = "id_categorie")
    private Categorie categorie;

    /**
     * The Brand.
     */
    @ManyToOne
    @JoinColumn(name = "id_marque")
    private Marque marque;

    /**
     * The Ingredients.
     */
    @ManyToMany
    @JoinTable(name = "ingredient_in_produit",
            joinColumns = @JoinColumn(name = "id_produit", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_ingredient", referencedColumnName = "id"))
    private Set<Ingredient> ingredients = new HashSet<>();

    /**
     * The Additifs.
     */
    @ManyToMany
    @JoinTable(name = "additif_in_produit",
            joinColumns = @JoinColumn(name = "id_produit", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_additif", referencedColumnName = "id"))
    private Set<Additif> additifs = new HashSet<>();

    /**
     * The Allergens.
     */
    @ManyToMany
    @JoinTable(name = "allergene_in_produit",
            joinColumns = @JoinColumn(name = "id_produit", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_allergene", referencedColumnName = "id"))
    private Set<Allergene> allergenes = new HashSet<>();

    /**
     * The Grade.
     */
    private String grade;
    /**
     * The Energy for 100 g.
     */
    private Double energie100g;
    /**
     * The Fat for 100 g.
     */
    private Double graisse100g;
    /**
     * The Sugar for 100 g.
     */
    private Double sucres100g;
    /**
     * The Fibres for 100 g.
     */
    private Double fibres100g;
    /**
     * The Proteins for 100 g.
     */
    private Double proteines100g;
    /**
     * The Salt for 100 g.
     */
    private Double sel100g;
    /**
     * The Vit a 100 g.
     */
    private Double vitA100g;
    /**
     * The Vit d 100 g.
     */
    private Double vitD100g;
    /**
     * The Vit e 100 g.
     */
    private Double vitE100g;
    /**
     * The Vit k 100 g.
     */
    private Double vitK100g;
    /**
     * The Vit c 100 g.
     */
    private Double vitC100g;
    /**
     * The Vit b 1100 g.
     */
    private Double vitB1100g;
    /**
     * The Vit b 2100 g.
     */
    private Double vitB2100g;
    /**
     * The Vit pp 100 g.
     */
    private Double vitPP100g;
    /**
     * The Vit b 6100 g.
     */
    private Double vitB6100g;
    /**
     * The Vit b 9100 g.
     */
    private Double vitB9100g;
    /**
     * The Vit b 12100 g.
     */
    private Double vitB12100g;
    /**
     * The Calcium 100 g.
     */
    private Double calcium100g;
    /**
     * The Magnesium 100 g.
     */
    private Double magnesium100g;
    /**
     * The Iron 100 g.
     */
    private Double iron100g;
    /**
     * The Fer 100 g.
     */
    private Double fer100g;
    /**
     * The Beta carotene 100 g.
     */
    private Double betaCarotene100g;
    /**
     * The Presence of palm oil.
     */
    private String presenceHuilePalme;

    /**
     * Instantiates a new Produit.
     */
    public Produit(){

    }

    /**
     * Instantiates a new Produit.
     *
     * @param nom the nom
     */
    public Produit(String nom) {
        super(nom);
    }

    //HashCode and equals function to solve the possible Primary Key issues.
    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(this.nom).toHashCode();
    }

    @Override
    public boolean equals(Object obj) {

        if (!(obj instanceof Produit)) {
            return false;
        }
        Produit autre = (Produit) obj;
        return new EqualsBuilder().append(this.nom, autre.getNom()).isEquals();
    }

    /**
     * Gets categorie.
     *
     * @return the categorie
     */
    public Categorie getCategorie() {
        return categorie;
    }

    /**
     * Sets categorie.
     *
     * @param categorie the categorie
     */
    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    /**
     * Gets marque.
     *
     * @return the marque
     */
    public Marque getMarque() {
        return marque;
    }

    /**
     * Sets marque.
     *
     * @param marque the marque
     */
    public void setMarque(Marque marque) {
        this.marque = marque;
    }

    /**
     * Gets ingredients.
     *
     * @return the ingredients
     */
    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    /**
     * Sets ingredients.
     *
     * @param ingredients the ingredients
     */
    public void setIngredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    /**
     * Gets additifs.
     *
     * @return the additifs
     */
    public Set<Additif> getAdditifs() {
        return additifs;
    }

    /**
     * Sets additifs.
     *
     * @param additifs the additifs
     */
    public void setAdditifs(Set<Additif> additifs) {
        this.additifs = additifs;
    }

    /**
     * Gets allergenes.
     *
     * @return the allergenes
     */
    public Set<Allergene> getAllergenes() {
        return allergenes;
    }

    /**
     * Sets allergenes.
     *
     * @param allergenes the allergenes
     */
    public void setAllergenes(Set<Allergene> allergenes) {
        this.allergenes = allergenes;
    }

    /**
     * Gets grade.
     *
     * @return the grade
     */
    public String getGrade() {
        return grade;
    }

    /**
     * Sets grade.
     *
     * @param grade the grade
     */
    public void setGrade(String grade) {
        this.grade = grade;
    }

    /**
     * Gets energie 100 g.
     *
     * @return the energie 100 g
     */
    public Double getEnergie100g() {
        return energie100g;
    }

    /**
     * Sets energie 100 g.
     *
     * @param energie100g the energie 100 g
     */
    public void setEnergie100g(Double energie100g) {
        this.energie100g = energie100g;
    }

    /**
     * Gets graisse 100 g.
     *
     * @return the graisse 100 g
     */
    public Double getGraisse100g() {
        return graisse100g;
    }

    /**
     * Sets graisse 100 g.
     *
     * @param graisse100g the graisse 100 g
     */
    public void setGraisse100g(Double graisse100g) {
        this.graisse100g = graisse100g;
    }

    /**
     * Gets sucres 100 g.
     *
     * @return the sucres 100 g
     */
    public Double getSucres100g() {
        return sucres100g;
    }

    /**
     * Sets sucres 100 g.
     *
     * @param sucres100g the sucres 100 g
     */
    public void setSucres100g(Double sucres100g) {
        this.sucres100g = sucres100g;
    }

    /**
     * Gets fibres 100 g.
     *
     * @return the fibres 100 g
     */
    public Double getFibres100g() {
        return fibres100g;
    }

    /**
     * Sets fibres 100 g.
     *
     * @param fibres100g the fibres 100 g
     */
    public void setFibres100g(Double fibres100g) {
        this.fibres100g = fibres100g;
    }

    /**
     * Gets proteines 100 g.
     *
     * @return the proteines 100 g
     */
    public Double getProteines100g() {
        return proteines100g;
    }

    /**
     * Sets proteines 100 g.
     *
     * @param proteines100g the proteines 100 g
     */
    public void setProteines100g(Double proteines100g) {
        this.proteines100g = proteines100g;
    }

    /**
     * Gets sel 100 g.
     *
     * @return the sel 100 g
     */
    public Double getSel100g() {
        return sel100g;
    }

    /**
     * Sets sel 100 g.
     *
     * @param sel100g the sel 100 g
     */
    public void setSel100g(Double sel100g) {
        this.sel100g = sel100g;
    }

    /**
     * Gets vit a 100 g.
     *
     * @return the vit a 100 g
     */
    public Double getVitA100g() {
        return vitA100g;
    }

    /**
     * Sets vit a 100 g.
     *
     * @param vitA100g the vit a 100 g
     */
    public void setVitA100g(Double vitA100g) {
        this.vitA100g = vitA100g;
    }

    /**
     * Gets vit d 100 g.
     *
     * @return the vit d 100 g
     */
    public Double getVitD100g() {
        return vitD100g;
    }

    /**
     * Sets vit d 100 g.
     *
     * @param vitD100g the vit d 100 g
     */
    public void setVitD100g(Double vitD100g) {
        this.vitD100g = vitD100g;
    }

    /**
     * Gets vit e 100 g.
     *
     * @return the vit e 100 g
     */
    public Double getVitE100g() {
        return vitE100g;
    }

    /**
     * Sets vit e 100 g.
     *
     * @param vitE100g the vit e 100 g
     */
    public void setVitE100g(Double vitE100g) {
        this.vitE100g = vitE100g;
    }

    /**
     * Gets vit k 100 g.
     *
     * @return the vit k 100 g
     */
    public Double getVitK100g() {
        return vitK100g;
    }

    /**
     * Sets vit k 100 g.
     *
     * @param vitK100g the vit k 100 g
     */
    public void setVitK100g(Double vitK100g) {
        this.vitK100g = vitK100g;
    }

    /**
     * Gets vit c 100 g.
     *
     * @return the vit c 100 g
     */
    public Double getVitC100g() {
        return vitC100g;
    }

    /**
     * Sets vit c 100 g.
     *
     * @param vitC100g the vit c 100 g
     */
    public void setVitC100g(Double vitC100g) {
        this.vitC100g = vitC100g;
    }

    /**
     * Gets vit b 1100 g.
     *
     * @return the vit b 1100 g
     */
    public Double getVitB1100g() {
        return vitB1100g;
    }

    /**
     * Sets vit b 1100 g.
     *
     * @param vitB1100g the vit b 1100 g
     */
    public void setVitB1100g(Double vitB1100g) {
        this.vitB1100g = vitB1100g;
    }

    /**
     * Gets vit b 2100 g.
     *
     * @return the vit b 2100 g
     */
    public Double getVitB2100g() {
        return vitB2100g;
    }

    /**
     * Sets vit b 2100 g.
     *
     * @param vitB2100g the vit b 2100 g
     */
    public void setVitB2100g(Double vitB2100g) {
        this.vitB2100g = vitB2100g;
    }

    /**
     * Gets vit pp 100 g.
     *
     * @return the vit pp 100 g
     */
    public Double getVitPP100g() {
        return vitPP100g;
    }

    /**
     * Sets vit pp 100 g.
     *
     * @param vitPP100g the vit pp 100 g
     */
    public void setVitPP100g(Double vitPP100g) {
        this.vitPP100g = vitPP100g;
    }

    /**
     * Gets vit b 6100 g.
     *
     * @return the vit b 6100 g
     */
    public Double getVitB6100g() {
        return vitB6100g;
    }

    /**
     * Sets vit b 6100 g.
     *
     * @param vitB6100g the vit b 6100 g
     */
    public void setVitB6100g(Double vitB6100g) {
        this.vitB6100g = vitB6100g;
    }

    /**
     * Gets vit b 9100 g.
     *
     * @return the vit b 9100 g
     */
    public Double getVitB9100g() {
        return vitB9100g;
    }

    /**
     * Sets vit b 9100 g.
     *
     * @param vitB9100g the vit b 9100 g
     */
    public void setVitB9100g(Double vitB9100g) {
        this.vitB9100g = vitB9100g;
    }

    /**
     * Gets vit b 12100 g.
     *
     * @return the vit b 12100 g
     */
    public Double getVitB12100g() {
        return vitB12100g;
    }

    /**
     * Sets vit b 12100 g.
     *
     * @param vitB12100g the vit b 12100 g
     */
    public void setVitB12100g(Double vitB12100g) {
        this.vitB12100g = vitB12100g;
    }

    /**
     * Gets calcium 100 g.
     *
     * @return the calcium 100 g
     */
    public Double getCalcium100g() {
        return calcium100g;
    }

    /**
     * Sets calcium 100 g.
     *
     * @param calcium100g the calcium 100 g
     */
    public void setCalcium100g(Double calcium100g) {
        this.calcium100g = calcium100g;
    }

    /**
     * Gets magnesium 100 g.
     *
     * @return the magnesium 100 g
     */
    public Double getMagnesium100g() {
        return magnesium100g;
    }

    /**
     * Sets magnesium 100 g.
     *
     * @param magnesium100g the magnesium 100 g
     */
    public void setMagnesium100g(Double magnesium100g) {
        this.magnesium100g = magnesium100g;
    }

    /**
     * Gets iron 100 g.
     *
     * @return the iron 100 g
     */
    public Double getIron100g() {
        return iron100g;
    }

    /**
     * Sets iron 100 g.
     *
     * @param iron100g the iron 100 g
     */
    public void setIron100g(Double iron100g) {
        this.iron100g = iron100g;
    }

    /**
     * Gets fer 100 g.
     *
     * @return the fer 100 g
     */
    public Double getFer100g() {
        return fer100g;
    }

    /**
     * Sets fer 100 g.
     *
     * @param fer100g the fer 100 g
     */
    public void setFer100g(Double fer100g) {
        this.fer100g = fer100g;
    }

    /**
     * Gets beta carotene 100 g.
     *
     * @return the beta carotene 100 g
     */
    public Double getBetaCarotene100g() {
        return betaCarotene100g;
    }

    /**
     * Sets beta carotene 100 g.
     *
     * @param betaCarotene100g the beta carotene 100 g
     */
    public void setBetaCarotene100g(Double betaCarotene100g) {
        this.betaCarotene100g = betaCarotene100g;
    }

    /**
     * Gets presence huile palme.
     *
     * @return the presence huile palme
     */
    public String getPresenceHuilePalme() {
        return presenceHuilePalme;
    }

    /**
     * Sets presence huile palme.
     *
     * @param presenceHuilePalme the presence huile palme
     */
    public void setPresenceHuilePalme(String presenceHuilePalme) {
        this.presenceHuilePalme = presenceHuilePalme;
    }
}