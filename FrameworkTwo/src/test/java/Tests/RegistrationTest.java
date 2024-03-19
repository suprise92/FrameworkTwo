package Tests;

import Pages.HomePage;
import Pages.RegistrationPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static Utils.ExtentReports.ExtentTestManager.startTest;

public class RegistrationTest extends BaseTest {
    HomePage home = new HomePage();//Create instances of the HomePage class
    RegistrationPage register = new RegistrationPage();//Create instances of the LoginPage class

    //The above instances will be used to interact with the web pages during the test.
    @Test()//This is a TestNG annotation that marks a method as a test method.
    public void InvalidRegistration() {//This method is the first test case
        startTest("Invalid Registration Scenario", "Invalid Registration Scenario with incorrect username and password.");
        //The home instance of the HomePage class is used to access the navigateToUrl and navigateToLoginPage methods.
        home.navigateToUrl();
        home.navigateToRegistrationPage();
        //calling the EnterLoginDetails method on the login instance of the LoginPage class, passing in the email and password.
        register.EnterRegisterDetails("Email@ABC.com", "Password123");
        //using the TestNG Assert.assertEquals method to check if the login attempt is unsuccessful.
        //It verifies that the text returned by VerifyUnsuccessfulLoginTxt matches the expected text.
        Assert.assertEquals(register.VerifyUnsuccessfulLRegisterTxt(), "Login was unsuccessful. Please correct the errors and try again.", "Incorrect error message displayed");

    }

        @Test()
        public void validRegistration(){
            startTest("Valid Registration Scenario", "Valid Registration Scenario with correct username and password.");
            home.navigateToUrl();
            home.navigateToLoginPage();
            register.EnterRegisterDetails("smarintse@inspiredtesting.com","7877473@s");
            Assert.assertEquals(register.VerifySuccessfulLRegisterTxt(),"smarintse@inspiredtesting.com", "Not Logged in !");
        }


    }
