package javabasic;

public class Topic_12_String_Format { // bài này là phần học trong topic ggdos Dynamic Locator/Rest Parameter

	// public static String ADDRESS_LINK = "//div[contains(@class,'account-navigation')]//a[text()='Addresses']";
	// public static String MY_PRODUCT_REVIEW_LINK = "//div[contains(@class,'account-navigation')]//a[text()='My product reviews']";
	// public static String REWARD_POINT_LINK = "//div[contains(@class,'account-navigation')]//a[text()='Reward points']";
	// public static String CUSTOMER_INFO_LINK = "//div[contains(@class,'account-navigation')]//a[text()='Customer info']";

	// public static void clickToSideBarLink(String locator) {
	// System.out.println("Click to: " + locator);
	// }

	// public static void main(String[] args) {
	// clickToSideBarLink(ADDRESS_LINK);
	// clickToSideBarLink(MY_PRODUCT_REVIEW_LINK);
	// clickToSideBarLink(REWARD_POINT_LINK);
	// clickToSideBarLink(CUSTOMER_INFO_LINK);
	// }

	// thay vì viết tận 4 dòng code tạo biến có format gần giống nhau - chỉ khác nhau tên page cho 4 page như trên thì ta có thể tổng hợp = phương pháp string format
	public static String DYNAMIC_SIDEBAR_LINK_BY_PAGE_NAME = "//div[contains(@class,'account-navigation')]//a[text()='%s']"; // %s là String format trong Java

	// 1 tham số động
	// public static void clickToSideBarLink(String dynamicLocator, String pageName) {
	// String locator = String.format(dynamicLocator, pageName); // cái hàm format đc định nghĩa Object.../String.../Int... thì ... là Rest Parameter - các tham số còn lại
	// System.out.println("Click to: " + locator);
	// }

	public static void main(String[] args) {
		clickToAreaLink(DYNAMIC_SIDEBAR_LINK_BY_PAGE_NAME, "Addresses"); // tên page như Addresses sẽ đc ép kiểu thành %s trong format để chạy thành công
		clickToAreaLink(DYNAMIC_SIDEBAR_LINK_BY_PAGE_NAME, "My product reviews");
		clickToAreaLink(DYNAMIC_SIDEBAR_LINK_BY_PAGE_NAME, "Reward points");
		clickToAreaLink(DYNAMIC_SIDEBAR_LINK_BY_PAGE_NAME, "Customer info");

		clickToAreaLink(DYNAMIC_LINK_BY_PAGE_NAME, "header-upper", "My Account");
		clickToAreaLink(DYNAMIC_LINK_BY_PAGE_NAME, "account-navigation", "Addresses");
		clickToAreaLink(DYNAMIC_LINK_BY_PAGE_NAME, "footer-upper", "Search");
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// hoặc muốn gộp nhiều hơn nữa thì
	// tạo 1 Locator để đại diện cho các Header/Footer và Sidebar luôn cũng đc (ví dụ là tham số header-upper, footer-upper của header/footer và account-navigation của sidebar)
	public static String DYNAMIC_LINK_BY_PAGE_NAME = "//div[contains(@class,'%s')]//a[text()='%s']";

	// 2 tham số động
	// public static void clickToAreaLink(String dynamicLocator, String areaName, String pageName) { // cũng tương tự như trên thôi nhưng có thêm 1 biến
	// String locator = String.format(dynamicLocator, areaName, pageName);
	// System.out.println("Click to: " + locator);
	// }

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// nhưng nếu nhiều locator trùng lặp ko lẽ mình cứ thêm biến như trên hả, giờ đang 2 biến rồi 3-4 biến làm ntn
	// dùng cách rest parameter/last agurments

	// n tham số động
	public static void clickToAreaLink(String dynamicLocator, String... params) {
		String locator = String.format(dynamicLocator, (Object[]) params);
		System.out.println("Click to: " + locator);
	}
	// vì hàm này đã bao gồm mấy hàm 1, 2 tham số động trên nên 2 hàm trên mình ko cần đến nó nữa, 1 mình thằng này là đủ, thích dùng bao nhiêu tham số động cũng đc

	//// kết quả của bài học này là thay vì mình phải tạo từng cái biến cho các locator có nội dung giống nhau như trên thì mình có thể áp dụng String format
	//// ví dụ trong bài này đang chỉ có 4 phần cần truy cập, lỡ thực tế cần truy cập vài chục vài trăm phần để test thì sao, ko nên viết hàng chục hàng trăm cái biến locator
	//// áp dụng String format chúng ta chỉ cần khai báo 1 biến Dynamic rồi truyền tên của page cần truy cập vào là xong, đơn giản hơn nhiều
}
