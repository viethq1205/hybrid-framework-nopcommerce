package pageUI.wordpress;

public class UserHomePageUI {
	public static final String POST_TITLE = "xpath=//article//h2/a[text()='%s']";

	public static final String POST_DAY_POSTED = "xpath=//article//a[text()='%s']/parent::h2/following-sibling::div/span//time[text()='%s']";

	public static final String POST_BODY = "xpath=//article//p[text()='%s']";

	public static final String POST_AUTHOR = "xpath=//article//a[text()='%s']/parent::h2/following-sibling::div//span/span/a[text()='%s']";

	public static final String POST_SEARCH_TEXTBOX = "css=input#wp-block-search__input-1"; // dùng cái xapth thẻ name thôi - cái này đã chỉnh trong cái hàm getByLocator bên basepage nên dùng bth như xpath, css, id

	public static final String SEARCH_BUTTON = "css=button.wp-block-search__button";

}
