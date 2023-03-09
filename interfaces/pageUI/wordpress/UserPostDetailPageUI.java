package pageUI.wordpress;

public class UserPostDetailPageUI {
	public static final String POST_TITLE = "xpath=//article//h1[text()='%s']";

	public static final String POST_DAY_POSTED = "xpath=//article//h1[text()='%s']/following-sibling::div/span//time[text()='%s']";

	public static final String POST_BODY = "xpath=//article//h1[text()='%s']/ancestor::header/following-sibling::div/p[text()='%s']";

	public static final String POST_AUTHOR = "xpath=//article//h1[text()='%s']/following-sibling::div/span//span/a[text()='%s']";
}
