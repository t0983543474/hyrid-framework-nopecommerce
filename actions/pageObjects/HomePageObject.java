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
	

	
	public LoginPageObject clickLoginLink() {
		waitForElementClickAble(driver, HomePageUI.LOGIN_LINK);
		clickToElement(driver, HomePageUI.LOGIN_LINK);
		return PageGeneratorManager.getLoginPageObject(driver);
	}
	
	public boolean MyAccountIsDisplay() {
		waitForElementVisible(driver, HomePageUI.MYACCOUNT_LINK);
		return isElementDisplay(driver, HomePageUI.MYACCOUNT_LINK);
	}
	
	public CustomerInfoObject openCustomerInfoPage() {
		waitForElementClickAble(driver, HomePageUI.MYACCOUNT_LINK);
		clickToElement(driver, HomePageUI.MYACCOUNT_LINK);
		return PageGeneratorManager.getCustomerPageObject(driver);
	}

}
