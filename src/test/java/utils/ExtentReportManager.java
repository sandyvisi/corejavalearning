package utils;

import java.io.IOException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import basepackage.BaseClass;

public class ExtentReportManager extends BaseClass implements ITestListener {

	String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

	String reportPath = System.getProperty("user.dir") + "\\Reports\\" + timestamp + ".html";

	public ExtentSparkReporter extentSparkReporter;
	public ExtentReports extentReports;
	public ExtentTest logger;

	@Override
	public void onStart(ITestContext context) {

		extentSparkReporter = new ExtentSparkReporter(reportPath);

		extentSparkReporter.config().setDocumentTitle("cogmento report");
		extentSparkReporter.config().setReportName("smoke report");
		extentSparkReporter.config().setTheme(Theme.STANDARD);

		extentReports = new ExtentReports();
		extentReports.attachReporter(extentSparkReporter);

		extentReports.setSystemInfo("Computer Name", "sandy");
		extentReports.setSystemInfo("Browser name", "chrome");
		extentReports.setSystemInfo("Tester Name", "Santhosh");
		extentReports.setSystemInfo("Environment Name", "QA");
		extentReports.setSystemInfo("OS", "Windows10 Pro");

		System.out.println("execution is started after class is instantiated  " + context.getName());
	}

	@Override
	public void onTestStart(ITestResult result) {

		logger = extentReports.createTest(result.getName());// create new entry in the report

		System.out.println("test method is started to execute " + result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		logger.log(Status.PASS, "TEST IS PASSED " + result.getName());
		System.out.println("test method is passed  " + result.getName());

	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		logger.log(Status.FAIL, "TEST IS FAILED " + result.getName());
		logger.log(Status.FAIL, "TEST IS FAILED " + result.getThrowable());

		System.out.println("Test method FAILED: " + result.getName());
		System.out.println("Exception message: " + result.getThrowable());

		try {
			String screenshotPath = TakessScreenshotUtility.getScreenshot(driver, result.getName());
			logger.addScreenCaptureFromPath(screenshotPath);
			System.out.println("Screenshot saved at: " + screenshotPath);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		logger.log(Status.SKIP, "TEST IS SKIPPED " + result.getName());

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		logger.log(Status.INFO, "TEST IS failedWithSuccessPercentage " + result.getName());
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		logger.log(Status.INFO, "TEST IS failedWithTimeout " + result.getName());
	}

	@Override
	public void onFinish(ITestContext context) {

		extentReports.flush();

	}

}
