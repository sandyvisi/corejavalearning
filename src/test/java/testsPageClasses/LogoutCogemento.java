package testsPageClasses;

import org.openqa.selenium.By;

import basepackage.BaseClass;

public class LogoutCogemento extends BaseClass {

	private By settingIconLocator = By.xpath("//div/i[contains(@class,'settings icon')]");

	private By logoutMenus = By.xpath("//div[contains(@class,'menu transition visible')]//a");

	private void clickSettingsIcon(By locator) {

		waitAndClickElement(locator);

	}

	private void selectAnFeature(By locator, String text) {

		listOfElementsAndClickOneElement(locator, text);

	}

	public void logoutFunctions(String text) {

		clickSettingsIcon(settingIconLocator);

		selectAnFeature(logoutMenus, text);

	}

}
