package com.nopecommerce.product.practice;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopecommerce.common.Common_01_Register;

import common.BaseTest;
import common.PageGeneratorManager;
import pageObjects.nopecommerce.product.UserDetailProductPageObject;
import pageObjects.nopecommerce.product.UserProductPageObject;
import pageObjects.nopecommerce.product.UserTopComponentPageObject;
import pageObjects.nopecommerce.user.UserHomePageObject;
import pageObjects.nopecommerce.user.UserLoginPageObject;
import reportExtentV5Config.ExtentTestManager;

public class Product_04_Order extends BaseTest{
	WebDriver driver;
	UserHomePageObject homePage;
	UserProductPageObject productPage;
	UserLoginPageObject loginPage;
	UserDetailProductPageObject detailProductPage;
	UserTopComponentPageObject topComponent;
	String productName = "Build your own computer";
	String processorName = "2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00]";
	String RAM = "8GB [+$60.00]" , HDD = "400 GB [+$100.00]" , OS = "Vista Premium [+$60.00]" , SoftWare1 = "Microsoft Office [+$50.00]", software2="Acrobat Reader [+$10.00]" , software3="Total Commander [+$5.00]";
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowser(browserName);
		homePage = PageGeneratorManager.getUserHomPageObject(driver);
		loginPage = homePage.clickLoginLink();
		
		homePage = loginPage.LoginPortalUser(Common_01_Register.email, Common_01_Register.userPassword);
	}
	
	@Test
	public void Order_01_Add_Product_To_Cart(Method method) {
		ExtentTestManager.startTest(method.getName(), "Order_01_Add_Product_To_Cart");
		
		homePage.clickSubMenuInMenuByText(driver, "Computers ", "Desktops ");
		productPage = PageGeneratorManager.getUserProductPageObject(driver);
		
		detailProductPage = productPage.clickViewDetailProduct(productName);
		
		detailProductPage.selectProcessor(processorName);
		detailProductPage.selectRAM(RAM);
		detailProductPage.selectHDD(HDD);
		detailProductPage.selectOS(OS);
		detailProductPage.checkSoftWare(SoftWare1);
		detailProductPage.checkSoftWare(software2);
		detailProductPage.checkSoftWare(software3);
		
		String priceDetail = detailProductPage.getPrice();
		String quantityDetail = detailProductPage.getQuantity();
		
		detailProductPage.clickAddToCart();
		
		Assert.assertEquals("The product has been added to your shopping cart", detailProductPage.getMessageAddToCartSuccess());
		
		detailProductPage.clickCloseMessageSuccess();
		
		topComponent = PageGeneratorManager.getUserTopComponentPageObject(driver);
		
		topComponent.hoverToShoppingCart();
		
		sleepSecond(3);
		
		Assert.assertEquals("1", topComponent.getQuantityShoppingCart());
		Assert.assertEquals("There are 1 item(s) in your cart.", topComponent.getTextMiniShopCart());
		String attributes = topComponent.getAttributes(productName);
		String price = topComponent.getPrice(productName);
		System.out.println("top price =" + price);
		String quantity = topComponent.getQuantity(productName);
		
		Assert.assertTrue(attributes.contains(processorName) && attributes.contains(HDD) && attributes.contains(OS)
				&& attributes.contains(RAM) && attributes.contains(SoftWare1)&& attributes.contains(software2)&& attributes.contains(software3));
		
		Assert.assertEquals(priceDetail, price);
		Assert.assertEquals(quantityDetail, quantity);
	}
	
	@Test
	public void Order_02_Edit_Product_In_Shopping_Cart(Method method) {
		ExtentTestManager.startTest(method.getName(), "Order_02_Edit_Product_In_Shopping_Cart");
		
	}
	
	@Test
	public void Order_03_Remove_From_Cart(Method method) {
		ExtentTestManager.startTest(method.getName(), "Order_03_Remove_From_Cart");
		
	}
	
	@Test
	public void Order_04_Update_Shopping_Cart(Method method) {
		ExtentTestManager.startTest(method.getName(), "Order_04_Update_Shopping_Cart");
		
	}
	
	@Test
	public void Order_05_Checkout_Order_Payment_Method_By_Cheque(Method method) {
		ExtentTestManager.startTest(method.getName(), "Order_05_Checkout_Order_Payment_Method_By_Cheque");
		
	}
	
	@Test
	public void Order_06_Checkout_Order_Payment_Method_By_Card(Method method) {
		ExtentTestManager.startTest(method.getName(), "Order_06_Checkout_Order_Payment_Method_By_Card");
		
	}
	
	@Test
	public void Order_07_ReOrder(Method method) {
		ExtentTestManager.startTest(method.getName(), "Order_07_ReOrder");
		
	}
	
	@AfterClass
	public void afterClass() {
		closeBrowserAndDriver();
	}
	
}
