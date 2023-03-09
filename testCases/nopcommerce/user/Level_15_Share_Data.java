package nopcommerce.user;

import org.testng.annotations.Test;

import com.nopcommerce.common.Common_01_Register;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class Level_15_Share_Data extends BaseTest {
	private WebDriver driver;
	private String firstName, lastName, password, emailAddress;
	private UserHomePageObject homePage;
	private UserLoginPageObject loginPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String brwoserName) {

		driver = getMultipleBrowserDriver(brwoserName);

		homePage = PageGeneratorManager.getUserHomePage(driver);

		password = Common_01_Register.password;

		emailAddress = Common_01_Register.emailAddress;

		log.info("Pre-condition - Step 01: Navigate to Login Page");
		loginPage = homePage.openLoginPage();

		log.info("Pre-condition - Step 02: Enter to Email Address Textbox with '" + emailAddress + "'");
		loginPage.inputToEmailTextbox(emailAddress);

		log.info("Pre-condition - Step 03: Enter to Password Textbox with '" + password + "'");
		loginPage.inputToPasswordTextbox(password);

		log.info("Pre-condition - Step 04: Click to Login Button");
		homePage = loginPage.clickToLoginButton();

	}

	// Những cái ở phía trên (gồm class common và các bước trên) đc gọi là precondition y chang bên manual

	// như vậy sau khi set cái class common có step tạo tk và ở trên là login trong xml thì ngay dưới là vào các test case chức năng search luôn mà ko cần mỗi lần chạy 1 test case là phải tạo 1 tk
	// nếu có chức năng nào cần dùng các value như email bla bla của register thì mình chỉ cần lấy ra xài thôi

	// Note: nhưng trong 1 số trường hợp mình có thể set cái step tạo tk vào chung class này cũng đc ko nhất thiết phải có 1 class riêng

	@Test
	public void Search_01_Search_Empty_Data() {

	}

	public void Search_02_Search_Product_Name() { // search tuyệt đối

	}

	public void Search_01_Search_Relative_Product_Name() { // search tương đối (ko chính xác hoàn toàn tên 1 sp)

	}

	public void Search_04_Search_Parent_Category() {

	}

	public void Search_05_Search_Incorrect_Manufacturer() {

	}

	public void Search_06_Search_Correct_Manufacturer() {

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
