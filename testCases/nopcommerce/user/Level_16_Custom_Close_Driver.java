package nopcommerce.user;

import org.testng.annotations.Test;

import com.nopcommerce.common.Common_01_Register;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_16_Custom_Close_Driver extends BaseTest {
	// bài này học để làm sao sau mỗi lần chạy nếu có fail nó clean các dữ liệu rác đi, các driver của browser cũng v
	// tránh việc nó lưu lại quá nhiều trong bộ nhớ khiến 1 số máy cấu hình yếu bị chậm
	// dùng always run
	// ngoài ra còn có trường hợp browser bị crash/stop thì nó đã tắt rồi nhưng cái driver.quit() nó vẫn chạy nên lại có lỗi driver executable file
	private WebDriver driver;
	private String firstName, lastName, password, emailAddress;
	private UserHomePageObject homePage;
	private UserLoginPageObject loginPage;
	private UserRegisterPageObject registerPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String brwoserName) {

		driver = getMultipleBrowserDriver(brwoserName);

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
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed..");

		log.info("Pre-condition - Step 01: Navigate to Login Page");
		loginPage = homePage.openLoginPage();

		log.info("Pre-condition - Step 02: Enter to Email Address Textbox with '" + emailAddress + "'");
		loginPage.inputToEmailTextbox(emailAddress);

		log.info("Pre-condition - Step 03: Enter to Password Textbox with '" + password + "'");
		loginPage.inputToPasswordTextbox(password);

		log.info("Pre-condition - Step 04: Click to Login Button");
		homePage = loginPage.clickToLoginButton();

	}

	@Test
	public void Search_01_Search_Name() {

	}

	public void Search_02_Search_Address() {

	}

	@AfterClass(alwaysRun = true) // thằng alwaysRun ko cần set trên before (vì nó luôn chạy trước) nhưng after thì phải có vì có thể 1 số bước ở before ảnh hưởng đến after
	public void afterClass() {
		closeBrowserDriver();
	}

}
