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

public class Level_08_Dynamic_Locator extends BaseTest {
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

		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		loginPage = homePage.openLoginPage();

		loginPage.inputToEmailTextbox(emailAddress);

		loginPage.inputToPasswordTextbox(password);

		homePage = loginPage.clickToLoginButton();

		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());

		customerInfoPage = homePage.openMyAccountPage();

		Assert.assertTrue(customerInfoPage.isCustomerInfoHeaderDisplayed());
	}

	@Test
	public void User_02_Dynamic_Locator_Cach_1() { // ép kiểu để khởi tạo cái page

		// Customer Info -> Address
		addressPage = (UserAddressPageObject) customerInfoPage.openMyAccountSidebarByName(driver, "Addresses"); // (UserAddressPageObject) là ép kiểu

		// Address -> My Product Review
		myProductReviewPage = (UserMyProductReviewPageObject) addressPage.openMyAccountSidebarByName(driver, "My product reviews");

		// My Product Review -> Reward
		rewardPointPage = (UserRewardPointPageObject) myProductReviewPage.openMyAccountSidebarByName(driver, "Reward points");

		// Reward -> Address
		addressPage = (UserAddressPageObject) rewardPointPage.openMyAccountSidebarByName(driver, "Addresses");

		// Address -> Reward
		rewardPointPage = (UserRewardPointPageObject) addressPage.openMyAccountSidebarByName(driver, "Reward points");

		// Reward -> My Product Review
		myProductReviewPage = (UserMyProductReviewPageObject) rewardPointPage.openMyAccountSidebarByName(driver, "My product reviews");
	}

	@Test
	public void User_03_Dynamic_Locator_Cach_3() {

		// Customer Info -> Address
		customerInfoPage.openMyAccountSidebarByName(driver, "Addresses");
		addressPage = PageGeneratorManager.getUserAddressPage(driver);

		// Address -> My Product Review
		addressPage.openMyAccountSidebarByName(driver, "My product reviews");
		myProductReviewPage = PageGeneratorManager.getUserMyProductReviewPage(driver);

		// My Product Review -> Reward
		myProductReviewPage.openMyAccountSidebarByName(driver, "Reward points");
		rewardPointPage = PageGeneratorManager.getUserRewardPointPage(driver);

		// Reward -> Address
		rewardPointPage.openMyAccountSidebarByName(driver, "Addresses");
		addressPage = PageGeneratorManager.getUserAddressPage(driver);

		// Address -> Reward
		addressPage.openMyAccountSidebarByName(driver, "Reward points");
		rewardPointPage = PageGeneratorManager.getUserRewardPointPage(driver);

		// Reward -> My Product Review
		rewardPointPage.openMyAccountSidebarByName(driver, "My product reviews");
		myProductReviewPage = PageGeneratorManager.getUserMyProductReviewPage(driver);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
