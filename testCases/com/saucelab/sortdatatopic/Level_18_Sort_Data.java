package com.saucelab.sortdatatopic;

import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.sauceLab.LoginPageObject;
import pageObjects.sauceLab.PageGenerator;
import pageObjects.sauceLab.ProductsPageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_18_Sort_Data extends BaseTest { // bài này học sort data tăng dần (asc) và giảm dần (decs)
	private WebDriver driver;
	LoginPageObject loginPage;
	ProductsPageObject productPage;
	String userName = "standard_user";
	String password = "secret_sauce";

	@Parameters({ "browser", "appURL" })
	@BeforeClass
	public void beforeClass(String browserName, String sauceLabURL) {

		driver = getMultipleBrowserDriver(browserName, sauceLabURL);

		loginPage = PageGenerator.getLoginPageObject(driver);

		loginPage.enterToUsernameTextbox(userName);

		loginPage.enterToPasswordTextbox(password);

		productPage = loginPage.clickToLoginButton();
	}

	@Test
	public void Sort_01_Name() {
		productPage.selectItemInSortDropdown("Name (A to Z)"); // tang dan
		productPage.sleepInSecond(2);
		// cần verify xem sản phẩm có hiện đúng theo asc ko
		Assert.assertTrue(productPage.isProductNameSortByAsc());

		productPage.selectItemInSortDropdown("Name (Z to A)"); // giam dan
		productPage.sleepInSecond(2);
		// cần verify xem sản phẩm có hiện đúng theo desc ko
		Assert.assertTrue(productPage.isProductNameSortByDesc());
	}

	@Test
	public void Sort_02_Price() {
		productPage.selectItemInSortDropdown("Price (low to high)"); // tang dan
		productPage.sleepInSecond(2);
		Assert.assertTrue(productPage.isProductPriceSortByAsc());

		productPage.selectItemInSortDropdown("Price (high to low)"); // giam dan
		productPage.sleepInSecond(2);
		Assert.assertTrue(productPage.isProductPriceSortByDesc());
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		// closeBrowserDriver();
	}

}
