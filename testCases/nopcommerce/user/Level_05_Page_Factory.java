package nopcommerce.user;

import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjectWithFactory.nopCommerce.HomePageObjectFactory;
import pageObjectWithFactory.nopCommerce.LoginPageObjectFactory;
import pageObjectWithFactory.nopCommerce.RegisterPageObjectFactory;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_05_Page_Factory extends BaseTest { // xem thêm chi tiết ở package pageobjectfactory
	private WebDriver driver;
	private String firstName, lastName, password, incorrectPassword, existingEmail, invalidEmail, notFoundEmail;
	private HomePageObjectFactory homePage;
	private RegisterPageObjectFactory registerPage;
	private LoginPageObjectFactory loginPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String brwoserName) {

		driver = getMultipleBrowserDriver(brwoserName);

		homePage = new HomePageObjectFactory(driver);

		firstName = "Selenium";
		lastName = "Locator";
		password = "123456";
		existingEmail = "automation" + fakeNumber() + "@gmail.vn";
		invalidEmail = "hellohello@gamil*com";
		notFoundEmail = "automation" + fakeNumber() + "@gmail.com";
		incorrectPassword = "654321";

		homePage.clickToRegisterLink();
		registerPage = new RegisterPageObjectFactory(driver);

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
		homePage.clickToLoginLink();

		// giống như bên register, ở đây là trang home nhấn vào login => đến page login nên mình khởi tạo nó
		loginPage = new LoginPageObjectFactory(driver);

		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getErrorMessageEmailTextBox(), "Please enter your email");

	}

	@Test
	public void Login_02_Invalid_Email() {
		homePage.clickToLoginLink();

		loginPage = new LoginPageObjectFactory(driver);

		loginPage.inputToEmailTextbox(invalidEmail);

		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getErrorMessageEmailTextBox(), "Wrong email");
	}

	@Test
	public void Login_03_Email_Not_Found() {
		homePage.clickToLoginLink();

		loginPage = new LoginPageObjectFactory(driver);

		loginPage.inputToEmailTextbox(notFoundEmail);

		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getUnsuccessfulErrorMessage(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
	}

	@Test
	public void Login_04_Existing_Email_and_Empty_Password() {
		homePage.clickToLoginLink();

		loginPage = new LoginPageObjectFactory(driver);

		loginPage.inputToEmailTextbox(existingEmail);

		loginPage.inputToPasswordTextbox("");

		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getUnsuccessfulErrorMessage(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");

	}

	@Test
	public void Login_05_Existing_Email_and_Wrong_Password() {
		homePage.clickToLoginLink();

		loginPage = new LoginPageObjectFactory(driver);

		loginPage.inputToEmailTextbox(existingEmail);

		loginPage.inputToPasswordTextbox(incorrectPassword);

		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getUnsuccessfulErrorMessage(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");

	}

	@Test
	public void Login_06_Existing_Email_and_Valid_Password() {
		homePage.clickToLoginLink();

		loginPage = new LoginPageObjectFactory(driver);

		loginPage.inputToEmailTextbox(existingEmail);

		loginPage.inputToPasswordTextbox(password);

		loginPage.clickToLoginButton();

		// login thành công thì theo cái business flow của trang này thì sẽ quay về homepage => khởi tạo homepage r verify
		homePage = new HomePageObjectFactory(driver);

		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public int fakeNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}

}
