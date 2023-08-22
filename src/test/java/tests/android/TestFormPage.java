package tests.android;

import driver.DriverInitializer;
import org.testng.annotations.Test;
import pages.android.Form;
import pages.android.Products;

public class TestFormPage extends DriverInitializer {

    @Test
    public void testFormPage() {
        new Form()
                .validateTheToolBarTitle()
                .validateFormElementsExist()
                .fillForm("Egypt", "Ahmed");
        new Products()
                .validateTheToolBarTitle();
    }
}