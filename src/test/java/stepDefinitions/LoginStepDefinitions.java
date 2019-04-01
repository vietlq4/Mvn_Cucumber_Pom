package stepDefinitions;

import actions.LoginPageObject;
import actions.PageFactoryManager;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumberOptions.Hooks;
import org.openqa.selenium.WebDriver;


public class LoginStepDefinitions {
    private LoginPageObject loginPageObject;
    public static String url;
    WebDriver driver;

    public LoginStepDefinitions() {
        driver = Hooks.openBrowser();
        loginPageObject = PageFactoryManager.openLoginPage(driver);
        url = driver.getCurrentUrl();
    }

    @Given("^I click Here link button$")
    public void iClickHereLinkButton() {
        loginPageObject.clickRegistHereButton();
    }

    @Then("^I click Login button$")
    public void iClickLoginButton() {
        System.out.println("Register page");
        loginPageObject.clickLoginButton();
    }




}
