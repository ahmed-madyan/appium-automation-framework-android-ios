package waits;

import driver.DriverManager;
import exceptions.Exceptions;
import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class Fluent {
    public Fluent() {
    }

    private static final FluentWait<AppiumDriver> driverWait = new FluentWait<AppiumDriver>(DriverManager.getDriverInstance())
            .withTimeout(Duration.ofSeconds(60))
            .pollingEvery(Duration.ofSeconds(5))
            .ignoring(NoSuchElementException.class);

    public Fluent visibilityOfElementLocated(@NotNull final By elementLocated) {
        try {
            driverWait.until(ExpectedConditions.visibilityOfElementLocated(elementLocated));
        } catch (Exception e) {
            Exceptions.handle(e);
        }
        return this;
    }

    public Fluent elementToBeClickable(@NotNull final By elementLocated) {
        try {
            visibilityOfElementLocated(elementLocated);
            driverWait.until(ExpectedConditions.elementToBeClickable(elementLocated));
        } catch (Exception e) {
            Exceptions.handle(e);
        }
        return this;
    }

    public Fluent elementToBeSelected(@NotNull final By elementLocated) {
        try {
            visibilityOfElementLocated(elementLocated);
            driverWait.until(ExpectedConditions.elementToBeSelected(elementLocated));
        } catch (Exception e) {
            Exceptions.handle(e);
        }
        return this;
    }

    public Fluent elementToBeUnSelected(@NotNull final By elementLocated) {
        try {
            visibilityOfElementLocated(elementLocated);
            driverWait.until(ExpectedConditions.elementSelectionStateToBe(elementLocated, false));
        } catch (Exception e) {
            Exceptions.handle(e);
        }
        return this;
    }

    public Fluent elementSelectionStateToBe(@NotNull final By elementLocated, @NotNull final boolean state) {
        try {
            visibilityOfElementLocated(elementLocated);
            driverWait.until(ExpectedConditions.elementSelectionStateToBe(elementLocated, state));
        } catch (Exception e) {
            Exceptions.handle(e);
        }
        return this;
    }

    public Fluent textToBePresentInElementLocated(@NotNull final By elementLocated, @NotNull final String expectedText) {
        try {
            visibilityOfElementLocated(elementLocated);
            driverWait.until(ExpectedConditions.textToBePresentInElementLocated(elementLocated, expectedText));
        } catch (Exception e) {
            Exceptions.handle(e);
        }
        return this;
    }

    public Fluent textToBe(@NotNull final By elementLocated, @NotNull final String expectedText) {
        try {
            visibilityOfElementLocated(elementLocated);
            driverWait.until(ExpectedConditions.textToBe(elementLocated, expectedText));
        } catch (Exception e) {
            Exceptions.handle(e);
        }
        return this;
    }

    public Fluent contextToBe(@NotNull final String context) {
        String currentContext;
        try {
            do {
                currentContext = ((AndroidDriver) DriverManager.getDriverInstance()).getContext();
            } while (!currentContext.equalsIgnoreCase(context));
        } catch (Exception e) {
            Exceptions.handle(e);
        }
        return this;
    }

    public Fluent urlContains(@NotNull final String expectedURL) {
        try {
            driverWait.until(ExpectedConditions.urlContains(expectedURL));
        } catch (Exception e) {
            Exceptions.handle(e);
        }
        return this;
    }

    public Fluent urlToBe(@NotNull final String expectedURL) {
        try {
            driverWait.until(ExpectedConditions.urlToBe(expectedURL));
        } catch (Exception e) {
            Exceptions.handle(e);
        }
        return this;
    }
}