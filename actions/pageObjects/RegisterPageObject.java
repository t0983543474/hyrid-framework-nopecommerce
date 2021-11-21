package pageObjects;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import common.PageGeneratorManager;
import pageUIs.HomePageUI;
import pageUIs.RegisterPageUI;

public class RegisterPageObject extends BasePage {
	WebDriver driver;
	
	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickToRegisterButton() {
		waitForElementClickAble(driver, RegisterPageUI.REGISTER_BTN);
		clickToElement(driver, RegisterPageUI.REGISTER_BTN);
	}

	public void inputToFirstNameTextBox(String firstName) {
		sendKeyToElement(driver, RegisterPageUI.FIRSTNAME_TXT, firstName);
	}
	
	public void inputToLastNameTextBox(String lastName) {
		sendKeyToElement(driver, RegisterPageUI.LASTNAME_TXT, lastName);
	}
	
	public void inputToEmailTextBox(String email) {
		sendKeyToElement(driver, RegisterPageUI.EMAIL_TXT, email);
	}
	
	public void inputToPasswordTextBox(String password) {
		sendKeyToElement(driver, RegisterPageUI.PASSWORD_TXT, password);
	}
	
	public void inputToConfirmPasswordTextBox(String confirmPassword) {
		sendKeyToElement(driver, RegisterPageUI.CONFIRM_PASSWORD_TXT, confirmPassword);
	}
	
	public String getErrorMessageLastnameTextbox() {
		return getElementText(driver, RegisterPageUI.LASTNAME_ERROR_MESSAGE_TEXT);
	}
	
	public String getErrorMessageEmailTextbox() {
		return getElementText(driver, RegisterPageUI.EMAIL_ERROR_MESSAGE_TEXT);
	}
	
	public String getErrorMessagePasswordTextbox() {
		return getElementText(driver, RegisterPageUI.PASSWORD_ERROR_MESSAGE_TEXT);
	}
	
	public String getErrorMessageConfirmPasswordTextbox() {
		return getElementText(driver, RegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE_TEXT);
	}
	
	public String getErrorMessageFirstnameTextbox() {
		return getElementText(driver, RegisterPageUI.FIRSTNAME_ERROR_MESSAGE_TEXT);
	}
	
	public String getMessageRegisterSuccess() {
		waitForAllElementVisible(driver, RegisterPageUI.REGISTER_SUCCESS_TEXT);
		return getElementText(driver, RegisterPageUI.REGISTER_SUCCESS_TEXT);
	}
	
	public String getMessageRegisterEmailExists() {
		waitForElementVisible(driver, RegisterPageUI.REGISTER_EMAIL_EXISTS_TEXT);
		return getElementText(driver, RegisterPageUI.REGISTER_EMAIL_EXISTS_TEXT);
	}
	
	public HomePageObject clickLogOutLink() {
		waitForElementClickAble(driver, RegisterPageUI.LOGOUT_LINK);
		clickToElement(driver, RegisterPageUI.LOGOUT_LINK);
		return PageGeneratorManager.getHomPageObject(driver);
	}
	
}
