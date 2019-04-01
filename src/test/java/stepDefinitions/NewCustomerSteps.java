package stepDefinitions;

import actions.AbstractPageObject;
import actions.NewCustomerPageObject;
import actions.PageFactoryManager;
import commons.AbstractTest;
import cucumber.api.java.en.And;

import cucumberOptions.Hooks;
import org.openqa.selenium.WebDriver;

public class NewCustomerSteps {
	WebDriver driver;
	private NewCustomerPageObject newCustomerPageObject;
	private AbstractTest abstractTest;
	private AbstractPageObject abstractPageObject;


	public NewCustomerSteps() {
		driver = Hooks.openBrowser();
		newCustomerPageObject = PageFactoryManager.openNewCustomerPage(driver);
		abstractPageObject = PageFactoryManager.getAbstracPageObject(driver);
		abstractTest = new AbstractTest();
	}
	
	@And("^I get Customer ID in \"([^\"]*)\" table$")
	public void iGetCustomerId(String locatorValue) {
		ShareData.customerId = abstractPageObject.getDynamicTextOnTable(driver,locatorValue);
	}
	
	@And("^I input to EmailField with data \"([^\"]*)\"$")
	public void iInputToEmailFieldWithData( String value) {
		value = abstractTest.randomNumber() + value;
		System.out.println(value);
		newCustomerPageObject.sendTextToEmailField(value);
	}
}
