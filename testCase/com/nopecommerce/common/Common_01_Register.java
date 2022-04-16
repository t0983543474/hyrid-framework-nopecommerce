package com.nopecommerce.common;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import common.BaseTest;
import common.PageGeneratorManager;
import pageObjects.nopecommerce.admin.AdminDashboardPageObject;
import pageObjects.nopecommerce.admin.AdminLoginPageObject;
import pageObjects.nopecommerce.user.UserCustomerInfoObject;
import pageObjects.nopecommerce.user.UserHomePageObject;
import pageObjects.nopecommerce.user.UserLoginPageObject;
import pageObjects.nopecommerce.user.UserRegisterPageObject;



public class Common_01_Register extends BaseTest{
	
	WebDriver driver;
	UserHomePageObject userHomePage;
	UserRegisterPageObject userRegisterPage;
	UserLoginPageObject userLoginPage;
	AdminLoginPageObject adminLoginPage;
	AdminDashboardPageObject adminDashboardPage;
	UserCustomerInfoObject userCustomerInfoPage;

	public static String email;
	public static String userPassword = "123456";
	String userFirstName = "Test", userLastName = "Automation",  userConfirmPassword = "123456";
	String adminEmail = "admin@yourstore.com" , adminPassword = "admin";

	@Parameters("browser")
	@BeforeTest
	public void Register(String browserName) {
	
		driver = getBrowser(browserName);
		
		email = "auto" + getRandom() + "@gmail.com";
		userHomePage = PageGeneratorManager.getUserHomPageObject(driver);
		
		log.info("beforeClass - Click to link to redirect to register page");
		userRegisterPage= userHomePage.clickToRegisterLink();
		
		log.info("beforeClass - Register to Portal User");
		userRegisterPage.RegisterToPortalUser(userFirstName, userLastName, email, userPassword, userConfirmPassword);

		log.info("beforeClass : Verify get Message Register Success");
		verifyEqual(userRegisterPage.getMessageRegisterSuccess(), "Your registration completed");

		log.info("beforeClass - Click logout");
		userHomePage = userRegisterPage.clickLogOutLink();
		driver.quit();
		
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("After tesst Trang");
		closeBrowserAndDriver();
	}
	
}
