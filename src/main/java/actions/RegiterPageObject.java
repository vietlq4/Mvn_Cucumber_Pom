package actions;

import commons.AbstracPage;
import interfaces.RegisterPageUI;
import org.openqa.selenium.WebDriver;

public class RegiterPageObject extends AbstracPage {
	WebDriver driver;

	public RegiterPageObject(WebDriver mappingDriver) {
		driver = mappingDriver;
	}

	public void sendTextToEmailField(String value) {
		waitForControlVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, value);
	}


}
