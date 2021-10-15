package pageUIs;

public class RegisterPageUI {
	
	public static final String REGISTER_BTN = "//button[@id='register-button']";
	

	public static final String FIRSTNAME_ERROR_MESSAGE_TEXT = "//span[@id='FirstName-error']";
	
	
	public static final String LASTNAME_ERROR_MESSAGE_TEXT = "//span[@id='LastName-error']";
	
	public static final String EMAIL_ERROR_MESSAGE_TEXT = "//span[@id='Email-error']";
	public static final String PASSWORD_ERROR_MESSAGE_TEXT = "//span[@id='Password-error']";
	public static final String CONFIRM_PASSWORD_ERROR_MESSAGE_TEXT = "//span[@id='ConfirmPassword-error']";
	
	public static final String FIRSTNAME_TXT = "//input[@id='FirstName']";
	public static final String LASTNAME_TXT = "//input[@id='LastName']";
	public static final String EMAIL_TXT = "//input[@id='Email']";
	public static final String PASSWORD_TXT = "//input[@id='Password']";
	public static final String CONFIRM_PASSWORD_TXT = "//input[@id='ConfirmPassword']";
	
	public static final String REGISTER_SUCCESS_TEXT = "//div[@class='result']";
	public static final String REGISTER_EMAIL_EXISTS_TEXT = "//div[contains(@class, 'message-error')]//li";
	
	
}
