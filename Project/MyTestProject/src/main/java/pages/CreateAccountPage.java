package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class CreateAccountPage {


    private WebDriver driver;
    CreateAccountPage createAccountPage;
    WebDriverWait wait;


    @FindBy(xpath = "//input[@id='create_account_email']")
    WebElement emailField;

    @FindBy(xpath = "(//input[@id='create_account_email']//following::input)[1]")
    WebElement firstName;


    @FindBy(xpath = "(//input[@id='create_account_email']//following::input)[2]")
    WebElement lastName;

    @FindBy(xpath = "(//span[text() = 'Create a Password']//following::input)[1]")
    WebElement passwordField;

    @FindBy(xpath = "(//span[text() = 'Confirm Password']//following::input)[1]")
    WebElement confirmPasswordField;

    @FindBy(xpath = "(//span[contains(text(),'Phone Number')]/following::input)[1]")
    WebElement phoneNumberField;

    @FindBy(xpath = "(//span[contains(text(),'Street Address')]/following::input)[1]")
    WebElement streetAdressField;

    @FindBy(xpath = "(//span[contains(text(),'City')]/following::input)[1]")
    WebElement cityField;

    @FindBy(xpath = "(//span[contains(text(),'Zip or Postal Code')]/following::input)[1]")
    WebElement zipOrPostalCodeField;

    @FindBy(xpath = "(//i[@class='dropdown icon'])[1]")
    WebElement stateDropDownIcon;

    @FindBy(xpath = "(//i[@class='dropdown icon'])[2]")
    WebElement countryDropDownIcon;

    @FindBy(xpath = "(//div[@data-react-toolbox='radio'])[2]")
    WebElement noCheckBox;

    @FindBy(xpath = "//div[@data-react-toolbox= 'check']")
    WebElement iAgreeCheckBox;

    @FindBy(xpath = "//div[@class= 'recaptcha-checkbox-border']")
    WebElement captchaCheckBox;

    @FindBy(xpath = "//button[contains(text(),'Create account')]")
    WebElement createAccountBtn;

    @FindBy(xpath = "//div[@class= 'requirement-label']")
    WebElement passwordRequirements;


    public CreateAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(25));
    }


    public void fillEmail(String email) {
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void fillFirsAndLastname(String fName, String lName) {
        firstName.clear();
        firstName.sendKeys(fName);
        lastName.sendKeys(lName);
        lastName.sendKeys(Keys.TAB);
    }

    public void setPassword(String psw) {

        wait.until(ExpectedConditions.visibilityOf(passwordField));
        passwordField.sendKeys(psw);
        passwordField.sendKeys(Keys.TAB);

        wait.until(ExpectedConditions.visibilityOf(confirmPasswordField));
        confirmPasswordField.sendKeys(Keys.TAB);
        confirmPasswordField.sendKeys(psw);
    }

    public void fillPhoneNumber(String phone) {
        phoneNumberField.clear();
        phoneNumberField.sendKeys(phone);
    }

    public void fillAdress(String adress) {
        streetAdressField.sendKeys(adress);
    }

    public void fillzipCode(String zip) {
        zipOrPostalCodeField.sendKeys(zip);
    }

    public void fillCity(String city) {
        cityField.sendKeys(city);
    }

    public void chooseState(String state) {
        stateDropDownIcon.click();
        driver.findElement(By.xpath("//span[contains(text(),'" + state + "')]")).click();
    }

    public void chooseCountry(String country) {
        countryDropDownIcon.click();
        driver.findElement(By.xpath(" //span[text()='" + country + "']")).click();
    }

    public void clickInvestorNoCheckbox() {
        wait.until(ExpectedConditions.elementToBeClickable(noCheckBox));
        noCheckBox.click();
    }

    public void clickAgreeCheckBox() {
        wait.until(ExpectedConditions.elementToBeClickable(iAgreeCheckBox));
        iAgreeCheckBox.click();
    }

    public void confirmCaptcha() {

        WebElement iframe = driver.findElement(By.xpath("//iframe[@title='reCAPTCHA']"));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframe));

        Actions builder = new Actions(driver);
        builder.moveToElement(captchaCheckBox).click(captchaCheckBox);
        builder.perform();

        driver.switchTo().defaultContent();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("switch to default content");
    }

    public void clickCreateAccountBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(createAccountBtn));
        createAccountBtn.click();
    }


    public String getFieldSize() {

        String size = passwordField.getAttribute("size");
        System.out.println(size);

        if (size == null) {
            System.out.println("No limit is set.");
        } else {

            if (size.equals("20")) {
                System.out.println("Max character limit is set as expected.");
            }
        }
        return size;
    }


}





