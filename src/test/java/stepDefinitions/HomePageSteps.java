package stepDefinitions;

import actions.HomePageObject;
import actions.PageFactoryManager;
import commons.AbstractTest;
import cucumber.api.java.en.Then;

import cucumberOptions.Hooks;
import interfaces.HomePageUI;
import org.openqa.selenium.WebDriver;

public class HomePageSteps {
	WebDriver driver;
	private HomePageObject homePageObject;
	private AbstractTest abstractTest;

	public HomePageSteps() {
		driver = Hooks.openBrowser();
		homePageObject = PageFactoryManager.getHomePageDriver(driver);
		abstractTest = new AbstractTest();
	}

	@Then("^I verify Login success$")
	public void iVerifyLoginSuccess() {
		abstractTest.verifyTrue(homePageObject.isControlDisplayed(driver, HomePageUI.MANAGER_ID_TEXT, ShareData.userId));
	}

}