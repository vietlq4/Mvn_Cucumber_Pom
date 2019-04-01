package actions;

import commons.AbstracPage;
import org.openqa.selenium.WebDriver;

public class WithDrawPageObject extends AbstracPage {
	WebDriver driver;
	public WithDrawPageObject(WebDriver mappingdriver) {
		driver= mappingdriver;
	}

}
