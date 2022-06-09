package pageUIs.nopecommerce.product;

public class UserTopComponentUI {
	public static final String QUANTITY_SHOPPING_CART = "css=.ico-cart .cart-qty";
	
	public static final String MINI_SHOP_CART = "css=.mini-shopping-cart .count";
	
	public static final String TOP_SHOPPING_CART_ICON = "css=#topcartlink .ico-cart";
	public static final String PRODUCT_NAME_LIST = "css=.product .name a";
	public static final String ATTRIBUTES_BY_PRODUCT_NAME = "xpath=//a[text()='%s']/parent::div/following-sibling::div[@class='attributes']";
	public static final String PRICE_BY_PRODUCT_NAME ="xpath=//a[text()='%s']/parent::div/following-sibling::div[@class='price']/span";
	public static final String QUANTITY_BY_PRODUCT_NAME = "xpath=//a[text()='%s']/parent::div/following-sibling::div[@class='quantity']/span";
	
}
