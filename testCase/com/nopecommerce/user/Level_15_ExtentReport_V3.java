package com.nopecommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import common.BaseTest;
import common.GlobalConstants;
import common.PageGeneratorManager;
import pageObjects.nopecommerce.admin.AdminDashboardPageObject;
import pageObjects.nopecommerce.admin.AdminLoginPageObject;
import pageObjects.nopecommerce.user.UserCustomerInfoObject;
import pageObjects.nopecommerce.user.UserHomePageObject;
import pageObjects.nopecommerce.user.UserLoginPageObject;
import pageObjects.nopecommerce.user.UserRegisterPageObject;



public class Level_15_ExtentReport_V3 extends BaseTest{

	WebDriver driver;
	UserHomePageObject userHomePage;
	UserRegisterPageObject userRegisterPage;
	UserLoginPageObject userLoginPage;
	AdminLoginPageObject adminLoginPage;
	AdminDashboardPageObject adminDashboardPage;
	UserCustomerInfoObject userCustomerInfoPage;
//	 ExtentTest test;
//	   ExtentReports extent;
	String userEmailAddress;
	String userFirstName = "Test", userLastName = "Automation", userPassword = "123456", userConfirmPassword = "123456";
	String adminEmail = "admin@yourstore.com" , adminPassword = "admin";

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		log.info("Browser:" +  browserName);
		driver = getBrowser(browserName);
//		 extent = new ExtentReports();
//		 
//		  test = extent.createTest("logsGeneration");
//	        test.log(Status.INFO,"createTest() method will return the ExtentTest object");
//	        test.log(Status.INFO, "I am in actual Test");
//	        test.log(Status.INFO, "We can write the actual test logic in this Test");
		
		userEmailAddress = "auto" + getRandom() + "@gmail.com";
		userHomePage = PageGeneratorManager.getUserHomPageObject(driver);
		
		log.info("beforeClass - Click to link to redirect to register page");
		userRegisterPage= userHomePage.clickToRegisterLink();
		
		log.info("beforeClass - Register to Portal User");
		userRegisterPage.RegisterToPortalUser(userFirstName, userLastName, userEmailAddress, userPassword, userConfirmPassword);

		log.info("beforeClass : Verify get Message Register Success");
		verifyEqual(userRegisterPage.getMessageRegisterSuccess(), "Your registration completed");

		log.info("beforeClass - Click logout");
		userHomePage = userRegisterPage.clickLogOutLink();
	}
	
	
	@Test
	public void Role_01_User_To_Admin() {
		
		log.info("Role_01_User_To_Admin: Click login link");
		userLoginPage = userHomePage.clickLoginLink();
		
		log.info("Role_01_User_To_Admin - user login to portal user");
		userHomePage =  userLoginPage.LoginPortalUser(userEmailAddress, userPassword);

		log.info("Role_01_User_To_Admin - Verify My Account display");
		Assert.assertTrue(userHomePage.MyAccountIsDisplay());
		
		log.info("Role_01_User_To_Admin - open Customer Infor Page ");
		userCustomerInfoPage =  userHomePage.openCustomerInfoPage();
		
		log.info("Role_01_User_To_Admin - Logout Portal User page");
		userHomePage = userCustomerInfoPage.clickLogoutLinkAtUserPage(driver);
		
		log.info("Role_01_User_To_Admin  Open link Admin page");
	  	userHomePage.openPageURL(driver, GlobalConstants.ADMIN_PAGE_URL);
	  	
	    adminLoginPage = PageGeneratorManager.getAdminLoginPageObject(driver);
	    
	    log.info("Role_01_User_To_Admin- Login Admin page with email " + adminEmail + " password " + adminPassword);
	    adminDashboardPage = adminLoginPage.LoginToAdmiPage(adminEmail, adminPassword);
	    
	    
	    Assert.assertFalse(adminDashboardPage.getTextHeadingDashBoard().contains("Dashboard"));
		
	   
	}
	
	@Test
	public void Role_02_Admin_To_User() {

		 log.info("Role_02_Admin_To_User - Logout Portal Admin page");
			adminLoginPage = adminDashboardPage.clickLogoutLinkAtAdminPage(driver);
		
		log.info("Role_02_Admin_To_User: Login  Open link Portal page");
	  adminLoginPage.openPageURL(driver, GlobalConstants.PORTAL_PAGE_URL);
	  userHomePage = PageGeneratorManager.getUserHomPageObject(driver);
	  
	  userLoginPage = userHomePage.clickLoginLink();
	  
		userHomePage =  userLoginPage.LoginPortalUser(userEmailAddress, userPassword);
		log.info("Role_02_Admin_To_User: Verify My account is display");
		  Assert.assertTrue(userHomePage.MyAccountIsDisplay());
	}

	@AfterClass
	public void afterClass() {
//		 extent.flush();
		driver.quit();
	}
}