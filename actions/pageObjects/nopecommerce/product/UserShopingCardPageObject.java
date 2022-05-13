package pageObjects.nopecommerce.product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import common.BasePage;
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
}