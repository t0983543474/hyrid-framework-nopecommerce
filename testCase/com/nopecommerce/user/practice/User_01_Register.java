package com.nopecommerce.user.practice;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import common.BaseTest;
import common.PageGeneratorManager;
import pageObjects.nopecommerce.user.UserHomePageObject;
import pageObjects.nopecommerce.user.UserRegisterPageObject;
import reportExtentV5Config.ExtentTestManager;

public class User_01_Register extends BaseTest{
	WebDriver driver;
	UserHomePageObject userHomePage;
	UserRegisterPageObject registerPage;
	String invalidEmail = "imavlidemail@";
	String firstName = "Trang";
	String lastName = "Le";
	String password = "123456";
	String confirmPassword = "123456";
	String email ;
			
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowser(browserName);
		userHomePage = PageGeneratorManager.getUserHomPageObject(driver);
		
		email = "automation" + getRandom() + "@gmail.com";
	}
	
	@Test
	public void Register_01_Register_Empty_Data(Method method) {
		ExtentTestManager.startTest(method.getName(), "Register_01: Register_01_Register_Empty_Data");
		
		ExtentTestManager.getTest().log(Status.INFO, "Register_01: Go to register page");
		registerPage = userHomePage.clickToRegisterLink();
		
		ExtentTestManager.getTest().log(Status.INFO, "Register_01: Ckick register button");
		registerPage.clickToRegisterButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "Register_01: Verify error message First name");
		Assert.assertEquals("First name is required.", registerPage.getErrorMessageFirstnameTextbox());
		
		ExtentTestManager.getTest().log(Status.INFO, "Register_01: Veerify error message Last name");
		Assert.assertEquals("Last name is required.", registerPage.getErrorMessageLastnameTextbox());
		
		ExtentTestManager.getTest().log(Status.INFO, "Register_01: Veerify error message Email");
		Assert.assertEquals("Email is required.", registerPage.getErrorMessageEmailTextbox());
		
		ExtentTestManager.getTest().log(Status.INFO, "Register_01: Veerify error message Password");
		Assert.assertEquals("Password is required.", registerPage.getErrorMessagePasswordTextbox());
		
		ExtentTestManager.getTest().log(Status.INFO, "Register_01: Veerify error message Confirm Password");
		Assert.assertEquals("Password is required.", registerPage.getErrorMessageConfirmPasswordTextbox());
		
	}
	
	@Test
	public void Register_02_Register_Invalid_Email(Method method) {
		ExtentTestManager.startTest(method.getName(), "Register_02: Register_Invalid_Email");
		
		ExtentTestManager.getTest().log(Status.INFO,"Register_02: Input to First name");
		registerPage.inputToFirstNameTextBox(firstName);
		
		ExtentTestManager.getTest().log(Status.INFO,"Register_02: Input to lastName");
		registerPage.inputToLastNameTextBox(lastName);
		
		ExtentTestManager.getTest().log(Status.INFO,"Register_02: Input to invalidEmail");
		registerPage.inputToEmailTextBox(invalidEmail);
		
		ExtentTestManager.getTest().log(Status.INFO,"Register_02: Input to password");
		registerPage.inputToPasswordTextBox(password);
		
		ExtentTestManager.getTest().log(Status.INFO,"Register_02: Input to confirmPassword");
		registerPage.inputToConfirmPasswordTextBox(confirmPassword);
		
		ExtentTestManager.getTest().log(Status.INFO, "Register_01: Ckick register button");
		registerPage.clickToRegisterButton();
		
		ExtentTestManager.getTest().log(Status.INFO,"Register_02: Verify message error invalid email ");
		Assert.assertEquals("Wrong email", registerPage.getErrorMessageEmailTextbox());
	}
	
	@Test
	public void Register_03_Register_Valid_Email(Method method) {
		ExtentTestManager.startTest(method.getName(), "Register_03: Register_Valid_Email");
		
		ExtentTestManager.getTest().log(Status.INFO,"Register_03: Input to First name");
		registerPage.inputToFirstNameTextBox(firstName);
		
		ExtentTestManager.getTest().log(Status.INFO,"Register_03: Input to lastName");
		registerPage.inputToLastNameTextBox(lastName);
		
		ExtentTestManager.getTest().log(Status.INFO,"Register_03: Input to valid Email");
		registerPage.inputToEmailTextBox(email);
		
		ExtentTestManager.getTest().log(Status.INFO,"Register_03: Input to password");
		registerPage.inputToPasswordTextBox(password);
		
		ExtentTestManager.getTest().log(Status.INFO,"Register_03: Input to confirmPassword");
		registerPage.inputToConfirmPasswordTextBox(confirmPassword);
		
		ExtentTestManager.getTest().log(Status.INFO, "Register_03: Ckick register button");
		registerPage.clickToRegisterButton();
		
		ExtentTestManager.getTest().log(Status.INFO,"Register_03: Verify message register successfully");
		Assert.assertEquals("Your registration completed", registerPage.getMessageRegisterSuccess());
		
		ExtentTestManager.getTest().log(Status.INFO, "Register_03: Click logout");
		userHomePage =  registerPage.clickLogOutLink();
	}
	
	
	@Test
	public void Register_04_Register_Exists_Email(Method method) {
		ExtentTestManager.startTest(method.getName(), "Register_04: Register_Exists_Email");
		
		ExtentTestManager.getTest().log(Status.INFO, "Register_04: Go to register page");
		registerPage = userHomePage.clickToRegisterLink();
		
		ExtentTestManager.getTest().log(Status.INFO,"Register_04: Input to First name");
		registerPage.inputToFirstNameTextBox(firstName);
		
		ExtentTestManager.getTest().log(Status.INFO,"Register_04: Input to lastName");
		registerPage.inputToLastNameTextBox(lastName);
		
		ExtentTestManager.getTest().log(Status.INFO,"Register_04: Input to valid Email");
		registerPage.inputToEmailTextBox(email);
		
		ExtentTestManager.getTest().log(Status.INFO,"Register_04: Input to password");
		registerPage.inputToPasswordTextBox(password);
		
		ExtentTestManager.getTest().log(Status.INFO,"Register_04: Input to confirmPassword");
		registerPage.inputToConfirmPasswordTextBox(confirmPassword);
		
		ExtentTestManager.getTest().log(Status.INFO, "Register_04: Ckick register button");
		registerPage.clickToRegisterButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "Register_04: Verify message register email exists");
		Assert.assertEquals("The specified email already exists", registerPage.getMessageRegisterEmailExists());
		
	}
	
	@Test
	public void Register_05_Register_Password_LessThan_6(Method method) {
		ExtentTestManager.startTest(method.getName(), "Register_05: Register_Password_LessThan_6");
		
		ExtentTestManager.getTest().log(Status.INFO, "Register_05: Go to register page");
		registerPage = userHomePage.clickToRegisterLink();
		
		ExtentTestManager.getTest().log(Status.INFO,"Register_05: Input to First name");
		registerPage.inputToFirstNameTextBox(firstName);
		
		ExtentTestManager.getTest().log(Status.INFO,"Register_05: Input to lastName");
		registerPage.inputToLastNameTextBox(lastName);
		
		ExtentTestManager.getTest().log(Status.INFO,"Register_05: Input to valid Email");
		registerPage.inputToEmailTextBox(email);
		
		ExtentTestManager.getTest().log(Status.INFO,"Register_05: Input to password");
		registerPage.inputToPasswordTextBox("12345");
//		
//		ExtentTestManager.getTest().log(Status.INFO,"Register_05: Input to confirmPassword");
//		registerPage.inputToConfirmPasswordTextBox(confirmPassword);
//		
		ExtentTestManager.getTest().log(Status.INFO, "Register_05: Ckick register button");
		registerPage.clickToRegisterButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "Register_05: Verify message with password less than 6 character");
		Assert.assertEquals("Password must meet the following rules:\nmust have at least 6 characters", registerPage.getErrorMessagePasswordTextbox());
	}
	
	@Test
	public void Register_06_Register_ConfirmPassword_Not_Maching(Method method) {
ExtentTestManager.startTest(method.getName(), "Register_06: ConfirmPassword_Not_Matching");
		
//		ExtentTestManager.getTest().log(Status.INFO, "Register_06: Go to register page");
//		registerPage = userHomePage.clickToRegisterLink();
//		
		ExtentTestManager.getTest().log(Status.INFO,"Register_06: Input to First name");
		registerPage.inputToFirstNameTextBox(firstName);
		
		ExtentTestManager.getTest().log(Status.INFO,"Register_06: Input to lastName");
		registerPage.inputToLastNameTextBox(lastName);
		
		ExtentTestManager.getTest().log(Status.INFO,"Register_06: Input to valid Email");
		registerPage.inputToEmailTextBox(email);
		
		ExtentTestManager.getTest().log(Status.INFO,"Register_06: Input to password");
		registerPage.inputToPasswordTextBox(password);
		
		ExtentTestManager.getTest().log(Status.INFO,"Register_06: Input to confirmPassword");
		registerPage.inputToConfirmPasswordTextBox("1234567");
		
		ExtentTestManager.getTest().log(Status.INFO, "Register_06: Ckick register button");
		registerPage.clickToRegisterButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "Register_06: Verify message confirm password not maching with password");
		Assert.assertEquals("The password and confirmation password do not match.", registerPage.getErrorMessageConfirmPasswordTextbox());
	}
	
	@AfterClass
	public void afterClass() {
//		 extent.flush();
		closeBrowserAndDriver();
	}
}
