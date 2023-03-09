package pageObjects.jQuery.dataTable;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUI.jQuery.dataTable.HomePageUI;

public class HomePageObject extends BasePage {
	WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void openPagingByNumber(String pageNumber) {
		waitForElementClickable(driver, HomePageUI.PAGINATION_BY_NUMBER, pageNumber);
		clickToElement(driver, HomePageUI.PAGINATION_BY_NUMBER, pageNumber);
	}

	public void searchByLabel(String labelHeader, String value) {
		waitForElementVisible(driver, HomePageUI.LABEL_HEADER, labelHeader);
		sendKeysToElement(driver, HomePageUI.LABEL_HEADER, value, labelHeader);
		pressKeyToElement(driver, HomePageUI.LABEL_HEADER, Keys.ENTER, labelHeader);
	}

	public boolean isPageNumberActive(String pageNumber) {
		waitForElementVisible(driver, HomePageUI.PAGINATION_BY_NUMBER_ACTIVED, pageNumber);
		return isElementDisplayed(driver, HomePageUI.PAGINATION_BY_NUMBER_ACTIVED, pageNumber);
	}

	public List<String> getValueEachRowAtAllPage() {
		int totalPage = getElementSize(driver, HomePageUI.TOTAL_PAGINATION); // tìm xem có bao nhiêu trang paging
		System.out.println("Total Page = " + totalPage);

		List<String> allRowValueofAllPage = new ArrayList<String>();
		for (int index = 1; index <= totalPage; index++) {
			clickToElement(driver, HomePageUI.PAGINATION_PAGE_INDEX, String.valueOf(index));
			sleepInSecond(1);

			List<WebElement> allRowValueofEachPage = getListWebElement(driver, HomePageUI.ALL_ROW_VALUE_EACH_PAGE);
			for (WebElement eachRow : allRowValueofEachPage) {
				allRowValueofAllPage.add(eachRow.getText());
			}
		}
		return allRowValueofAllPage;
	}

	public void enterToTextboxAtARowByColumnName(String columName, String rowNumber, String values) {
		// column index dựa vào tên cột
		int columnIndex = getElementSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columName) + 1;
		// vì cái hàm getSize return lại 1 cái list nên phải +1, vd: cột Country là cột đầu tiên đi, thì nếu ko +1 ra index cột này là [1] thì cái hàm getSize nó sẽ chỉ return lại là 0

		// sendkeys vào textbox
		waitForElementVisible(driver, HomePageUI.INPUT_TEXTBOX_BY_COLUMN_AND_ROW_INDEX, rowNumber, String.valueOf(columnIndex)); // cái biến có 2 cái %s thì cái đầu là index row, còn cái 2 là index cột
		// vì columnIndex là kiểu int nên mình phải ép nó qua String bằng String.valueOf(columnIndex)
		sendKeysToElement(driver, HomePageUI.INPUT_TEXTBOX_BY_COLUMN_AND_ROW_INDEX, values, rowNumber, String.valueOf(columnIndex));
	}

	public void selectDropDownByColumnName(String columName, String rowNumber, String valueSelect) {
		int columnIndex = getElementSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columName) + 1;

		waitForElementClickable(driver, HomePageUI.SELECT_DROPDOWN_BY_COLUMN_AND_ROW_INDEX, rowNumber, String.valueOf(columnIndex));
		selectItemInDefaultDropdown(driver, HomePageUI.SELECT_DROPDOWN_BY_COLUMN_AND_ROW_INDEX, valueSelect, rowNumber, String.valueOf(columnIndex));

	}

	public void clickLoadButton() {
		waitForElementClickable(driver, HomePageUI.LOAD_BUTTON);
		clickToElement(driver, HomePageUI.LOAD_BUTTON);

	}

	public void checkToCheckboxByColumnName(String columName, String rowNumber) {
		int columnIndex = getElementSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columName) + 1;

		waitForElementClickable(driver, HomePageUI.CHECKBOX_BY_COLUMN_AND_ROW_INDEX, rowNumber, String.valueOf(columnIndex));
		checkTheDefaultCheckboxOrRadio(driver, HomePageUI.CHECKBOX_BY_COLUMN_AND_ROW_INDEX, rowNumber, String.valueOf(columnIndex));
	}

	public void uncheckToCheckboxByColumnName(String columName, String rowNumber) {
		int columnIndex = getElementSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columName) + 1;

		waitForElementClickable(driver, HomePageUI.CHECKBOX_BY_COLUMN_AND_ROW_INDEX, rowNumber, String.valueOf(columnIndex));
		uncheckTheDefaultCheckbox(driver, HomePageUI.CHECKBOX_BY_COLUMN_AND_ROW_INDEX, rowNumber, String.valueOf(columnIndex));

	}

	public void clickToIconByRowNumber(String rowNumber, String iconName) {
		waitForElementClickable(driver, HomePageUI.SELECT_ICON_BY_ROW_INDEX, rowNumber, iconName);
		clickToElement(driver, HomePageUI.SELECT_ICON_BY_ROW_INDEX, rowNumber, iconName);

	}

}
