package pageObject.wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.wordpress.UserHomePageUI;

public class UserHomePO extends BasePage {
	WebDriver driver;

	public UserHomePO(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isPostTitleDisplayed(String titleValue) {
		waitForElementVisible(driver, UserHomePageUI.POST_TITLE, titleValue);
		return isElementDisplayed(driver, UserHomePageUI.POST_TITLE, titleValue);
	}

	public boolean isPostBodyDisplayed(String bodyValue) {
		waitForElementVisible(driver, UserHomePageUI.POST_BODY, bodyValue);
		return isElementDisplayed(driver, UserHomePageUI.POST_BODY, bodyValue);
	}

	public boolean isPostAuthorNameDisplayed(String title, String authorName) {
		waitForElementVisible(driver, UserHomePageUI.POST_AUTHOR, title, authorName);
		return isElementDisplayed(driver, UserHomePageUI.POST_AUTHOR, title, authorName);
	}

	public boolean isPostDateDisplayed(String title, String currentDay) {
		waitForElementVisible(driver, UserHomePageUI.POST_DAY_POSTED, title, currentDay);
		return isElementDisplayed(driver, UserHomePageUI.POST_DAY_POSTED, title, currentDay);
	}

	public UserPostDetailsPO clickToPostTitle(String titleValue) {
		waitForElementClickable(driver, UserHomePageUI.POST_TITLE, titleValue);
		clickToElement(driver, UserHomePageUI.POST_TITLE, titleValue);
		return PageGeneratorManager.getUserPostDetailPage(driver);
	}

	public boolean isThePostUndisplayed(String editTitleValue) {
		return isElementUndisplayed(driver, UserHomePageUI.POST_TITLE, editTitleValue);
	}

	public void enterTheTitleToSearchPostTextbox(String editTitleValue) {
		waitForElementVisible(driver, UserHomePageUI.POST_SEARCH_TEXTBOX);
		sendKeysToElement(driver, UserHomePageUI.POST_SEARCH_TEXTBOX, editTitleValue);
		sleepInSecond(3);
	}

	public UserSearchPostsPO clickToSearchPostButton() {
		waitForElementClickable(driver, UserHomePageUI.SEARCH_BUTTON);
		clickToElement(driver, UserHomePageUI.SEARCH_BUTTON);
		return PageGeneratorManager.getUserSearchPostPage(driver);
	}
}
