package nopcommerce.user;

import org.testng.annotations.Test;

import com.nopcommerce.common.Common_01_Register;
import com.nopcommerce.common.Common_01_Register_Cookie;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class Level_15_Share_Data_2 extends BaseTest {
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

		log.info("Pre-condition - Step 02: Set Cookie and reload page");
		loginPage.setCookie(driver, Common_01_Register_Cookie.loggedCookie);
		loginPage.refreshPage(driver);

		log.info("Pre-condition - Step 03: Verify 'My Account' link is displayed");
		verifyTrue(homePage.isMyAccountLinkDisplayed());
	}

	@Test
	public void Search_01_Search_Empty_Data() {

	}

	public void Search_02_Search_Product_Name() { // search tuyệt đối

	}

	public void Search_03_Search_Relative_Product_Name() { // search tương đối (ko chính xác hoàn toàn tên 1 sp)

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
