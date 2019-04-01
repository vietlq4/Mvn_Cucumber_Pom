package actions;

import commons.AbstracPage;
import interfaces.AbstractPageUI;
import interfaces.LoginPageUI;
import org.openqa.selenium.WebDriver;

public class LoginPageObject extends AbstracPage {
WebDriver driver;
public LoginPageObject(WebDriver mappingdriver) {
	driver= mappingdriver;
}


    public RegiterPageObject clickRegistHereButton() {
        waitForControlVisible(driver, LoginPageUI.HERE_BUTTON);
        clickElementByJS(driver, LoginPageUI.HERE_BUTTON);
        return PageFactoryManager.openRegiterPage(driver);
    }

    public HomePageObject clickLoginButton() {
        waitForControlVisible(driver, AbstractPageUI.DynamicLocator.DYNAMIC_TEXTBOX,LoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, AbstractPageUI.DynamicLocator.DYNAMIC_TEXTBOX,LoginPageUI.LOGIN_BUTTON);
        return PageFactoryManager.getHomePageDriver(driver);
    }
    public String getLoginPageUrl() {
        return driver.getCurrentUrl();
    }
 
}
