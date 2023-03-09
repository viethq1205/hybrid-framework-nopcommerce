package pageUI.jQuery.uploadFile;

public class HomePageUI {
	public static final String UPLOAD_FILE = "xpath=//input[@type='file']"; // cái locator này luôn có ở mọi trang có tính năng upload nhé, có 1 vài trang khi mình inspect sẽ ko thấy dòng code này vì dev ẩn đi

	public static final String FILE_NAME_LOADED = "xpath=//p[@class='name' and text()='%s']"; // đoạn code này để verify xem file mình load lên (chứ chưa upload hoàn toàn lên site nhé) đã đúng tên chưa

	public static final String START_BUTTON = "css=table button.start";

	public static final String FILE_NAME_UPLOADED_LINK = "xpath=//a[text()='%s']";

	public static final String IMAGE_OF_FILE_UPLOADED = "xpath=//a[@title='%s']/img";

}
