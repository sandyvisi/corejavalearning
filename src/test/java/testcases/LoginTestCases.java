package testcases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basepackage.BaseClass;
import testsPageClasses.LoginTestPage;
import utils.ReadExcelSheet;

public class LoginTestCases {

	BaseClass bc;
	LoginTestPage loginpage;

	@BeforeTest
	public void initBrowser() throws IOException {
		bc = new BaseClass();
		bc.init();
	}

	@Test(dataProvider = "loginData", priority = 1, groups = "smoke")
	public void loginFunctions(String userName, String password) {
		loginpage = new LoginTestPage();
		loginpage.loginFunctions(userName, password);
		bc.waitForTitle();
		Assert.assertEquals(bc.getTitle(), "Free CRM");
		System.out.println(bc.getTitle());
	}

	@DataProvider(name = "loginData")
	public Object[][] logindatas() throws EncryptedDocumentException, IOException {

		return ReadExcelSheet.excelDatas();

	}

}
