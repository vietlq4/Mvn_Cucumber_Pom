package actions;

import commons.AbstracPage;
import org.openqa.selenium.WebDriver;

public class DeleteAccountPageObject extends AbstracPage {
	WebDriver driver;
	public DeleteAccountPageObject(WebDriver mappingdriver) {
		driver= mappingdriver;
	}

}
