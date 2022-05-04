package com.nopecommerce.common;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import common.BaseTest;
import common.PageGeneratorManager;
import pageObjects.nopecommerce.admin.AdminDashboardPageObject;
import pageObjects.nopecommerce.admin.AdminLoginPageObject;
import pageObjects.nopecommerce.user.UserCustomerInfoPageObject;
import pageObjects.nopecommerce.user.UserHomePageObject;
import pageObjects.nopecommerce.user.UserLoginPageObject;
import pageObjects.nopecommerce.user.UserRegisterPageObject;



public class Common_01_Register_Cookies extends BaseTest{
	
	WebDriver driver;
	UserHomePageObject userHomePage;
	UserRegisterPageObject userRegisterPage;
	UserLoginPageObject userLoginPage;
	AdminLoginPageObject adminLoginPage;
	AdminDashboardPageObject adminDashboardPage;
	UserCustomerInfoPageObject userCustomerInfoPage;

	public static String email;
	public static String userPassword = "123456";
	String userFirstName = "Test", userLastName = "Automation",  userConfirmPassword = "123456";
	String adminEmail = "admin@yourstore.com" , adminPassword = "admin";
	public static Set<Cookie> logginCookies ;

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
		
		userLoginPage = userHomePage.clickLoginLink();
		
		userHomePage = userLoginPage.LoginPortalUser(email, userPassword);
		
		
		logginCookies = userHomePage.getAllCookies(driver);
		
		userHomePage.clickLogoutLinkAtUserPage(driver);
		
		driver.quit();
		
	}
	
	@AfterTest
	public void afterTest() {
//		driver.quit();
	}
	
}
