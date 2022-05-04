package pageObjects.nopecommerce.user;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUIs.nopecommerce.user.UserCustomerInfoUI;

public class UserCustomerInfoPageObject extends BasePage {
	WebDriver driver;
	public UserCustomerInfoPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean isCustomerInforPageDisplay() {
		waitForElementVisible(driver, UserCustomerInfoUI.HEADING_CUSTOMER_INFO);
		return isElementDisplay(driver, UserCustomerInfoUI.HEADING_CUSTOMER_INFO);
	}
	
	public void selectedFemail() {
		waitForElementVisible(driver, UserCustomerInfoUI.FEMAIL_RADIO_BTN);
		checkToDefaultCheckboxRadio(driver, UserCustomerInfoUI.FEMAIL_RADIO_BTN);
	}
	
	public void inputFirstName(String firstName) {
		waitForElementVisible(driver, UserCustomerInfoUI.FIRSTNAME_TXT);
		sendKeyToElement(driver, UserCustomerInfoUI.FIRSTNAME_TXT, firstName);
	}
	
	public void inputLastName(String lastName) {
		waitForElementVisible(driver, UserCustomerInfoUI.LASTNAME_TXT);
		sendKeyToElement(driver, UserCustomerInfoUI.LASTNAME_TXT, lastName);
	}
	
	public void inputEmaile(String email) {
		waitForElementVisible(driver, UserCustomerInfoUI.EMAIL_TXT);
		sendKeyToElement(driver, UserCustomerInfoUI.EMAIL_TXT, email);
	}
	
	public void inputCompanyName(String companyName) {
		waitForElementVisible(driver, UserCustomerInfoUI.COMPANY_TXT);
		sendKeyToElement(driver, UserCustomerInfoUI.COMPANY_TXT, companyName);
	}
	
	public void selectDateMonthYear(String date, String month , String year) {
		waitForElementVisible(driver, UserCustomerInfoUI.DATE_OF_BIRTH_DROPDOWN);
		selectItemDefaultDropdowList(driver, UserCustomerInfoUI.DATE_OF_BIRTH_DROPDOWN, date);
		
		waitForElementVisible(driver, UserCustomerInfoUI.MONTH_OF_BIRTH_DROPDOWN);
		selectItemDefaultDropdowList(driver, UserCustomerInfoUI.MONTH_OF_BIRTH_DROPDOWN, month);
		
		waitForElementVisible(driver, UserCustomerInfoUI.YEAR_OF_BIRTH_DROPDOWN);
		selectItemDefaultDropdowList(driver, UserCustomerInfoUI.YEAR_OF_BIRTH_DROPDOWN, year);
	}
	
	public void clickSave() {
		waitForElementVisible(driver, UserCustomerInfoUI.SAVE_BTN);
		clickToElement(driver, UserCustomerInfoUI.SAVE_BTN);
	}
	
	public boolean femailIsCheck() {
		waitForElementVisible(driver, UserCustomerInfoUI.FEMAIL_RADIO_BTN);
		return isElementSelected(driver,  UserCustomerInfoUI.FEMAIL_RADIO_BTN);
	}
	
	
}
