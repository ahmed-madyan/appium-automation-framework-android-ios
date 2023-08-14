package waits;

import driver.DriverManager;
import exceptions.Exceptions;
import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;

public class Explicit {
    public Explicit() {
    }

    private final WebDriverWait driverWait = new WebDriverWait(DriverManager.getDriverInstance(), Duration.ofMinutes(1));

    public Explicit visibilityOfElementLocated(@NotNull final By elementLocated) {
        try {
            driverWait.until(ExpectedConditions.visibilityOfElementLocated(elementLocated));
        } catch (Exception e) {
            Exceptions.handle(e);
        }
        return this;
    }

    public Explicit elementToBeClickable(@NotNull final By elementLocated) {
        try {
            visibilityOfElementLocated(elementLocated);
            driverWait.until(ExpectedConditions.elementToBeClickable(elementLocated));
        } catch (Exception e) {
            Exceptions.handle(e);
        }
        return this;
    }

    public Explicit elementToBeSelected(@NotNull final By elementLocated) {
        try {
            visibilityOfElementLocated(elementLocated);
            driverWait.until(ExpectedConditions.elementToBeSelected(elementLocated));
        } catch (Exception e) {
            Exceptions.handle(e);
        }
        return this;
    }

    public Explicit elementToBeUnSelected(@NotNull final By elementLocated) {
        try {
            visibilityOfElementLocated(elementLocated);
            driverWait.until(ExpectedConditions.elementSelectionStateToBe(elementLocated, false));
        } catch (Exception e) {
            Exceptions.handle(e);
        }
        return this;
    }

    public Explicit elementSelectionStateToBe(@NotNull final By elementLocated, @NotNull final boolean state) {
        try {
            visibilityOfElementLocated(elementLocated);
            driverWait.until(ExpectedConditions.elementSelectionStateToBe(elementLocated, state));
        } catch (Exception e) {
            Exceptions.handle(e);
        }
        return this;
    }

    public Explicit textToBePresentInElementLocated(@NotNull final By elementLocated, @NotNull final String expectedText) {
        try {
            visibilityOfElementLocated(elementLocated);
            driverWait.until(ExpectedConditions.textToBePresentInElementLocated(elementLocated, expectedText));
        } catch (Exception e) {
            Exceptions.handle(e);
        }
        return this;
    }

    public Explicit textToBe(@NotNull final By elementLocated, @NotNull final String expectedText) {
        try {
            visibilityOfElementLocated(elementLocated);
            driverWait.until(ExpectedConditions.textToBe(elementLocated, expectedText));
        } catch (Exception e) {
            Exceptions.handle(e);
        }
        return this;
    }

    public Explicit contextToBe(@NotNull final String context) {
        String currentContext;
        try {
            do {
                currentContext = ((AndroidDriver) DriverManager.getDriverInstance()).getContext();
            } while (!Objects.requireNonNull(currentContext).equalsIgnoreCase(context));
        } catch (Exception e) {
            Exceptions.handle(e);
        }
        return this;
    }

    public Explicit urlContains(@NotNull final String expectedURL) {
        try {
            driverWait.until(ExpectedConditions.urlContains(expectedURL));
        } catch (Exception e) {
            Exceptions.handle(e);
        }
        return this;
    }

    public Explicit urlToBe(@NotNull final String expectedURL) {
        try {
            driverWait.until(ExpectedConditions.urlToBe(expectedURL));
        } catch (Exception e) {
            Exceptions.handle(e);
        }
        return this;
    }
}