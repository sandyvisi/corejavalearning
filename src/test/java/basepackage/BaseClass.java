package basepackage;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ConfigReader;

public class BaseClass {

	protected static WebDriver driver;
	protected static JavascriptExecutor js;
	protected static Actions action;
	protected static WebDriverWait wait;

	public void init() throws IOException {
//		ChromeOptions options = new ChromeOptions(); sfsfds
//		options.addArguments("--headless"); // Run without GUI
//		options.addArguments("--disable-gpu");
//		options.addArguments("--window-size=1920,1080");
//		options.addArguments("--no-sandbox"); // required on some CI environments
//		options.addArguments("--disable-dev-shm-usage"); // for memory issues in CI
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		ConfigReader.initPropertyFile();
		driver.get(ConfigReader.getValue("url"));
		js = (JavascriptExecutor) driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		action = new Actions(driver);

	}

	public void listOfElementsAndClickOneElement(By locator, String text) {
		List<WebElement> elements = driver.findElements(locator);

		for (WebElement element : elements) {

			if (element.getText().equalsIgnoreCase(text)) {
				element.click();
			}

		}

	}

	public String getUrl() {
		return driver.getCurrentUrl();
	}

	public void waitForTitle() {
		wait.until(ExpectedConditions.titleContains("Free"));
	}

	public String getTitle() {
		return driver.getTitle();
	}

	public void waitAndClickElement(By locator) {

		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		element.click();
	}

	public void moveToElement(By locator) {
		WebElement element = driver.findElement(locator);
		action.moveToElement(element).build().perform();
	}

	public void sendKeys(By locator, String text) {
		driver.findElement(locator).sendKeys(text);
	}

	public void click(By locator) {
		driver.findElement(locator).click();
	}

	public void tearDown() {

		driver.quit();

	}

}
