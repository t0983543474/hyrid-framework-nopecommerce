package common;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseTest {
	private WebDriver driver;
	
	String projectPath = System.getProperty("user.dir");
	
	
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
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
		
		return driver;
	}
	
	public int getRandom() {
		Random ran = new Random();
		return ran.nextInt(9999);
	}

	
	

}
