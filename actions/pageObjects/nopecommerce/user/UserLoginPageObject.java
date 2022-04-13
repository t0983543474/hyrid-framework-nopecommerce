package pageObjects.nopecommerce.user;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import common.PageGeneratorManager;
import io.qameta.allure.Step;
import pageUIs.nopecommerce.user.UserLoginPageUI;

public class UserLoginPageObject extends BasePage {
	
	WebDriver driver;
	public UserLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void inputToEmail(String email) {
		sendKeyToElement(driver, UserLoginPageUI.EMAIL_TXT, email);
	}
	
	public void inputToPassword(String password) {
		sendKeyToElement(driver, UserLoginPageUI.PASSWORD_TXT, password);
	}
	
	public String getMessageErrorEmail() {
		return getElementText(driver, UserLoginPageUI.MESSAGE_ERROR_TEXT);
		
	}
	
	public String getMessageErrorSumary() {
		return getElementText(driver, UserLoginPageUI.MESSAGE_ERROR_SUMARY_TEXT);
	}
	
	@Step("CLick login button")
	public UserHomePageObject clickLoginButton() {
		waitForElementClickAble(driver, UserLoginPageUI.LOGIN_BTN);
		clickToElement(driver, UserLoginPageUI.LOGIN_BTN);
		return PageGeneratorManager.getUserHomPageObject(driver);
	}
	
	@Step("Login in portal user")
	public UserHomePageObject LoginPortalUser(String email , String password) {
		inputToEmail(email);
		inputToPassword(password);
		
		return clickLoginButton();
	}
	
	

}
