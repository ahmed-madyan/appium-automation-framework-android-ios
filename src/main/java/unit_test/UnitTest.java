package unit_test;

import readers.properties_reader.PropertiesDataManager;

public class UnitTest {
    public static void main(String[] args) {
        String appPackageMainActivity = PropertiesDataManager.getProperty("mobile_appActivity", PropertiesDataManager.Capability.MOBILE);
        System.out.println(PropertiesDataManager.getProperty("mobile_appActivity", PropertiesDataManager.Capability.MOBILE));
        PropertiesDataManager.editProperty("mobile_appActivity", "edited", PropertiesDataManager.Capability.MOBILE);
        System.out.println(PropertiesDataManager.getProperty("mobile_appActivity", PropertiesDataManager.Capability.MOBILE));
        PropertiesDataManager.editProperty("mobile_appActivity", appPackageMainActivity, PropertiesDataManager.Capability.MOBILE);
        System.out.println(PropertiesDataManager.getProperty("mobile_appActivity", PropertiesDataManager.Capability.MOBILE));
    }
}