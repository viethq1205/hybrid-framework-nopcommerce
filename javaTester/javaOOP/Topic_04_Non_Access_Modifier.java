package javaOOP;

public class Topic_04_Non_Access_Modifier {

	static String browserName = "Chrome";

	String serverName = "Auto";

	public static void main(String[] args) {

		System.out.println(browserName);

		// System.out.println(serverName); // đã học tương tự ở topic03, biến thường ko thể truy cập trực tiếp như static, phải qua 1 object

	}

}
