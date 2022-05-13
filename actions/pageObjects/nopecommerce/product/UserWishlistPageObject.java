package pageObjects.nopecommerce.product;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import common.BasePage;
import pageUIs.nopecommerce.product.UserWishlistPageUI;

public class UserWishlistPageObject extends BasePage{
	WebDriver driver;
	public UserWishlistPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public void clickShareLink() {
		// TODO Auto-generated method stub
		waitForElementClickAble(driver, UserWishlistPageUI.SHARE_LINK);
		clickToElement(driver, UserWishlistPageUI.SHARE_LINK);
	}
	public String getPageTitleWishlist() {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, UserWishlistPageUI.PAGE_TITLE_WISHLIST);

		return getElementText(driver, UserWishlistPageUI.PAGE_TITLE_WISHLIST);
	}

	public List<String> getproductListinWishlist() {
		// TODO Auto-generated method stub
		List<String> products = new ArrayList<>();
		waitForAllElementVisible(driver, UserWishlistPageUI.PRODUCT_NAME_LIST_IN_WISHLIST);
		List<WebElement> list = getWebElements(driver, UserWishlistPageUI.PRODUCT_NAME_LIST_IN_WISHLIST);
		for (WebElement webElement : list) {
			products.add(webElement.getText());
		}
		return products;
	}
	public void clickCheckAddToCartByProductName(String productName) {
		// TODO Auto-generated method stub
		waitForElementClickAble(driver, UserWishlistPageUI.ADD_TO_CARD_CHECKBOX_BY_NAME,productName );
		clickToElement(driver, UserWishlistPageUI.ADD_TO_CARD_CHECKBOX_BY_NAME, productName);
	}
	public void clickAddToCartButton() {
		// TODO Auto-generated method stub
		waitForElementClickAble(driver, UserWishlistPageUI.ADD_TO_CARD_BTN);
		clickToElement(driver, UserWishlistPageUI.ADD_TO_CARD_BTN);
		
	}
	public void clickRemoveProductFromWishlistByName(String productName) {
		// TODO Auto-generated method stub
		waitForElementClickAble(driver, UserWishlistPageUI.REMOVE_PRPDUCT_FROM_WISH_LIST_BTN, productName);
		clickToElement(driver, UserWishlistPageUI.REMOVE_PRPDUCT_FROM_WISH_LIST_BTN, productName);
	}
	public String getMessageEmptyWishlistPage() {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, UserWishlistPageUI.MESSAGE_NO_DATA);
		return getElementText(driver, UserWishlistPageUI.MESSAGE_NO_DATA);
	}
	public boolean isNotDisplayProduct(String productName) {
		// TODO Auto-generated method stub
		waitForElementInvisible(driver, UserWishlistPageUI.PRODUCT_NAME_LIST_IN_WISHLIST);
		return isElementUnDisplay(driver, UserWishlistPageUI.PRODUCT_NAME_LIST_IN_WISHLIST);
	} 
}
