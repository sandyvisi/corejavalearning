package utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import basepackage.BaseClass;

public class TakessScreenshotUtility {

	public static TakesScreenshot ts;

	public static String getScreenshot(WebDriver driver, String methodName) throws IOException {

		String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);

		String reportPath = System.getProperty("user.dir") + "\\screenshots\\" + timestamp + methodName + ".png";
		File destination = new File(reportPath);
//		destination.getParentFile().mkdirs();

		FileUtils.copyFile(source, destination);
		return reportPath;

	}

}
