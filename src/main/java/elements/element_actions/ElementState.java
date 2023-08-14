package elements.element_actions;

import driver.DriverManager;
import elements.Elements;
import exceptions.Exceptions;
import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import org.openqa.selenium.By;

public class ElementState {
    public ElementState() {
    }

    public boolean isCheckable(@NotNull final By elementLocated) {
        boolean isCheckable = false;
        try {
            if (Elements.elementActions().getAttribute(elementLocated, "checkable").equals("true")) {
                isCheckable = true;
            }
        } catch (Exception e) {
            Exceptions.handle(e);
        }
        return isCheckable;
    }

    public boolean isChecked(@NotNull final By elementLocated) {
        boolean isChecked = false;
        try {
            if (Elements.elementActions().getAttribute(elementLocated, "checked").equals("true")) {
                isChecked = true;
            }
        } catch (Exception e) {
            Exceptions.handle(e);
        }
        return isChecked;
    }

    public boolean isClickable(@NotNull final By elementLocated) {
        boolean isClickable = false;
        try {
            if (Elements.elementActions().getAttribute(elementLocated, "clickable").equals("true")) {
                isClickable = true;
            }
        } catch (Exception e) {
            Exceptions.handle(e);
        }
        return isClickable;
    }

    public boolean isEnabled(@NotNull final By elementLocated) {
        boolean isEnabled = false;
        try {
            if (Elements.elementActions().findElement(elementLocated).isEnabled()) {
                isEnabled = true;
            }
        } catch (Exception e) {
            Exceptions.handle(e);
        }
        return isEnabled;
    }

    public boolean isFocusable(@NotNull final By elementLocated) {
        boolean isFocusable = false;
        try {
            if (Elements.elementActions().findElement(elementLocated).getAttribute("focusable").equals("true")) {
                isFocusable = true;
            }
        } catch (Exception e) {
            Exceptions.handle(e);
        }
        return isFocusable;
    }

    public boolean isFocused(@NotNull final By elementLocated) {
        boolean isFocused = false;
        try {
            if (Elements.elementActions().findElement(elementLocated).getAttribute("focused").equals("true")) {
                isFocused = true;
            }
        } catch (Exception e) {
            Exceptions.handle(e);
        }
        return isFocused;
    }

    public boolean isLongClickable(@NotNull final By elementLocated) {
        boolean isLongClickable = false;
        try {
            if (Elements.elementActions().findElement(elementLocated).getAttribute("long-clickable").equals("true")) {
                isLongClickable = true;
            }
        } catch (Exception e) {
            Exceptions.handle(e);
        }
        return isLongClickable;
    }

    public boolean isPassword(@NotNull final By elementLocated) {
        boolean isPassword = false;
        try {
            if (Elements.elementActions().findElement(elementLocated).getAttribute("password").equals("true")) {
                isPassword = true;
            }
        } catch (Exception e) {
            Exceptions.handle(e);
        }
        return isPassword;
    }

    public boolean isScrollable(@NotNull final By elementLocated) {
        boolean isScrollable = false;
        try {
            if (Elements.elementActions().findElement(elementLocated).getAttribute("scrollable").equals("true")) {
                isScrollable = true;
            }
        } catch (Exception e) {
            Exceptions.handle(e);
        }
        return isScrollable;
    }

    public boolean isSelected(@NotNull final By elementLocated) {
        boolean isSelected = false;
        try {
            if (Elements.elementActions().findElement(elementLocated).isSelected()) {
                isSelected = true;
            }
        } catch (Exception e) {
            Exceptions.handle(e);
        }
        return isSelected;
    }

    public boolean isDisplayed(@NotNull final By elementLocated) {
        boolean isDisplayed = false;
        try {
            if (DriverManager.getDriverInstance().findElement(elementLocated).isDisplayed()) {
                isDisplayed = true;
            }
        } catch (Exception e) {
            Exceptions.handle(e);
        }
        return isDisplayed;
    }
}