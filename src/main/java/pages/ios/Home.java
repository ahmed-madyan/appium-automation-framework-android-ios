package pages.ios;

import elements.Elements;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class Home {
    private static final By ALERT_VIEWS_BUTTON = AppiumBy.accessibilityId("Alert Views");

    public Home openAlertsPage() {
        Elements.elementActions().click(ALERT_VIEWS_BUTTON);
        return this;
    }
}