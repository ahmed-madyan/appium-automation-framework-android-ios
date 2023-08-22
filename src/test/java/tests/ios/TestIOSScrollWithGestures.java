package tests.ios;

import driver.DriverInitializer;
import elements.Elements;
import elements.gesture_actions.GestureDirection;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class TestIOSScrollWithGestures extends DriverInitializer {
    private static final By WEB_VIEW_BUTTON = AppiumBy.accessibilityId("Web View");

    @Test
    public void testIOSScroll() throws InterruptedException {
        Elements
                .gestureActions()
                .iosGestures()
                .scrollToElement(WEB_VIEW_BUTTON, GestureDirection.DOWN)
                .elementActions()
                .click(WEB_VIEW_BUTTON);
    }
}