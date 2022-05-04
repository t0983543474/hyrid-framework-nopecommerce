package com.nopecommerce.user.practice;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.nopecommerce.common.Common_01_Register;

import common.BaseTest;
import common.PageGeneratorManager;
import pageObjects.nopecommerce.user.UserAddressesPageObject;
import pageObjects.nopecommerce.user.UserChangePasswordPageObject;
import pageObjects.nopecommerce.user.UserCustomerInfoPageObject;
import pageObjects.nopecommerce.user.UserHomePageObject;
import pageObjects.nopecommerce.user.UserLoginPageObject;
import pageObjects.nopecommerce.user.UserMyProductReviewsObject;
import pageObjects.nopecommerce.user.UserProductReviewPageObject;
import reportExtentV5Config.ExtentTestManager;

public class User_03_MyAccount extends BaseTest {

	WebDriver driver;
	UserHomePageObject userHomePage;
	UserLoginPageObject loginPage;
	UserCustomerInfoPageObject customerPage;
	UserAddressesPageObject addressPage;
	String invalidEmail = "imavlidemail@";
	String firstName = "nana", lastName = "kaka", company = "IT company";
	String newemail;
	String date ="18", month = "May", year= "1995";
	String newPassword = "newPass";
	UserChangePasswordPageObject changePasswordPage;
	UserProductReviewPageObject productReviewPage;
	UserMyProductReviewsObject myProductReviewPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowser(browserName);
		newemail = "automation" + getRandom() + "@gmail.com";
		userHomePage = PageGeneratorManager.getUserHomPageObject(driver);
		
		loginPage = userHomePage.clickLoginLink();
		
		userHomePage = loginPage.LoginPortalUser(Common_01_Register.email, Common_01_Register.userPassword);
	}
	
	@Test
	public void MyAccount_01_Customer_Infor(Method method) {
		ExtentTestManager.startTest(method.getName(), "MyAccount_01_Customer_Infor");
		
		ExtentTestManager.getTest().log(Status.INFO, "Go to Customer page");
		customerPage = userHomePage.openCustomerInfoPage();
		
		ExtentTestManager.getTest().log(Status.INFO, "selected femail");
		customerPage.selectedFemail();        
		
		ExtentTestManager.getTest().log(Status.INFO, "Input company name");
		customerPage.inputCompanyName(company);
		
		ExtentTestManager.getTest().log(Status.INFO, "input email");
		customerPage.inputEmaile(newemail);
		
		ExtentTestManager.getTest().log(Status.INFO, "input last  name");
		customerPage.inputLastName(lastName);
		
		ExtentTestManager.getTest().log(Status.INFO, "input first name");
		customerPage.inputFirstName(firstName);
		
		ExtentTestManager.getTest().log(Status.INFO, "selected date, month year");
		customerPage.selectDateMonthYear(date, month, year);
		
		ExtentTestManager.getTest().log(Status.INFO, "Click save button");
		customerPage.clickSave();
		
		ExtentTestManager.getTest().log(Status.INFO, "Verify first name");
		Assert.assertEquals(firstName, customerPage.getValueTextboxById(driver, "FirstName"));
		
		ExtentTestManager.getTest().log(Status.INFO, "Verify Last name");
		Assert.assertEquals(lastName, customerPage.getValueTextboxById(driver, "LastName"));
		
		ExtentTestManager.getTest().log(Status.INFO, "Verify Email");
		Assert.assertEquals(newemail, customerPage.getValueTextboxById(driver, "Email"));
		
		ExtentTestManager.getTest().log(Status.INFO, "Verify Company name");
		Assert.assertEquals(company, customerPage.getValueTextboxById(driver, "Company"));
		
		ExtentTestManager.getTest().log(Status.INFO, "Verify Date of birth");
		Assert.assertEquals(date, customerPage.getSelectedItemDefaultDropdowListByName(driver, "DateOfBirthDay"));
		
		ExtentTestManager.getTest().log(Status.INFO, "Verify Month of birth");
		Assert.assertEquals(month, customerPage.getSelectedItemDefaultDropdowListByName(driver, "DateOfBirthMonth"));
		
		ExtentTestManager.getTest().log(Status.INFO, "Verify Year of birth");
		Assert.assertEquals(year, customerPage.getSelectedItemDefaultDropdowListByName(driver, "DateOfBirthYear"));
		
	}
	
	@Test
	public void MyAccount_02_Address(Method method) {
		String city = "City 1" , address = "44 Hoang Hon",  phone = "0987655433",  zip = "8888"; String country = "United States",  state ="Alaska";
		ExtentTestManager.startTest(method.getName(), "MyAccount_02_Address");
		
		ExtentTestManager.getTest().log(Status.INFO, "Open Address page");
		addressPage = customerPage.openUserAddressPage(driver);
		
		ExtentTestManager.getTest().log(Status.INFO, "");
		addressPage.clickAddNew();
		
		ExtentTestManager.getTest().log(Status.INFO, "Input first name");
		addressPage.inputFirstName(firstName);
		
		ExtentTestManager.getTest().log(Status.INFO, "Input last name");
		addressPage.inputLastName(lastName);
		
		ExtentTestManager.getTest().log(Status.INFO, "input email");
		addressPage.inputEmail(newemail);
		
		ExtentTestManager.getTest().log(Status.INFO, "select country");
		addressPage.selectedCountry(country);

		ExtentTestManager.getTest().log(Status.INFO, "select state");
		addressPage.selectedState(state);
		
		ExtentTestManager.getTest().log(Status.INFO, "Input address");
		addressPage.inputAddress(address);
		
		ExtentTestManager.getTest().log(Status.INFO, "input city");
		addressPage.inputCity(city);
		
		ExtentTestManager.getTest().log(Status.INFO, "input phone number");
		addressPage.inputPhoneNumber(phone);
		
		ExtentTestManager.getTest().log(Status.INFO, "input zip");
		addressPage.inputZipCode(zip);
		
		ExtentTestManager.getTest().log(Status.INFO, "Click save button");
		addressPage.clickSave();
		
		ExtentTestManager.getTest().log(Status.INFO, "Verify first name");
		Assert.assertTrue(addressPage.getFullNameInfo().contains(firstName));
		
		ExtentTestManager.getTest().log(Status.INFO, "Verify last name");
		Assert.assertTrue(addressPage.getFullNameInfo().contains(lastName));
		
		ExtentTestManager.getTest().log(Status.INFO, "Verify email");
		Assert.assertTrue( addressPage.getEmailInfo().contains(newemail));
		
		ExtentTestManager.getTest().log(Status.INFO, "Verify coumtry");
		Assert.assertEquals(country, addressPage.getCountryInfo());
		
		ExtentTestManager.getTest().log(Status.INFO, "Verify state");
		Assert.assertTrue(addressPage.getCityStateZipInfo().contains(state));
		
		ExtentTestManager.getTest().log(Status.INFO, "Verify city");
		Assert.assertTrue(addressPage.getCityStateZipInfo().contains(city));
		
		ExtentTestManager.getTest().log(Status.INFO, "Verify zip");
		Assert.assertTrue(addressPage.getCityStateZipInfo().contains(zip));
		
		ExtentTestManager.getTest().log(Status.INFO, "Verify address");
		Assert.assertEquals(address, addressPage.getAddressInfo());
	}
	
	@Test
	public void MyAccount_03_Change_Password(Method method) {
		ExtentTestManager.startTest(method.getName(), "MyAccount_03_Change_Password");
		
		ExtentTestManager.getTest().log(Status.INFO, "Open Change Password page");
		changePasswordPage = (UserChangePasswordPageObject)addressPage.openMyAccountPageByName(driver, "Change password");
		
		ExtentTestManager.getTest().log(Status.INFO, "Input old password");
		changePasswordPage.inputOldPassword(Common_01_Register.userPassword);
		
		ExtentTestManager.getTest().log(Status.INFO, "Input new password");
		changePasswordPage.inputNewPassword(newPassword);
		
		ExtentTestManager.getTest().log(Status.INFO, "Input confirm password");
		changePasswordPage.inputCOnfirmPassword(newPassword);
		
		ExtentTestManager.getTest().log(Status.INFO, "Click chane password");
		changePasswordPage.clickChangePassword();
		
		ExtentTestManager.getTest().log(Status.INFO, "Assert change password success");
		Assert.assertEquals("Password was changed", changePasswordPage.getMessageSuccess());
		
		changePasswordPage.clickCloseMessageSuucess();
		sleepSecond(2);
		
		ExtentTestManager.getTest().log(Status.INFO, "CLick log out");
		userHomePage = changePasswordPage.clickLogoutLinkAtUserPage(driver);
		
		ExtentTestManager.getTest().log(Status.INFO, "CLick login page");
		loginPage = userHomePage.clickLoginLink();
		
		
		ExtentTestManager.getTest().log(Status.INFO, "Login with old password");
		loginPage.inputToEmail(newemail);
		loginPage.inputToPassword(Common_01_Register.userPassword);
		
		ExtentTestManager.getTest().log(Status.INFO, "Click login button");
		loginPage.clickLoginButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "Verify login with empty password");
		Assert.assertEquals("Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect", loginPage.getMessageErrorSumary());
		
	
		ExtentTestManager.getTest().log(Status.INFO, "Login with new password");
		ExtentTestManager.getTest().log(Status.INFO, "Input email '%s'");
		loginPage.inputToEmail(newemail);
		
		ExtentTestManager.getTest().log(Status.INFO, "Input email '%s'");
		loginPage.inputToPassword(newPassword);
		
		ExtentTestManager.getTest().log(Status.INFO, "Click login button");
		userHomePage =  loginPage.clickLogin();
		
		ExtentTestManager.getTest().log(Status.INFO, "Veridy MyAccout page is display");
		Assert.assertTrue(userHomePage.MyAccountIsDisplay());
		
		
	}
	
	
	
	@Test
	public void MyAccount_04_View_My_Product_Reviewr(Method method) {
		ExtentTestManager.startTest(method.getName(), "MyAccount_04_View_My_Product_Reviewr");
		
		String productName = "Build your own computer";
		String title = "Review product A", textReview = "Description review";
		
		ExtentTestManager.getTest().log(Status.INFO, "Click view a product");
		userHomePage.clickToLinkByText(driver, productName);
		
		ExtentTestManager.getTest().log(Status.INFO, "Click add review link");
		userHomePage.clickToLinkByText(driver, "Add your review");
		
		                                                                                                                                                                                                                                                                                                                                                                                                                                                                            
		productReviewPage = PageGeneratorManager.getUserProductReviewPageObject(driver);
		
		ExtentTestManager.getTest().log(Status.INFO, "Input and submit a review");
		productReviewPage.inputReviewTitle(title);
		productReviewPage.inputReviewText(textReview);
		productReviewPage.clickSubmitReview();
		
		
		ExtentTestManager.getTest().log(Status.INFO, "Verify submit done ");
		Assert.assertEquals("Existing reviews", productReviewPage.getTitleReViewPage());
		
		customerPage = productReviewPage.clickMyAccountLink(driver);
		
		
		ExtentTestManager.getTest().log(Status.INFO, "Click to My product Review Page");
		myProductReviewPage = (UserMyProductReviewsObject) customerPage.openMyAccountPageByName(driver, "My product reviews");
		
		ExtentTestManager.getTest().log(Status.INFO, "Verify title review");
		Assert.assertEquals(title, myProductReviewPage.getTitleReview());
		
		ExtentTestManager.getTest().log(Status.INFO, "Verify Text review");
		Assert.assertEquals(textReview, myProductReviewPage.getTextReview());
		
		ExtentTestManager.getTest().log(Status.INFO, "Verify product name review");
		Assert.assertEquals(productName, myProductReviewPage.getProductNameReview());
	}
	
	
	@AfterClass
	public void afterClass() {
//		 extent.flush();
		closeBrowserAndDriver();
	}
}
