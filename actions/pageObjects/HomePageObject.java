package pageObjects;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import common.PageGeneratorManager;
import pageUIs.HomePageUI;

public class HomePageObject extends BasePage {
	
	WebDriver driver;
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public RegisterPageObject clickToRegisterLink() {
		waitForElementClickAble(driver, HomePageUI.REGISTER_LINK);
		clickToElement(driver, HomePageUI.REGISTER_LINK);
		
		return PageGeneratorManager.getRegisterPageeObject(driver);
	}
	
	public void clickLogOutLink() {
		waitForElementClickAble(driver, HomePageUI.LOGOUT_LINK);
		clickToElement(driver, HomePageUI.LOGOUT_LINK);
	}
	
	public LoginPageObject clickLoginLink() {
		waitForElementClickAble(driver, HomePageUI.LOGIN_LINK);
		clickToElement(driver, HomePageUI.LOGIN_LINK);
		return PageGeneratorManager.getLoginPageObject(driver);
	}
	
	public boolean MyAccountIsDisplay() {
		waitForElementVisible(driver, HomePageUI.MYACCOUNT_LINK);
		return isElementDisplay(driver, HomePageUI.MYACCOUNT_LINK);
	}

}
