package pageObjects.nopecommerce.user;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import common.PageGeneratorManager;
import io.qameta.allure.Step;
import pageUIs.nopecommerce.user.UserHomePageUI;

public class UserHomePageObject extends BasePage {
	
	WebDriver driver;
	public UserHomePageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	@Step("Open register page")
	public UserRegisterPageObject clickToRegisterLink() {
		waitForElementClickAble(driver, UserHomePageUI.REGISTER_LINK);
		clickToElement(driver, UserHomePageUI.REGISTER_LINK);
		
		return PageGeneratorManager.getUserRegisterPageeObject(driver);
	}
	

	@Step("click logout link")
	public UserLoginPageObject clickLoginLink() {
		waitForElementClickAble(driver, UserHomePageUI.LOGIN_LINK);
		clickToElement(driver, UserHomePageUI.LOGIN_LINK);
		return PageGeneratorManager.getUserLoginPageObject(driver);
	}
	
	@Step("Verify My account page is display")
	public boolean MyAccountIsDisplay() {
		waitForElementVisible(driver, UserHomePageUI.MYACCOUNT_LINK);
		return isElementDisplay(driver, UserHomePageUI.MYACCOUNT_LINK);
	}
	
	@Step("Open customer page")
	public UserCustomerInfoPageObject openCustomerInfoPage() {
		waitForElementClickAble(driver, UserHomePageUI.MYACCOUNT_LINK);
		clickToElement(driver, UserHomePageUI.MYACCOUNT_LINK);
		return PageGeneratorManager.getUserCustomerPageObject(driver);
	}

	public void clickAddCompareByProductName(String productName) {
		// TODO Auto-generated method stub
		waitForElementClickAble(driver, UserHomePageUI.COMPARE_BTN_BY_PRODUCT_NAME, productName);
		clickToElement(driver, UserHomePageUI.COMPARE_BTN_BY_PRODUCT_NAME, productName);
	}

	public void clickCompareProductLink() {
		// TODO Auto-generated method stub
		waitForElementClickAble(driver, UserHomePageUI.COMPARE_LINK);
		clickToElement(driver, UserHomePageUI.COMPARE_LINK);
	}

	public String getMessageAddCompare() {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, UserHomePageUI.MESSAGE_ADD_COMPARE_SUCCESS);
		return getElementText(driver, UserHomePageUI.MESSAGE_ADD_COMPARE_SUCCESS);
	}

}
