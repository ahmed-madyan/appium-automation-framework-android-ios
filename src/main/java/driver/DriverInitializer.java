package driver;

import io.appium.java_client.AppiumDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import readers.properties_reader.PropertiesConfigurations;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class DriverInitializer {
    protected static String dateTime = null;

    @BeforeSuite(alwaysRun = true)
    public void generateBuildIdentifierDateTime() {
        dateTime = (new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Timestamp(System.currentTimeMillis())));
        System.out.println("Date time: " + dateTime);
    }

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
        BrowserStackInitializer.appiumDriver.get().quit();
    }

    protected static AppiumDriver getDriver() {
            return BrowserStackInitializer.appiumDriver.get();
    }

    private static void setDriver(AppiumDriver appiumDriver) {
            BrowserStackInitializer.appiumDriver.set(appiumDriver);
    }
}