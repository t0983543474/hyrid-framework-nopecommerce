package com.facebook;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import common.GlobalConstants;
import pageObjects.facebook.register.PageGeneratorManager;
import pageObjects.facebook.register.RegisterPageObject;



public class Level13_Element_Undisplay extends BaseTest{

	WebDriver driver;
	RegisterPageObject registerPage;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		System.out.println("Browser:" +  browserName);
		driver = getBrowser(browserName, url);
		
		registerPage = PageGeneratorManager.getRegisterPageObject(driver);
	
	}
	
	
	@Test
	public void Role_01_User_To_Admin() {
	
		registerPage.clickOpenRegisterPopup();
		
		verifyTrue(registerPage.isDisplayEmail());
		
		verifyTrue(registerPage.isUnDisplayConfirmEmail());
	
		registerPage.inputEmail(driver, "trang@fuvi.vn");
	
		verifyTrue(registerPage.isDisplayConfirmEmail());
		
		registerPage.closePopupRegister();

		verifyTrue(registerPage.isUnDisplayConfirmEmail());
		
//		sleepSecond(5);
		
	}
	


	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
