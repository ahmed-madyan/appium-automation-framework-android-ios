package driver;

import io.appium.java_client.AppiumDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import readers.properties_reader.PropertiesConfigurations;
import waits.Waits;

public class DriverInitializer {
    public DriverInitializer(AppiumDriver appiumDriver) {
        DriverInitializer.appiumDriver = appiumDriver;
    }

    static AppiumDriver appiumDriver;

    @BeforeClass(alwaysRun = true)
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

    @AfterClass(alwaysRun = true)
    protected void tearDownDriver() {
        //Tear the driver instance down
        DriverInitializer.appiumDriver.quit();
    }

        protected static AppiumDriver getDriver () {
            return DriverInitializer.appiumDriver;
    }

        private static void setDriver (AppiumDriver appiumDriver){
            DriverInitializer.appiumDriver = appiumDriver;
    }
}