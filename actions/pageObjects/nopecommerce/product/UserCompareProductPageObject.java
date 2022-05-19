package pageObjects.nopecommerce.product;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import common.BasePage;
import pageUIs.nopecommerce.product.UserCompareProductPageUI;

public class UserCompareProductPageObject extends BasePage{
	WebDriver driver; 
	
	public UserCompareProductPageObject(WebDriver driver) {
		this.driver = driver;
	}

	

	public void clickClearList() {
		// TODO Auto-generated method stub
		waitForElementClickAble(driver, UserCompareProductPageUI.CLEAR_ALL_BUTTON);
		clickToElement(driver, UserCompareProductPageUI.CLEAR_ALL_BUTTON);
	}

	public String getMessageClearList() {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, UserCompareProductPageUI.NO_DATA_MESSAGE);
		return getElementText(driver, UserCompareProductPageUI.NO_DATA_MESSAGE);
	}

	public boolean isNotDisplayProductInCompage() {
		// TODO Auto-generated method stub
		List<WebElement> list = getWebElements(driver, UserCompareProductPageUI.LIST_PRODUCT_NAME);
		return list.size()==0;
	}
	
	public List<String> getListProductName(){
		List<String> productNameList = new ArrayList<String>();
		waitForAllElementVisible(driver, UserCompareProductPageUI.LIST_PRODUCT_NAME);
		List<WebElement> elementList = getWebElements(driver, UserCompareProductPageUI.LIST_PRODUCT_NAME);
	
		for (WebElement webElement : elementList) {
			productNameList.add(webElement.getText());
		}
		return productNameList;
	}
	
	public boolean isDisplayRemoveByIndex(String index) {
		waitForElementVisible(driver, UserCompareProductPageUI.REMOVE_BY_INDEX, index);
		return isElementDisplay(driver, UserCompareProductPageUI.REMOVE_BY_INDEX, index);
	}
	public String getPriceByIndex(String index) {
		waitForElementVisible(driver, UserCompareProductPageUI.PRICE_BY_INDEX, index);
		return getElementText(driver, UserCompareProductPageUI.PRICE_BY_INDEX, index);
	}
	
	public String getProductNameByIndex(String index) {
		waitForElementVisible(driver, UserCompareProductPageUI.PRODUCT_NAME_BY_INDEX, index);
		return getElementText(driver, UserCompareProductPageUI.PRODUCT_NAME_BY_INDEX, index);
	}
}
