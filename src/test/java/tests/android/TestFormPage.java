package tests.android;

import driver.DriverInitializer;
import org.testng.annotations.Test;
import pages.android.Form;
import pages.android.Products;
import readers.properties_reader.PropertiesDataManager;

public class TestFormPage extends DriverInitializer {

    private static final String testDataFilePath = ("src/test/resources/FormPage.json");
    @Test
    public void testFormPage() {
        new Form()
                .validateTheToolBarTitle()
                .validateFormElementsExist()
                .fillForm(PropertiesDataManager.getProperty("country", testDataFilePath), PropertiesDataManager.getProperty("name", testDataFilePath));
        new Products()
                .validateTheToolBarTitle();
    }
}