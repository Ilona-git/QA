package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class MyAccountPage {

    private WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//div[@data-react-toolbox= 'dialog']")
    WebElement dialogBox;

    @FindBy(xpath = "//h2[contains(text(), 'Congrats')]")
    WebElement congrats;


    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String getWelcomeText() {

        wait.until(ExpectedConditions.visibilityOf(dialogBox));
        System.out.println("switch to dialog");
        String text = dialogBox.getText();
        System.out.println(text);

        return text;
    }


}
