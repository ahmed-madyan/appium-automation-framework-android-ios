package elements.mobile_actions;

import driver.DriverManager;
import elements.Elements;
import exceptions.Exceptions;
import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.ScreenOrientation;

public class AndroidActions {
    public static void startActivity(@NotNull final String appPackage, @NotNull final String appActivity) {
        try {
            DriverManager.androidDriver().getDriverInstance().startActivity(new Activity(appPackage.trim(), appActivity.trim()));
        } catch (Exception e) {
            Exceptions.handle(e);
        }
    }

    public static void scrollIntoView(@NotNull final String elementText) {
        try {
            Elements.elementActions().findElement(AppiumBy.ByAndroidUIAutomator.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"" + elementText + "\").instance(0))"));
        } catch (Exception e) {
            Exceptions.handle(e);
        }
    }

    public static void scrollIntoElementView(@NotNull final By elementLocated, @NotNull final String elementText) {
        try {
            Elements.elementActions().findElement(AppiumBy.ByAndroidUIAutomator.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"" + elementText + "\").instance(0))"));
            System.out.println("Is element displayed: " + Elements.elementState().isDisplayed(elementLocated));
        } catch (Exception e) {
            Exceptions.handle(e);
        }
    }

    public static void setClipboardText(@NotNull final String text) {
        try {
            DriverManager.androidDriver().getDriverInstance().setClipboardText(text);
        } catch (Exception e) {
            Exceptions.handle(e);
        }
    }

    public static String getClipboardText() {
        String clipboardText = null;
        try {
            clipboardText = DriverManager.androidDriver().getDriverInstance().getClipboardText();
        } catch (Exception e) {
            Exceptions.handle(e);
        }
        return clipboardText;
    }

    public static void rotateRight() {
        try {
            DriverManager.androidDriver().getDriverInstance().rotate(new DeviceRotation(0, 0, 90));
        } catch (Exception e) {
            Exceptions.handle(e);
        }
    }

    public static void rotateLeft() {
        try {
            DriverManager.androidDriver().getDriverInstance().rotate(new DeviceRotation(0, 0, 270));
        } catch (Exception e) {
            Exceptions.handle(e);
        }
    }

    public static void rotateCustomAngle(@NotNull final int angle) {
        try {
            DriverManager.androidDriver().getDriverInstance().rotate(new DeviceRotation(0, 0, angle));
        } catch (Exception e) {
            Exceptions.handle(e);
        }
    }

    public static void setPortraitMode() {
        try {
            DriverManager.androidDriver().getDriverInstance().rotate(ScreenOrientation.PORTRAIT);
        } catch (Exception e) {
            Exceptions.handle(e);
        }
    }

    public static void setLandscapeMode() {
        try {
            DriverManager.androidDriver().getDriverInstance().rotate(ScreenOrientation.LANDSCAPE);
        } catch (Exception e) {
            Exceptions.handle(e);
        }
    }

    public static String getToastMessage() {
        String text = null;
        try {
            text = DriverManager.androidDriver().getDriverInstance().findElement(AppiumBy.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
        } catch (Exception e) {
            Exceptions.handle(e);
        }
        return text;
    }
}