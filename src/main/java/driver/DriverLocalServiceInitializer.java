package driver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import readers.properties_reader.PropertiesDataManager;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class DriverLocalServiceInitializer {
    private static AppiumDriverLocalService appiumService;

    protected static AndroidDriver localServiceInitialization() {
        //Build the Appium service
        AppiumServiceBuilder serviceBuilder = new AppiumServiceBuilder()
                .withAppiumJS(new File("C:\\Users\\_VOIS\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                .withIPAddress(PropertiesDataManager.getProperty("executionIPAddress", PropertiesDataManager.Capability.EXECUTION))
                .usingPort(Integer.parseInt(PropertiesDataManager.getProperty("executionPort", PropertiesDataManager.Capability.EXECUTION)));
        //Start the server with the builder
        appiumService = AppiumDriverLocalService.buildService(serviceBuilder);
        appiumService.start();
        //Initialize the driver and launch the app
        try {
            return new AndroidDriver(new URL(PropertiesDataManager.getProperty("appiumServerURL", PropertiesDataManager.Capability.EXECUTION)),
                    new UiAutomator2Options()
                            .setDeviceName(PropertiesDataManager.getProperty("mobile_deviceName", PropertiesDataManager.Capability.MOBILE))
                            .setApp("C:\\Users\\_VOIS\\Documents\\GitHub\\general-store-ecommerce-hybrid-app-automation\\src\\main\\resources\\app_binaries\\General-Store.apk")
                            .setChromedriverExecutable("C:\\Users\\_VOIS\\Documents\\GitHub\\general-store-ecommerce-hybrid-app-automation\\src\\main\\resources\\app_binaries\\chromedriver.exe"));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    protected static void localServiceTermination() {
        //Stop the server with the builder
        appiumService.stop();
    }
}