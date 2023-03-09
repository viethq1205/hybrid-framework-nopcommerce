package pageObject.wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.wordpress.AdminLoginPageUI;
import pageUI.wordpress.AdminPostSearchPageUI;

public class AdminPostSearchPO extends BasePage { // Page post và đang ở page có chức năng search, các tên khác cũng có ý nghĩa như thế giống như post là tên function chính và search/addnew... là các page function phụ
	WebDriver driver;

	public AdminPostSearchPO(WebDriver driver) {
		this.driver = driver;
	}

	public AdminPostAddNewPO clickToAddNewButton() {
		waitForElementClickable(driver, AdminPostSearchPageUI.ADD_NEW_BUTTON);
		clickToElement(driver, AdminPostSearchPageUI.ADD_NEW_BUTTON);
		return PageGeneratorManager.getAdminPostAddNewPage(driver);
	}

	public void enterToSearchTextbox(String value) {
		waitForElementVisible(driver, AdminPostSearchPageUI.POST_SEARCH_TEXTBOX);
		sendKeysToElement(driver, AdminPostSearchPageUI.POST_SEARCH_TEXTBOX, value);
	}

	public void clickToSearchPostButton() {
		waitForElementClickable(driver, AdminPostSearchPageUI.POST_SEARCH_BUTTON);
		clickToElement(driver, AdminPostSearchPageUI.POST_SEARCH_BUTTON);
	}

	public boolean isPostSearchTableDisplayedWithValue(String headerIDName, String value) {
		int headerIndex = getElementSize(driver, AdminPostSearchPageUI.TABLE_HEADER_INDEX_BY_HEADER_ID_NAME, headerIDName) + 1;
		// phần này giống y chang bài đã học ở topic data table

		waitForElementVisible(driver, AdminPostSearchPageUI.TABLE_ROW_BY_HEADER_INDEX, String.valueOf(headerIndex), value);
		return isElementDisplayed(driver, AdminPostSearchPageUI.TABLE_ROW_BY_HEADER_INDEX, String.valueOf(headerIndex), value);
	}

	public AdminPostAddNewPO clickToPostTitleLink(String titleValue) {
		waitForElementClickable(driver, AdminPostSearchPageUI.TABLE_ROW_TITLE_DETAIL_BY_TITLE_NAME, titleValue);
		clickToElement(driver, AdminPostSearchPageUI.TABLE_ROW_TITLE_DETAIL_BY_TITLE_NAME, titleValue);
		return PageGeneratorManager.getAdminPostAddNewPage(driver);
	}

	public void selectPostInTableByCheckbox(String editTitleValue) {
		waitForElementClickable(driver, AdminPostSearchPageUI.TABLE_ROW_CHECKBOX_BY_TITLE_NAME, editTitleValue);
		checkTheDefaultCheckboxOrRadio(driver, AdminPostSearchPageUI.TABLE_ROW_CHECKBOX_BY_TITLE_NAME, editTitleValue);
	}

	public void selectItemInActionDropdown(String actionItem) {
		waitForElementClickable(driver, AdminPostSearchPageUI.ACTION_DROPDOWN);
		selectItemInDefaultDropdown(driver, AdminPostSearchPageUI.ACTION_DROPDOWN, actionItem);
	}

	public void clickToApplyButton() {
		waitForElementClickable(driver, AdminPostSearchPageUI.APPLY_BUTTON);
		clickToElement(driver, AdminPostSearchPageUI.APPLY_BUTTON);
	}

	public boolean isTrashMessageDisplayed(String message) {
		waitForElementVisible(driver, AdminPostSearchPageUI.TRASH_MESSAGE, message);
		return isElementDisplayed(driver, AdminPostSearchPageUI.TRASH_MESSAGE, message);
	}

	public boolean isThePostDeletedInAdminSite(String message) {
		waitForElementVisible(driver, AdminPostSearchPageUI.NO_POST_FOUND_MESSAGE, message);
		return isElementDisplayed(driver, AdminPostSearchPageUI.NO_POST_FOUND_MESSAGE, message);
	}

}
