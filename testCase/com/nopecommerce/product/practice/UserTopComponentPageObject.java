package com.nopecommerce.product.practice;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUIs.nopecommerce.product.UserTopComponentUI;

public class UserTopComponentPageObject extends BasePage{
	WebDriver driver;
	
	public UserTopComponentPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getQuantityShoppingCart() {
		waitForElementVisible(driver, UserTopComponentUI.QUANTITY_SHOPPING_CART);
		return getElementText(driver, UserTopComponentUI.QUANTITY_SHOPPING_CART).replace("(", "").replace(")", "");
	}
	
	public String getTextMiniShopCart() {
		waitForElementVisible(driver, UserTopComponentUI.MINI_SHOP_CART);
		return getElementText(driver, UserTopComponentUI.MINI_SHOP_CART);
	}
	
	public void hoverToShoppingCart() {
		waitForElementVisible(driver, UserTopComponentUI.TOP_SHOPPING_CART_ICON);
		hoverMouseToElement(driver, UserTopComponentUI.TOP_SHOPPING_CART_ICON);
	}
	
	public String getAttributes(String productName) {
		boolean isUnDisplay = isElementUnDisplay(driver, UserTopComponentUI.ATTRIBUTES_BY_PRODUCT_NAME, productName);
		System.out.println("uyuwyerewr " + isUnDisplay);
		if(isUnDisplay==true) {
			return null;
		}else {
			return getElementText(driver, UserTopComponentUI.ATTRIBUTES_BY_PRODUCT_NAME, productName);
		}
	}
	
	public String getPrice(String productName) {
		waitForElementVisible(driver, UserTopComponentUI.PRICE_BY_PRODUCT_NAME,productName );
		return getElementText(driver, UserTopComponentUI.PRICE_BY_PRODUCT_NAME, productName);
	}
	
	public String getQuantity(String productName) {
		waitForElementVisible(driver, UserTopComponentUI.QUANTITY_BY_PRODUCT_NAME,productName );
		return getElementText(driver, UserTopComponentUI.QUANTITY_BY_PRODUCT_NAME, productName);
	}
}
