package com.nopecommerce.user;

import org.testng.annotations.Test;

import common.BasePage;

import org.testng.annotations.BeforeClass;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_01_Register_DRY {
	
	WebDriver driver;
	
	String projectPath = System.getProperty("user.dir");
	String emailAddress;
	
 
  @BeforeClass
  public void beforeClass() {
	  System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDriver\\chromedriver.exe");
	  driver  = new ChromeDriver();
	 
	  emailAddress = "auto" +  getRandom() + "@gmail.com";
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  driver.get("https://demo.nopcommerce.com/");
  }
  
  @Test
  public void TC_01_Register_Empty_Data() {
	  driver.findElement(By.cssSelector("a.ico-register")).click();
	 
	  driver.findElement(By.cssSelector("button#register-button")).click();
	  
	  Assert.assertEquals(driver.findElement(By.cssSelector("span#FirstName-error")).getText(), "First name is required.");
	  
	  Assert.assertEquals(driver.findElement(By.cssSelector("span#LastName-error")).getText(), "Last name is required.");
		
	  Assert.assertEquals(driver.findElement(By.cssSelector("span#Email-error")).getText(), "Email is required.");
		
	  Assert.assertEquals(driver.findElement(By.cssSelector("span#Password-error")).getText(), "Password is required.");
		
	  Assert.assertEquals(driver.findElement(By.cssSelector("span#ConfirmPassword-error")).getText(), "Password is required.");
		
	  
  }
  
  @Test
  public void TC_02_Register_Invalid_Email() {
	  
	  driver.findElement(By.cssSelector("a.ico-register")).click();
	  
	  driver.findElement(By.cssSelector("input#FirstName")).sendKeys("test");
	  driver.findElement(By.cssSelector("input#LastName")).sendKeys("auto");
	  driver.findElement(By.cssSelector("input#Email")).sendKeys("123!@#");
	  driver.findElement(By.cssSelector("input#Password")).sendKeys("123456");
	  driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys("123456");
	  
	  driver.findElement(By.cssSelector("button#register-button")).click();
	  
	  Assert.assertEquals(driver.findElement(By.cssSelector("span#Email-error")).getText(), "Wrong email");
		
  }
  
  @Test
  public void TC_03_Register_Valid_Infomation() {
  driver.findElement(By.cssSelector("a.ico-register")).click();
	  
	  driver.findElement(By.cssSelector("input#FirstName")).sendKeys("test");
	  driver.findElement(By.cssSelector("input#LastName")).sendKeys("auto");
	  driver.findElement(By.cssSelector("input#Email")).sendKeys(emailAddress);
	  driver.findElement(By.cssSelector("input#Password")).sendKeys("123456");
	  driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys("123456");
	  
	  driver.findElement(By.cssSelector("button#register-button")).click();
	  
	  Assert.assertEquals(driver.findElement(By.cssSelector("div.result")).getText(), "Your registration completed");
	  
	  driver.findElement(By.cssSelector("a.ico-logout")).click();
	  
		
  }
  
  @Test
  public void TC_04_Register_Email_Exists() {
	  driver.findElement(By.cssSelector("a.ico-register")).click();
	  
	  driver.findElement(By.cssSelector("input#FirstName")).sendKeys("test");
	  driver.findElement(By.cssSelector("input#LastName")).sendKeys("auto");
	  driver.findElement(By.cssSelector("input#Email")).sendKeys(emailAddress);
	  driver.findElement(By.cssSelector("input#Password")).sendKeys("123456");
	  driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys("123456");
	  
	  driver.findElement(By.cssSelector("button#register-button")).click();
	  
	  Assert.assertEquals(driver.findElement(By.cssSelector("div.message-error li")).getText(), "The specified email already exists");
	  
  }
  
  @Test
  public void TC_05_Register_Password_LessThan_6() {
  driver.findElement(By.cssSelector("a.ico-register")).click();
	  
	  driver.findElement(By.cssSelector("input#FirstName")).sendKeys("test");
	  driver.findElement(By.cssSelector("input#LastName")).sendKeys("auto");
	  driver.findElement(By.cssSelector("input#Email")).sendKeys("auto" +  getRandom() + "@gmail.com");
	  driver.findElement(By.cssSelector("input#Password")).sendKeys("123");
	  driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys("123");
	  
	  driver.findElement(By.cssSelector("button#register-button")).click();
	  
	  Assert.assertEquals(driver.findElement(By.cssSelector("span#Password-error")).getText(),
			"Password must meet the following rules:" + 
			"\n" + 
			"must have at least 6 characters");
	  
	  
  }
  
  @Test
  public void TC_06_ConfirmPassword_NotMatch() {
  driver.findElement(By.cssSelector("a.ico-register")).click();
	  
	  driver.findElement(By.cssSelector("input#FirstName")).sendKeys("test");
	  driver.findElement(By.cssSelector("input#LastName")).sendKeys("auto");
	  driver.findElement(By.cssSelector("input#Email")).sendKeys("auto" +  getRandom() + "@gmail.com");
	  driver.findElement(By.cssSelector("input#Password")).sendKeys("123567");
	  driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys("123568");
	  
	  driver.findElement(By.cssSelector("button#register-button")).click();
	  
	  Assert.assertEquals(driver.findElement(By.cssSelector("span#ConfirmPassword-error")).getText(), "The password and confirmation password do not match.");
		
		
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
