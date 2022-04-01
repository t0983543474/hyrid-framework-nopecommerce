package com.nopecommerce.user;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

//import com.relevantcodes.extentreports.LogStatus;

import common.BaseTest;
import common.GlobalConstants;
import common.PageGeneratorManager;
import pageObjects.nopecommerce.admin.AdminDashboardPageObject;
import pageObjects.nopecommerce.admin.AdminLoginPageObject;
import pageObjects.nopecommerce.user.UserCustomerInfoObject;
import pageObjects.nopecommerce.user.UserHomePageObject;
import pageObjects.nopecommerce.user.UserLoginPageObject;
import pageObjects.nopecommerce.user.UserRegisterPageObject;
//import reportConfig.ExtentTestManager;



public class Level_15_ExtentReport_V2 extends BaseTest{

	WebDriver driver;
	UserHomePageObject userHomePage;
	UserRegisterPageObject userRegisterPage;
	UserLoginPageObject userLoginPage;
	AdminLoginPageObject adminLoginPage;
	AdminDashboardPageObject adminDashboardPage;
	UserCustomerInfoObject userCustomerInfoPage;

	String userEmailAddress;
	String userFirstName = "Test", userLastName = "Automation", userPassword = "123456", userConfirmPassword = "123456";
	String adminEmail = "admin@yourstore.com" , adminPassword = "admin";

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		log.info("Browser:" +  browserName);
		driver = getBrowser(browserName);
		
		userEmailAddress = "auto" + getRandom() + "@gmail.com";
		userHomePage = PageGeneratorManager.getUserHomPageObject(driver);
		
		log.info("Register - Click to link to redirect to register page");
		userRegisterPage= userHomePage.clickToRegisterLink();
		
		log.info("Register - Register to Portal User");
		userRegisterPage.RegisterToPortalUser(userFirstName, userLastName, userEmailAddress, userPassword, userConfirmPassword);

		log.info("Verify get Message Register Success");
		verifyEqual(userRegisterPage.getMessageRegisterSuccess(), "Your registration completed");

		log.info("Register - Click logout");
		userHomePage = userRegisterPage.clickLogOutLink();
	}
	
	
	@Test
	public void Role_01_User_To_Admin(Method method) {
//		ExtentTestManager.startTest(method.getName(), "Role_01_User_To_Admin");
//		ExtentTestManager.getTest().log(LogStatus.INFO, "Click login link");
//		
//		userLoginPage = userHomePage.clickLoginLink();
//		
//		ExtentTestManager.getTest().log(LogStatus.INFO,"Login - user login to portal user");
//		userHomePage =  userLoginPage.LoginPortalUser(userEmailAddress, userPassword);
//
//		ExtentTestManager.getTest().log(LogStatus.INFO,"Login - Verify My Account display");
//		Assert.assertTrue(userHomePage.MyAccountIsDisplay());
//		
//		ExtentTestManager.getTest().log(LogStatus.INFO,"Login - open Customer Infor Page ");
//		userCustomerInfoPage =  userHomePage.openCustomerInfoPage();
//		
//		ExtentTestManager.getTest().log(LogStatus.INFO,"Login - Logout Portal User page");
//		userHomePage = userCustomerInfoPage.clickLogoutLinkAtUserPage(driver);
//		
//		ExtentTestManager.getTest().log(LogStatus.INFO,"Login  Open link Admin page");
//	  	userHomePage.openPageURL(driver, GlobalConstants.ADMIN_PAGE_URL);
//	  	
//	    adminLoginPage = PageGeneratorManager.getAdminLoginPageObject(driver);
//	    
//	    ExtentTestManager.getTest().log(LogStatus.INFO,"Login- Login Admin page with email " + adminEmail + " password " + adminPassword);
//	    adminDashboardPage = adminLoginPage.LoginToAdmiPage(adminEmail, adminPassword);
//	    
//	    
//	    Assert.assertTrue(adminDashboardPage.getTextHeadingDashBoard().contains("Dashboard"));
//		
//	    ExtentTestManager.getTest().log(LogStatus.INFO,"Login - Logout Portal Admin page");
//		adminLoginPage = adminDashboardPage.clickLogoutLinkAtAdminPage(driver);
//		
//		ExtentTestManager.endTest();
	}
	
	@Test
	public void Role_02_Admin_To_User(Method method) {
//		ExtentTestManager.startTest(method.getName(), "Role_01_User_To_Admin");
//		  ExtentTestManager.getTest().log(LogStatus.INFO,"Login  Open link Portal page");
//	  adminLoginPage.openPageURL(driver, GlobalConstants.PORTAL_PAGE_URL);
//	  userHomePage = PageGeneratorManager.getUserHomPageObject(driver);
//	  
//	  userLoginPage = userHomePage.clickLoginLink();
//	  
//		userHomePage =  userLoginPage.LoginPortalUser(userEmailAddress, userPassword);
//		  ExtentTestManager.getTest().log(LogStatus.INFO,"Verify My account is display");
//		  Assert.assertFalse(userHomePage.MyAccountIsDisplay());
//		  ExtentTestManager.endTest();
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
