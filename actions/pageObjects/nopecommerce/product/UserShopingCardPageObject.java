package pageObjects.nopecommerce.product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import common.BasePage;
import common.PageGeneratorManager;
import pageUIs.nopecommerce.product.UserShopingCardPageUI;

public class UserShopingCardPageObject extends BasePage{
	WebDriver driver;
	public UserShopingCardPageObject(WebDriver driver) {
		this.driver= driver;
	}
	public List<String> getAllProductNameInShoppongCart() {
		// TODO Auto-generated method stub
		 List<String> productNames = new ArrayList<>();
		waitForAllElementVisible(driver, UserShopingCardPageUI.PRODUCT_NAME_IN_CARD);
		List<WebElement> lists = getWebElements(driver, UserShopingCardPageUI.PRODUCT_NAME_IN_CARD);
		for (WebElement webElement : lists) {
			productNames.add(webElement.getText());
		}
		return productNames;
	}
	public UserDetailProductPageObject clickEditByProductName(String processorName) {
		waitForElementClickAble(driver, UserShopingCardPageUI.EDIT_PRODUCT_IN_CARD_BY_NAME, processorName);
		clickToElement(driver, UserShopingCardPageUI.EDIT_PRODUCT_IN_CARD_BY_NAME, processorName);
		return PageGeneratorManager.getUserDetailProductPageObject(driver);
	}
	public String getAttributesByProductName(String productName) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, UserShopingCardPageUI.ATTRIBUTES_OF_PRODUCT, productName);
		return getElementText(driver, UserShopingCardPageUI.ATTRIBUTES_OF_PRODUCT, productName);
		
	}
	public String getQuantityByProductName(String productName) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, UserShopingCardPageUI.QUANTITY_OF_PRODUCT, productName);
		return getElementAttribute(driver, UserShopingCardPageUI.QUANTITY_OF_PRODUCT, "value" ,productName );
	}
	public String getTotalByProductName(String productName) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, UserShopingCardPageUI.TOTAL_OF_PRODUCT, productName);
		return getElementText(driver, UserShopingCardPageUI.TOTAL_OF_PRODUCT, productName);
		
	}
	public String getPriceByProductName(String productName) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, UserShopingCardPageUI.PRICE_OF_PRODUCT, productName);
		return getElementText(driver, UserShopingCardPageUI.PRICE_OF_PRODUCT, productName);
	}
}