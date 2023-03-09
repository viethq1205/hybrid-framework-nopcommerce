package nopcommerce.user;

import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import nopcommerce.data.UserDataJson;
import pageObjects.nopCommerce.user.UserMyAccountCustomerInfoPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_19_Manage_Data_Cach_Khac2 extends BaseTest { // cách dùng json

	private WebDriver driver;
	private UserDataJson userData;
	private String emailAddress;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserMyAccountCustomerInfoPageObject customerInfoPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String brwoserName) {

		driver = getMultipleBrowserDriver(brwoserName);

		homePage = PageGeneratorManager.getUserHomePage(driver);

		userData = UserDataJson.getUserData();

		emailAddress = userData.getEmail() + fakeNumber() + "@gmail.vn";

	}

	@Test
	public void User_01_Register() {
		log.info("Register - Step 01: Navigate to Register Page");
		registerPage = homePage.openRegisterPage();

		registerPage.clickToRadioButtonByLabel(driver, "Male");

		log.info("Register - Step 02: Enter to Firstname Textbox with '" + userData.getFirstName() + "'");
		// registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToTextboxByIDAttribute(driver, "FirstName", userData.getFirstName());
		// vì đây là 1 hàm dùng cho chung chung nên ta ko tạo ở class đặc thù register mà nên tạo ở basepage
		// FirstName chính là cái id='FirstName' trong html

		log.info("Register - Step 03: Enter to Lastname Textbox with '" + userData.getLastName() + "'");
		// registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToTextboxByIDAttribute(driver, "LastName", userData.getLastName());

		registerPage.selectDropdownByNameAttribute(driver, "DateOfBirthDay", userData.getDate());
		registerPage.selectDropdownByNameAttribute(driver, "DateOfBirthMonth", userData.getMonth());
		registerPage.selectDropdownByNameAttribute(driver, "DateOfBirthYear", userData.getYear());

		log.info("Register - Step 04: Enter to Email Address Textbox with '" + emailAddress + "'");
		// registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToTextboxByIDAttribute(driver, "Email", emailAddress);

		registerPage.clickToCheckboxByLabel(driver, "Newsletter");

		log.info("Register - Step 05: Enter to Password Textbox with '" + userData.getPassword() + "'");
		// registerPage.inputToPasswordTextbox(password);
		registerPage.inputToTextboxByIDAttribute(driver, "Password", userData.getPassword());

		log.info("Register - Step 06: Enter to Confirm Password Textbox with '" + userData.getPassword() + "'");
		// registerPage.inputToConfirmPasswordTextbox(password);
		registerPage.inputToTextboxByIDAttribute(driver, "ConfirmPassword", userData.getPassword());

		log.info("Register - Step 07: Click Register Button");
		// registerPage.clickToRegisterButton();
		registerPage.clickToButtonByText(driver, "Register"); // thằng này thì dùng text thay vì ID attri như trên vì tag button bọn dev thường miêu tả id class hơi dài, dùng text là chuẩn nhất

		log.info("Register - Step 08: Verify Register success message is displayed");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
	}

	@Test
	public void User_02_Login() {
		log.info("Login - Step 01: Navigate to Login Page");
		loginPage = homePage.openLoginPage();

		log.info("Login - Step 02: Enter to Email Address Textbox with '" + emailAddress + "'");
		// loginPage.inputToEmailTextbox(emailAddress);
		loginPage.inputToTextboxByIDAttribute(driver, "Email", emailAddress);

		log.info("Login - Step 03: Enter to Password Textbox with '" + userData.getPassword() + "'");
		// loginPage.inputToPasswordTextbox(password);
		loginPage.inputToTextboxByIDAttribute(driver, "Password", emailAddress);

		log.info("Login - Step 04: Click to Login Button");
		// homePage = loginPage.clickToLoginButton();
		loginPage.clickToButtonByText(driver, "Log in");
		homePage = PageGeneratorManager.getUserHomePage(driver);

		log.info("Login - Step 05: Verify 'My Account' link is displayed");
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());

	}

	@Test
	public void User_03_My_Account() {
		log.info("MyAccount - Step 01: Navigate to My Account Page");
		customerInfoPage = homePage.openMyAccountPage();

		log.info("MyAccount - Step 02: Verify 'Customer Info' page is displayed");
		Assert.assertTrue(customerInfoPage.isCustomerInfoHeaderDisplayed());

		log.info("MyAccount - Step 03: Verify 'First Name' value is displayed");
		Assert.assertEquals(customerInfoPage.getTextboxValueByIdAttribute(driver, "FirstName"), userData.getFirstName());

		log.info("MyAccount - Step 03: Verify 'Last Name' value is displayed");
		Assert.assertEquals(customerInfoPage.getTextboxValueByIdAttribute(driver, "LastName"), userData.getLastName());

		log.info("MyAccount - Step 03: Verify 'Email' value is displayed");
		Assert.assertEquals(customerInfoPage.getTextboxValueByIdAttribute(driver, "Email"), emailAddress);
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		// closeBrowserDriver();
	}

}
