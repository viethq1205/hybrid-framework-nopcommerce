package pageUI.nopCommerce.user;

public class HomePageUI { // thằng này cũng có chức năng giống loginpage trên package pageobject nhưng về phần UI, đây là nơi lưu các locator thường dùng của màn hình Login

	public static final String REGISTER_LINK = "css=a[class='ico-register']"; // tên biến được đặt theo thứ tự như sau tên field_loại field
	// chỉnh static thì có thể ở class khác truy cập trưc tiếp đến email_textbox thông qua tên class HomePageUI mà ko phải khai báo khởi tạo
	// Note: chú ý để cái final nhé, nhất là các class chứa locator, vì nếu ko có final thì ai cũng có thể chỉnh sửa cái locator, tùy thích gán lại ở bên class khác +
	// , khi nhiều người trong team chạy test chỉnh sửa sẽ rất mệt
	// để ý cái chữ email_textbox sau khi thêm static final thì đc in nghiêng và in đậm lên, đây đc gọi là 1 constant (hằng số) - giá trị ko đc thay đổi, luôn cố định

	public static final String LOGIN_LINK = "CSS=a[class='ico-login']";

	public static final String MY_ACCOUNT_LINK = "Css=a[class='ico-account']";

}
