package pageUI.wordpress;

public class AdminPostAddNewPageUI {
	public static final String ADD_POST_TITLE = "css=h1.wp-block-post-title";

	public static final String ADD_POST_BODY_BEFORE_CLICK = "css=p[class*='block-editor-default']";

	public static final String ADD_POST_BODY_AFTER_CLICK = "css=p.block-editor-rich-text__editable";

	public static final String PUBLISH_OR_UPDATE_BUTTON = "css=button[class*='editor-post-publish-button']";

	public static final String PUBLISH_BUTTON_AGAIN = "css=div.editor-post-publish-panel__header-publish-button>button.editor-post-publish-button__button";

	public static final String PUBLISHED_OR_UPDATED_MESSAGE_POPUP = "xpath=//div[@class='components-snackbar__content' and text()='%s']";
}
