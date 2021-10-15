package com.nopecommerce.user;

import org.testng.annotations.Test;

import common.BasePage;

import org.testng.annotations.BeforeClass;

import java.util.Random;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_02_Apply_BasePage_III extends BasePage {
	
	WebDriver driver;
	
	String projectPath = System.getProperty("user.dir");
	String emailAddress;
	

  @BeforeClass
  public void beforeClass() {
	  System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDriver\\chromedriver.exe");
	  driver  = new ChromeDriver();
//	  basePage = BasePage.getBasePageObject();
	  emailAddress = "auto" +  getRandom() + "@gmail.com";
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  driver.get("https://demo.nopcommerce.com/");
  }
  
  @Test
  public void TC_01_Register_Empty_Data() {
	  waitForElementClickAble(driver, "//a[@class='ico-register']");
	  clickToElement(driver, "//a[@class='ico-register']");
	
	  waitForElementClickAble(driver, "//button[@id='register-button']");
	  clickToElement(driver, "//button[@id='register-button']");
	 
	  Assert.assertEquals(getElementText(driver, "//span[@id='FirstName-error']"), "First name is required.");
	  
	  Assert.assertEquals(getElementText(driver, "//span[@id='LastName-error']"), "Last name is required.");
		
	  Assert.assertEquals(getElementText(driver, "//span[@id='Email-error']"), "Email is required.");
		
	  Assert.assertEquals(getElementText(driver, "//span[@id='Password-error']"), "Password is required.");
		
	  Assert.assertEquals(getElementText(driver, "//span[@id='ConfirmPassword-error']"), "Password is required.");
		
	  
  }
  
  @Test
  public void TC_02_Register_Invalid_Email() {
	  waitForElementClickAble(driver, "//a[@class='ico-register']");
	  clickToElement(driver, "//a[@class='ico-register']");
	 
	  sendKeyToElement(driver, "//input[@id='FirstName']", "test");
	  sendKeyToElement(driver, "//input[@id='LastName']", "auto");
	  sendKeyToElement(driver, "//input[@id='Email']", "123!@#");
	  sendKeyToElement(driver, "//input[@id='Password']", "123456");
	  sendKeyToElement(driver, "//input[@id='ConfirmPassword']", "123456");
	  
	  clickToElement(driver, "//button[@id='register-button']");
	  
	  Assert.assertEquals(getElementText(driver, "//span[@id='Email-error']"), "Wrong email");
		
	 
		
  }
  
  @Test
  public void TC_03_Register_Valid_Infomation() {
	  clickToElement(driver, "//a[@class='ico-register']");
	  
	  sendKeyToElement(driver, "//input[@id='FirstName']", "test");
	  sendKeyToElement(driver, "//input[@id='LastName']", "auto");
	  sendKeyToElement(driver, "//input[@id='Email']", emailAddress);
	  sendKeyToElement(driver, "//input[@id='Password']", "123456");
	  sendKeyToElement(driver, "//input[@id='ConfirmPassword']", "123456");
	  

	  clickToElement(driver, "//button[@id='register-button']");
	  //div.result
	  waitForAllElementVisible(driver, "//div[@class='result']");
	  Assert.assertEquals(getElementText(driver, "//div[@class='result']"), "Your registration completed");
	  
	  clickToElement(driver, "//a[@class='ico-logout']");
	 
  }
  
  @Test
  public void TC_04_Register_Email_Exists() {
	  waitForElementClickAble(driver, "//a[@class='ico-register']");
	  clickToElement(driver, "//a[@class='ico-register']");
	 
	  
	  
	  sendKeyToElement(driver, "//input[@id='FirstName']", "test");
	  sendKeyToElement(driver, "//input[@id='LastName']", "auto");
	  sendKeyToElement(driver, "//input[@id='Email']", emailAddress);
	  sendKeyToElement(driver, "//input[@id='Password']", "123456");
	  sendKeyToElement(driver, "//input[@id='ConfirmPassword']", "123456");
	
	  
	  clickToElement(driver, "//button[@id='register-button']");
	 // div.message-error li
	  Assert.assertEquals(getElementText(driver, "//div[contains(@class, 'message-error')]//li"), "The specified email already exists");
	  
  }
  
  @Test
  public void TC_05_Register_Password_LessThan_6() {
	  waitForElementClickAble(driver, "//a[@class='ico-register']");
	  clickToElement(driver, "//a[@class='ico-register']");
	 
	  sendKeyToElement(driver, "//input[@id='FirstName']", "test");
	  sendKeyToElement(driver, "//input[@id='LastName']", "auto");
	  sendKeyToElement(driver, "//input[@id='Email']", "auto" +  getRandom() + "@gmail.com");
	  sendKeyToElement(driver, "//input[@id='Password']", "123");
	  sendKeyToElement(driver, "//input[@id='ConfirmPassword']", "123");
	

	  
	  clickToElement(driver, "//button[@id='register-button']");
	 
	  Assert.assertEquals(getElementText(driver, "//span[@id='Password-error']"),
			"Password must meet the following rules:" + 
			"\n" + 
			"must have at least 6 characters");
	  
	  
  }
  
  @Test
  public void TC_06_ConfirmPassword_NotMatch() {
	  waitForElementClickAble(driver, "//a[@class='ico-register']");
	  clickToElement(driver, "//a[@class='ico-register']");
	 
	  sendKeyToElement(driver, "//input[@id='FirstName']", "test");
	  sendKeyToElement(driver, "//input[@id='LastName']", "auto");
	  sendKeyToElement(driver, "//input[@id='Email']", "auto" +  getRandom() + "@gmail.com");
	  sendKeyToElement(driver, "//input[@id='Password']", "123567");
	  sendKeyToElement(driver, "//input[@id='ConfirmPassword']", "123568");
	
	  
	
	  
	  clickToElement(driver, "//button[@id='register-button']");
	  
	  Assert.assertEquals(getElementText(driver, "//span[@id='ConfirmPassword-error']"), "The password and confirmation password do not match.");
		
		
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }
  
  public int getRandom() {
	  Random ran=  new Random();
	  return ran.nextInt(9999);
  }

}
