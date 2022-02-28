package com.jquery;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import pageObjects.jquery.uploadFile.HomePageObject;
import pageObjects.jquery.uploadFile.PageGeneratorManager;

public class Level_11_Uppload_Files extends BaseTest{

	WebDriver driver;
	HomePageObject homePage;

	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		System.out.println("Browser:" +  browserName);
		driver = getBrowser(browserName, url);
		homePage = PageGeneratorManager.getHomePageObject(driver);
	
	}

	

//	@Test
	public void Table_01_Upload_Single_File() {
	
		
	}

//	@Test
	public void Table_02_Upload_Multiple_Files() {
		
	}
	

	

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}

