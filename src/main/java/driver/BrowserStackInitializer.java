package driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.remote.DesiredCapabilities;
import readers.properties_reader.PropertiesConfigurations;
import readers.properties_reader.PropertiesDataManager;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class BrowserStackInitializer {
    private static final String browserStack_ServerURL =
            ("https://" +
                    PropertiesDataManager.getProperty("username", PropertiesDataManager.Capability.BROWSERSTACK) +
                    ":" +
                    PropertiesDataManager.getProperty("accessKey", PropertiesDataManager.Capability.BROWSERSTACK) +
                    "@hub-cloud.browserstack.com/wd/hub");
    private static final DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
    private static final HashMap<String, Object> browserstackOptions = new HashMap<>();
    private static AppiumDriver appiumDriver;

    protected static AppiumDriver browserStackInitialization() {
        System.out.println("TargetRemoteExecution: " + PropertiesConfigurations.getExecutionAddressConfig());
        switch (PropertiesConfigurations.getExecutionAddressConfig()) {
            case "manual" -> setupManually();
            case "yml" -> setupYML();
            default -> {
                System.out.println("Kindly set the target remote execution option.");
                throw new RuntimeException();
            }
        }
        return appiumDriver;
    }


    private static void setupManually() {
        //Build the Browser Stack service
        /**********************************************************************************************************/
        /****************************************Specify the App***************************************************/
        //Specify App
        desiredCapabilities.setCapability("app", PropertiesDataManager.getProperty("app", PropertiesDataManager.Capability.BROWSERSTACK));
        /**********************************************************************************************************/
        /****************************************Select device*****************************************************/
        //Select device
        desiredCapabilities.setCapability("platformName", PropertiesDataManager.getProperty("platformName", PropertiesDataManager.Capability.BROWSERSTACK));
        desiredCapabilities.setCapability("platformVersion", PropertiesDataManager.getProperty("platformVersion", PropertiesDataManager.Capability.BROWSERSTACK));
        desiredCapabilities.setCapability("deviceName", PropertiesDataManager.getProperty("deviceName", PropertiesDataManager.Capability.BROWSERSTACK));
        /**********************************************************************************************************/
        /****************************************Select an automation engine***************************************/
        //Select an automation engine
        desiredCapabilities.setCapability("automationName", PropertiesDataManager.getProperty("automationName", PropertiesDataManager.Capability.BROWSERSTACK));
        /**********************************************************************************************************/
        /****************************************Organize tests****************************************************/
        //Organize tests
        browserstackOptions.put("projectName", PropertiesDataManager.getProperty("projectName", PropertiesDataManager.Capability.BROWSERSTACK));
        browserstackOptions.put("buildName", PropertiesDataManager.getProperty("buildName", PropertiesDataManager.Capability.BROWSERSTACK));
        /**********************************************************************************************************/
        /****************************************Set debugging options*********************************************/
        //Set debugging options
        //1- Text logs are enabled by default, and cannot be disabled
        //2- Network Logs are disabled by default. To enable network logs use its capability
        browserstackOptions.put("networkLogs", PropertiesDataManager.getProperty("networkLogs", PropertiesDataManager.Capability.BROWSERSTACK));
        //3- Device logs are enabled by default. To disable device logs use its capability
        browserstackOptions.put("deviceLogs", PropertiesDataManager.getProperty("deviceLogs", PropertiesDataManager.Capability.BROWSERSTACK));
        //4- Appium logs are enabled by default. To disable Appium logs use its capability
        browserstackOptions.put("appiumLogs", PropertiesDataManager.getProperty("appiumLogs", PropertiesDataManager.Capability.BROWSERSTACK));
        //5- Visual logs are disabled by default. To enable visual logs use its capability
        browserstackOptions.put("debug", PropertiesDataManager.getProperty("debug", PropertiesDataManager.Capability.BROWSERSTACK));
        //6- Video logs are enabled by default. Note that video recording slightly increases the text execution time. To disable video logs use its capability
        browserstackOptions.put("video", PropertiesDataManager.getProperty("video", PropertiesDataManager.Capability.BROWSERSTACK));
        /**********************************************************************************************************/
        /****************************************Set Appium version************************************************/
        //Set Appium version
        browserstackOptions.put("appiumVersion", PropertiesDataManager.getProperty("appiumVersion", PropertiesDataManager.Capability.BROWSERSTACK));
        /**********************************************************************************************************/
        /*********************************Set browser stack capability options ************************************/
        //Set bstack:options capabilities
        desiredCapabilities.setCapability("bstack:options", browserstackOptions);
        /**********************************************************************************************************/
        //Initialize the driver and launch the app
        switch (PropertiesConfigurations.getPlatformName()) {
            case "android" -> {
                try {
                    appiumDriver = new AndroidDriver(new URL(browserStack_ServerURL), desiredCapabilities);
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                }
            }
            case "ios" -> {
                try {
                    appiumDriver = new IOSDriver(new URL(browserStack_ServerURL), desiredCapabilities);
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                }
            }
            default -> {
                System.out.println("Kindly set the target operating system option.");
                throw new RuntimeException();
            }
        }
    }

    private static void setupYML() {
        switch (PropertiesConfigurations.getPlatformName()) {
            case "android" -> {
                try {
                    MutableCapabilities capabilities = new UiAutomator2Options();
                    appiumDriver = new AndroidDriver(new URL(PropertiesDataManager.getProperty("appiumServerURL", PropertiesDataManager.Capability.BROWSERSTACK)), capabilities);
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                }
            }
            case "ios" -> {
                try {
                    MutableCapabilities capabilities = new XCUITestOptions();
                    appiumDriver = new IOSDriver(new URL(PropertiesDataManager.getProperty("appiumServerURL", PropertiesDataManager.Capability.BROWSERSTACK)), capabilities);
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                }
            }
            default -> {
                System.out.println("Kindly set the target operating system option.");
                throw new RuntimeException();
            }
        }
    }
}