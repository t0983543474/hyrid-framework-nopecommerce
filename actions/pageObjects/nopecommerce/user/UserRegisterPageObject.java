package pageObjects.nopecommerce.user;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import common.PageGeneratorManager;
import pageUIs.nopecommerce.user.UserHomePageUI;
import pageUIs.nopecommerce.user.UserRegisterPageUI;

public class UserRegisterPageObject extends BasePage {
	WebDriver driver;
	
	public UserRegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickToRegisterButton() {
		waitForElementClickAble(driver, UserRegisterPageUI.REGISTER_BTN);
		clickToElement(driver, UserRegisterPageUI.REGISTER_BTN);
	}

	public void inputToFirstNameTextBox(String firstName) {
		sendKeyToElement(driver, UserRegisterPageUI.FIRSTNAME_TXT, firstName);
	}
	
	public void inputToLastNameTextBox(String lastName) {
		sendKeyToElement(driver, UserRegisterPageUI.LASTNAME_TXT, lastName);
	}
	
	public void inputToEmailTextBox(String email) {
		sendKeyToElement(driver, UserRegisterPageUI.EMAIL_TXT, email);
	}
	
	public void inputToPasswordTextBox(String password) {
		sendKeyToElement(driver, UserRegisterPageUI.PASSWORD_TXT, password);
	}
	
	public void inputToConfirmPasswordTextBox(String confirmPassword) {
		sendKeyToElement(driver, UserRegisterPageUI.CONFIRM_PASSWORD_TXT, confirmPassword);
	}
	
	public String getErrorMessageLastnameTextbox() {
		return getElementText(driver, UserRegisterPageUI.LASTNAME_ERROR_MESSAGE_TEXT);
	}
	
	public String getErrorMessageEmailTextbox() {
		return getElementText(driver, UserRegisterPageUI.EMAIL_ERROR_MESSAGE_TEXT);
	}
	
	public String getErrorMessagePasswordTextbox() {
		return getElementText(driver, UserRegisterPageUI.PASSWORD_ERROR_MESSAGE_TEXT);
	}
	
	public String getErrorMessageConfirmPasswordTextbox() {
		return getElementText(driver, UserRegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE_TEXT);
	}
	
	public String getErrorMessageFirstnameTextbox() {
		return getElementText(driver, UserRegisterPageUI.FIRSTNAME_ERROR_MESSAGE_TEXT);
	}
	
	public String getMessageRegisterSuccess() {
		waitForAllElementVisible(driver, UserRegisterPageUI.REGISTER_SUCCESS_TEXT);
		return getElementText(driver, UserRegisterPageUI.REGISTER_SUCCESS_TEXT);
	}
	
	public String getMessageRegisterEmailExists() {
		waitForElementVisible(driver, UserRegisterPageUI.REGISTER_EMAIL_EXISTS_TEXT);
		return getElementText(driver, UserRegisterPageUI.REGISTER_EMAIL_EXISTS_TEXT);
	}
	
	public UserHomePageObject clickLogOutLink() {
		waitForElementClickAble(driver, UserRegisterPageUI.LOGOUT_LINK);
		clickToElement(driver, UserRegisterPageUI.LOGOUT_LINK);
		return PageGeneratorManager.getUserHomPageObject(driver);
	}
	
	public void RegisterToPortalUser(String firstName , String lastName, String emailAddress, String password, String confirmPassword) {
		inputToFirstNameTextBox(firstName);
		inputToLastNameTextBox(lastName);
		inputToEmailTextBox(emailAddress);
		inputToPasswordTextBox(password);
		inputToConfirmPasswordTextBox(confirmPassword);

		 clickToRegisterButton();
	}
	
}
