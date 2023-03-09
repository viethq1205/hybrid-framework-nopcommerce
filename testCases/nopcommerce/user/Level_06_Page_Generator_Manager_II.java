package nopcommerce.user;

import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_06_Page_Generator_Manager_II extends BaseTest { // phần 2 này ko cho phép khởi tạo - new quá nhiều class ở mỗi test case vì sẽ vi phạm DRY
	private WebDriver driver;
	private String firstName, lastName, password, incorrectPassword, existingEmail, invalidEmail, notFoundEmail;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String brwoserName) {

		driver = getMultipleBrowserDriver(brwoserName);

		homePage = new UserHomePageObject(driver);

		firstName = "Selenium";
		lastName = "Locator";
		password = "123456";
		existingEmail = "automation" + fakeNumber() + "@gmail.vn";
		invalidEmail = "hellohello@gamil*com";
		notFoundEmail = "automation" + fakeNumber() + "@gmail.com";
		incorrectPassword = "654321";

		// này là precondition cho 1 số test case phải dùng email đã đăng ký thành công trc để test trường hợp như email đã có nhưng ko nhập pass hoặc sai pass gì đó

		registerPage = homePage.openRegisterPage();
		// registerPage = new RegisterPageObject(driver); bỏ bước này đi // mình khởi tạo ngay trong cái clickToRegisterLink luôn rồi gán registerPage vào cái trên => code gọn lại
		// với ý ông thầy ở đây ở cách này có sự kết nối hơn, như registerPage = homePage.clickToRegisterLink như trên (B=A.actions)
		// những dòng code sẽ gọn lại so với việc khi qua page nào cũng phải new lên như cái topic page gener manager I
		// nhưng vẫn sẽ có vài nhược điểm (xem ở trong ggdocs page generator) và ông thầy sẽ dạy cách tối ưu nhất là gom tất cả các bước khởi tạo vào trong 1 class PageGenObject

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

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
