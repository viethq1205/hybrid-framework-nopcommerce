package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import io.qameta.allure.Step;
import pageUI.nopCommerce.user.CustomerInfoPageUI;

public class UserMyAccountCustomerInfoPageObject extends BasePage {
	private WebDriver driver;

	public UserMyAccountCustomerInfoPageObject(WebDriver driver) {
		this.driver = driver;
	}

	@Step("Verify Customer Information header is displayed")
	public boolean isCustomerInfoHeaderDisplayed() {
		waitForElementVisible(driver, CustomerInfoPageUI.CUSTOMER_INFO_HEADER);
		return isElementDisplayed(driver, CustomerInfoPageUI.CUSTOMER_INFO_HEADER);
	}

}
