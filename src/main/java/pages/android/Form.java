package pages.android;

import assertions.Assertions;
import elements.Elements;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class Form {
    public Form() {
    }

    private final By TOOL_BAR_TITLE = AppiumBy.id("com.androidsample.generalstore:id/toolbar_title");
    private final By COUNTRY_LIST = AppiumBy.id("com.androidsample.generalstore:id/spinnerCountry");
    private final By NAME_TEXT_BOX = AppiumBy.id("com.androidsample.generalstore:id/nameField");
    private final By MALE_RADIO_BUTTON = AppiumBy.id("com.androidsample.generalstore:id/radioMale");
    private final By FEMALE_RADIO_BUTTON = AppiumBy.id("com.androidsample.generalstore:id/radioFemale");
    private final By LETS_SHOP_BUTTON = AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop");

    public Form validateTheToolBarTitle() {
        Assertions
                .hardAssert()
                .elementTextToBe(TOOL_BAR_TITLE, "General Store");
        return this;
    }

    public Form validateFormElementsExist() {
        Assertions.hardAssert().elementDisplayed(COUNTRY_LIST);
        Assertions.hardAssert().elementEnabled(COUNTRY_LIST);
        Assertions.hardAssert().elementDisplayed(NAME_TEXT_BOX);
        Assertions.hardAssert().elementEnabled(NAME_TEXT_BOX);
        Assertions.hardAssert().elementClickable(NAME_TEXT_BOX);
        Assertions.hardAssert().elementDisplayed(MALE_RADIO_BUTTON);
        Assertions.hardAssert().elementDisplayed(FEMALE_RADIO_BUTTON);
        Assertions.hardAssert().elementDisplayed(LETS_SHOP_BUTTON);
        return this;
    }

    public Form fillForm() {
        Elements.gestureActions()
                .androidGestures()
                .click(COUNTRY_LIST);
        String country = ("//android.widget.TextView[@text='{country}']");
        Elements.mobileActions()
                .androidActions()
                .scrollIntoView("Egypt");
        Elements.gestureActions()
                .androidGestures()
                .click(AppiumBy.xpath(country.replace("{country}", "Egypt")));
        Elements.elementActions()
                .sendKeys(NAME_TEXT_BOX, "Ahmed");
        Elements.gestureActions()
                .androidGestures()
                .click(LETS_SHOP_BUTTON);
        return this;
    }
}