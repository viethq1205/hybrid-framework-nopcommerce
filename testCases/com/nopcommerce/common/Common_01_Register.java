package com.nopcommerce.common;

import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserMyAccountCustomerInfoPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class Common_01_Register extends BaseTest { // class này bắt đầu đc sử dụng từ topic 81 Share Login
	// ứng dụng data chung cho các class test khác (ở đây là register 1 tk)
	private WebDriver driver;
	private String firstName, lastName;
	public static String password, emailAddress;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;

	@Parameters("browser")
	@BeforeTest(description = "Create new User for all Class Test")
	public void Register(String browserName) {
		driver = getMultipleBrowserDriver(browserName);

		homePage = PageGeneratorManager.getUserHomePage(driver);

		firstName = "Selenium";
		lastName = "Locator";
		password = "123456";
		emailAddress = "automation" + fakeNumber() + "@gmail.vn";

		log.info("Register - Step 01: Navigate to Register Page");
		registerPage = homePage.openRegisterPage();

		log.info("Register - Step 02: Enter to Firstname Textbox with '" + firstName + "'");
		registerPage.inputToFirstNameTextbox(firstName);

		log.info("Register - Step 03: Enter to Lastname Textbox with '" + lastName + "'");
		registerPage.inputToLastNameTextbox(lastName);

		log.info("Register - Step 04: Enter to Email Address Textbox with '" + emailAddress + "'");
		registerPage.inputToEmailTextbox(emailAddress);

		log.info("Register - Step 05: Enter to Password Textbox with '" + password + "'");
		registerPage.inputToPasswordTextbox(password);

		log.info("Register - Step 06: Enter to Confirm Password Textbox with '" + password + "'");
		registerPage.inputToConfirmPasswordTextbox(password);

		log.info("Register - Step 07: Click Register Button");
		registerPage.clickToRegisterButton();

		log.info("Register - Step 08: Verify Register success message is displayed");
		verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		driver.quit();
	}

	// @AfterClass
	// public void afterClass() {
	// driver.quit(); //driver quit này phải bỏ lên kia mới chạy đc vì theo bên class Annotation mình đã học thì phạm vi của class nhỏ hơn test nên sẽ ko chạy đc
	// trừ phi cái @AfterClass mình đổi thành @AfterTest
	// }

}
