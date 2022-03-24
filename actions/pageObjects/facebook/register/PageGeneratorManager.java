package pageObjects.facebook.register;

import org.openqa.selenium.WebDriver;


public class PageGeneratorManager {
	public static RegisterPageObject getRegisterPageObject(WebDriver driver) {
		return new RegisterPageObject(driver);
	}
	
	
}
