package pageObject.wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.wordpress.UserSearchPostPageUI;

public class UserSearchPostsPO extends BasePage {
	WebDriver driver;

	public UserSearchPostsPO(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isThePostDeletedInUserSite(String message) {
		waitForElementVisible(driver, UserSearchPostPageUI.NOTHING_FOUND_MESSAGE, message);
		return isElementDisplayed(driver, UserSearchPostPageUI.NOTHING_FOUND_MESSAGE, message);
	}
}
