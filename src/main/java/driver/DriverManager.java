package driver;

import com.google.common.collect.ImmutableMap;
import exceptions.Exceptions;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;

public class DriverManager {
    public DriverManager() {
    }

    public static AppiumDriver getDriverInstance() {
        return DriverInitializer.getDriver();
    }

    public static Android androidDriver() {
        return new Android();
    }

    public static IOS iosDriver() {
        return new IOS();
    }

    protected static void quitDriver() {
        getDriverInstance().quit();
    }

    public static Dimension getWindowSize() {
        return DriverManager.getDriverInstance().manage().window().getSize();
    }

    public static Point getPosition() {
        return DriverManager.getDriverInstance().manage().window().getPosition();
    }

    public static String getPageSource() {
        return DriverManager.getDriverInstance().getPageSource();
    }

    public static void executeScript(String script, ImmutableMap<Object, Object> immutableMap) {
        try {
            DriverInitializer.getDriver().executeScript(script, immutableMap);
        } catch (Exception e) {
            Exceptions.handle(e);
        }
    }
}