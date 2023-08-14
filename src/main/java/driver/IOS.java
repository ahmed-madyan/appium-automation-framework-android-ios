package driver;

import io.appium.java_client.ios.IOSDriver;

public class IOS {
    public IOS() {
    }

    public IOSDriver getDriverInstance() {
        return ((IOSDriver) DriverInitializer.getDriver());
    }
}