import fr.diginamic.openfoodfacts.entity.Produit;
import fr.diginamic.openfoodfacts.manager.ProduitManager;
import fr.diginamic.openfoodfacts.utils.FileReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Class OpenFoodFactsApp
 *
 * @author Tibo Pfeifer
 * @version 1.0
 * @date 14/11/2021
 */
public class OpenFoodFactsApp {

    private static final Logger LOGGER = LoggerFactory.getLogger(OpenFoodFactsApp.class);

    public static void main(String[] args) {

        FileReader fileReader = new FileReader();
        List<Produit> products = fileReader.getProducts(fileReader.getClass().getClassLoader().getResourceAsStream("open-food-facts.csv"));

        ProduitManager productManager = new ProduitManager();

        for (Produit product : products) {
            productManager.processProduct(product);
        }

        LOGGER.info("Elements processed.");

        productManager.close();
    }
}