package elements.element_actions;

import driver.DriverManager;
import elements.gesture_actions.GestureActions;
import elements.mobile_actions.MobileActions;
import elements.touch_actions.TouchActions;
import exceptions.Exceptions;
import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import waits.Waits;

import java.util.List;

public class ElementActions {
    public ElementActions() {
    }

    public GestureActions gestureActions() {
        return new GestureActions();
    }
    public MobileActions mobileActions() {
        return new MobileActions();
    }
    public TouchActions touchActions() {
        return new TouchActions();
    }

    public WebElement findElement(@NotNull final By elementLocated) {
        WebElement element = null;
        try {
            Waits.fluentlyWait().visibilityOfElementLocated(elementLocated);
            element = DriverManager.getDriverInstance().findElement(elementLocated);
        } catch (Exception e) {
            Exceptions.handle(e);
        }
        return element;
    }

    public List<WebElement> findElements(@NotNull final By elementLocated) {
        List<WebElement> elements = null;
        try {
            Waits.fluentlyWait().visibilityOfElementLocated(elementLocated);
            elements = DriverManager.getDriverInstance().findElements(elementLocated);
        } catch (Exception e) {
            Exceptions.handle(e);
        }
        return elements;
    }

    public ElementActions click(@NotNull final By elementLocated) {
        try {
            findElement(elementLocated).click();
        } catch (Exception e) {
            Exceptions.handle(e);
        }
        return this;
    }

    public ElementActions sendKeys(@NotNull final By elementLocated, @NotNull final String keyToSend) {
        try {
            findElement(elementLocated).sendKeys(keyToSend);
        } catch (Exception e) {
            Exceptions.handle(e);
        }
        return this;
    }

    public String getText(@NotNull final By elementLocated) {
        String elementText = null;
        try {
            elementText = findElement(elementLocated).getText();
        } catch (Exception e) {
            Exceptions.handle(e);
        }
        return elementText;
    }

    public String getAttribute(@NotNull final By elementLocated, @NotNull final String attribute) {
        String attributeValue = null;
        try {
            attributeValue = findElement(elementLocated).getAttribute(attribute);
        } catch (Exception e) {
            Exceptions.handle(e);
        }
        return attributeValue;
    }

    public int getMiddleLocationX(@NotNull final By elementLocated) {
        int leftLocationX;
        int rightLocationX;
        int middleLocationX = 0;
        try {
            Waits.fluentlyWait().visibilityOfElementLocated(elementLocated);
            leftLocationX = getElementLocationX(elementLocated);
            rightLocationX = getElementWidth(elementLocated);
            middleLocationX = ((leftLocationX + rightLocationX) / 2);
            System.out.println
                    ("Left Location X: " + leftLocationX +
                            "\nRight Location X: " + rightLocationX +
                            "\nMiddle Location X: " + middleLocationX);
        } catch (Exception e) {
            Exceptions.handle(e);
        }
        return middleLocationX;
    }

    public int getMiddleLocationY(@NotNull final By elementLocated) {
        int upperLocationY;
        int lowerLocationY;
        int middleLocationY = 0;
        try {
            Waits.fluentlyWait().visibilityOfElementLocated(elementLocated);
            upperLocationY = getElementLocationY(elementLocated);
            lowerLocationY = getElementHeight(elementLocated);
            middleLocationY = ((upperLocationY + lowerLocationY) / 2);
            System.out.println
                    ("Upper Location Y: " + upperLocationY +
                            "\nLower Location Y: " + lowerLocationY +
                            "\nMiddle Location Y: " + middleLocationY);
        } catch (Exception e) {
            Exceptions.handle(e);
        }
        return middleLocationY;
    }

    public int getElementLocationX(@NotNull final By elementLocated) {
        int elementLocationX = 0;
        try {
            Waits.fluentlyWait().visibilityOfElementLocated(elementLocated);
            elementLocationX = findElement(elementLocated).getLocation().getX();
            System.out.println("Element Location X: " + elementLocationX);
        } catch (Exception e) {
            Exceptions.handle(e);
        }
        return elementLocationX;
    }

    public int getElementWidth(@NotNull final By elementLocated) {
        int elementWidth = 0;
        try {
            elementWidth = findElement(elementLocated).getSize().getWidth();
            System.out.println("Element width: " + elementWidth);
        } catch (Exception e) {
            Exceptions.handle(e);
        }
        return elementWidth;
    }

    public int getElementLocationY(@NotNull final By elementLocated) {
        int elementLocationY = 0;
        try {
            elementLocationY = findElement(elementLocated).getLocation().getY();
            System.out.println("Element Location Y: " + elementLocationY);
        } catch (Exception e) {
            Exceptions.handle(e);
        }
        return elementLocationY;
    }

    public int getElementHeight(@NotNull final By elementLocated) {
        int elementHeight = 0;
        try {
            elementHeight = findElement(elementLocated).getSize().getHeight();
            System.out.println("Element height: " + elementHeight);
        } catch (Exception e) {
            Exceptions.handle(e);
        }
        return elementHeight;
    }

    public ElementActions selectByVisibleText(@NotNull final By elementLocated, @NotNull final String visibleText) {
        try {
            new Select(findElement(elementLocated)).selectByVisibleText(visibleText);
        } catch (Exception e) {
            Exceptions.handle(e);
        }
        return this;
    }

    public ElementActions highlightWebElementLocated(@NotNull final By elementLocated) {
        try {
            ((JavascriptExecutor) DriverManager.getDriverInstance()).executeScript("arguments[0].style.border='3px solid red'", findElement(elementLocated));
        } catch (Exception e) {
            Exceptions.handle(e);
        }
        return this;
    }
}