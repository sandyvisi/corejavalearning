package testcases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import testsclasses.ContacsTestPage;

public class ContactTestCases {

	ContacsTestPage ct;

	@Test(priority = 2, dependsOnGroups = "smoke")
	public void contactSideBarFunctions() {
		ct = new ContacsTestPage();
		ct.contactActions();
	}

//	@AfterTest
//	public void closeBrowser() {
//		ct.tearDown();
//	}

}
