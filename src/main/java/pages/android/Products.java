package pages.android;

import assertions.Assertions;
import driver.DriverManager;
import elements.Elements;
import elements.gesture_actions.GestureDirection;
import elements.mobile_actions.KeyEvents;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import waits.Waits;

public class Products {
    private final By TOOL_BAR_TITLE = AppiumBy.id("com.androidsample.generalstore:id/toolbar_title");
    private final By PRODUCT_NAME = AppiumBy.id("com.androidsample.generalstore:id/productName");
    private final By ADD_TO_CART_BUTTON = AppiumBy.id("com.androidsample.generalstore:id/productAddCart");
    private final By CART_BUTTON = AppiumBy.id("com.androidsample.generalstore:id/appbar_btn_cart");
    private final By MALE_RADIO_BUTTON = AppiumBy.id("com.androidsample.generalstore:id/radioMale");
    private final By FEMALE_RADIO_BUTTON = AppiumBy.id("com.androidsample.generalstore:id/radioFemale");
    private final By COUNTRY_LIST = AppiumBy.id("com.androidsample.generalstore:id/spinnerCountry");
    private final By NAME_TEXT_BOX = AppiumBy.id("com.androidsample.generalstore:id/nameField");
    private final By LETS_SHOP_BUTTON = AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop");
    private final By TOTAL_AMOUNT_TEXT = AppiumBy.id("com.androidsample.generalstore:id/totalAmountLbl");
    private final By TERMS_AND_CONDITIONS_BUTTON = AppiumBy.id("com.androidsample.generalstore:id/termsButton");
    private final By TERMS_AND_CONDITIONS_CLOSE = AppiumBy.id("android:id/button1");
    private final By SEND_EMAILS_CHECK_BOX = AppiumBy.className("android.widget.CheckBox");
    private final By COMPLETE_PURCHASE_BUTTON = AppiumBy.id("com.androidsample.generalstore:id/btnProceed");

    public Products validateTheToolBarTitle() {
        Assertions
                .hardAssert()
                .elementTextToBe(TOOL_BAR_TITLE, "Products");
        return this;
    }

    public void addToCard(String product) {
        Elements.gestureActions().androidGestures().scrollToElement(AppiumBy.xpath("//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productName' and @text='" + product + "']"), GestureDirection.DOWN);
        if (Elements.elementActions().getText(AppiumBy.xpath("//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productName' and @text='" + product + "']/following-sibling::android.widget.LinearLayout/android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productAddCart']")).equalsIgnoreCase("ADD TO CART"))
            Elements.elementActions().click(AppiumBy.xpath("//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productName' and @text='" + product + "']/following-sibling::android.widget.LinearLayout/android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productAddCart']"));
        else System.out.println("Product: " + product + " already added to the cart");
    }

    public float getProductPrice(String product) {
        Elements.gestureActions().androidGestures().scrollToElement(AppiumBy.xpath("//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productName' and @text='" + product + "']"), GestureDirection.DOWN);
        String price = Elements.elementActions().getText(AppiumBy.xpath("//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productName' and @text='" + product + "']/following-sibling::android.widget.LinearLayout/android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productPrice']")).substring(1);
        float productPrice = Float.parseFloat(price);
        System.out.println("Product: " + product + " price is: " + productPrice);
        return productPrice;
    }

    public void addProductsToCart() {
        Waits.fluentlyWait().visibilityOfElementLocated(TOOL_BAR_TITLE);
        addToCard("Air Jordan 9 Retro");
        addToCard("Air Jordan 9 Retro");
        float airJordan9_productPrice = getProductPrice("Air Jordan 9 Retro");
        addToCard("Nike SFB Jungle");
        float nikeSFBJungle_productPrice = getProductPrice("Nike SFB Jungle");
        addToCard("Air Jordan 4 Retro");
        float airJordan4_productPrice = getProductPrice("Air Jordan 4 Retro");
        Assertions.hardAssert().elementDisplayed(ADD_TO_CART_BUTTON);
        Elements.elementActions().click(CART_BUTTON);
        Assertions.hardAssert().elementAttributeToBe(TOOL_BAR_TITLE, "text", "Cart");
        Assertions.hardAssert().elementTextToBe(PRODUCT_NAME, "Air Jordan 9 Retro");
        float expectedTotalAmount = airJordan9_productPrice + nikeSFBJungle_productPrice + airJordan4_productPrice;
        System.out.println("Expected total amount: " + expectedTotalAmount);
        Assertions.hardAssert().elementTextToBe(TOTAL_AMOUNT_TEXT, ("$ " + expectedTotalAmount).trim());
        Elements.gestureActions().androidGestures().longClick(TERMS_AND_CONDITIONS_BUTTON, 1);
        Elements.elementActions().click(TERMS_AND_CONDITIONS_CLOSE);
        Elements.elementActions().click(SEND_EMAILS_CHECK_BOX);
        Elements.elementActions().click(COMPLETE_PURCHASE_BUTTON);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(DriverManager.androidDriver().getContextHandles());
        DriverManager.androidDriver().switchContext("WEBVIEW_com.androidsample.generalstore");
        System.out.println(DriverManager.getDriverInstance().getCurrentUrl());
        KeyEvents.keyBack();
        DriverManager.androidDriver().switchContext("NATIVE_APP");
    }
}