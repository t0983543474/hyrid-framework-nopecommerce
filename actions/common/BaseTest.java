package common;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.Reporter;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseTest {
	private WebDriver driver;
	
	String projectPath = System.getProperty("user.dir");
	
	protected final Log log;
	
	public BaseTest() {
		log = LogFactory.getLog(getClass());
	
	}
	
	public WebDriver getInstance() {
		return driver;
	}
	
	protected WebDriver getBrowser(String browserName) {
		if(browserName.equals("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if(browserName.equals("h-Chrome")) {
//			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDriver\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			ChromeOptions option = new ChromeOptions();
			option.addArguments("--headless");
			option.addArguments("window-size=1366x768");
			driver = new ChromeDriver(option);
		}else if(browserName.equals("FireFox")) {
//			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDriver\\geckodriver.exe");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}else if(browserName.equals("h-Firefox")) {
//			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDriver\\geckodriver.exe");
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions option = new FirefoxOptions();
			option.addArguments("--headless");
			option.addArguments("window-size=1366x768");
			driver = new FirefoxDriver(option);
		}else if(browserName.equals("Edge")) {
			WebDriverManager.edgedriver().setup();
//			System.setProperty("webdriver.edge.driver", projectPath + "\\browserDriver\\msedgedriver.exe");
			driver = new EdgeDriver();
		}else {
			throw new RuntimeException("Browser is invalid");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
		
		return driver;
	}
	
	protected WebDriver getBrowser(String browserName, String url) {
		if(browserName.equals("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if(browserName.equals("h-Chrome")) {
//			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDriver\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			ChromeOptions option = new ChromeOptions();
			option.addArguments("--headless");
			option.addArguments("window-size=1366x768");
			driver = new ChromeDriver(option);
		}else if(browserName.equals("FireFox")) {
//			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDriver\\geckodriver.exe");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}else if(browserName.equals("h-Firefox")) {
//			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDriver\\geckodriver.exe");
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions option = new FirefoxOptions();
			option.addArguments("--headless");
			option.addArguments("window-size=1366x768");
			driver = new FirefoxDriver(option);
		}else if(browserName.equals("Edge")) {
			WebDriverManager.edgedriver().setup();
//			System.setProperty("webdriver.edge.driver", projectPath + "\\browserDriver\\msedgedriver.exe");
			driver = new EdgeDriver();
		}else {
			throw new RuntimeException("Browser is invalid");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(url);
		
		return driver;
	}
	
	protected boolean verifyTrue(boolean condition) {
		boolean pass = true;
		try {
			Assert.assertTrue(condition);
			log.info("-------------PASS----------------");
		}catch(Throwable e) {
			log.info("--------------FAIL----------------");
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}
	
	protected boolean verifyFail(boolean condition) {
		boolean pass = true;
		try {
			Assert.assertFalse(condition);
			log.info("-------------PASS----------------");
		}catch(Throwable e) {
			log.info("--------------FAIL----------------");
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}
	
	protected boolean verifyEqual(Object actual , Object expected) {
		boolean pass = true;
		try {
			Assert.assertEquals(actual, expected);
			log.info("-------------PASS----------------");
		}catch(Throwable e) {
			log.info("--------------FAIL----------------");
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}
	
	public int getRandom() {
		Random ran = new Random();
		return ran.nextInt(9999);
	}

	
	protected void sleepSecond(long number) {
		try {
			Thread.sleep(number*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
