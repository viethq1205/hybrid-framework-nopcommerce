package nopcommerce.data;

public class UserData { // viết data vào 1 class lớn của 1 module mới (module chính là cái package ấy)
	// như class này ta lưu trữ các data của chức năng bên user, ta có thể tạo thêm class cho các chức năng như product, admin, ...

	// ngoài ra để dễ quản lý mình có thể tạo các subclass với tên gọi chức năng thuộc phần user chẳng hạn

	public static class Register { // nơi lưu data của chức năng register thuộc phần user
		public static final String FIRST_NAME = "Selenium";

		public static final String LAST_NAME = "FC";

		public static final String PASSWORD = "123456";

		public static final String EMAIL = "automationvn";

		public static final String DAY = "13";

		public static final String MONTH = "1";

		public static final String YEAR = "1997";
	}

	public static class MyAccount {
		public static final String PHONE = "";

		public static final String CITY = "";

		public static final String ADDRESS = "";
	}

	// Nên để ý project mình làm mà phân tách tạo class cho data test theo module/ chức năng, mình khai báo ở 1 class khác còn class test chỉ cần gọi ra và dùng thôi, tránh việc khai báo quá nhiều ở class test

	// bài này là trong topic 101 manage data test

}
