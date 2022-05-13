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
	
	
}
