package nopcommerce.user;

import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserMyAccountCustomerInfoPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_14_ReportNG_Screenshot extends BaseTest {
	private WebDriver driver;
	private String firstName, lastName, password, emailAddress;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserMyAccountCustomerInfoPageObject customerInfoPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String brwoserName) {

		driver = getMultipleBrowserDriver(brwoserName);

		homePage = PageGeneratorManager.getUserHomePage(driver);

		firstName = "Selenium";
		lastName = "Locator";
		password = "123456";
		emailAddress = "automation" + fakeNumber() + "@gmail.vn";
	}

	@Test
	public void User_01_Register() {
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
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
	}

	@Test
	public void User_02_Login() {
		log.info("Login - Step 01: Navigate to Login Page");
		loginPage = homePage.openLoginPage();

		log.info("Login - Step 02: Enter to Email Address Textbox with '" + emailAddress + "'");
		loginPage.inputToEmailTextbox(emailAddress);

		log.info("Login - Step 03: Enter to Password Textbox with '" + password + "'");
		loginPage.inputToPasswordTextbox(password);

		log.info("Login - Step 04: Click to Login Button");
		homePage = loginPage.clickToLoginButton();

		log.info("Login - Step 05: Verify 'My Account' link is displayed");
		Assert.assertFalse(homePage.isMyAccountLinkDisplayed());

		log.info("Login - Step 06: Navigate to My Account Page");
		customerInfoPage = homePage.openMyAccountPage();

		log.info("Login - Step 07: Verify 'Customer Info' page is displayed");
		Assert.assertFalse(customerInfoPage.isCustomerInfoHeaderDisplayed());

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
