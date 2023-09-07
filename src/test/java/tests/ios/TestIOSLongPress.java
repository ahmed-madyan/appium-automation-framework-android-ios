//package tests.ios;
//
//import driver.DriverInitializer;
//import elements.Elements;
//import io.appium.java_client.AppiumBy;
//import org.openqa.selenium.By;
//import org.testng.annotations.Test;
//
//public class TestIOSLongPress extends DriverInitializer {
//    private static final By Steppers_BUTTON = AppiumBy.accessibilityId("Steppers");
//    private static final By CUSTOM_INCREMENT_BUTTON = AppiumBy.xpath("//XCUIElementTypeOther[@name='CUSTOM']//following::XCUIElementTypeCell/XCUIElementTypeButton");
//    @Test
//    public void testIOSLongPress() {
//        Elements
//                .elementActions()
//                .click(Steppers_BUTTON)
//                .click(CUSTOM_INCREMENT_BUTTON)
//                .gestureActions()
//                .iosGestures()
//                .longClick(CUSTOM_INCREMENT_BUTTON, 10);
//    }
//}