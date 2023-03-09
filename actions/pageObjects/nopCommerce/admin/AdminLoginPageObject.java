package pageObjects.nopCommerce.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageUI.nopCommerce.admin.AdminLoginPageUI;

public class AdminLoginPageObject extends BasePage {
	private WebDriver driver;

	public AdminLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void iputToUsernameTextbox(String emailAddress) {
		waitForElementVisible(driver, AdminLoginPageUI.USERNAME_OR_EMAIL_TEXTBOX);
		sendKeysToElement(driver, AdminLoginPageUI.USERNAME_OR_EMAIL_TEXTBOX, emailAddress);
	}

	public void iputToPasswordTextbox(String password) {
		waitForElementVisible(driver, AdminLoginPageUI.PASSWORD_TEXTBOX);
		sendKeysToElement(driver, AdminLoginPageUI.PASSWORD_TEXTBOX, password);
	}

	public AdminDashboardPageObject clickLoginButton() {
		waitForElementClickable(driver, AdminLoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, AdminLoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getAdminDashboardPage(driver); // sau khi nhấn đăng nhập nó sẽ chuyển vào trang dashboard
	}

	// wrap 3 hàm trên thành bước login admin trang nopcommerce như này cho gọn
	public AdminDashboardPageObject loginAsAnAdmin(String emailAddress, String password) {
		iputToUsernameTextbox(emailAddress);
		iputToPasswordTextbox(password);
		return clickLoginButton();
	}
}
