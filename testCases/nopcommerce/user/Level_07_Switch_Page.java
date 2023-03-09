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

public class Level_07_Switch_Page extends BaseTest {
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
	public void User_01_Register() {
		registerPage = homePage.openRegisterPage();

		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

	}

	@Test
	public void User_02_Login() {
		loginPage = homePage.openLoginPage();

		loginPage.inputToEmailTextbox(emailAddress);

		loginPage.inputToPasswordTextbox(password);

		homePage = loginPage.clickToLoginButton();

		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
	}

	@Test
	public void User_03_Customer_Info() {
		customerInfoPage = homePage.openMyAccountPage();

		Assert.assertTrue(customerInfoPage.isCustomerInfoHeaderDisplayed());
	}

	@Test
	public void User_04_Switch_Page() {
		// mấu chốt của việc switchpage là đơn giản phải có hàm action như click/open vào link, button, image.. nào đó

		// NOTE: ví dụ hàm openAddressPage mở ở customPage và openAddressPage mở ở rewardPage là 2 hàm khác nhau, tuy y chang nhưng do bấm chuyển từ page khác nhau (khác Source) nên tính chất openAddressPage cũng khác

		// nên khi mình thêm code ở mấy cái pageobject và UI sẽ hơi lú

		// Customer Info (vì ở TC03 trên mình đang ở page customer info) -> Address
		addressPage = customerInfoPage.openAddressPage(driver);

		// Address -> My Product Review
		myProductReviewPage = addressPage.openMyProductReviewPage(driver);

		// My Product Review -> Reward
		rewardPointPage = myProductReviewPage.openRewardPointPage(driver);

		// Reward -> Address
		addressPage = rewardPointPage.openAddressPage(driver);

		// Address -> Reward
		rewardPointPage = addressPage.openRewardPointPage(driver);

		// Reward -> My Product Review
		myProductReviewPage = rewardPointPage.openMyProductReviewPage(driver);

		// My Product Review -> Customer Info
		customerInfoPage = myProductReviewPage.openCustomerInfoPage(driver);
	}

	// @Test
	public void User_05_Switch_Role() {
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
