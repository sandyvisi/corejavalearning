package testsPageClasses;

import org.openqa.selenium.By;

import basepackage.BaseClass;

public class CalendarTestPage extends BaseClass {

	private By calendarSidebar = By.xpath("//div[@id='main-nav']//div//a/span[text()='Calendar']");
	private By createButton = By.xpath("//a[contains(@href,'calendar/new')]/button[@class='ui linkedin button']");
	private By titleInputField = By
			.xpath("//form[contains(@class,'ui form segment custom-form-container')]//input[@name='title']");
	private By saveButton = By.xpath("//button[text()='Save']");

	private void clickCalendarSidebar(By locator) {
		waitAndClickElement(locator);
	}

	private void clickCreateButton(By locator) {
		click(locator);
	}

	private void enterTitle(String text, By locator) {
		sendKeys(locator, text);
	}

	private void clickSaveButton(By locator) {
		waitAndClickElement(locator);
	}

	private void clearElement(By locator) {
		clearValues(locator);
	}

	public void calendarFunctions(String text) {

		clickCalendarSidebar(calendarSidebar);
		clickCreateButton(createButton);
		enterTitle(text, titleInputField);
		clearElement(titleInputField);
		System.out.println(driver.findElement(titleInputField).getText());
		clickSaveButton(saveButton);

	}

}
