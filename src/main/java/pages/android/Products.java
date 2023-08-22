package pages.android;

import assertions.Assertions;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class Products {
    private final By TOOL_BAR_TITLE = AppiumBy.id("com.androidsample.generalstore:id/toolbar_title");
    private final By COUNTRY_LIST = AppiumBy.id("com.androidsample.generalstore:id/spinnerCountry");
    private final By NAME_TEXT_BOX = AppiumBy.id("com.androidsample.generalstore:id/nameField");
    private final By MALE_RADIO_BUTTON = AppiumBy.id("com.androidsample.generalstore:id/radioMale");
    private final By FEMALE_RADIO_BUTTON = AppiumBy.id("com.androidsample.generalstore:id/radioFemale");
    private final By LETS_SHOP_BUTTON = AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop");

    public Products validateTheToolBarTitle() {
        Assertions
                .hardAssert()
                .elementTextToBe(TOOL_BAR_TITLE, "Products");
        return this;
    }
}
