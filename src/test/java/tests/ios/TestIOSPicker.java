//package tests.ios;
//
//import driver.DriverInitializer;
//import elements.Elements;
//import io.appium.java_client.AppiumBy;
//import org.openqa.selenium.By;
//import org.testng.annotations.Test;
//
//public class TestIOSPicker extends DriverInitializer {
//    private static final By PICKER_VIEW_BUTTON = AppiumBy.accessibilityId("Picker View");
//    private static final By RED_PICKER = AppiumBy.accessibilityId("Red color component value");
//    private static final By GREEN_PICKER = AppiumBy.accessibilityId("Green color component value");
//    private static final By BLUE_PICKER = AppiumBy.accessibilityId("Blue color component value");
//    @Test
//    public void testIOSPicker() {
//        Elements
//                .elementActions()
//                .click(PICKER_VIEW_BUTTON)
//                .mobileActions()
//                .iosActions()
//                .setPicker(RED_PICKER, "55")
//                .setPicker(GREEN_PICKER, "140")
//                .setPicker(BLUE_PICKER, "50");
//    }
//}