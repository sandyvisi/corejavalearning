package testsclasses;

import org.openqa.selenium.By;

import basepackage.BaseClass;

public class ContacsTestPage extends BaseClass {

	private By contactSidebar = By.xpath("//div[@id='main-nav']//div//a/span[text()='Contacts']");
	private By creaeteLocator = By.xpath("//div[@class='item']//a/button[text()='Create']");
	private By contactIcon = By.xpath("//div//a[contains(@href,'contacts')]");

//
//	private void clickContactSideBar(By locator) {
//
//		click(locator);
//	}
//
//	private void clickCreate(By locator) {
//
//		click(locator);
//	}

	public void contactActions() {
		waitAndClickElement(contactIcon);
		waitAndClickElement(contactSidebar);
		waitAndClickElement(creaeteLocator);
	}

}
