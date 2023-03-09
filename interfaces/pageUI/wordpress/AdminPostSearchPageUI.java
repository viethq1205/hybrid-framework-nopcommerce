package pageUI.wordpress;

public class AdminPostSearchPageUI { // Page post và đang ở page có chức năng search, các tên khác cũng có ý nghĩa như thế giống như post là tên function chính và search/addnew... là các page function phụ
	public static final String ADD_NEW_BUTTON = "css=a.page-title-action";

	public static final String POST_SEARCH_TEXTBOX = "css=input#post-search-input";

	public static final String POST_SEARCH_BUTTON = "css=input#search-submit";

	public static final String TABLE_HEADER_INDEX_BY_HEADER_ID_NAME = "xpath=//table[contains(@class,'table-view-list posts')]/thead//th[@id='%s']/preceding-sibling::*";

	public static final String TABLE_ROW_BY_HEADER_INDEX = "xpath=//table[contains(@class,'table-view-list posts')]/tbody/tr/*[%s]//a[text()='%s']";

	public static final String TABLE_ROW_TITLE_DETAIL_BY_TITLE_NAME = "xpath=//table[contains(@class,'table-view-list posts')]/tbody/tr//a[@class='row-title' and text()='%s']";

	public static final String TABLE_ROW_CHECKBOX_BY_TITLE_NAME = "xpath=//table[contains(@class,'table-view-list posts')]/tbody/tr/th/label[contains(text(),'%s')]/following-sibling::input";

	public static final String ACTION_DROPDOWN = "css=select#bulk-action-selector-top";

	public static final String APPLY_BUTTON = "css=input#doaction";

	public static final String TRASH_MESSAGE = "xpath=//div[@id='message']/p[contains(text(),'%s')]";

	public static final String NO_POST_FOUND_MESSAGE = "xpath=//table[contains(@class,'table-view-list posts')]//tr[@class='no-items']/td[text()='%s']";

}
