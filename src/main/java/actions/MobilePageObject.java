package actions;

import commons.AbstracPage;
import org.openqa.selenium.WebDriver;

public class MobilePageObject extends AbstracPage {
	WebDriver driver;
	public MobilePageObject(WebDriver mappingdriver) {
		driver= mappingdriver;
	}

}
