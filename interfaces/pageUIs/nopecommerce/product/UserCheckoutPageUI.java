package pageUIs.nopecommerce.product;

public class UserCheckoutPageUI {
	
	//Billing address
	public static final String  SHIP_TO_SAME_ADDRESS_CHECK_BOX  = "name=ShipToSameAddress";
	public static final String FIRST_NAME_BILLING_TEXTBOX =  "name=BillingNewAddress.FirstName";
	public static final String LAST_NAME_BILLING_TEXTBOX =  "name=BillingNewAddress.LastName";
	public static final String EMAIL_BILLING_TEXTBOX =  "name=BillingNewAddress.Email";
	public static final String COMAPANY_BILLING_TEXTBOX =  "name=BillingNewAddress.Company";
	public static final String COUNTRY_BILLING_DROPDOW =  "name=BillingNewAddress.CountryId";
	public static final String STATE_BILLING_DROPDOW =  "name=BillingNewAddress.StateProvinceId";
	public static final String CITY_BILLING_EXTBOX =  "name=BillingNewAddress.City";
	public static final String ADDRESS1_BILLING_TEXTBOX =  "name=BillingNewAddress.Address1";
	public static final String ADDRESS2_BILLING_TEXTBOX =  "name=BillingNewAddress.Address2";
	public static final String ZIP_CODE_BILLING_TEXTBOX =  "name=BillingNewAddress.ZipPostalCode";
	public static final String PHONE_BILLING_TEXTBOX =  "name=BillingNewAddress.PhoneNumber";
	public static final String FAX_BILLING_TEXTBOX =  "name=BillingNewAddress.FaxNumber";
	public static final String LOADING_STATE_BILLING_ICON = "css=#states-loading-progress";
	public static final String CONTINUE_BILLING_BILLING_BTN = "css=#billing-buttons-container .new-address-next-step-button";
	
	
	// 2 Shipping address
	
	public static final String LOADING_NEXT_SHIPPING_ICON = "css=span#shipping-please-wait";
	public static final String SHIPPING_ARRESS_DROPDOW = "css=select#shipping-address-select";
	
	public static final String  FIRSTNAME_SHIPPING_TEXTBOX = "name=ShippingNewAddress.FirstName";
	public static final String   LASTNAME_SHIPPING_TEXTBOX= "name=ShippingNewAddress.LastName";
	public static final String   EMAIL_SHIPPING_TEXTBOX= "name=ShippingNewAddress.Email";
	public static final String   COMPANY_SHIPPING_TEXTBOX= "name=ShippingNewAddress.Company";
	public static final String   COUNTRY_SHIPPING_TEXTBOX= "name=ShippingNewAddress.CountryId";
	public static final String   STATE_SHIPPING_TEXTBOX= "name=ShippingNewAddress.StateProvinceId";
	public static final String   CITY_SHIPPING_TEXTBOX= "name=ShippingNewAddress.City";
	public static final String   ADDRESS1_SHIPPING_TEXTBOX= "name=ShippingNewAddress.Address1";
	public static final String   ADDRESS2_SHIPPING_TEXTBOX= "name=ShippingNewAddress.Address2";
	public static final String   ZIP_CODE_SHIPPING_TEXTBOX= "name=ShippingNewAddress.ZipPostalCode";
	public static final String   PHONE_SHIPPING_TEXTBOX= "name=ShippingNewAddress.PhoneNumber";
	public static final String   FAX_SHIPPING_TEXTBOX= "name=ShippingNewAddress.FaxNumber";
	public static final String   CONTINUE_SHIPING_BUTTON= "css=#shipping-buttons-container button";
	public static final String   BACK_LINK_SHIPPING= "css=#shipping-buttons-container .back-link a";
	
	// 3 Shipping method
	public static final String  SHIPPING_METHOD_WAIT= "css=span#shipping-method-please-wait";
	public static final String SHIPPING_METHOD_RADIO = "xpath=//label[text()='%s']//preceding-sibling::input";
	public static final String BACK_LINK_METHOD_SHIPPING = "css=#shipping-method-buttons-container .back-link a";
	public static final String CONTINUE_METHOD_SHIPPING  = "css=#shipping-method-buttons-container .shipping-method-next-step-button";
	
	// 4 Payment method
	public static final String PAYMENT_RADIO = "xpath=//label[text()='%s']/preceding-sibling::input";
	public static final String  SHIPPING_PAYMENT_WAIT= "css=#payment-method-buttons-container .please-wait";
	public static final String BACK_LINK_PAYMENT = "css=#payment-method-buttons-container .back-link a";
	public static final String CONTINUE_PAYMENT  = "css=#payment-method-buttons-container .payment-method-next-step-button";
	
	// 5 Payment information 
	public static final String BACK_LINK_PAYMENT_INFORMATION = "css=#payment-info-buttons-container .back-link a";
	public static final String CONTINUE_PAYMENT_INFO ="css=#payment-info-buttons-container .payment-info-next-step-button";
	public static final String WAIT_PAYMENT_INFO = "css=#payment-info-buttons-container .please-wait";
	public static final String PAYMENT_INFO_TEXT = "xpath=//div[@class='section payment-info']//p[2]";
	// 6 Confirm order
		
}
