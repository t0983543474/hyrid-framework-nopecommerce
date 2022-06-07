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
import pageObjects.nopecommerce.product.UserShopingCardPageObject;
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
	UserShopingCardPageObject shoppingCartPage;
	String productName = "Build your own computer";
	String processorName = "2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00]";
	String RAM = "8GB [+$60.00]" , HDD = "400 GB [+$100.00]" , OS = "Vista Premium [+$60.00]" , SoftWare1 = "Microsoft Office [+$50.00]", software2="Acrobat Reader [+$10.00]" , software3="Total Commander [+$5.00]";
	
	String processorEdit = "2.2 GHz Intel Pentium Dual-Core E2200", RAMEdit="4GB [+$20.00]", HDDEdit="320 GB", OSEdit="Vista Home [+$50.00]"; 
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
		sleepSecond(2);
		String priceDetail = detailProductPage.getPrice();
		System.out.println("priceDetail " + priceDetail);
		String quantityDetail = detailProductPage.getQuantity();
		
		detailProductPage.clickAddToCart();
		
		Assert.assertEquals("The product has been added to your shopping cart", detailProductPage.getMessageAddUpdateToCartSuccess());
		
		detailProductPage.clickCloseMessageSuccess();
		
		topComponent = PageGeneratorManager.getUserTopComponentPageObject(driver);
		
		topComponent.hoverToShoppingCart();
		
		sleepSecond(3);
		
		Assert.assertEquals("1", topComponent.getQuantityShoppingCart());
		Assert.assertEquals("There are 1 item(s) in your cart.", topComponent.getTextMiniShopCart());
		String attributes = topComponent.getAttributes(productName);
		System.out.println("attributes" + attributes);
		String price = topComponent.getPrice(productName);
		System.out.println("priceTop " + price);
		String quantity = topComponent.getQuantity(productName);
		
		Assert.assertTrue(attributes.contains(processorName) && attributes.contains(HDD) && attributes.contains(OS)
				&& attributes.contains(RAM) && attributes.contains(SoftWare1)&& attributes.contains(software2)&& attributes.contains(software3));
		
		Assert.assertEquals(priceDetail, price);
		Assert.assertEquals(quantityDetail, quantity);
	}
	
	@Test
	public void Order_02_Edit_Product_In_Shopping_Cart(Method method) {
		ExtentTestManager.startTest(method.getName(), "Order_02_Edit_Product_In_Shopping_Cart");
		
		topComponent.clickToShoppingCard(driver);
		
		shoppingCartPage = PageGeneratorManager.getUserShopingCardPageObject(driver);
		
		detailProductPage = shoppingCartPage.clickEditByProductName(productName);
		
		detailProductPage.selectProcessor(processorEdit);
		
		detailProductPage.selectHDD(HDDEdit);
		
		detailProductPage.selectOS(OSEdit);
		
		detailProductPage.selectRAM(RAMEdit);
		
		detailProductPage.checkSoftWare(SoftWare1);
		
		detailProductPage.unCheckSoftware(software2);
		
		detailProductPage.unCheckSoftware(software3);
		
		detailProductPage.inputQuantity("2");
		
		sleepSecond(2);
		
		Assert.assertEquals(detailProductPage.getPrice(), "$1,320.00");
		
		detailProductPage.clickUpdateShoppringCard();
		
		Assert.assertEquals(detailProductPage.getMessageAddUpdateToCartSuccess(), "The product has been added to your shopping cart");
		
		detailProductPage.clickCloseMessageSuccess();
		sleepSecond(2);
		
		shoppingCartPage =  detailProductPage.clickToShoppingCard(driver);
		
		String attributes = shoppingCartPage.getAttributesByProductName(productName);
		
		String quantity = shoppingCartPage.getQuantityByProductName(productName);
		
		String price = shoppingCartPage.getPriceByProductName(productName);
		
		String total = shoppingCartPage.getTotalByProductName(productName);
		
		Assert.assertTrue(attributes.contains(processorEdit) && attributes.contains(HDDEdit) && attributes.contains(OSEdit)
				&& attributes.contains(RAMEdit) && attributes.contains(SoftWare1)&& !attributes.contains(software2)&& !attributes.contains(software3));
		
		System.out.println("total " + total);
		System.out.println("price " + price);
		System.out.println("quantity " + quantity);
		
		int total1 = Integer.parseInt(total.replace("$", "").replace(",", "").replace(".", ""));
		int price1 = Integer.parseInt(price.replace("$", "").replace(",", "").replace(".", ""));
		int quan = Integer.parseInt(quantity);
		Assert.assertEquals(price1*quan, total1);
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
