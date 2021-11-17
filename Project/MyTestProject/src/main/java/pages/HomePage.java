package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    private WebDriver driver;
    HomePage homePage;
    WebDriverWait wait;

    @FindBy(xpath = "//a[@href='/invexp/accounts/create-account']")
    WebElement createAccountBtn;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void clickCreateAccountBtn() {
        CreateAccountPage createAccountPage = PageFactory.initElements(driver, CreateAccountPage.class);

        wait.until(ExpectedConditions.elementToBeClickable(createAccountBtn));
        createAccountBtn.click();
        wait.until(ExpectedConditions.elementToBeClickable(createAccountPage.emailField));
        System.out.println(driver.getTitle());

    }
}
