package javabasic;

import org.testng.annotations.Test;

public class Topic_11_String_Exercise {
	String courseName = "AutomAtion TestIng 12 03 48 99 AdvanCed";

	// @Test
	public void TC_01() { // bài tập yêu cầu đếm trong coursename có bao nhiêu ký tự in hoa
		courseName.toCharArray(); // ban đầu dùng split nhưng đếm ký tự nên đổi thành chararray
		char courseNameArr[] = courseName.toCharArray(); // vì chararray ra thành nhiều phần tử nên mình khai báo mảng []
		int countUpper = 0;
		int countLower = 0;
		int countNumber = 0;

		// để duyệt từng chữ tìm ra chữ nào là chữ viết hoa thì mình dùng foreach
		for (char character : courseNameArr) {
			System.out.println(character); // bấm run sẽ thấy nó in ra từng chữ
			if (character >= 'A' && character <= 'Z') { // đây là cách đếm chữ in hoa trong Java, thường thì đổi thành a và z, số là 0 và 9
				countUpper++;
			}

			if (character >= 'a' && character <= 'z') {
				countLower++;
			}

			if (character >= '0' && character <= '9') {
				countNumber++;
			}
		}
		System.out.println("Số chữ được in hoa là: " + countUpper); // số chữ in hoa là 6
		System.out.println("Số chữ được in thường là: " + countLower); // số chữ in thường là 19
		System.out.println("Số chữ dạng số là: " + countNumber); // số chữ dạng số là 8
	}

	// @Test
	public void TC_02() {
		String courseName2 = "Automation Testing 345 Tutorials Online 789";
		char courseName2Arr[] = courseName.toCharArray();
		int count = 0;

		for (char c : courseName2Arr) {
			if (c == 'o') {
				count++;
			}
		}
	}

	@Test
	public void TC_03() { // yêu cầu đảo ngược chuỗi, giống sơn thành nơs
		char courseNameArr[] = courseName.toCharArray();
		for (int i = courseNameArr.length - 1; i >= 0; i--) { // nhắc lại cái -1 là vì - ví dụ viet thì length có 4 phần tử, mà index thì chỉ đến [3] thôi nên thêm vào -1 mới ko bị lỗi
			System.out.print(courseNameArr[i]);
		}
	}
}
