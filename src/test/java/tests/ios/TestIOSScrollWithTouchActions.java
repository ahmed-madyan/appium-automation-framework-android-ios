package tests.ios;

import driver.DriverInitializer;
import elements.Elements;
import elements.touch_actions.TouchDirection;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class TestIOSScrollWithTouchActions extends DriverInitializer {

    private static final By WEB_VIEW_BUTTON = AppiumBy.accessibilityId("Web View");
    private static final By ALERT_VIEWS_BUTTON = AppiumBy.accessibilityId("Alert Views");

    @Test
    public void testIOSScroll() throws InterruptedException {
        Elements
                .touchActions()
                .scrollToElement(WEB_VIEW_BUTTON, TouchDirection.VERTICAL)
                .scrollToElement(ALERT_VIEWS_BUTTON, TouchDirection.VERTICAL)
                .scrollToElement(WEB_VIEW_BUTTON, TouchDirection.VERTICAL)
                .tap(WEB_VIEW_BUTTON);
    }
}