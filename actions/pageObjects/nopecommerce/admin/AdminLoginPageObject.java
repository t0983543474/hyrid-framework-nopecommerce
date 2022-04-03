package pageObjects.nopecommerce.admin;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import common.PageGeneratorManager;
import io.qameta.allure.Step;
import pageUIs.nopecommerce.admin.AdminLoginPageUI;

public class AdminLoginPageObject  extends BasePage{
	
	WebDriver driver;
	
	public AdminLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void inputToEmail(String email) {
		waitForElementVisible(driver, AdminLoginPageUI.EMAIL_TXT);
		sendKeyToElement(driver, AdminLoginPageUI.EMAIL_TXT, email);
	}
	
	
	public void inputToPassword(String pass) {
		waitForElementVisible(driver, AdminLoginPageUI.PASSWORD_TXT);
		sendKeyToElement(driver, AdminLoginPageUI.PASSWORD_TXT, pass);
	}
	
	public AdminDashboardPageObject clickToLoginButton() {
		waitForElementClickAble(driver, AdminLoginPageUI.LOGIN_BTN);
		clickToElement(driver, AdminLoginPageUI.LOGIN_BTN);
		return PageGeneratorManager.getAdminDashboardPageObject(driver);
	}
	
	@Step("Login to admin page")
	public AdminDashboardPageObject  LoginToAdmiPage(String email, String pass) {
		inputToEmail(email);
		inputToPassword(pass);
		return clickToLoginButton();
	}
	
}
