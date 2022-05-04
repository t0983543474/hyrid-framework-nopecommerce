package com.nopecommerce.user;

import java.lang.reflect.Method;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import com.nopecommerce.common.Common_01_Register_Cookies;

//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.Status;

import common.BaseTest;
import common.GlobalConstants;
import common.PageGeneratorManager;
import pageObjects.nopecommerce.admin.AdminDashboardPageObject;
import pageObjects.nopecommerce.admin.AdminLoginPageObject;
import pageObjects.nopecommerce.user.UserCustomerInfoPageObject;
import pageObjects.nopecommerce.user.UserHomePageObject;
import pageObjects.nopecommerce.user.UserLoginPageObject;
import pageObjects.nopecommerce.user.UserRegisterPageObject;
import reportExtentV5Config.ExtentTestManager;



public class Level_16_Login_Cookies extends BaseTest{

	WebDriver driver;
	UserHomePageObject userHomePage;
	UserRegisterPageObject userRegisterPage;
	UserLoginPageObject userLoginPage;
	AdminLoginPageObject adminLoginPage;
	AdminDashboardPageObject adminDashboardPage;
	UserCustomerInfoPageObject userCustomerInfoPage;
	String adminEmail = "admin@yourstore.com" , adminPassword = "admin";
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		log.info("Browser:" +  browserName);
		driver = getBrowser(browserName);
		
		userHomePage = PageGeneratorManager.getUserHomPageObject(driver);
		
	}
	
	
	@Test
	public void Role_01_User_To_Admin(Method method) {
		ExtentTestManager.startTest(method.getName(), "Role_01_User_To_Admin");
	

		ExtentTestManager.getTest().log(Status.INFO,"Role_01_User_To_Admin: Click login link");
		userLoginPage = userHomePage.clickLoginLink();
		
		ExtentTestManager.getTest().log(Status.INFO,"Role_01_User_To_Admin - user login to portal user");
//		userHomePage =  userLoginPage.LoginPortalUser(Common_01_Register.email, Common_01_Register.userPassword);
		Set<Cookie> loginCookies = Common_01_Register_Cookies.logginCookies;
		userLoginPage.setCookies(driver, loginCookies);
		userLoginPage.clickLogo(driver);
		
	

		ExtentTestManager.getTest().log(Status.INFO,"Role_01_User_To_Admin - Verify My Account display");
		Assert.assertTrue(userHomePage.MyAccountIsDisplay());
		
		ExtentTestManager.getTest().log(Status.INFO,"Role_01_User_To_Admin - open Customer Infor Page ");
		userCustomerInfoPage =  userHomePage.openCustomerInfoPage();
		
		ExtentTestManager.getTest().log(Status.INFO,"Role_01_User_To_Admin - Logout Portal User page");
		userHomePage = userCustomerInfoPage.clickLogoutLinkAtUserPage(driver);
		
		ExtentTestManager.getTest().log(Status.INFO,"Role_01_User_To_Admin  Open link Admin page");
	  	userHomePage.openPageURL(driver, GlobalConstants.ADMIN_PAGE_URL);
	  	
	    adminLoginPage = PageGeneratorManager.getAdminLoginPageObject(driver);
	    
	    ExtentTestManager.getTest().log(Status.INFO,"Role_01_User_To_Admin- Login Admin page with email " + adminEmail + " password " + adminPassword);
	    adminDashboardPage = adminLoginPage.LoginToAdmiPage(adminEmail, adminPassword);
	    
	    
	    Assert.assertTrue(adminDashboardPage.getTextHeadingDashBoard().contains("Dashboard"));
		
	   
	}
	
	@Test
	public void Role_02_Admin_To_User(Method method) {
		ExtentTestManager.startTest(method.getName(), "Role_02_Admin_To_User");
		
		ExtentTestManager.getTest().log(Status.INFO,"Role_02_Admin_To_User - Logout Portal Admin page");
		adminLoginPage = adminDashboardPage.clickLogoutLinkAtAdminPage(driver);
		
		ExtentTestManager.getTest().log(Status.INFO,"Role_02_Admin_To_User: Login  Open link Portal page");
	  adminLoginPage.openPageURL(driver, GlobalConstants.PORTAL_PAGE_URL);
	  userHomePage = PageGeneratorManager.getUserHomPageObject(driver);
	  
	  userLoginPage = userHomePage.clickLoginLink();
	  
	  ExtentTestManager.getTest().log(Status.INFO,"Role_02_Admin_To_User: Login page with cookies");
//		userHomePage =  userLoginPage.LoginPortalUser(Common_01_Register.email, Common_01_Register.userPassword);
	  Set<Cookie> loginCookies = Common_01_Register_Cookies.logginCookies;
		userLoginPage.setCookies(driver, loginCookies);
		userLoginPage.clickLogo(driver);
		
		ExtentTestManager.getTest().log(Status.INFO,"Role_02_Admin_To_User: Verify My account is display");
		  Assert.assertTrue(userHomePage.MyAccountIsDisplay());
	}

	@AfterClass
	public void afterClass() {
//		 extent.flush();
		driver.quit();
	}
}