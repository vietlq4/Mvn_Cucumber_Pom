package actions;

import commons.AbstracPage;
import interfaces.AbstractPageUI;
import interfaces.NewCustomerPageUI;
import org.openqa.selenium.WebDriver;

public class NewCustomerPageObject extends AbstracPage {
	WebDriver driver;
	public NewCustomerPageObject(WebDriver mappingdriver) {
		driver= mappingdriver;
	}
   public WithDrawPageObject openWithDrawPage() {
	   waitForControlVisible(driver, NewCustomerPageUI.WITHDRAW_LINK);
	   clickToElement(driver,NewCustomerPageUI.WITHDRAW_LINK);
	   return PageFactoryManager.openWithDrawPage(driver);
   }
	public void sendTextToEmailField(String value) {
		waitForControlVisible(driver, AbstractPageUI.DynamicLocator.DYNAMIC_TEXTBOX, AbstractPageUI.FieldName.EMAIL_FIELD);
		sendkeyToElement(driver, AbstractPageUI.DynamicLocator.DYNAMIC_TEXTBOX, value, AbstractPageUI.FieldName.EMAIL_FIELD);
	}
}
