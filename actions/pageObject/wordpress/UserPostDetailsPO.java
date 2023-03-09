package pageObject.wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.wordpress.UserPostDetailPageUI;

public class UserPostDetailsPO extends BasePage {
	WebDriver driver;

	public UserPostDetailsPO(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isPostTitleDisplayed(String titleValue) {
		waitForElementVisible(driver, UserPostDetailPageUI.POST_TITLE, titleValue);
		return isElementDisplayed(driver, UserPostDetailPageUI.POST_TITLE, titleValue);
	}

	public boolean isPostBodyDisplayed(String title, String bodyValue) {
		waitForElementVisible(driver, UserPostDetailPageUI.POST_BODY, title, bodyValue);
		return isElementDisplayed(driver, UserPostDetailPageUI.POST_BODY, title, bodyValue);
	}

	public boolean isPostAuthorNameDisplayed(String title, String authorName) {
		waitForElementVisible(driver, UserPostDetailPageUI.POST_AUTHOR, title, authorName);
		return isElementDisplayed(driver, UserPostDetailPageUI.POST_AUTHOR, title, authorName);
	}

	public boolean isPostDateDisplayed(String title, String currentDay) {
		waitForElementVisible(driver, UserPostDetailPageUI.POST_DAY_POSTED, title, currentDay);
		return isElementDisplayed(driver, UserPostDetailPageUI.POST_DAY_POSTED, title, currentDay);
	}

}
