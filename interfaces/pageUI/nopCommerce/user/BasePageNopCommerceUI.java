package pageUI.nopCommerce.user;

public class BasePageNopCommerceUI {
	public static final String ADDRESS_LINK = "XPath=//div[contains(@class,'account-navigation')]//a[text()='Addresses']";
	public static final String MY_PRODUCT_REVIEW_LINK = "XPATH=//div[contains(@class,'account-navigation')]//a[text()='My product reviews']";
	public static final String REWARD_POINT_LINK = "xpath=//div[contains(@class,'account-navigation')]//a[text()='Reward points']";
	public static final String CUSTOMER_INFO_LINK = "xpath=//div[contains(@class,'account-navigation')]//a[text()='Customer info']";
	// tổng hợp 4 cái trên lại thành 1 hàm thông qua phương pháp dynamic locator
	public static final String MY_ACCOUNT_AREA_DYNAMIC_LOCATOR = "xpath=//div[contains(@class,'account-navigation')]//a[text()='%s']";

	public static final String LOGOUT_LINK_USER_PAGE = "css=a[class='ico-logout']";
	public static final String LOGOUT_LINK_ADMIN_PAGE = "xpath=//a[text()='Logout']";

	// thằng này giống cái biến MY_ACCOUNT_AREA_DYNAMIC_LOCATOR ở trên, phần bài đang học là pattern object giống tương tự bài dynamic locator
	public static final String DYNAMIC_TEXTBOX_BY_ID_ATTRIBUTE = "xpath=//input[@id='%s']";

	public static final String DYNAMIC_BUTTON_BY_TEXT = "xpath=//button[text()='%s']";

	public static final String DYNAMIC_DROPDOWN_BY_NAME_ATTRIBUTE = "xpath=//select[@name='%s']";

	public static final String DYNAMIC_RADIO_BUTTON_BY_LABEL = "xpath=//label[text()='%s']/preceding-sibling::input";

	public static final String DYNAMIC_CHECKBOX_BY_LABEL = "xpath=//label[contains(text(),'%s']/preceding-sibling::input";
}
