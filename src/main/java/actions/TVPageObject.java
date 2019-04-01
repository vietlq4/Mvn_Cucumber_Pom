package actions;

import commons.AbstracPage;
import org.openqa.selenium.WebDriver;


public class TVPageObject extends AbstracPage {
	WebDriver driver;
	public TVPageObject(WebDriver mappingdriver) {
		driver= mappingdriver;
	}
	

}
