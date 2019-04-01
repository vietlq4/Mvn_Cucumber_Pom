package actions;

import commons.AbstracPage;
import org.openqa.selenium.WebDriver;

import java.util.List;


public class HomePageObject extends AbstracPage {
	WebDriver driver;
	public HomePageObject(WebDriver mappingdriver) {
		driver= mappingdriver;
	}


}
