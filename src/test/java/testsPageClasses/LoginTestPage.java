package testsPageClasses;

import org.openqa.selenium.By;

import basepackage.BaseClass;

public class LoginTestPage extends BaseClass {

	private By loginLocator = By.xpath("//form[@class='ui large form']//input[@name='email']");
	private By passwordLocator = By.xpath("//form[@class='ui large form']//input[@name='password']");
	private By submitLocator = By.xpath("//form[@class='ui large form']//div[text()='Login']");

	private void enterUserName(By locator, String text) {
		sendKeys(locator, text);
	}

	private void enterPassword(By locator, String text) {
		sendKeys(locator, text);
	}

	private void clickSubmit(By locator) {
		click(locator);
	}

	public void loginFunctions(String userName, String password) {
		enterUserName(loginLocator, userName);
		enterPassword(passwordLocator, password);
		clickSubmit(submitLocator);

	}

}
