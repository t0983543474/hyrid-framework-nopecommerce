package pageObjects.facebook.register;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUI.facebook.register.RegisterPageUI;

public class RegisterPageObject extends BasePage{
WebDriver driver;
	
	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickOpenRegisterPopup() {
		waitForElementVisible(driver, RegisterPageUI.REGISTER_BTN);
		clickToElement(driver, RegisterPageUI.REGISTER_BTN);
	}
	
	public boolean isDisplayEmail() {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_TXT);
		return isElementDisplay(driver, RegisterPageUI.EMAIL_TXT);
	}
	
	public boolean isUnDisplayConfirmEmail() {
		waitForAllElementInvisible(driver, RegisterPageUI.CONFIRM_EMAIL_TXT);
		return isElementUnDisplay(driver, RegisterPageUI.CONFIRM_EMAIL_TXT);
	}
	
	public boolean isDisplayConfirmEmail() {
		waitForElementVisible(driver, RegisterPageUI.CONFIRM_EMAIL_TXT);
		return isElementDisplay(driver, RegisterPageUI.CONFIRM_EMAIL_TXT);
	}
	
	
	public void inputEmail(WebDriver driver, String value) {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_TXT);
		sendKeyToElement(driver, RegisterPageUI.EMAIL_TXT, value);
	}
	
	public void closePopupRegister() {
		waitForElementVisible(driver, RegisterPageUI.CLOSE_POPUP_ICON);
		clickToElement(driver, RegisterPageUI.CLOSE_POPUP_ICON);
	}
}
