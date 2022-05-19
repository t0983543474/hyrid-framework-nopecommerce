package pageObjects.nopecommerce.product;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import common.BasePage;
import pageUIs.nopecommerce.product.RecentlyViewedProductsPageUI;

public class RecentlyViewedProductsPageObject extends BasePage{

	WebDriver driver;
	public RecentlyViewedProductsPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public List<String> getProductNameList(){
		List<String> productNams = new ArrayList<String>();
		waitForAllElementVisible(driver, RecentlyViewedProductsPageUI.PRODUCT_NAME);
		List<WebElement> list = getWebElements(driver, RecentlyViewedProductsPageUI.PRODUCT_NAME);
		
		for (WebElement webElement : list) {
			productNams.add(webElement.getText());
		}
		
		return productNams;
	}
	
}
