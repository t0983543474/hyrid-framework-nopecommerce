package pageObjects.nopecommerce.user;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUIs.nopecommerce.user.UserChangePasswordUI;

public class UserChangePasswordPageObject extends BasePage{
	WebDriver driver;
	
	public UserChangePasswordPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void inputOldPassword(String oldPassword) {
		waitForElementVisible(driver, UserChangePasswordUI.OLD_PASSWORD);
		sendKeyToElement(driver, UserChangePasswordUI.OLD_PASSWORD, oldPassword);
	}
	
	public void inputNewPassword(String newPassword) {
		waitForElementVisible(driver, UserChangePasswordUI.NEW_PASSWORD);
		sendKeyToElement(driver, UserChangePasswordUI.NEW_PASSWORD, newPassword);
	}
	
	public void inputCOnfirmPassword(String confirmPassword) {
		waitForElementVisible(driver, UserChangePasswordUI.CONFIRM_PASSWORD);
		sendKeyToElement(driver, UserChangePasswordUI.CONFIRM_PASSWORD, confirmPassword);
	}
	
	public void clickChangePassword() {
		waitForElementClickAble(driver, UserChangePasswordUI.CHANGE_PASSWORD_BTN);
		clickToElement(driver, UserChangePasswordUI.CHANGE_PASSWORD_BTN);
	}
	
	public String getMessageSuccess() {
		waitForElementVisible(driver, UserChangePasswordUI.MESSAGE_CHANGE_PASSWORD_SUCCESS);
		return getElementText(driver, UserChangePasswordUI.MESSAGE_CHANGE_PASSWORD_SUCCESS);
	}
	
	public void clickCloseMessageSuucess() {
//		waitForElementClickAble(driver, UserChangePasswordUI.CLOSE_BTN);
		clickToElement(driver, UserChangePasswordUI.CLOSE_BTN);
	}
}
