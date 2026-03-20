package testcases;

import org.testng.annotations.Test;

import testsclasses.CallsTestPage;

public class CallsTestCases {
	CallsTestPage callsTestPage;

	@Test(priority = 3)
	public void callFeatureFunctions() {
		callsTestPage = new CallsTestPage();
		callsTestPage.callFunctions();
	}

}
