package pageUIs.nopecommerce.product;

public class UserWishlistPageUI {
	public static final String PRODUCT_NAME_LIST_IN_WISHLIST = "css=.wishlist-content .product a";
	public static final String SHARE_LINK = "css=a.share-link";
	public static final String PAGE_TITLE_WISHLIST ="css=.page-title h1";
	public static final String ADD_TO_CARD_BTN= "name=addtocartbutton";
	public static final String ADD_TO_CARD_CHECKBOX_BY_NAME = "xpath=//a[text()='%s']/parent::td//preceding-sibling::td[@class='add-to-cart']//input";
	public static final String REMOVE_PRPDUCT_FROM_WISH_LIST_BTN ="xpath=//a[text()='%s']/parent::td//following-sibling::td[@class='remove-from-cart']//button";
	public static final String MESSAGE_NO_DATA = "css=.no-data";
}
