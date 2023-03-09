package nopcommerce.user;

import org.testng.annotations.Test;

//import com.relevantcodes.extentreports.LogStatus;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserMyAccountCustomerInfoPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
//import reportConfig.ExtentManager;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_14_ExtentReportV2_Screenshot extends BaseTest {
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
	public void User_01_Register(Method method) {
		// ExtentManager.startTest(method.getName(), "User_01_Register");

		// ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 01: Navigate to Register Page");
		registerPage = homePage.openRegisterPage();

		// ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 02: Enter to Firstname Textbox with '" + firstName + "'");
		registerPage.inputToFirstNameTextbox(firstName);

		// ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 03: Enter to Lastname Textbox with '" + lastName + "'");
		registerPage.inputToLastNameTextbox(lastName);

		// ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 04: Enter to Email Address Textbox with '" + emailAddress + "'");
		registerPage.inputToEmailTextbox(emailAddress);

		// ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 05: Enter to Password Textbox with '" + password + "'");
		registerPage.inputToPasswordTextbox(password);

		// ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 06: Enter to Confirm Password Textbox with '" + password + "'");
		registerPage.inputToConfirmPasswordTextbox(password);

		// ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 07: Click Register Button");
		registerPage.clickToRegisterButton();

		// ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 08: Verify Register success message is displayed");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		// ExtentManager.endTest();
	}

	@Test
	public void User_02_Login(Method method) {
		// ExtentManager.startTest(method.getName(), "User_02_Login");

		// ExtentManager.getTest().log(LogStatus.INFO, "Login - Step 01: Navigate to Login Page");
		loginPage = homePage.openLoginPage();

		// ExtentManager.getTest().log(LogStatus.INFO, "Login - Step 02: Enter to Email Address Textbox with '" + emailAddress + "'");
		loginPage.inputToEmailTextbox(emailAddress);

		// ExtentManager.getTest().log(LogStatus.INFO, "Login - Step 03: Enter to Password Textbox with '" + password + "'");
		loginPage.inputToPasswordTextbox(password);

		// ExtentManager.getTest().log(LogStatus.INFO, "Login - Step 04: Click to Login Button");
		homePage = loginPage.clickToLoginButton();

		// ExtentManager.getTest().log(LogStatus.INFO, "Login - Step 05: Verify 'My Account' link is displayed");
		Assert.assertFalse(homePage.isMyAccountLinkDisplayed());

		// ExtentManager.getTest().log(LogStatus.INFO, "Login - Step 06: Navigate to My Account Page");
		customerInfoPage = homePage.openMyAccountPage();

		// ExtentManager.getTest().log(LogStatus.INFO, "Login - Step 07: Verify 'Customer Info' page is displayed");
		Assert.assertFalse(customerInfoPage.isCustomerInfoHeaderDisplayed());

		// ExtentManager.endTest();
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
