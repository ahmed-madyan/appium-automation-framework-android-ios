package tests.ios;

import driver.DriverInitializer;
import org.testng.annotations.Test;
import pages.ios.Alerts;
import pages.ios.Home;
import readers.json_reader.JSONDataManager;

public class TestIOSAlerts extends DriverInitializer {
    private static final String testDataFilePath = ("src/test/resources/AlertViews.json");

    @Test
    public void testIOSAlerts() {
        new Home().openAlertsPage();
        new Alerts()
                .openTextEntry()
                .cancelTextEntryAlert()
                .openTextEntry()
                .sendTextEntryAlert(JSONDataManager.getJSONData(testDataFilePath, "alert_view_text", JSONDataManager.Types.STRING).toString())
                .acceptTextEntryAlert()
                .openTheConfirmCancelAlert()
                .cancelTheConfirmCancelAlert()
                .openTheConfirmCancelAlert()
                .assertConfirmCancelAlertMessage(JSONDataManager.getJSONData(testDataFilePath, "confirm_cancel_alert_message", JSONDataManager.Types.STRING).toString())
                .confirmTheConfirmCancelAlert();
    }
}