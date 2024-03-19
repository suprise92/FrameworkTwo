package Pages;

import Utils.ExtentReports.ExtentTestManager;
import Utils.Logs.Log;
import com.ctc.wstx.shaded.msv_core.verifier.identity.SelectorMatcher;
import org.openqa.selenium.By;

import java.nio.channels.Selector;

public class RegistrationPage extends BasePage {
    private final By emailField = By.id("Email");//Declares a private constant By object named emailField,
    //used to locate the email input field on the login page using its ID attribute.
    private final By passwordField = By.id("Password");
    private final By registerBtn = By.className("login-button");//Declares a private constant By object named loginBtn,
    //used to locate the login button on the login page using its class name.
    private final By registerInEmailAccLinkTxt = By.xpath("//div[@class='header-links']//a[@class='account']");
    //Declares a private constant By object named loggedInEmailAccLinkTxt, used to locate an element on the login page using it a xpath.
    private final By registerErrorTxt = By.xpath("//div[@class='validation-summary-errors']//span");
    private final By invalidEmailTxt = By.className("field-validation-error");

    //This method is used to enter login details, It uses the provided email and password parameters and interacts with
    //the respective input fields and the login button on the page. Logging is also performed to track this action.
    public void EnterRegisterDetails(String email, String password){
        Log.info("Entering Register details");
        writeText(emailField, email);
        ExtentTestManager.getTest().pass("Successfully entered Email: " + email);
        writeText(passwordField, password);
        ExtentTestManager.getTest().pass("Successfully entered password: " + password);
        click(registerBtn);
        ExtentTestManager.getTest().pass("Successfully clicked Login Button");
    }


    //This method is used to verify a successful login by reading and returning the text from the element displaying
    //the logged-in user's email. Logging is used to provide information about this verification step.
    public String VerifyUnsuccessfulLRegisterTxt(){
        Log.info("Verifying Successful Login Text");
        ExtentTestManager.getTest().pass("Successfully verified '"+readText(registerInEmailAccLinkTxt)+"' is displayed");
        return readText(registerInEmailAccLinkTxt);
    }
    //This method is used to verify an unsuccessful login by reading and returning the text from the element that displays login error messages.
    //Logging is used to provide information about this verification step.
    public String VerifySuccessfulLRegisterTxt(){
        Log.info("Verifying Unsuccessful Login Text");
        ExtentTestManager.getTest().pass("Successfully verified '"+readText(registerErrorTxt)+"' is displayed");
        return readText(registerErrorTxt);

    }
}


