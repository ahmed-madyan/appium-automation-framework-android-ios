package driver;

import io.appium.java_client.AppiumDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import readers.properties_reader.PropertiesConfigurations;

public class DriverInitializer {
    private static AppiumDriver appiumDriver;

    @BeforeClass(alwaysRun = true)
    @Parameters("PlatformName")
    protected void initializeDriver(String platformName) {
        PropertiesConfigurations.setConfigProperties();
        System.out.println("Execution Platform: " + PropertiesConfigurations.getExecutionAddress());
        switch (PropertiesConfigurations.getExecutionAddress()) {
            case "local" -> setDriver(DriverLocalServiceInitializer.localServiceInitialization());
            case "remote" -> setDriver(BrowserStackInitializer.browserStackInitialization(platformName));
            default -> {
                System.out.println("Kindly set the execution platform address.");
                throw new RuntimeException();
            }
        }
    }

    @AfterClass(alwaysRun = true)
    protected void tearDownDriver() {
        //Tear the driver instance down
        DriverManager.quitDriver();
    }

        protected static AppiumDriver getDriver () {
            return appiumDriver;
    }

        private static void setDriver (AppiumDriver appiumDriver){
            DriverInitializer.appiumDriver = appiumDriver;
    }
}