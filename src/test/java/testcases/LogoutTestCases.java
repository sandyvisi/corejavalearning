package testcases;

import org.testng.annotations.Test;

import testsPageClasses.LogoutCogemento;

public class LogoutTestCases {

	LogoutCogemento logout;

	public void logoutFunctions() {

		logout = new LogoutCogemento();
		logout.logoutFunctions("Log Out");
	}

}
