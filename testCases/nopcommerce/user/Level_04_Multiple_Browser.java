package nopcommerce.user;

import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_04_Multiple_Browser extends BaseTest {
	private WebDriver driver;
	private String emailAddress = "automation" + fakeNumber() + "@gmail.vn";
	private String firstName, lastName, password;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String brwoserName) { // gán parameter browser trên kia để chạy cái beforeclass nên dưới đây cũng phải gán 1 cái biến

		// getMultipleBrowserDriver(brwoserName); //gán như này vô ko thôi sẽ sai nhé, vì driver class này và driver bên basetest khác nhau, phải làm như dòng dưới
		driver = getMultipleBrowserDriver(brwoserName);

		firstName = "Selenium";
		lastName = "Locator";
		password = "123456";

		homePage = new UserHomePageObject(driver);

	}

	@Test
	public void Register_01_Empty_Data() {
		homePage.openRegisterPage();

		registerPage = new UserRegisterPageObject(driver);

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getErrorMessageFirstName(), "First name is required.");
		Assert.assertEquals(registerPage.getErrorMessageLastName(), "Last name is required.");
		Assert.assertEquals(registerPage.getErrorMessageEmail(), "Email is required.");
		Assert.assertEquals(registerPage.getErrorMessagePassword(), "Password is required.");
		Assert.assertEquals(registerPage.getErrorMessageCPassword(), "Password is required.");

	}

	// @Test
	public void Register_02_Invalid_Email() {
		homePage.openRegisterPage();

		registerPage = new UserRegisterPageObject(driver);

		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox("automation@12345*com");
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getErrorMessageEmail(), "Wrong email");
	}

	// @Test
	public void Register_03_Success() {
		homePage.openRegisterPage();

		registerPage = new UserRegisterPageObject(driver);

		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
	}

	// @Test
	public void Register_04_Existing_Email() {
		homePage.openRegisterPage();

		registerPage = new UserRegisterPageObject(driver);

		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getExistEmailErrorMessage(), "The specified email already exists");

	}

	// @Test
	public void Register_05_Password_Less_Than_6_Letters() {
		homePage.openRegisterPage();

		registerPage = new UserRegisterPageObject(driver);

		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox("12345");
		registerPage.inputToConfirmPasswordTextbox("12345");

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getErrorMessagePassword(), "Password must meet the following rules:\nmust have at least 6 characters");

	}

	// @Test
	public void Register_06_Invalid_Confirm_Password() {
		homePage.openRegisterPage();

		registerPage = new UserRegisterPageObject(driver);

		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox("65432");

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getErrorMessageCPassword(), "The password and confirmation password do not match.");
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
