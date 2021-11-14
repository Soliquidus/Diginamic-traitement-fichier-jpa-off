package fr.diginamic.openfoodfacts.utils;

import fr.diginamic.openfoodfacts.entite.*;
import fr.diginamic.openfoodfacts.exception.FileException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Class FileReader
 *
 * @author Tibo Pfeifer
 * @version 1.0
 * @date 13 /11/2021
 */
public class FileReader {

    /**
     * Read from input list.
     *
     * @param inputStream the input stream
     * @return the list
     * @throws IOException the io exception
     */
    public static List<String> readFromInput(InputStream inputStream) throws IOException {

        List<String> lines = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        }
        return lines;
    }

    /**
     * Gets produits.
     *
     * @param inputStream the input stream
     * @return the produits
     * @throws IOException the io exception
     */
    public List<Produit> getProduits(InputStream inputStream) throws IOException {
        List<String> lines = null;
        try {
            lines = readFromInput(inputStream);
        } catch (IOException e) {
            throw new FileException("Fichier " + inputStream.toString() + " non trouvé.");
        }
        lines.remove(0);

        List<Produit> produits = new ArrayList<>();
        return produits;
    }

    /**
     * Read line by line in the CSV file to get each product.
     *
     * @param line the line
     * @return the produit
     */
    private Produit getProduitByLine(String line) {

        String[] parts = line.split("\\|", -1);

        String categoryName = parts[0];
        String brandName = parts[1];
        String productName = parts[2];
        String nutritionGrade = parts[3];

        String ingredients = parts[4];
        Double energie100g = TextManipulation.convertToDouble(parts[5]);
        Double graisse100g = TextManipulation.convertToDouble(parts[6]);
        Double sucres100g = TextManipulation.convertToDouble(parts[7]);
        Double fibres100g = TextManipulation.convertToDouble(parts[8]);
        Double proteines100g = TextManipulation.convertToDouble(parts[9]);
        Double sel100g = TextManipulation.convertToDouble(parts[10]);
        Double vitA100g = TextManipulation.convertToDouble(parts[11]);
        Double vitD100g = TextManipulation.convertToDouble(parts[12]);
        Double vitE100g = TextManipulation.convertToDouble(parts[13]);
        Double vitK100g = TextManipulation.convertToDouble(parts[14]);
        Double vitC100g = TextManipulation.convertToDouble(parts[15]);
        Double vitB1100g = TextManipulation.convertToDouble(parts[16]);
        Double vitB2100g = TextManipulation.convertToDouble(parts[17]);
        Double vitPP100g = TextManipulation.convertToDouble(parts[18]);
        Double vitB6100g = TextManipulation.convertToDouble(parts[19]);
        Double vitB9100g = TextManipulation.convertToDouble(parts[20]);
        Double vitB12100g = TextManipulation.convertToDouble(parts[21]);
        Double calcium100g = TextManipulation.convertToDouble(parts[22]);
        Double magnesium100g = TextManipulation.convertToDouble(parts[23]);
        Double iron100g = TextManipulation.convertToDouble(parts[24]);
        Double fer100g = TextManipulation.convertToDouble(parts[25]);
        Double betaCarotene100g = TextManipulation.convertToDouble(parts[26]);
        String presenceHuilePalme = parts[27];
        String allergenesStr = parts[28];
        String additifStr = parts[29];

        Categorie category = new Categorie(categoryName);
        Marque brand = new Marque(brandName);
        Produit product = new Produit(productName);
        product.setCategorie(category);
        product.setMarque(brand);
        product.setGrade(nutritionGrade);
        product.setIngredients(stringToIngredients(ingredients));
        product.setAdditifs(stringToAdditifs(additifStr));
        product.setAllergenes(stringToAllergens(allergenesStr));

        product.setBetaCarotene100g(betaCarotene100g);
        product.setCalcium100g(calcium100g);
        product.setEnergie100g(energie100g);
        product.setFer100g(fer100g);
        product.setFibres100g(fibres100g);
        product.setGraisse100g(graisse100g);
        product.setIron100g(iron100g);
        product.setMagnesium100g(magnesium100g);
        product.setPresenceHuilePalme(presenceHuilePalme);
        product.setProteines100g(proteines100g);
        product.setSel100g(sel100g);
        product.setSucres100g(sucres100g);
        product.setVitA100g(vitA100g);
        product.setVitB1100g(vitB1100g);
        product.setVitB12100g(vitB12100g);
        product.setVitB2100g(vitB2100g);
        product.setVitB6100g(vitB6100g);
        product.setVitB9100g(vitB9100g);
        product.setVitC100g(vitC100g);
        product.setVitD100g(vitD100g);
        product.setVitE100g(vitE100g);
        product.setVitK100g(vitK100g);
        product.setVitPP100g(vitPP100g);

        return product;
    }

    /**
     * Transform the ingredients String into a list. Several text manipulations are used
     * in order to ignore useless data.
     *
     * @param string the ingredients string
     * @return the set
     */
    private Set<Ingredient> stringToIngredients(String string) {

        List<String> parts = TextManipulation.splitString(string);
        Set<Ingredient> ingredients = new HashSet<>();
        parts.forEach(name -> ingredients.add(new Ingredient(name)));
        return ingredients;
    }

    /**
     * Transform the additifs String into a list. Several text manipulations are used
     * in order to ignore useless data.
     *
     * @param string the additifs string
     * @return the set
     */
    private Set<Additif> stringToAdditifs(String string) {

        List<String> parts = TextManipulation.splitString(string);
        Set<Additif> additifs = new HashSet<>();
        parts.forEach(name -> additifs.add(new Additif(name)));
        return additifs;
    }

    /**
     * Transform the allergens String into a list. Several text manipulations are used
     * in order to ignore useless data.
     *
     * @param string the allergens string
     * @return the set
     */
    private Set<Allergene> stringToAllergens(String string) {

        List<String> parts = TextManipulation.splitString(string);
        Set<Allergene> allergens = new HashSet<>();
        parts.forEach(name -> allergens.add(new Allergene(name)));
        return allergens;
    }
}