package assertions;

import elements.Elements;
import exceptions.Exceptions;
import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import org.openqa.selenium.By;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

public class Verify {
    public Verify() {
    }

    static SoftAssert softAssert = new SoftAssert();

    public Verify elementCheckable(@NotNull final By elementLocated) {
        try {
            softAssert.assertTrue(Elements.elementState().isCheckable(elementLocated), "Element located with {" + elementLocated.toString() + "} is not checkable");
            System.out.println("Element located with {" + elementLocated + "} is checkable");
        } catch (Exception e) {
           Exceptions.handle(e);
        }
        return this;
    }

    public Verify elementChecked(@NotNull final By elementLocated) {
        try {
            softAssert.assertTrue(Elements.elementState().isChecked(elementLocated), "Element located with {" + elementLocated.toString() + "} is not checked");
            System.out.println("Element located with {" + elementLocated + "} is checked");
        } catch (Exception e) {
           Exceptions.handle(e);
        }
        return this;
    }

    public Verify elementClickable(@NotNull final By elementLocated) {
        try {
            softAssert.assertTrue(Elements.elementState().isClickable(elementLocated), "Element located with {" + elementLocated.toString() + "} is not clickable");
            System.out.println("Element located with {" + elementLocated + "} is clickable");
        } catch (Exception e) {
           Exceptions.handle(e);
        }
        return this;
    }

    public Verify elementEnabled(@NotNull final By elementLocated) {
        try {
            softAssert.assertTrue(Elements.elementState().isEnabled(elementLocated), "Element located with {" + elementLocated.toString() + "} is not enabled");
            System.out.println("Element located with {" + elementLocated + "} is enabled");
        } catch (Exception e) {
           Exceptions.handle(e);
        }
        return this;
    }

    public Verify elementFocusable(@NotNull final By elementLocated) {
        try {
            softAssert.assertTrue(Elements.elementState().isFocusable(elementLocated), "Element located with {" + elementLocated.toString() + "} is not focusable");
            System.out.println("Element located with {" + elementLocated + "} is focusable");
        } catch (Exception e) {
           Exceptions.handle(e);
        }
        return this;
    }

    public Verify elementFocused(@NotNull final By elementLocated) {
        try {
            softAssert.assertTrue(Elements.elementState().isFocused(elementLocated), "Element located with {" + elementLocated.toString() + "} is not focused");
            System.out.println("Element located with {" + elementLocated + "} is focused");
        } catch (Exception e) {
           Exceptions.handle(e);
        }
        return this;
    }

    public Verify elementLongClickable(@NotNull final By elementLocated) {
        try {
            softAssert.assertTrue(Elements.elementState().isLongClickable(elementLocated), "Element located with {" + elementLocated.toString() + "} is not long-clickable");
            System.out.println("Element located with {" + elementLocated + "} is long-clickable");
        } catch (Exception e) {
           Exceptions.handle(e);
        }
        return this;
    }

    public Verify elementPassword(@NotNull final By elementLocated) {
        try {
            softAssert.assertTrue(Elements.elementState().isPassword(elementLocated), "Element located with {" + elementLocated.toString() + "} is not password");
            System.out.println("Element located with {" + elementLocated + "} is password");
        } catch (Exception e) {
           Exceptions.handle(e);
        }
        return this;
    }

    public Verify elementScrollable(@NotNull final By elementLocated) {
        try {
            softAssert.assertTrue(Elements.elementState().isScrollable(elementLocated), "Element located with {" + elementLocated.toString() + "} is not scrollable");
            System.out.println("Element located with {" + elementLocated + "} is scrollable");
        } catch (Exception e) {
           Exceptions.handle(e);
        }
        return this;
    }

    public Verify elementSelected(@NotNull final By elementLocated) {
        try {
            softAssert.assertTrue(Elements.elementState().isSelected(elementLocated), "Element located with {" + elementLocated.toString() + "} is not selected");
            System.out.println("Element located with {" + elementLocated + "} is selected");
        } catch (Exception e) {
           Exceptions.handle(e);
        }
        return this;
    }

    public Verify elementDisplayed(@NotNull final By elementLocated) {
        try {
            softAssert.assertTrue(Elements.elementState().isDisplayed(elementLocated), "Element located with {" + elementLocated.toString() + "} is not displayed");
            System.out.println("Element located with {" + elementLocated + "} is displayed");
        } catch (Exception e) {
           Exceptions.handle(e);
        }
        return this;
    }

    public Verify elementNotDisplayed(@NotNull final By elementLocated) {
        try {
            new Assertion().assertFalse(Elements.elementState().isDisplayed(elementLocated), "Element located with {" + elementLocated.toString() + "} is displayed");
            System.out.println("Element located with {" + elementLocated + "} is displayed");
        } catch (Exception e) {
            Exceptions.handle(e);
        }
        return this;
    }

    public Verify elementTextToBe(@NotNull final By elementLocated, final String expectedText) {
        try {
            new SoftAssert().assertEquals(Elements.elementActions().getText(elementLocated).trim(), expectedText.trim()
                    , "Element text {" + Elements.elementActions().getText(elementLocated).trim() + "} located with {" + elementLocated.toString() + "} is equals to the expected text {" + expectedText.trim() + "}");
        } catch (Exception e) {
            Exceptions.handle(e);
            System.out.println("Element text {" + Elements.elementActions().getText(elementLocated).trim() + "} located with {" + elementLocated.toString() + "} is equals to the expected text {" + expectedText.trim() + "}");
        }
        return this;
    }

    public Verify elementTextContains(@NotNull final By elementLocated, final String expectedText) {
        try {
            softAssert.assertTrue(Elements.elementActions().getText(elementLocated).trim().contains(expectedText.trim()));
            System.out.println("Element text {" + Elements.elementActions().getText(elementLocated).trim() + "} located with {" + elementLocated.toString() + "} contains the expected text {" + expectedText.trim() + "}");
        } catch (Exception e) {
            Exceptions.handle(e);
        }
        return this;
    }

    public Verify textToBe(@NotNull final String actualText, @NotNull final String expectedText) {
        try {
            softAssert.assertEquals(actualText, expectedText);
            System.out.println("Actual text {" + actualText + "} is equals to the expected text {" + expectedText + "}");
        } catch (Exception e) {
           Exceptions.handle(e);
        }
        return this;
    }

    public Verify attributeToBe(@NotNull final String attribute, @NotNull final boolean expected) {
        try {
            softAssert.assertEquals(attribute, expected);
            System.out.println("Attribute {" + attribute + "} is equals to the expected {" + expected + "}");
        } catch (Exception e) {
           Exceptions.handle(e);
        }
        return this;
    }

    public Verify attributeToBe(@NotNull final String attribute, @NotNull final String expected) {
        try {
            softAssert.assertEquals(attribute, expected);
            System.out.println("Attribute {" + attribute + "} is equals to the expected {" + expected + "}");
        } catch (Exception e) {
           Exceptions.handle(e);
        }
        return this;
    }

    public Verify elementAttributeToBe(@NotNull final By elementLocated, @NotNull final String attribute, @NotNull final boolean expected) {
        try {
            softAssert.assertEquals(Elements.elementActions().getAttribute(elementLocated, attribute), expected);
            System.out.println("Attribute {" + attribute + "} is equals to the expected {" + expected + "}");
        } catch (Exception e) {
           Exceptions.handle(e);
        }
        return this;
    }

    public Verify elementAttributeToBe(@NotNull final By elementLocated, @NotNull final String attribute, @NotNull final String value) {
        try {
            softAssert.assertEquals(Elements.elementActions().getAttribute(elementLocated, attribute), value);
            System.out.println("Attribute {" + attribute + "} is equals to the expected {" + value + "}");
        } catch (Exception e) {
            Exceptions.handle(e);
        }
        return this;
    }

    public Verify equals(@NotNull final Object actual, @NotNull final Object expected) {
        try {
            softAssert.assertEquals(actual, expected);
            System.out.println("Actual {" + actual + "} is equals to the expected {" + expected + "}");
        } catch (Exception e) {
            Exceptions.handle(e);
        }
        return this;
    }

    public Verify notEquals(@NotNull final Object actual, @NotNull final Object expected) {
        try {
            softAssert.assertNotEquals(actual, expected);
            System.out.println("Actual {" + actual + "} not equals to the expected {" + expected + "}");
        } catch (Exception e) {
            Exceptions.handle(e);
        }
        return this;
    }

    public Verify assertTrue(@NotNull final boolean condition) {
        try {
            softAssert.assertTrue(condition);
            System.out.println("Actual condition is: {" + condition + "}");
        } catch (Exception e) {
            Exceptions.handle(e);
        }
        return this;
    }

    public Verify assertFalse(@NotNull final boolean condition) {
        try {
            softAssert.assertFalse(condition);
            System.out.println("Actual condition is: {" + condition + "}");
        } catch (Exception e) {
            Exceptions.handle(e);
        }
        return this;
    }
}