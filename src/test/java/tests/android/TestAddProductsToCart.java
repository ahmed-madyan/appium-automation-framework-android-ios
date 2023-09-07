package tests.android;

import driver.DriverInitializer;
import org.testng.annotations.Test;
import pages.android.Form;
import pages.android.Products;
import readers.json_reader.JSONDataManager;

public class TestAddProductsToCart extends DriverInitializer {

    private static final String testDataFilePath = ("src/test/resources/FormPage.json");

    @Test
    public void testAddProductsToCart() {
        new Form()
                .validateTheToolBarTitle()
                .validateFormElementsExist()
                .fillForm(JSONDataManager.getJSONData(testDataFilePath, "country", JSONDataManager.Types.STRING).toString(), JSONDataManager.getJSONData(testDataFilePath, "name", JSONDataManager.Types.STRING).toString());
        new Products()
                .validateTheToolBarTitle();
    }
}