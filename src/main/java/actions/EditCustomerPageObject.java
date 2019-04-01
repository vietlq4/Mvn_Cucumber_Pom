package actions;

import commons.AbstracPage;
import org.openqa.selenium.WebDriver;

public class EditCustomerPageObject extends AbstracPage {
	WebDriver driver;
	public EditCustomerPageObject(WebDriver mappingdriver) {
		driver= mappingdriver;
	}

}
