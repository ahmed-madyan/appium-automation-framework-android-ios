package driver;

import io.appium.java_client.AppiumDriver;
import org.testng.annotations.*;
import readers.properties_reader.PropertiesConfigurations;

public class DriverInitializer {
    private static final ThreadLocal<AppiumDriver> appiumDriver = new ThreadLocal<>();

    @BeforeMethod(alwaysRun = true)
    @Parameters("PlatformName")
    protected void initializeDriver(String platformName) {
        PropertiesConfigurations.setConfigProperties();
        System.out.println("Execution Address: " + PropertiesConfigurations.getExecutionAddress());
        switch (PropertiesConfigurations.getExecutionAddress()) {
            case "local" -> setDriver(DriverLocalServiceInitializer.localServiceInitialization());
            case "remote" -> setDriver(BrowserStackInitializer.browserStackInitialization(platformName));
            default -> {
                System.out.println("Kindly set the execution platform address.");
                throw new RuntimeException();
            }
        }
        System.out.println("Session Id: " + getDriver().getSessionId());
    }

    @AfterMethod(alwaysRun = true)
    protected void tearDownDriver() {
        //Tear the driver instance down
        DriverInitializer.appiumDriver.get().quit();
        DriverInitializer.appiumDriver.remove();
    }

        protected static AppiumDriver getDriver () {
            return DriverInitializer.appiumDriver.get();
    }

        private static void setDriver (AppiumDriver appiumDriver){
            DriverInitializer.appiumDriver.set(appiumDriver);
    }
}