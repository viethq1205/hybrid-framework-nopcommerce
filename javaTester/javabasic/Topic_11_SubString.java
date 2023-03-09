package javabasic;

public class Topic_11_SubString { // đã từng làm trong topic 11 String
	// bài này đc học thêm để bổ sung kiến thức cho topic dynamic locator, Rest Parameter phần framework

	public static void main(String[] args) {
		String firstText = "id=Email";
		String secondText = "css=input[id='Password']";
		String thirdText = "xpath=//button[text()='Log in']";
		System.out.println(firstText.substring(3)); // cần lấy mỗi chữ Email thì set int là 3 vào substring sẽ lấy đc
		System.out.println(secondText.substring(4));
		System.out.println(thirdText.substring(6));
	}

}
