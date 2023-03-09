package pageObjects.facebook;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.facebook.LoginPageUI;

public class LoginPageObject extends BasePage {
	WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToCreateNewAccountButton() {
		waitForElementClickable(driver, LoginPageUI.CREATE_NEW_ACCOUNT_BUTTON);
		clickToElement(driver, LoginPageUI.CREATE_NEW_ACCOUNT_BUTTON);
	}

	public boolean isEmailTextboxDisplayed() {
		waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
		return isElementDisplayed(driver, LoginPageUI.EMAIL_TEXTBOX);
	}

	public void enterToEmailTextbox(String emailAdress) {
		waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
		sendKeysToElement(driver, LoginPageUI.EMAIL_TEXTBOX, emailAdress);
	}

	public boolean isConfirmEmailAddressTextboxDisplayed() {
		// tại sao chỗ này ko có wait vì trong test case 2 Level12 này mình đang cần dùng method này check 2 trường hợp element vừa có trong DOM vừa ko có trong DOM
		// nếu dùng wait visible cho trường hợp element biến mất thì ko hợp lý vì sẽ dẫn đến fail cả case
		return isElementDisplayed(driver, LoginPageUI.CONFIRM_EMAIL_TEXTBOX);
	}

	public void clickClosePopupCreateNewAccount() {
		waitForElementClickable(driver, LoginPageUI.CLOSE_ICON_POPUP);
		clickToElement(driver, LoginPageUI.CLOSE_ICON_POPUP);
	}

	public boolean isConfirmEmailTextboxUndisplayed() {
		waitForElementUndisplayed(driver, LoginPageUI.CONFIRM_EMAIL_TEXTBOX);
		return isElementUndisplayed(driver, LoginPageUI.CONFIRM_EMAIL_TEXTBOX);
	}

}
