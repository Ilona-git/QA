package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pages.CreateAccountPage;
import pages.HomePage;
import pages.MyAccountPage;
import tests.base.Base;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class LoginTest extends Base {

    // Verify that the User is redirected to the Create an account page when clicking on  Create an account link
    @Test
    public void testCreateAccountRedirect() {

        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        CreateAccountPage createAccountPage = PageFactory.initElements(driver, CreateAccountPage.class);

        homePage.clickCreateAccountBtn();
        assertTrue(driver.getTitle().contains("Create Account | CrowdStreet"));

    }


    //Verify if a user can create account with a valid CC.
    @Test
    public void testCreateAccountWithValidCC() {

        CreateAccountPage createAccountPage = PageFactory.initElements(driver, CreateAccountPage.class);
        MyAccountPage myAccountPage = PageFactory.initElements(driver, MyAccountPage.class);
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);

        homePage.clickCreateAccountBtn();
        createAccountPage.fillEmail("ilonagoro2@gmail.com");
        createAccountPage.fillFirsAndLastname("ilona", "har");
        createAccountPage.setPassword("123Rf!kcKjsndod");
        createAccountPage.fillPhoneNumber("123434567");
        createAccountPage.fillAdress("Spectrum");
        createAccountPage.fillCity("Irvine");
        createAccountPage.fillzipCode("92618");
        createAccountPage.chooseState("California (CA)");
        createAccountPage.chooseCountry("United States of America");
        createAccountPage.clickAgreeCheckBox();
        createAccountPage.clickInvestorNoCheckbox();
        createAccountPage.confirmCaptcha();
        createAccountPage.clickCreateAccountBtn();
    //  Verify that User is redirected to appropriate page after successful registration
        assertTrue(myAccountPage.getWelcomeText().contains("Congrats"));
    }


   // Verify password field maximum length.
    @Test
    public void checkPasswordFieldSize() {
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        CreateAccountPage createAccountPage = PageFactory.initElements(driver, CreateAccountPage.class);

        homePage.clickCreateAccountBtn();
        assertEquals(createAccountPage.getFieldSize(), "20");
    }

}


