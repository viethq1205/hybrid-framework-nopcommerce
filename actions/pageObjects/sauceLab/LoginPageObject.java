package pageObjects.sauceLab;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.sauceLab.LoginPageUI;

public class LoginPageObject extends BasePage {
	WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void enterToUsernameTextbox(String userName) {
		waitForElementVisible(driver, LoginPageUI.LOGIN_TEXBOX);
		sendKeysToElement(driver, LoginPageUI.LOGIN_TEXBOX, userName);
	}

	public void enterToPasswordTextbox(String password) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXBOX);
		sendKeysToElement(driver, LoginPageUI.PASSWORD_TEXBOX, password);
	}

	public ProductsPageObject clickToLoginButton() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return PageGenerator.getProductsPageObject(driver);
	}
}
