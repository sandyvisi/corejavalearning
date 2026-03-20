package testcases;

import org.testng.annotations.Test;

import testsPageClasses.CallsTestPage;
import testsPageClasses.LogoutCogemento;

public class CallsTestCases {
	CallsTestPage callsTestPage;
	LogoutCogemento settings = new LogoutCogemento();

	@Test(priority = 3)
	public void callFeatureFunctions() {
		callsTestPage = new CallsTestPage();
		callsTestPage.callFunctions();
		settings.logoutFunctions("Messages");

	}

}
