package pageObject.wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.wordpress.AdminPostAddNewPageUI;

public class AdminPostAddNewPO extends BasePage {
	WebDriver driver;

	public AdminPostAddNewPO(WebDriver driver) {
		this.driver = driver;
	}

	public void enterToAddTitleInAddNewOrEdit(String addPostTitleValue) {
		waitForElementVisible(driver, AdminPostAddNewPageUI.ADD_POST_TITLE);
		sendKeysToElement(driver, AdminPostAddNewPageUI.ADD_POST_TITLE, addPostTitleValue);
	}

	public void enterToAddBodyInAddNew(String addPostBodyValue) {
		// lưu ý: thằng này nó khác với thằng title ở điểm ko thể cứ truyền value thẳng vào đc
		// nếu mình làm manual thì cái element của nó khi chưa click vào để nhập khác với khi mình click vào, do có sự khác biệt nên phần code dưới phải làm kỹ hơn cái add title
		waitForElementClickable(driver, AdminPostAddNewPageUI.ADD_POST_BODY_BEFORE_CLICK);
		clickToElement(driver, AdminPostAddNewPageUI.ADD_POST_BODY_BEFORE_CLICK);

		waitForElementVisible(driver, AdminPostAddNewPageUI.ADD_POST_BODY_AFTER_CLICK);
		sendKeysToElement(driver, AdminPostAddNewPageUI.ADD_POST_BODY_AFTER_CLICK, addPostBodyValue);
	}

	// thằng này cũng bị vấn đề như hàm trên nên viết lại hàm khác chứ ko dùng chung đc
	public void enterToEditBody(String addPostBodyValue) {
		waitForElementClickable(driver, AdminPostAddNewPageUI.ADD_POST_BODY_AFTER_CLICK);
		clickToElement(driver, AdminPostAddNewPageUI.ADD_POST_BODY_AFTER_CLICK);

		waitForElementVisible(driver, AdminPostAddNewPageUI.ADD_POST_BODY_AFTER_CLICK);
		// case này phải có cái thằng Key delete này vì tuy trong hàm sendkeys đã set cái hàm clear nhưng clear này chỉ có tác dụng khi cái element là thẻ input
		// ở đây nó lại là thẻ p nên phải có cái hàm đặc biệt này mới xóa đc hết cái phần body cũ
		clearValueInElementByDeleteKey(driver, AdminPostAddNewPageUI.ADD_POST_BODY_AFTER_CLICK);
		sendKeysToElement(driver, AdminPostAddNewPageUI.ADD_POST_BODY_AFTER_CLICK, addPostBodyValue);
	}

	public void clickToPublishOrUpdateButton() {
		waitForElementClickable(driver, AdminPostAddNewPageUI.PUBLISH_OR_UPDATE_BUTTON);
		clickToElement(driver, AdminPostAddNewPageUI.PUBLISH_OR_UPDATE_BUTTON);
	}

	public void clickToPublishButtonAgain() {
		waitForElementClickable(driver, AdminPostAddNewPageUI.PUBLISH_BUTTON_AGAIN);
		clickToElement(driver, AdminPostAddNewPageUI.PUBLISH_BUTTON_AGAIN);
	}

	public boolean isPostPublishedOrUpdatedPopupDisplayed(String postPublishedMessage) {
		waitForElementVisible(driver, AdminPostAddNewPageUI.PUBLISHED_OR_UPDATED_MESSAGE_POPUP, postPublishedMessage);
		return isElementDisplayed(driver, AdminPostAddNewPageUI.PUBLISHED_OR_UPDATED_MESSAGE_POPUP, postPublishedMessage);
	}

	public AdminPostSearchPO openPostSearchPageURL(String postSearchURL) {
		openPageUrl(driver, postSearchURL);
		return PageGeneratorManager.getAdminPostSearchPage(driver);
	}

}
