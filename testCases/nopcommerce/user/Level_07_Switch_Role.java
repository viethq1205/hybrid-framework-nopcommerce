package nopcommerce.user;

import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.admin.AdminDashboardPageObject;
import pageObjects.nopCommerce.admin.AdminLoginPageObject;
import pageObjects.nopCommerce.user.UserMyAccountCustomerInfoPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_07_Switch_Role extends BaseTest {
	private WebDriver driver;
	private String userPassword, userEmailAddress, adminEmailAddress, adminPassword;
	private UserHomePageObject userHomePage;
	private UserLoginPageObject userLoginPage;
	private UserMyAccountCustomerInfoPageObject userCustomerInfoPage;
	private AdminLoginPageObject adminLoginPage;
	private AdminDashboardPageObject adminDashboardPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String brwoserName) {

		driver = getMultipleBrowserDriver(brwoserName);

		userHomePage = PageGeneratorManager.getUserHomePage(driver);

		userPassword = "123456";
		userEmailAddress = "automationfc1205@gmail.com"; // mấy cái user khi test này rảnh thì tạo lại, chứ sau 1 time nhỏ là server xóa tk

		adminEmailAddress = "admin@yourstore.com";
		adminPassword = "admin";
	}

	@Test
	public void Role_01_User_To_Admin() {
		userLoginPage = userHomePage.openLoginPage();

		userHomePage = userLoginPage.loginAsAnUser(userEmailAddress, userPassword); // hàm loginuser này mình nên wrap trong cái loginpageobject do hàm này dùng nhiều và qua topic khác vẫn có thể tái sử dụng
		// cộng thêm cả mấy bước ở dưới là nhập mail, password, nhấn login, mình có thể wrap chúng vào hàm loginAsAnUser này, wrap nhiều hàm vào 1 hàm sẽ gọn lại khá nhiều

		// loginPage.inputToEmailTextbox(emailAddress);

		// loginPage.inputToPasswordTextbox(password);

		// homePage = loginPage.clickToLoginButton();

		Assert.assertTrue(userHomePage.isMyAccountLinkDisplayed());

		// Từ Home Page nhảy sang Customer Info (my account)

		userCustomerInfoPage = userHomePage.openMyAccountPage();

		// bấm logout thì theo behavior tự động về lại homepage

		userHomePage = userCustomerInfoPage.clickToLogOutLinkAtUserPage(driver);

		// Từ web userhomepage nhảy sang web adminlogin (trang mặc định của admin là login khác với mặc định homepage của user)

		userHomePage.openPageUrl(driver, GlobalConstants.ADMIN_PAGE_URL); // tại sao ở đây ko gán đc adminloginpage vì openpageurl là hàm dùng chung nó và ko return 1 thằng cụ thể nào

		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);

		adminDashboardPage = adminLoginPage.loginAsAnAdmin(adminEmailAddress, adminPassword);

		Assert.assertTrue(adminDashboardPage.isDashboardHeaderDisplayed());

		// logout khỏi tài khoản admin -> trở lại trang login (vì bahavior của thằng này khi logout sẽ quay lại chỗ page mặc định login)

		adminLoginPage = adminDashboardPage.clickToLogOutLinkAtAdminPage(driver);

	}

	// @Test
	public void Role_02_Admin() {
		// từ page admin truy cập trang user rồi đăng nhập lum la giống cái trên

		adminLoginPage.openPageUrl(driver, GlobalConstants.PORTAL_PAGE_URL); // tại sao ở đây ko gán đc userhomepage vì openpageurl là hàm dùng chung nó và ko return 1 thằng cụ thể nào

		userHomePage = PageGeneratorManager.getUserHomePage(driver);

		userLoginPage = userHomePage.openLoginPage();

		userHomePage = userLoginPage.loginAsAnUser(userEmailAddress, userPassword);

		Assert.assertTrue(userHomePage.isMyAccountLinkDisplayed());

		userCustomerInfoPage = userHomePage.openMyAccountPage();

		Assert.assertTrue(userCustomerInfoPage.isCustomerInfoHeaderDisplayed());

	}

	@Test
	public void User_03_Customer_Info() {

	}

	@Test
	public void User_04_Switch_Page() {

	}

	@AfterClass
	public void afterClass() {
		// driver.quit();
	}

}
