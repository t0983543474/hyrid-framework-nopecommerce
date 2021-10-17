package pageObjects;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUIs.LoginPageUI;

public class LoginPageObject extends BasePage {
	
	WebDriver driver;
	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void inputToEmail(String email) {
		sendKeyToElement(driver, LoginPageUI.EMAIL_TXT, email);
	}
	
	public void inputToPassword(String password) {
		sendKeyToElement(driver, LoginPageUI.PASSWORD_TXT, password);
	}
	
	public String getMessageErrorEmail() {
		return getElementText(driver, LoginPageUI.MESSAGE_ERROR_TEXT);
		
	}
	
	public String getMessageErrorSumary() {
		return getElementText(driver, LoginPageUI.MESSAGE_ERROR_SUMARY_TEXT);
	}
	
	public void clickLoginButton() {
		waitForElementClickAble(driver, LoginPageUI.LOGIN_BTN);
		clickToElement(driver, LoginPageUI.LOGIN_BTN);
	}

}
