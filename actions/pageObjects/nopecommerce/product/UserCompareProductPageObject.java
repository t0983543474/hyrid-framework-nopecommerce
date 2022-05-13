package pageObjects.nopecommerce.product;

import org.openqa.selenium.WebDriver;

import common.BasePage;

public class UserCompareProductPageObject extends BasePage{
	WebDriver driver; 
	
	public UserCompareProductPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean displayRemoveProductByProductName(String productName) {
		
		// TODO Auto-generated method stub
		return false;
	}

	public String getProductListInComparePage() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getPriceByProductName(String productName) {
		// TODO Auto-generated method stub
		return null;
	}

	public void clickClearList() {
		// TODO Auto-generated method stub
		
	}

	public String getMessageClearList() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isNotDisplayProductInCompage() {
		// TODO Auto-generated method stub
		return false;
	}
}
