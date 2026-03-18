package testcases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basepackage.BaseClass;
import testsclasses.LoginTestPage;
import utils.ReadExcelSheet;

public class LoginTestClass {

	BaseClass bc;
	LoginTestPage loginpage;

	@BeforeClass
	public void initBrowser() throws IOException {
		bc = new BaseClass();
		bc.init();
	}

	@Test(dataProvider = "loginData")
	public void loginFunctions(String userName, String password) {
		loginpage = new LoginTestPage();
		loginpage.loginFunctions(userName, password);
	}

	@DataProvider(name = "loginData")
	public Object[][] logindatas() throws EncryptedDocumentException, IOException {

		return ReadExcelSheet.excelDatas();

	}

	@AfterClass
	public void closeBrowser() {
		bc.tearDown();
	}

}
