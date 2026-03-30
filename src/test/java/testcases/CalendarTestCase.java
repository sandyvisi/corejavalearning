package testcases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basepackage.BaseClass;
import testsPageClasses.CalendarTestPage;
import testsPageClasses.LoginTestPage;
import utils.ReadExcelSheet;

public class CalendarTestCase {

	BaseClass base = new BaseClass();
	LoginTestPage loginPage = new LoginTestPage();
	CalendarTestPage calendarPage = new CalendarTestPage();

	@Test(dataProvider = "loginData")
	public void calendarTestCases(String username, String password) throws IOException {
		base.init();
		loginPage.loginFunctions(username, password);
		calendarPage.calendarFunctions("this is calendar title");
	}

	@DataProvider(name = "loginData")
	public Object[][] getData() throws EncryptedDocumentException, IOException {

		return ReadExcelSheet.excelDatas();

	}

}
