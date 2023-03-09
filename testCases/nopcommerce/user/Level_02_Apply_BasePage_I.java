package nopcommerce.user;

import org.testng.annotations.Test;

import commons.BasePage;

import org.testng.annotations.BeforeClass;

import java.util.Random;
import java.util.concurrent.TimeUnit;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_02_Apply_BasePage_I {
	WebDriver driver;
	// Declare - khai báo
	BasePage basePage;
	String projectPath = System.getProperty("user.dir"); // user.dir là user directory, lấy ra cái thư mục của dự án
	String emailAddress = "automation" + fakeNumber() + "@gmail.vn";

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		// Initial - khởi tạo
		basePage = new BasePage(); // BasePage là class còn basePage là 1 object-đối tượng

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
	}

	@Test
	/*
	 * public void TC_01_Register_Empty_Data() { basePage.waitForElementClickable(driver, "//a[@class='ico-register']"); basePage.clickToElement(driver, "//a[@class='ico-register']");
	 * 
	 * basePage.waitForElementClickable(driver, "//button[@id='register-button']"); basePage.clickToElement(driver, "//button[@id='register-button']");
	 * 
	 * Assert.assertEquals(basePage.getElementText(driver, "//span[@id='FirstName-error']"), "First name is required."); Assert.assertEquals(basePage.getElementText(driver, "//span[@id='LastName-error']"), "Last name is required.");
	 * Assert.assertEquals(basePage.getElementText(driver, "//span[@id='Email-error']"), "Email is required."); Assert.assertEquals(basePage.getElementText(driver, "//span[@id='Password-error']"), "Password is required.");
	 * Assert.assertEquals(basePage.getElementText(driver, "//span[@id='ConfirmPassword-error']"), "Password is required."); }
	 * 
	 * @Test public void TC_02_Register_Invalid_Email() { basePage.waitForElementClickable(driver, "//a[@class='ico-register']"); basePage.clickToElement(driver, "//a[@class='ico-register']");
	 * 
	 * basePage.sendKeysToElement(driver, "//input[@id='FirstName']", "Selenium"); basePage.sendKeysToElement(driver, "//input[@id='LastName']", "Locator"); basePage.sendKeysToElement(driver, "//input[@id='Email']", "automation@12345*com");
	 * basePage.sendKeysToElement(driver, "//input[@id='Password']", "123456"); basePage.sendKeysToElement(driver, "//input[@id='ConfirmPassword']", "123456");
	 * 
	 * Assert.assertEquals(basePage.getElementText(driver, "//span[@id='Email-error']"), "Wrong email"); }
	 * 
	 * @Test public void TC_03_Register_Success() { basePage.waitForElementClickable(driver, "//a[@class='ico-register']"); basePage.clickToElement(driver, "//a[@class='ico-register']");
	 * 
	 * basePage.sendKeysToElement(driver, "//input[@id='FirstName']", "Selenium"); basePage.sendKeysToElement(driver, "//input[@id='LastName']", "Locator"); basePage.sendKeysToElement(driver, "//input[@id='Email']", emailAddress);
	 * basePage.sendKeysToElement(driver, "//input[@id='Password']", "123456"); basePage.sendKeysToElement(driver, "//input[@id='ConfirmPassword']", "123456");
	 * 
	 * basePage.waitForElementClickable(driver, "//button[@id='register-button']"); basePage.clickToElement(driver, "//button[@id='register-button']");
	 * 
	 * Assert.assertEquals(basePage.getElementText(driver, "//div[@class='result']"), "Your registration completed");
	 * 
	 * }
	 * 
	 * @Test public void TC_04_Register_Existing_Email() { basePage.waitForElementClickable(driver, "//a[@class='ico-register']"); basePage.clickToElement(driver, "//a[@class='ico-register']");
	 * 
	 * basePage.sendKeysToElement(driver, "//input[@id='FirstName']", "Selenium"); basePage.sendKeysToElement(driver, "//input[@id='LastName']", "Locator"); basePage.sendKeysToElement(driver, "//input[@id='Email']", emailAddress);
	 * basePage.sendKeysToElement(driver, "//input[@id='Password']", "123456"); basePage.sendKeysToElement(driver, "//input[@id='ConfirmPassword']", "123456");
	 * 
	 * basePage.waitForElementClickable(driver, "//button[@id='register-button']"); basePage.clickToElement(driver, "//button[@id='register-button']");
	 * 
	 * Assert.assertEquals(basePage.getElementText(driver, "//div[contains(@class,'message-error')]//li"), "The specified email already exists"); }
	 * 
	 * @Test public void TC_05_Register_Password_Less_Than_6_Letters() { basePage.waitForElementClickable(driver, "//a[@class='ico-register']"); basePage.clickToElement(driver, "//a[@class='ico-register']");
	 * 
	 * basePage.sendKeysToElement(driver, "//input[@id='FirstName']", "Selenium"); basePage.sendKeysToElement(driver, "//input[@id='LastName']", "Locator"); basePage.sendKeysToElement(driver, "//input[@id='Email']", emailAddress);
	 * basePage.sendKeysToElement(driver, "//input[@id='Password']", "12345"); basePage.sendKeysToElement(driver, "//input[@id='ConfirmPassword']", "12345");
	 * 
	 * basePage.waitForElementClickable(driver, "//button[@id='register-button']"); basePage.clickToElement(driver, "//button[@id='register-button']");
	 * 
	 * Assert.assertEquals(basePage.getElementText(driver, "//span[@id='Password-error']"), "Password must meet the following rules:\nmust have at least 6 characters"); }
	 * 
	 * @Test public void TC_06_Register_Invalid_Confirm_Password() { basePage.waitForElementClickable(driver, "//a[@class='ico-register']"); basePage.clickToElement(driver, "//a[@class='ico-register']");
	 * 
	 * basePage.sendKeysToElement(driver, "//input[@id='FirstName']", "Selenium"); basePage.sendKeysToElement(driver, "//input[@id='LastName']", "Locator"); basePage.sendKeysToElement(driver, "//input[@id='Email']", emailAddress);
	 * basePage.sendKeysToElement(driver, "//input[@id='Password']", "123456"); basePage.sendKeysToElement(driver, "//input[@id='ConfirmPassword']", "65432");
	 * 
	 * basePage.waitForElementClickable(driver, "//button[@id='register-button']"); basePage.clickToElement(driver, "//button[@id='register-button']");
	 * 
	 * Assert.assertEquals(basePage.getElementText(driver, "//span[@id='ConfirmPassword-error']"), "The password and confirmation password do not match."); }
	 */

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public int fakeNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}

}
