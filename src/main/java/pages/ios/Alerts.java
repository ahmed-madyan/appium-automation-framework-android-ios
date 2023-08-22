package pages.ios;

import assertions.Assertions;
import elements.Elements;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class Alerts {
    private static final By TEXT_ENTRY_BUTTON = AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`name=='Text Entry'`]");
    private static final By TEXT_ENTRY_ALERT_TEXT_BOX = AppiumBy.iOSNsPredicateString("type == 'XCUIElementTypeTextField'");
    private static final By TEXT_ENTRY_ALERT_OK_BUTTON = AppiumBy.accessibilityId("OK");
    private static final By TEXT_ENTRY_ALERT_Cancel_BUTTON = AppiumBy.accessibilityId("Cancel");
    private static final By CONFIRM_CANCEL_ALERT_BUTTON = AppiumBy.accessibilityId("Confirm / Cancel");
    private static final By CONFIRM_CANCEL_ALERT_MESSAGE_TEXT = AppiumBy.iOSNsPredicateString("name BEGINSWITH[c] 'A message'");
    private static final By CONFIRM_CANCEL_ALERT_CONFIRM_BUTTON = AppiumBy.accessibilityId("Cancel");
    private static final By CONFIRM_CANCEL_ALERT_CANCEL_BUTTON = AppiumBy.accessibilityId("Confirm");

    public Alerts openTextEntry() {
        Elements
                .elementActions()
                .click(TEXT_ENTRY_BUTTON);
        return this;
    }

    public Alerts acceptTextEntryAlert() {
        Elements.elementActions()
                .click(TEXT_ENTRY_ALERT_OK_BUTTON);
        return this;
    }

    public Alerts cancelTextEntryAlert() {
        Elements.elementActions()
                .click(TEXT_ENTRY_ALERT_Cancel_BUTTON);
        return this;
    }

    public Alerts sendTextEntryAlert(String alertText) {
        Elements
                .elementActions()
                .sendKeys(TEXT_ENTRY_ALERT_TEXT_BOX, alertText);
        return this;
    }

    public Alerts openTheConfirmCancelAlert() {
        Elements.elementActions()
                .click(CONFIRM_CANCEL_ALERT_BUTTON);
        return this;
    }

    public Alerts cancelTheConfirmCancelAlert() {
        Elements.elementActions()
                .click(CONFIRM_CANCEL_ALERT_CANCEL_BUTTON);
        return this;
    }

    public Alerts confirmTheConfirmCancelAlert() {
        Elements.elementActions()
                .click(CONFIRM_CANCEL_ALERT_CONFIRM_BUTTON);
        return this;
    }

    public Alerts assertConfirmCancelAlertMessage() {
        Assertions
                .hardAssert()
                .elementDisplayed(CONFIRM_CANCEL_ALERT_MESSAGE_TEXT)
                .elementTextToBe(CONFIRM_CANCEL_ALERT_MESSAGE_TEXT, "A message should be a short, complete sentence.");
        return this;
    }
}