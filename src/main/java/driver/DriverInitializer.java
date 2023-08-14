package driver;

import io.appium.java_client.AppiumDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import readers.properties_reader.PropertiesConfigurations;

public class DriverInitializer {
    private static AppiumDriver appiumDriver;

    @BeforeClass(alwaysRun = true)
    protected void initializeDriver() {
        PropertiesConfigurations.setConfigProperties();
        System.out.println("Execution Platform: " + PropertiesConfigurations.getExecutionAddress());
        setDriver(BrowserStackInitializer.browserStackInitialization());
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