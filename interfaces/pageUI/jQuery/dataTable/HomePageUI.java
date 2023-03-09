package pageUI.jQuery.dataTable;

public class HomePageUI {
	public static final String PAGINATION_BY_NUMBER = "Xpath=//li[@class='qgrd-pagination-page']/a[text()='%s']";

	public static final String PAGINATION_BY_NUMBER_ACTIVED = "Xpath=//li[@class='qgrd-pagination-page']/a[@class='qgrd-pagination-page-link active' and text()='%s']";

	public static final String LABEL_HEADER = "Xpath=//div[@class='qgrd-header-text' and text()='%s']/parent::div/following-sibling::input";

	public static final String TOTAL_PAGINATION = "css=ul.qgrd-pagination-ul>li.qgrd-pagination-page";

	public static final String PAGINATION_PAGE_INDEX = "xpath=//ul[@class='qgrd-pagination-ul']/li[@class='qgrd-pagination-page'][%s]/a";

	public static final String ALL_ROW_VALUE_EACH_PAGE = "xpath=//tbody/tr";

	public static final String COLUMN_INDEX_BY_NAME = "xpath=//tr/th[text()='%s']/preceding-sibling::th";

	public static final String INPUT_TEXTBOX_BY_COLUMN_AND_ROW_INDEX = "xpath=//tbody/tr[%s]/td[%s]/input";

	public static final String SELECT_DROPDOWN_BY_COLUMN_AND_ROW_INDEX = "xpath=//tbody/tr[%s]/td[%s]//select";

	public static final String LOAD_BUTTON = "css=button#load";

	public static final String CHECKBOX_BY_COLUMN_AND_ROW_INDEX = "xpath=//tbody/tr[%s]/td[%s]//input[@type='checkbox']";

	public static final String SELECT_ICON_BY_ROW_INDEX = "xpath=//tbody/tr[%s]//button[@title='%s']";
}
