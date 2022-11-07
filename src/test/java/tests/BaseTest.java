package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.logging.Logger;

public class BaseTest {
    WebDriver webDriver;

    final private String BASE_URL = "https://practis.co.il/automation/";
    private final Logger logger = Logger.getLogger("BaseTest");

    @BeforeClass
    public void configureWebDriver() {
        logger.info("Configuring web driver");
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUp() {
        startBrowser();
        maximizeBrowser();
        openBaseUrl();
    }

    @AfterMethod
    public void tearDown() {
        closeBrowser();
    }

    public void startBrowser() {
        logger.info("Starting browser");
        ChromeOptions chromeOptions = new ChromeOptions();
        webDriver = new ChromeDriver(chromeOptions);
    }

    public void maximizeBrowser() {
        logger.info("Maximizing browser");
        webDriver.manage().window().maximize();
    }

    public void openBaseUrl() {
        logger.info("Opening base URL: " + BASE_URL);
        webDriver.get(BASE_URL);
    }

    public void closeBrowser() {
        logger.info("Closing browser");
        webDriver.close();
    }
}