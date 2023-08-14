package elements.touch_actions;

import driver.DriverManager;
import elements.Elements;
import exceptions.Exceptions;
import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import java.time.Duration;

class Scroller {
    private static final TouchAction touchActions = new TouchAction((PerformsTouchActions) DriverManager.getDriverInstance());
    private static final Dimension dimension = DriverManager.getWindowSize();

    protected static void scrollToElement(@NotNull final By elementLocated, @NotNull final TouchDirection direction) {
        boolean isElementDisplayed = false;
        switch (direction) {
            case VERTICAL -> {
                try {
                    isElementDisplayed = scrollDown(elementLocated);
                    if (!isElementDisplayed) {
                        isElementDisplayed = scrollUp(elementLocated);
                        System.out.println("Element located with [" + elementLocated + "] is displayed: " + isElementDisplayed);
                    }
                } catch (Exception e) {
                    Exceptions.handle(e);
                }
            }
            case HORIZONTAL -> {
                try {
                    isElementDisplayed = scrollRight(elementLocated);
                    if (!isElementDisplayed) {
                        isElementDisplayed = scrollLeft(elementLocated);
                        System.out.println("Element located with [" + elementLocated + "] is displayed: " + isElementDisplayed);
                    }
                } catch (Exception e) {
                    Exceptions.handle(e);
                }
            }
        }
    }

    private static boolean scrollUp(@NotNull final By elementLocated) {
        boolean isElementDisplayed = false;
        String startPageSource;
        String endPageSource;
        try {
            do {
                startPageSource = DriverManager.getPageSource();
                int scrollStart = (int) (dimension.getHeight() * 0.2);
                int scrollEnd = (int) (dimension.getHeight() * 0.8);
                touchActions.press(PointOption.point(0, scrollStart))
                        .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                        .moveTo(PointOption.point(0, scrollEnd))
                        .release()
                        .perform();
                endPageSource = DriverManager.getPageSource();
                isElementDisplayed = Elements.elementState().isDisplayed(elementLocated);
            } while ((!Elements.elementState().isDisplayed(elementLocated)) && (!endPageSource.equals(startPageSource)));
        } catch (Exception e) {
            Exceptions.handle(e);
        }
        return isElementDisplayed;
    }

    private static boolean scrollDown(@NotNull final By elementLocated) {
        boolean isElementDisplayed = false;
        String startPageSource;
        String endPageSource;
        try {
            do {
                startPageSource = DriverManager.getPageSource();
                int scrollStart = (int) (dimension.getHeight() * 0.8);
                int scrollEnd = (int) (dimension.getHeight() * 0.2);
                touchActions.press(PointOption.point(0, scrollStart))
                        .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                        .moveTo(PointOption.point(0, scrollEnd))
                        .release()
                        .perform();
                endPageSource = DriverManager.getPageSource();
                isElementDisplayed = Elements.elementState().isDisplayed(elementLocated);
            } while ((!Elements.elementState().isDisplayed(elementLocated)) && (!endPageSource.equals(startPageSource)));
        } catch (Exception e) {
            Exceptions.handle(e);
        }
        return isElementDisplayed;
    }

    private static boolean scrollRight(@NotNull final By elementLocated) {
        boolean isElementDisplayed = false;
        String startPageSource;
        String endPageSource;
        try {
            do {
                startPageSource = DriverManager.getPageSource();
                int scrollStart = (int) (dimension.getWidth() * 0.8);
                int scrollEnd = (int) (dimension.getWidth() * 0.2);
                touchActions.press(PointOption.point(0, scrollStart))
                        .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                        .moveTo(PointOption.point(0, scrollEnd))
                        .release()
                        .perform();
                endPageSource = DriverManager.getPageSource();
                isElementDisplayed = Elements.elementState().isDisplayed(elementLocated);
            } while ((!Elements.elementState().isDisplayed(elementLocated)) && (!endPageSource.equals(startPageSource)));
        } catch (Exception e) {
            Exceptions.handle(e);
        }
        return isElementDisplayed;
    }

    private static boolean scrollLeft(@NotNull final By elementLocated) {
        boolean isElementDisplayed = false;
        String startPageSource;
        String endPageSource;
        try {
            do {
                startPageSource = DriverManager.getPageSource();
                int scrollStart = (int) (dimension.getWidth() * 0.2);
                int scrollEnd = (int) (dimension.getWidth() * 0.8);
                touchActions.press(PointOption.point(0, scrollStart))
                        .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                        .moveTo(PointOption.point(0, scrollEnd))
                        .release()
                        .perform();
                endPageSource = DriverManager.getPageSource();
                isElementDisplayed = Elements.elementState().isDisplayed(elementLocated);
            } while ((!Elements.elementState().isDisplayed(elementLocated)) && (!endPageSource.equals(startPageSource)));
        } catch (Exception e) {
            Exceptions.handle(e);
        }
        return isElementDisplayed;
    }
}