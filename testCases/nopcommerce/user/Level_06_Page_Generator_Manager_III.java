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

public class Level_06_Page_Generator_Manager_III extends BaseTest {
	private WebDriver driver;
	private String firstName, lastName, password, incorrectPassword, existingEmail, invalidEmail, notFoundEmail;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserMyAccountCustomerInfoPageObject myAccountPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String brwoserName) {

		driver = getMultipleBrowserDriver(brwoserName);

		homePage = PageGeneratorManager.getUserHomePage(driver);

		firstName = "Selenium";
		lastName = "Locator";
		password = "123456";
		existingEmail = "automation" + fakeNumber() + "@gmail.vn";
		invalidEmail = "hellohello@gamil*com";
		notFoundEmail = "automation" + fakeNumber() + "@gmail.com";
		incorrectPassword = "654321";

		// này là precondition cho 1 số test case phải dùng email đã đăng ký thành công trc để test trường hợp như email đã có nhưng ko nhập pass hoặc sai pass gì đó

		registerPage = homePage.openRegisterPage();

		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(existingEmail);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

	}

	@Test
	public void Login_01_Empty_Data() {
		loginPage = homePage.openLoginPage();

		// loginPage = new LoginPageObject(driver); bỏ bước này đi // mình khởi tạo ngay trong cái clickToLoginLink luôn rồi gán loginPage vào cái trên => code gọn lại

		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getErrorMessageEmailTextBox(), "Please enter your email");

	}

	@Test
	public void Login_02_Invalid_Email() {
		loginPage = homePage.openLoginPage();

		// loginPage = new LoginPageObject(driver);

		loginPage.inputToEmailTextbox(invalidEmail);

		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getErrorMessageEmailTextBox(), "Wrong email");
	}

	@Test
	public void Login_03_Email_Not_Found() {
		loginPage = homePage.openLoginPage();

		// loginPage = new LoginPageObject(driver);

		loginPage.inputToEmailTextbox(notFoundEmail);

		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getUnsuccessfulErrorMessage(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
	}

	@Test
	public void Login_04_Existing_Email_and_Empty_Password() {
		loginPage = homePage.openLoginPage();

		// loginPage = new LoginPageObject(driver);

		loginPage.inputToEmailTextbox(existingEmail);

		loginPage.inputToPasswordTextbox("");

		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getUnsuccessfulErrorMessage(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");

	}

	@Test
	public void Login_05_Existing_Email_and_Wrong_Password() {
		loginPage = homePage.openLoginPage();

		// loginPage = new LoginPageObject(driver);

		loginPage.inputToEmailTextbox(existingEmail);

		loginPage.inputToPasswordTextbox(incorrectPassword);

		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getUnsuccessfulErrorMessage(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");

	}

	@Test
	public void Login_06_Existing_Email_and_Valid_Password() {
		loginPage = homePage.openLoginPage();

		// loginPage = new LoginPageObject(driver);

		loginPage.inputToEmailTextbox(existingEmail);

		loginPage.inputToPasswordTextbox(password);

		homePage = loginPage.clickToLoginButton();

		// login thành công thì theo cái business flow của trang này thì sẽ quay về homepage => khởi tạo homepage r verify
		// homePage = new HomePageObject(driver);

		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());

		myAccountPage = homePage.openMyAccountPage();

		// đến đây thì mới nhấp vào link thôi chưa verify gì hết (lười làm vl)

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
