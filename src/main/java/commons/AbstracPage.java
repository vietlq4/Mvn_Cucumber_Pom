package commons;

import actions.MyAccountObject;
import actions.PageFactoryManager;
import interfaces.AbstractPageUI;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class AbstracPage {
	private int timeout = 20;
	private WebDriverWait wait;
// ************* Driver  ******************         
	public void openAnyUrl(WebDriver driver, String url) {
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public String getCurrentPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public void backToPreviousPage(WebDriver driver) {
		driver.navigate().back();

	}

	public void refreshCurrentPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	// ************* END Driver ******************
	public void clickToElement(WebDriver driver, String locator) {
		WebElement ele = driver.findElement(By.xpath(locator));
		ele.click();
	}

	public void clickToElement(WebDriver driver, String locator, String... valueDynamic) {
		locator = String.format(locator, (Object[]) valueDynamic);
		System.out.print("locator"+locator);
		WebElement ele = driver.findElement(By.xpath(locator));
		ele.click();
	}

	public void sendkeyToElement(WebDriver driver, String locator, String value) {
		WebElement ele = driver.findElement(By.xpath(locator));
		ele.clear();
		ele.sendKeys(value);
	}
	public void clickElementByJS(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}
	public void sendKeyToDateField(WebDriver driver, String locator, String inputValue, String... locatorValues) {
		locator = String.format(locator, (Object[]) locatorValues);
		WebElement element = driver.findElement(By.xpath(locator));
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('type', 'text');", element);
		element.clear();
		element.sendKeys(inputValue);
	}

	public void sendkeyToElement(WebDriver driver, String locator, String valueInput, String... valueDynamic) {
		locator = String.format(locator, (Object[]) valueDynamic);
		System.out.println("sendkeyToElement locator " + locator);
		WebElement ele = driver.findElement(By.xpath(locator));
		ele.clear();
		ele.sendKeys(valueInput);
	}
	public void sendKeysToDisableField(WebDriver driver, String locator, String inputValue, String... locatorValues) {
		locator = String.format(locator, (Object[]) locatorValues);
		WebElement element = driver.findElement(By.xpath(locator));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].removeAttribute('disabled')", element);
		element.clear();
		element.sendKeys(inputValue);
	}
	public String getTextAlert(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		return alert.getText();
	}
	public void acceptAlert(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	public void selectItemInDropDown(WebDriver driver, String locator, String item) {
		Select select = new Select(driver.findElement(By.xpath(locator)));
		select.selectByVisibleText(item);
	}
	public void scrollToElementByJS(WebDriver driver, String locator, String... locatorValues) {
		locator = String.format(locator, (Object[]) locatorValues);
		System.out.print("scrollToElementByJS"+locator);
		WebElement element = driver.findElement(By.xpath(locator));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	public void selectItemInDropDown(WebDriver driver, String item, String locator, String... locatorValues) {
		locator = String.format(locator, (Object[]) locatorValues);
		Select select = new Select(driver.findElement(By.xpath(locator)));
		select.selectByVisibleText(item);
	}
	public void selecItemInDropdown(WebDriver driver, String locator, String item) {
		Select select = new Select(driver.findElement(By.xpath(locator)));
		select.selectByVisibleText(item);
	}

	public void selectCustomDropdownList(WebDriver driver, String locator, String itemsList, String itemvalue) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		WebElement element = driver.findElement(By.xpath(locator));
		((JavascriptExecutor) driver).executeScript("arguments.scrollIntoView(true);", element);
		element.click();
		List<WebElement> allItems = driver.findElements(By.xpath(itemsList));
		wait.until(ExpectedConditions.visibilityOfAllElements(allItems));

		for (WebElement items : allItems) {
			System.out.println("List items : " + items.getText());
			if (items.getText().trim().equals(itemvalue)) {
				// Scroll to item
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", items);
				items.click();
				break;
			}
		}
	}

	public String getFirstItemSelected(WebDriver driver, String locator) {
		Select select = new Select(driver.findElement(By.xpath(locator)));
		return select.getFirstSelectedOption().getText();
	}

	public String getAttribute(WebDriver driver, String locator, String attributeName) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.getAttribute(attributeName);
	}

	public String getTextElement(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.getText();
	}
	public String getTextElement(WebDriver driver, String locator,String ...valueDynamic) {
		locator = String.format(locator, (Object[]) valueDynamic);
		WebElement element = driver.findElement(By.xpath(locator));
		return element.getText();
	}

	public int getSizeElement(WebDriver driver, String locator) {
		List<WebElement> elements = driver.findElements(By.xpath(locator));
		return elements.size();
	}

	public void checkToCheckBox(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		if (!element.isSelected()) {
			element.click();
		}

	}

//	================ Wait ========================
	public void waitForControlVisible(WebDriver driver, String locator) {
		 wait = new WebDriverWait(driver, timeout);
		 System.out.println("waitForControlVisible locator " + locator);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
	}
   
	public void waitForControlVisible(WebDriver driver, String locator, String... valueDynamic) {
		//locator = String.format(locator, (Object[]) valueDynamic);
		String xpath = String.format(locator, (Object[]) valueDynamic);
		System.out.println("waitForControlVisible locator " + xpath);
		wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	}
     
	
	// ================Wait end==============
	public boolean isControlUndisplayed(WebDriver driver, String locator) {
		Date date = new Date();
		System.out.println("Started time = " + date.toString());
		overrideGlobalTimeout(driver, shorTimeout);
		List<WebElement> elements = driver.findElements(By.xpath(locator));
		if (elements.size() == 0) {
			date = new Date();
			System.out.println("End time = " + date.toString());
			overrideGlobalTimeout(driver, timeout);
			return true;
		} else {
			date = new Date();
			System.out.println("End time = " + date.toString());
			overrideGlobalTimeout(driver, timeout);
			return false;
		}
	}

	public boolean isControlUndisplayed(WebDriver driver, String locator, String... value) {
		Date date = new Date();
		System.out.println("Started time = " + date.toString());
		overrideGlobalTimeout(driver, shorTimeout);
		locator = String.format(locator, (Object[]) value);
		List<WebElement> elements = driver.findElements(By.xpath(locator));
		if (elements.size() == 0) {
			date = new Date();
			System.out.println("End time = " + date.toString());
			overrideGlobalTimeout(driver, timeout);
			return true;
		} else {
			date = new Date();
			System.out.println("End time = " + date.toString());
			overrideGlobalTimeout(driver, timeout);
			return false;
		}
	}

	public boolean isControlDisplayed(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.isDisplayed();
	}

	public boolean isControlDisplayed(WebDriver driver, String locator, String valueDynamic) {
		locator = String.format(locator, valueDynamic);
		WebElement element = driver.findElement(By.xpath(locator));
		return element.isDisplayed();
	}

	public boolean isControlDisplayed(WebDriver driver, String locator, String... locatorValues) {
		locator = String.format(locator, (Object[]) locatorValues);
		WebElement element = driver.findElement(By.xpath(locator));
		return element.isDisplayed();
	}



	public void overrideGlobalTimeout(WebDriver driver, long timeOut) {
		driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
	}

	private int shorTimeout = 5;
	public void keyTabPressDown(WebDriver driver) {
		Actions action = new Actions(driver);
		action.sendKeys(Keys.TAB).build().perform();
	}
	public void clearFieldText(WebDriver driver, String locator, String... locatorValues) {
		locator = String.format(locator, (Object[]) locatorValues);
		WebElement element = driver.findElement(By.xpath(locator));
		element.clear();
	}
	// ===================== Action Dynamic start =====================
	public void openDynamicAnyPages(WebDriver driver, String pageName) {
		waitForControlVisible(driver, AbstractPageUI.DynamicLocator.DYNAMIC_XPATH_OPENPAGE, pageName);
		clickToElement(driver, AbstractPageUI.DynamicLocator.DYNAMIC_XPATH_OPENPAGE, pageName);
	}

	public void leaveDynamicTextBoxBlank(WebDriver driver, String locatorValue) {
		waitForControlVisible(driver, AbstractPageUI.DynamicLocator.DYNAMIC_TEXTBOX, locatorValue);
		clickToElement(driver, AbstractPageUI.DynamicLocator.DYNAMIC_TEXTBOX, locatorValue);
		clearFieldText(driver, AbstractPageUI.DynamicLocator.DYNAMIC_TEXTBOX, locatorValue);
		keyTabPressDown(driver);
	}

	public void leaveDynamicTextAreaBlank(WebDriver driver, String locatorValue) {
		waitForControlVisible(driver, AbstractPageUI.DynamicLocator.DYNAMIC_TEXTAREA, locatorValue);
		clickToElement(driver, AbstractPageUI.DynamicLocator.DYNAMIC_TEXTAREA, locatorValue);
		clearFieldText(driver, AbstractPageUI.DynamicLocator.DYNAMIC_TEXTAREA, locatorValue);
		keyTabPressDown(driver);
	}

	public boolean isDynamicErrorTextField(WebDriver driver, String expectedValue, String... locatorValues) {
		waitForControlVisible(driver, AbstractPageUI.DynamicLocator.DYNAMIC_ERROR_MESS, locatorValues);
		return getTextElement(driver, AbstractPageUI.DynamicLocator.DYNAMIC_ERROR_MESS, locatorValues).equals(expectedValue);
	}

	public void waitSleepWithDynamicTime(String timeSecond) {
		long time = Long.parseLong(timeSecond);
		try {
			Thread.sleep(time * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	// ===================== Action Dynamic END =====================

	// ===================== get page start =====================
//	 public AbstracPage getDynamicPageFromButton(WebDriver driver,String PageName){
//		 waitForControlVisible(driver, AbstractPageUI.DYNAMIC_BUTTON,PageName);
//		 clickToElement(driver, AbstractPageUI.DYNAMIC_BUTTON,PageName);
//		 
//		 return null;
//	 }


	// ===================== get page start =====================

}
