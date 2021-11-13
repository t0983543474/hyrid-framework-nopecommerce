package common;

import org.openqa.selenium.WebDriver;

import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;


public class PageGeneratorManager {
	
	public static HomePageObject getHomPageObject(WebDriver driver) {
		return  new HomePageObject(driver);
	}
	
	public static RegisterPageObject getRegisterPageeObject(WebDriver driver) {
		return new RegisterPageObject(driver);
	}
	
	public static LoginPageObject getLoginPageObject(WebDriver driver) {
		return new LoginPageObject(driver);
	}
	

}
