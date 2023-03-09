package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import io.qameta.allure.Step;
import pageUI.nopCommerce.user.HomePageUI;

public class UserHomePageObject extends BasePage { // các đối tượng sẽ thao tác ở Homepage
	private WebDriver driver;
	// actions - hành động nào ở page nào thì đi với cái class đó nhé, như action homepage thì đi với class này - homepageobject

	public UserHomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	@Step("Navigate to Register page") // đây là cách ghi describe test của Allure
	public UserRegisterPageObject openRegisterPage() {
		waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
		clickToElement(driver, HomePageUI.REGISTER_LINK);
		return PageGeneratorManager.getUserRegisterPage(driver); // nếu chỉ new ko thì sẽ ko có gì cả vì mình chỉ mới new lên thôi, nên cần return để có dữ liệu,
		// mà RegisterPageObject là kiểu dữ liệu class nên mình để ngay kế public luôn thì mới return đc, giống như để String thì return lại là text ấy
	}

	@Step("Navigate to Login page")
	public UserLoginPageObject openLoginPage() {
		waitForElementClickable(driver, HomePageUI.LOGIN_LINK);
		clickToElement(driver, HomePageUI.LOGIN_LINK);
		return PageGeneratorManager.getUserLoginPage(driver);
	}

	@Step("Verify My Account link is dispalyed")
	public boolean isMyAccountLinkDisplayed() {
		waitForElementVisible(driver, HomePageUI.MY_ACCOUNT_LINK);
		return isElementDisplayed(driver, HomePageUI.MY_ACCOUNT_LINK);
	}

	@Step("Navigate to My Account page")
	public UserMyAccountCustomerInfoPageObject openMyAccountPage() {
		waitForElementClickable(driver, HomePageUI.MY_ACCOUNT_LINK);
		clickToElement(driver, HomePageUI.MY_ACCOUNT_LINK);
		return PageGeneratorManager.getUserCustomerInfoPage(driver);
	}

}
