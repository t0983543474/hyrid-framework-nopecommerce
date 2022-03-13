package com.jquery;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
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

	

	@Test
	public void Table_01_Upload_Single_File() {
	
		
	}

	@Test
	public void Table_02_Upload_Multiple_Files() {
		homePage.uploadFiles(driver, "ITZYYuNa.png", "itzy-yuna.jpg", "itzy-yuna-jyp.jpg");
		
		Assert.assertTrue(homePage.isDisplayUploadFile(driver, "ITZYYuNa.png", "itzy-yuna.jpg", "itzy-yuna-jyp.jpg"));
		homePage.startProcessUpload(driver);
		Assert.assertTrue(homePage.isDisplayLinkUploadFile(driver, "ITZYYuNa.png", "itzy-yuna.jpg", "itzy-yuna-jyp.jpg"));
		Assert.assertTrue(homePage.isDispayLoadedImage(driver, "ITZYYuNa.png", "itzy-yuna.jpg", "itzy-yuna-jyp.jpg"));
	}
	

	
	

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}

