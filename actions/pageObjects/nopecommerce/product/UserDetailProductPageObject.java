package pageObjects.nopecommerce.product;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUIs.nopecommerce.product.UserDetailProductPageUI;

public class UserDetailProductPageObject extends BasePage{

	WebDriver driver;
	public UserDetailProductPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public void clickAddWishlist() {
		
		waitForElementClickAble(driver, UserDetailProductPageUI.WISHLIST_BTN);
		clickToElement(driver, UserDetailProductPageUI.WISHLIST_BTN);
		
	}
	
	public String messageAddWishlistSuccess() {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, UserDetailProductPageUI.MESSAGE_ADD_WISHLIST_SUCCESS);
		return  getElementText(driver, UserDetailProductPageUI.MESSAGE_ADD_WISHLIST_SUCCESS);
		
		}
	
	public String getProductName() {
		waitForElementVisible(driver, UserDetailProductPageUI.PRODUCT_NAME);
		return getElementText(driver, UserDetailProductPageUI.PRODUCT_NAME);
	}
	
	public void selectProcessor(String processorName) {
		waitForElementVisible(driver, UserDetailProductPageUI.PROCESSOR_DROPDOW);
		selectItemDefaultDropdowList(driver, UserDetailProductPageUI.PROCESSOR_DROPDOW, processorName);
	}
	
	public void selectRAM(String RAM) {
		waitForElementVisible(driver, UserDetailProductPageUI.RAM_DROPDOW);
		selectItemDefaultDropdowList(driver, UserDetailProductPageUI.RAM_DROPDOW, RAM);
	}
	
	public void selectHDD(String hddName) {
		waitForElementClickAble(driver, UserDetailProductPageUI.HDD_RADIO, hddName);
		checkToDefaultCheckboxRadio(driver, UserDetailProductPageUI.HDD_RADIO, hddName);
	}
	
	public void selectOS(String osName) {
		waitForElementClickAble(driver, UserDetailProductPageUI.OS_RADIO, osName);
		checkToDefaultCheckboxRadio(driver, UserDetailProductPageUI.OS_RADIO, osName);
	}
	
	public void checkSoftWare(String softwareName) {
		waitForElementClickAble(driver, UserDetailProductPageUI.SOFTWARE_CHECKBOX, softwareName);
		checkToDefaultCheckboxRadio(driver, UserDetailProductPageUI.SOFTWARE_CHECKBOX, softwareName);
	}
	
	public void clickAddToCart() {
		waitForElementClickAble(driver, UserDetailProductPageUI.ADD_TO_CART_BUTTON);
		clickToElement(driver, UserDetailProductPageUI.ADD_TO_CART_BUTTON);
	}
	
	public String getMessageAddUpdateToCartSuccess() {
		waitForElementVisible(driver, UserDetailProductPageUI.MESSAGE_ADD_TO_CART_SUCCESS);
		return getElementText(driver, UserDetailProductPageUI.MESSAGE_ADD_TO_CART_SUCCESS);
	}
	
	public void clickCloseMessageSuccess() {
		waitForElementClickAble(driver, UserDetailProductPageUI.CLOSE_MESSAGE_ICON);
		clickToElement(driver, UserDetailProductPageUI.CLOSE_MESSAGE_ICON);
		
	}
	public String getQuantity() {
		waitForElementVisible(driver, UserDetailProductPageUI.QUANTITY_TEXTBOX);
		return getElementAttribute(driver, UserDetailProductPageUI.QUANTITY_TEXTBOX, "value");
	}
	
	public String getPrice() {
		waitForElementVisible(driver, UserDetailProductPageUI.PRICE_TEXT);
		return getElementText(driver, UserDetailProductPageUI.PRICE_TEXT);
	}
	public void unCheckSoftware(String software) {
		waitForElementClickAble(driver, UserDetailProductPageUI.SOFTWARE_CHECKBOX, software);
		uncheckDefaultToCheckbox(driver, UserDetailProductPageUI.SOFTWARE_CHECKBOX, software);
		
	}
	public void inputQuantity(String quantity) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, UserDetailProductPageUI.QUANTITY_TEXTBOX);
		sendKeyToElement(driver, UserDetailProductPageUI.QUANTITY_TEXTBOX, quantity);
	}
	public void clickUpdateShoppringCard() {
		// TODO Auto-generated method stub
		waitForElementClickAble(driver, UserDetailProductPageUI.UPDATE_CARD);
		clickToElement(driver, UserDetailProductPageUI.UPDATE_CARD);
	}
}
