package tests.ios;

import driver.DriverInitializer;
import org.testng.annotations.Test;
import pages.ios.Alerts;
import pages.ios.Home;
import readers.properties_reader.PropertiesDataManager;

public class TestIOSAlerts extends DriverInitializer {
    private static final String testDataFilePath = ("src/test/resources/AlertViews.json");

    @Test
    public void testIOSAlerts() {
        new Home().openAlertsPage();
        new Alerts()
                .openTextEntry()
                .cancelTextEntryAlert()
                .openTextEntry()
                .sendTextEntryAlert(PropertiesDataManager.getProperty("alert_view_text", testDataFilePath))
                .acceptTextEntryAlert()
                .openTheConfirmCancelAlert()
                .cancelTheConfirmCancelAlert()
                .openTheConfirmCancelAlert()
                .assertConfirmCancelAlertMessage(PropertiesDataManager.getProperty("confirm_cancel_alert_message", testDataFilePath))
                .confirmTheConfirmCancelAlert();
    }
}