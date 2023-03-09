package pageObject.wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.wordpress.AdminDashboardPageUI;

public class AdminDashboardPO extends BasePage {
	WebDriver driver;

	public AdminDashboardPO(WebDriver driver) {
		this.driver = driver;
	}

	public AdminPostSearchPO clickToPostsInMenu() {
		waitForElementClickable(driver, AdminDashboardPageUI.POSTS_LOCATOR_IN_MENU);
		clickToElement(driver, AdminDashboardPageUI.POSTS_LOCATOR_IN_MENU);
		return PageGeneratorManager.getAdminPostSearchPage(driver);
	}
}
