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
import pageObjects.nopecommerce.user.UserHomePageObject;
import pageObjects.nopecommerce.user.UserLoginPageObject;
import reportExtentV5Config.ExtentTestManager;

public class User_02_Login extends BaseTest {
	
	WebDriver driver;
	UserHomePageObject userHomePage;
	UserLoginPageObject loginPage;
	String invalidEmail = "imavlidemail@";


	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowser(browserName);
		userHomePage = PageGeneratorManager.getUserHomPageObject(driver);
		
	}
	
	@Test
	public void Login_01_Login_Empty_Data(Method method) {
		ExtentTestManager.startTest(method.getName(), "Login_01_Login_Empty_Data");
		
		ExtentTestManager.getTest().log(Status.INFO, "Redirect to login page");
		loginPage = userHomePage.clickLoginLink();
		
		ExtentTestManager.getTest().log(Status.INFO, "Click login button");
		loginPage.clickLoginButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "Verify error message empty email");
		Assert.assertEquals("Please enter your email", loginPage.getMessageErrorEmail());
	}
	
	@Test
	public void Login_02_Login_Invalid_Email(Method method) {
		
		ExtentTestManager.startTest(method.getName(), "Login_02_Login_Invalid_Email");
		
		ExtentTestManager.getTest().log(Status.INFO, "Input email '%s'");
		loginPage.inputToEmail(invalidEmail);
		
		ExtentTestManager.getTest().log(Status.INFO, "Click login button");
		loginPage.clickLoginButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "Verify error message empty email");
		Assert.assertEquals("Wrong email", loginPage.getMessageErrorEmail());
	}
	
	@Test
	public void Login_03_Login_Email_Not_Register(Method method) {
		String 	email = "automation" + getRandom() + "@gmail.com";
		
		ExtentTestManager.startTest(method.getName(), "Login_03_Login_Email_Not_Register");
		
		ExtentTestManager.getTest().log(Status.INFO, "Input email '%s'");
		loginPage.inputToEmail(email);
		
		ExtentTestManager.getTest().log(Status.INFO, "Input password '%s'");
		loginPage.inputToPassword("123456");
		
		ExtentTestManager.getTest().log(Status.INFO, "Click login button");
		loginPage.clickLoginButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "Verify login with email not register");
		Assert.assertEquals("Login was unsuccessful. Please correct the errors and try again.\nNo customer account found", loginPage.getMessageErrorSumary());
		
	}
	
	@Test
	public void Login_04_Valis_Email_And_Empty_Password(Method method) {
		ExtentTestManager.startTest(method.getName(), "Login_04_Valis_Email_And_Empty_Password");
		
		ExtentTestManager.getTest().log(Status.INFO, "Input email '%s'");
		loginPage.inputToEmail(Common_01_Register.email);
		
		ExtentTestManager.getTest().log(Status.INFO, "Input email '%s'");
		loginPage.inputToPassword("");
		
		ExtentTestManager.getTest().log(Status.INFO, "Click login button");
		loginPage.clickLoginButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "Verify login with empty password");
		Assert.assertEquals("Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect", loginPage.getMessageErrorSumary());
	}
	
	@Test
	public void Login_05_Valis_Email_And_Wrong_Password(Method method) {
		ExtentTestManager.startTest(method.getName(), "Login_05_Valis_Email_And_Wrong_Password");
		
		ExtentTestManager.getTest().log(Status.INFO, "Input email '%s'");
		loginPage.inputToEmail(Common_01_Register.email);
		
		ExtentTestManager.getTest().log(Status.INFO, "Input email '%s'");
		loginPage.inputToPassword("1234567");
		
		ExtentTestManager.getTest().log(Status.INFO, "Click login button");
		loginPage.clickLoginButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "Verify login with empty password");
		Assert.assertEquals("Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect", loginPage.getMessageErrorSumary());
	}
	
	@Test
	public void Login_06_Login_Email_Password_Correct(Method method) {
		ExtentTestManager.startTest(method.getName(), "Login_05_Valis_Email_And_Wrong_Password");
		
		ExtentTestManager.getTest().log(Status.INFO, "Input email '%s'");
		loginPage.inputToEmail(Common_01_Register.email);
		
		ExtentTestManager.getTest().log(Status.INFO, "Input email '%s'");
		loginPage.inputToPassword(Common_01_Register.userPassword);
		
		ExtentTestManager.getTest().log(Status.INFO, "Click login button");
		userHomePage =  loginPage.clickLogin();
		
		ExtentTestManager.getTest().log(Status.INFO, "Veridy MyAccout page is display");
		Assert.assertTrue(userHomePage.MyAccountIsDisplay());
		
	}
	
	@AfterClass
	public void afterClass() {
//		 extent.flush();
		closeBrowserAndDriver();
	}
}
