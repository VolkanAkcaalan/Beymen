package e2e.utils;

import e2e.stepDefinitions.PageInitializer;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class CommonMethods extends PageInitializer {

    public static WebDriver driver;


    public static void openAndLunchApplication() throws IOException {

        ConfigReader.readProperties(Constants.Configuration_FilePath);
        String isHeadless = ConfigReader.getPropertyValues("headless");

        switch (ConfigReader.getPropertyValues("browser")){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();

                if ("true".equalsIgnoreCase(isHeadless)) {
                    chromeOptions.addArguments("--headless=new");
                    chromeOptions.addArguments("--window-size=1920,1080");
                }
                driver = new ChromeDriver(chromeOptions);
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                throw new RuntimeException("Invalid browser name");
        }
        driver.manage().window().maximize();
        driver.get(ConfigReader.getPropertyValues("url"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.implicit_wait));
        initializeObjects();

    }

    public static void closeBrowser() {
        driver.quit();
    }

    public static WebDriverWait getWait() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait;
    }
    public static void waitForClick(WebElement element) {
        getWait().until(ExpectedConditions.elementToBeClickable(element));
    }
    public static Select waitForSelect(WebElement selectElement) {
        getWait().until(ExpectedConditions.elementToBeClickable(selectElement));
        return new Select(selectElement);
    }

    public static void click(WebElement element) {
        waitForClick(element);
        element.click();
    }

    public static String waitForText(WebElement element) {
        try {
            getWait().until(ExpectedConditions.visibilityOf(element));
            return element.getText().trim();
        } catch (TimeoutException e) {
            System.out.println("Timeout waiting for visibility of element: " + element);
            throw e;
        }
    }

}
