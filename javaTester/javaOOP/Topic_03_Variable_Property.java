package javaOOP;

public class Topic_03_Variable_Property {
	private String hello = "hi"; // biến global

	// access modifier: gọi là dạng default do nó ko để public, protected hay private gì cả, và default thì các class khác ở cùng package đều dùng đc
	int number = 10025;

	// biến static - có thể gán lại đc và có thể dùng trực tiếp ko cần qua 1 đối tượng nào (ví dụ nhìn xuống cái hàm display)
	public static String studentAdress = "HCM";

	// biến stactic final - có chữ final tức là khi dùng biến này sẽ ko gán lại đc, ví dụ dùng PI_NUMBER ở 1 chỗ khác và gán lại số khác sẽ bị báo lỗi
	// đây là 1 dữ liệu cố định nên cũng có thể gọi là constant - hằng số
	static final float PI_NUMBER = 3.14f;
	public static final String STUDENT_SCHOOL = "FTU";

	public static void main(String[] args) {
		String international = "Sweden"; // biến local trong hàm - static
	}

	public Topic_03_Variable_Property() {
		String international = "VN"; // biến local trong constructor
	}

	public void display() {
		String international = "USSR"; // biến local trong hàm - non static

		studentAdress = "HCM";
	}

}
