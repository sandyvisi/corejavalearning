package testsPageClasses;

import org.openqa.selenium.By;

import basepackage.BaseClass;

public class CallsTestPage extends BaseClass {

	private By callIconLocator = By.xpath("//a[contains(@href,'calls')]/i[contains(@class,'phone')]");

//	private void clickCallIcon(By locator) {
//
//		click(locator);
//
//	}

	public void callFunctions() {
		waitAndClickElement(callIconLocator);
		String currentUrl = getUrl();
		System.out.println(currentUrl);

	}

}
