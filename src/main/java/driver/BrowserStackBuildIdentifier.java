package driver;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.Test;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Arrays;

public class BrowserStackBuildIdentifier {
    @Setter
    @Getter
    public static int buildNumber;
    @Setter
    @Getter
    public static String dateTime;

    public static void generateBuildIdentifierDateTime() {
        setDateTime((new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Timestamp(System.currentTimeMillis()))));
    }

    public static void generateBuildNumber() {
        generateBuildIdentifierDateTime();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless=new");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://www.browserstack.com/users/sign_in");
        driver.findElement(By.id("user_email_login")).sendKeys("ahmed.madyan@vodafone.com");
        driver.findElement(By.id("user_password")).sendKeys("BrowserStack@1");
        driver.findElement(By.id("user_submit")).click();
        FluentWait<WebDriver> driverWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(60))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("builds-sidebar-button")));
        driver.findElement(By.className("builds-sidebar-button")).click();
        String firstBuild = driver.findElements(By.className("build__content")).get(0).getText();
        String[] code = StringUtils.substringsBetween(firstBuild, "No.", "at");
        String previousBuildNumber = Arrays.toString(code).replaceAll("[\\[\\]]", "");
        int buildInt = Integer.parseInt(previousBuildNumber.trim());
        setBuildNumber(buildInt + 1);
        driver.quit();
    }
}