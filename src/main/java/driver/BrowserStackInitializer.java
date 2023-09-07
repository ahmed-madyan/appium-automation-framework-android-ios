package driver;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.remote.DesiredCapabilities;
import readers.properties_reader.PropertiesConfigurations;
import readers.properties_reader.PropertiesDataManager;
import waits.Waits;

import javax.swing.text.DateFormatter;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
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
    protected static ThreadLocal<AppiumDriver> appiumDriver = new ThreadLocal<>();
    private static String platformName;

    protected static AppiumDriver browserStackInitialization(String platformName) {
        BrowserStackInitializer.platformName = platformName;
        System.out.println("Execution Address Configuration: " + PropertiesConfigurations.getExecutionAddressConfig());
        switch (PropertiesConfigurations.getExecutionAddressConfig()) {
            case "manual" -> setupManually();
            case "yml" -> setupYML();
            default -> {
                System.out.println("Kindly set the target remote execution option.");
                throw new RuntimeException();
            }
        }
        return appiumDriver.get();
    }

    private static void setupManually() {
        switch (platformName) {
            case "Android" -> initAndroidDriver();
            case "iOS" -> initIOSDriver();
        }
    }

    private static void setupYML() {
        switch (PropertiesConfigurations.getPlatformName()) {
            case "android" -> {
                try {
                    MutableCapabilities capabilities = new UiAutomator2Options();
                    appiumDriver.set(new AndroidDriver(new URL(PropertiesDataManager.getProperty("appiumServerURL", PropertiesDataManager.Capability.BROWSERSTACK)), capabilities));
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                }
            }
            case "ios" -> {
                try {
                    MutableCapabilities capabilities = new XCUITestOptions();
                    appiumDriver.set(new IOSDriver(new URL(PropertiesDataManager.getProperty("appiumServerURL", PropertiesDataManager.Capability.BROWSERSTACK)), capabilities));
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

    private static void initAndroidDriver() {
        //Build the Browser Stack service
        /**********************************************************************************************************/
        /****************************************Specify the App***************************************************/
        //Specify App
        desiredCapabilities.setCapability("app", PropertiesDataManager.getProperty("androidApp", PropertiesDataManager.Capability.BROWSERSTACK));
        /**********************************************************************************************************/
        /****************************************Select device*****************************************************/
        //Select device
        desiredCapabilities.setCapability("platformName", PropertiesDataManager.getProperty("androidPlatformName", PropertiesDataManager.Capability.BROWSERSTACK));
        desiredCapabilities.setCapability("platformVersion", PropertiesDataManager.getProperty("androidPlatformVersion", PropertiesDataManager.Capability.BROWSERSTACK));
        desiredCapabilities.setCapability("deviceName", PropertiesDataManager.getProperty("androidDeviceName", PropertiesDataManager.Capability.BROWSERSTACK));
        /**********************************************************************************************************/
        /****************************************Select an automation engine***************************************/
        //Select an automation engine
        desiredCapabilities.setCapability("automationName", PropertiesDataManager.getProperty("androidAutomationName", PropertiesDataManager.Capability.BROWSERSTACK));
        /**********************************************************************************************************/
        /****************************************Organize tests****************************************************/
        //Organize tests
        browserstackOptions.put("projectName", PropertiesDataManager.getProperty("androidProjectName", PropertiesDataManager.Capability.BROWSERSTACK));
        /**********************************************************************************************************/
        /****************************************Organize tests****************************************************/
        //Organize tests
        browserstackOptions.put("buildName", PropertiesDataManager.getProperty("androidBuildName", PropertiesDataManager.Capability.BROWSERSTACK));
        browserstackOptions.put("buildIdentifier", new SimpleDateFormat(new DateFormatter("yyyy")));
        /**********************************************************************************************************/
        setCommonDesiredCapabilities();
        //Initialize the driver and launch the app
        try {
            System.out.println("Android Desired Capabilities: " + desiredCapabilities);
            appiumDriver.set(new AndroidDriver(new URL(browserStack_ServerURL), desiredCapabilities));
            Waits.fluentlyWait().visibilityOfElementLocated(AppiumBy.id("com.androidsample.generalstore:id/toolbar_title"));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void initIOSDriver() {
        //Build the Browser Stack service
        /**********************************************************************************************************/
        /****************************************Specify the App***************************************************/
        //Specify App
        desiredCapabilities.setCapability("app", PropertiesDataManager.getProperty("iOSApp", PropertiesDataManager.Capability.BROWSERSTACK));
        /**********************************************************************************************************/
        /****************************************Select device*****************************************************/
        //Select device
        desiredCapabilities.setCapability("platformName", PropertiesDataManager.getProperty("iOSPlatformName", PropertiesDataManager.Capability.BROWSERSTACK));
        desiredCapabilities.setCapability("platformVersion", PropertiesDataManager.getProperty("iOSPlatformVersion", PropertiesDataManager.Capability.BROWSERSTACK));
        desiredCapabilities.setCapability("deviceName", PropertiesDataManager.getProperty("iOSDeviceName", PropertiesDataManager.Capability.BROWSERSTACK));
        /**********************************************************************************************************/
        /****************************************Select an automation engine***************************************/
        //Select an automation engine
        desiredCapabilities.setCapability("automationName", PropertiesDataManager.getProperty("iOSAutomationName", PropertiesDataManager.Capability.BROWSERSTACK));
        /**********************************************************************************************************/
        /****************************************Organize tests****************************************************/
        //Organize tests
        browserstackOptions.put("projectName", PropertiesDataManager.getProperty("iOSProjectName", PropertiesDataManager.Capability.BROWSERSTACK));
        /**********************************************************************************************************/
        /****************************************Organize tests****************************************************/
        //Organize tests
        browserstackOptions.put("buildName", PropertiesDataManager.getProperty("iOSBuildName", PropertiesDataManager.Capability.BROWSERSTACK));
        /**********************************************************************************************************/
        setCommonDesiredCapabilities();
        //Initialize the driver and launch the app
        try {
            System.out.println("iOS Desired Capabilities: " + desiredCapabilities);
            appiumDriver.set(new IOSDriver(new URL(browserStack_ServerURL), desiredCapabilities));
            Waits.fluentlyWait().visibilityOfElementLocated(AppiumBy.accessibilityId("Alert Views"));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void setCommonDesiredCapabilities() {
//        browserstackOptions.put("buildIdentifier", new SimpleDateFormat("yyyy-MM-dd HH").format(new Timestamp(System.currentTimeMillis())));
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
        /****************************************Set Interactive Debugging*****************************************/
        browserstackOptions.put("interactiveDebugging", PropertiesDataManager.getProperty("interactiveDebugging", PropertiesDataManager.Capability.BROWSERSTACK));
        /**********************************************************************************************************/
        /****************************************Set Test Observability********************************************/
//        browserstackOptions.put("testObservability", PropertiesDataManager.getProperty("testObservability", PropertiesDataManager.Capability.BROWSERSTACK));
        /**********************************************************************************************************/
        /****************************************Set Appium version************************************************/
        //Set Appium version
        browserstackOptions.put("appiumVersion", PropertiesDataManager.getProperty("appiumVersion", PropertiesDataManager.Capability.BROWSERSTACK));
        /****************************************Set Device Settings************************************************/
        //Set Device Settings
        browserstackOptions.put("deviceOrientation", PropertiesDataManager.getProperty("deviceOrientation", PropertiesDataManager.Capability.BROWSERSTACK));
        /**********************************************************************************************************/
        /****************************************Set Security Settings*********************************************/
        //Set Security Settings
//        browserstackOptions.put("acceptInsecureCerts", PropertiesDataManager.getProperty("acceptInsecureCerts", PropertiesDataManager.Capability.BROWSERSTACK));
//        browserstackOptions.put("acceptSslCert", PropertiesDataManager.getProperty("acceptSslCert", PropertiesDataManager.Capability.BROWSERSTACK));
        /**********************************************************************************************************/
        /****************************************Set Framework of test suite************************************************/
        //Set Device Settings
//        browserstackOptions.put("framework", PropertiesDataManager.getProperty("framework", PropertiesDataManager.Capability.BROWSERSTACK));
        /**********************************************************************************************************/
        /*********************************Set browser stack capability options ************************************/
        //Set bstack:options capabilities
        desiredCapabilities.setCapability("bstack:options", browserstackOptions);
        /**********************************************************************************************************/
    }
}