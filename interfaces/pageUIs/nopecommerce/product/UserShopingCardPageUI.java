package pageUIs.nopecommerce.product;

public class UserShopingCardPageUI {
	
	public static final String PRODUCT_NAME_IN_CARD = "css=.order-summary-content .product a";
	public static final String EDIT_PRODUCT_IN_CARD_BY_NAME ="xpath=//td[@class='product']/a[text()='%s']//following-sibling::div//a[text()='Edit']";
	public static final String PRICE_OF_PRODUCT = "xpath=//a[text()='%s']//parent::td/following-sibling::td[@class='unit-price']//span";
	public static final String QUANTITY_OF_PRODUCT = "xpath=//a[text()='%s']//parent::td/following-sibling::td[@class='quantity']//input";
	public static final String TOTAL_OF_PRODUCT = "xpath=//a[text()='%s']//parent::td/following-sibling::td[@class='subtotal']//span";
	public static final String ATTRIBUTES_OF_PRODUCT ="xpath=//td[@class='product']/a[text()='%s']//following-sibling::div[@class='attributes']";
	public static final String REMOVE_BY_PRODUCT ="xpath=//a[text()='%s']/parent::td/following-sibling::td[@class='remove-from-cart']//button";
	public static final String NO_DATA = "css=.order-summary-content .no-data";
	public static final String TERM_OF_SERVICE_CHECKBOX ="css=.terms-of-service input";
	public static final String CHECKOUT_BTN = "css=.checkout-buttons button";
}
