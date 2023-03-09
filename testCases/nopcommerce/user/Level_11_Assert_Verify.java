package nopcommerce.user;

import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserAddressPageObject;
import pageObjects.nopCommerce.user.UserMyAccountCustomerInfoPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserMyProductReviewPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import pageObjects.nopCommerce.user.UserRewardPointPageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_11_Assert_Verify extends BaseTest {
	private WebDriver driver;
	private String firstName, lastName, password, emailAddress;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserMyAccountCustomerInfoPageObject customerInfoPage;
	private UserAddressPageObject addressPage;
	private UserRewardPointPageObject rewardPointPage;
	private UserMyProductReviewPageObject myProductReviewPage;

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
	public void User_01_Register_Login_MyAccount() {
		registerPage = homePage.openRegisterPage();

		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);

		registerPage.clickToRegisterButton();

		verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		loginPage = homePage.openLoginPage();

		loginPage.inputToEmailTextbox(emailAddress);

		loginPage.inputToPasswordTextbox(password);

		homePage = loginPage.clickToLoginButton();

		verifyFalse(homePage.isMyAccountLinkDisplayed());

		customerInfoPage = homePage.openMyAccountPage();

		verifyFalse(customerInfoPage.isCustomerInfoHeaderDisplayed());
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
