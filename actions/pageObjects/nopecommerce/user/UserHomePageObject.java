package pageObjects.nopecommerce.user;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import common.PageGeneratorManager;
import pageUIs.nopecommerce.user.UserHomePageUI;

public class UserHomePageObject extends BasePage {
	
	WebDriver driver;
	public UserHomePageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public UserRegisterPageObject clickToRegisterLink() {
		waitForElementClickAble(driver, UserHomePageUI.REGISTER_LINK);
		clickToElement(driver, UserHomePageUI.REGISTER_LINK);
		
		return PageGeneratorManager.getUserRegisterPageeObject(driver);
	}
	

	
	public UserLoginPageObject clickLoginLink() {
		waitForElementClickAble(driver, UserHomePageUI.LOGIN_LINK);
		clickToElement(driver, UserHomePageUI.LOGIN_LINK);
		return PageGeneratorManager.getUserLoginPageObject(driver);
	}
	
	public boolean MyAccountIsDisplay() {
		waitForElementVisible(driver, UserHomePageUI.MYACCOUNT_LINK);
		return isElementDisplay(driver, UserHomePageUI.MYACCOUNT_LINK);
	}
	
	public UserCustomerInfoObject openCustomerInfoPage() {
		waitForElementClickAble(driver, UserHomePageUI.MYACCOUNT_LINK);
		clickToElement(driver, UserHomePageUI.MYACCOUNT_LINK);
		return PageGeneratorManager.getUserCustomerPageObject(driver);
	}

}
