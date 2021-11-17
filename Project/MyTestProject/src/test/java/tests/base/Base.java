package tests.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class Base {

    public static WebDriver driver;
    public static String url = "https://test.crowdstreet.com";
    public WebDriverWait wait;


    @BeforeClass
    public void initialize() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Set the path for chromedriver.exe
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver.manage().window().maximize();
        driver.get(url);
    }

    @AfterClass
    public void quit() {
        driver.quit();
    }

}