package pageObjects.nopecommerce.user;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUIs.nopecommerce.user.UserAddressesUI;

public class UserAddressesPageObject extends BasePage {
	
	WebDriver driver;
	public UserAddressesPageObject(WebDriver driver) {
		this.driver = driver;
	} 
	
	public void clickAddNew() {
		waitForElementClickAble(driver, UserAddressesUI.ADD_NEW_BTN);
		clickToElement(driver, UserAddressesUI.ADD_NEW_BTN);
	}
	
	public void inputFirstName(String firstName) {
		waitForElementVisible(driver, UserAddressesUI.FIRST_NAME_TXT);
		sendKeyToElement(driver, UserAddressesUI.FIRST_NAME_TXT, firstName);
	}
	
	public void inputLastName(String lastName) {
		waitForElementVisible(driver, UserAddressesUI.LAST_NAME_TXT);
		sendKeyToElement(driver, UserAddressesUI.LAST_NAME_TXT, lastName);
	}
	
	public void inputEmail(String email) {
		waitForElementVisible(driver, UserAddressesUI.EMAIL_TXT);
		sendKeyToElement(driver, UserAddressesUI.EMAIL_TXT, email);
	}
	
	public void inputCity(String city) {
		waitForElementVisible(driver, UserAddressesUI.CITY_TXT);
		sendKeyToElement(driver, UserAddressesUI.CITY_TXT, city);
	}
	
	public void inputAddress(String address) {
		waitForElementVisible(driver, UserAddressesUI.ADDRESS1_TXT);
		sendKeyToElement(driver, UserAddressesUI.ADDRESS1_TXT, address);
	}
	
	public void inputZipCode(String zipcode) {
		waitForElementVisible(driver, UserAddressesUI.ZIP_TXT);
		sendKeyToElement(driver, UserAddressesUI.ZIP_TXT, zipcode);
	}

	public void inputPhoneNumber(String phone) {
		waitForElementVisible(driver, UserAddressesUI.PHONE_TXT);
		sendKeyToElement(driver, UserAddressesUI.PHONE_TXT, phone);
	}
	
	public void selectedCountry(String country) {
		waitForAllElementVisible(driver, UserAddressesUI.COUNTRY_DROPDOW);
		selectItemDefaultDropdowList(driver, UserAddressesUI.COUNTRY_DROPDOW, country);
	}
	
	public void selectedState(String state) {
		waitForElementInvisible(driver, UserAddressesUI.WAIT_LOADING);
		waitForAllElementVisible(driver, UserAddressesUI.STATE_DROPDOW);
		selectItemDefaultDropdowList(driver, UserAddressesUI.STATE_DROPDOW, state);
	}
	
	public void clickSave() {
		waitForElementClickAble(driver, UserAddressesUI.SAVE_BTN);
		clickToElement(driver, UserAddressesUI.SAVE_BTN);
	}
	
	public String getFullNameInfo() {
		waitForElementVisible(driver, UserAddressesUI.FULLNAME_INFO);
		return getElementText(driver, UserAddressesUI.FULLNAME_INFO);
	}
	
	public String getEmailInfo() {
		waitForElementVisible(driver, UserAddressesUI.EMAIL_INFO);
		return getElementText(driver, UserAddressesUI.EMAIL_INFO);
	}
	
	public String getPoneInfo() {
		waitForElementVisible(driver, UserAddressesUI.PHONE_INFO);
		return getElementText(driver, UserAddressesUI.PHONE_INFO);
	}
	
	public String getAddressInfo() {
		waitForElementVisible(driver, UserAddressesUI.ADDRESS1_INFO);
		return getElementText(driver, UserAddressesUI.ADDRESS1_INFO);
	}
	
	public String getCityStateZipInfo() {
		waitForElementVisible(driver, UserAddressesUI.CITY_STATE_ZIP_INFO);
		return getElementText(driver, UserAddressesUI.CITY_STATE_ZIP_INFO);
	}
	
	public String getCountryInfo() {
		waitForElementVisible(driver, UserAddressesUI.COUNTRY_INFO);
		return getElementText(driver, UserAddressesUI.COUNTRY_INFO);
	}
}
