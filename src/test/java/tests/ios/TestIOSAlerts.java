package tests.ios;

import driver.DriverInitializer;
import org.testng.annotations.Test;
import pages.ios.Alerts;
import pages.ios.Home;

public class TestIOSAlerts extends DriverInitializer {

    @Test
    public void testIOSAlerts() {
        new Home().openAlertsPage();
        new Alerts()
                .openTextEntry()
                .cancelTextEntryAlert()
                .openTextEntry()
                .sendTextEntryAlert("Ahmed")
                .acceptTextEntryAlert();
    }
}