package javabasic;

import org.testng.annotations.Test;

import commons.GlobalConstants;

public class Topic_10_Array_Exercise {
	int number[] = { 5, 8, 15, 7, 60, 100 };

	// @Test
	public void TC_01() { // in ra số lớn nhất của mảng trên
		int x = 0;

		for (int i = 0; i < number.length; i++) { // chạy vòng lặp tìm trong 6 phần tử kia (nên phải có length), số nào lớn nhất sẽ in ra
			if (x < number[i]) {
				x = number[i];
			}
		}
		System.out.println("Số lớn nhất = " + x);
	}

	// @Test
	public void TC_02() { // tính tổng của phần tử đầu tiên và cuối cùng (đầu tiên là index [0] ấy còn cuối cùng tùy vào mình tạo bao nhiêu phần tử)
		int x = 0;
		// thằng này ko phải dùng for vì ko cần check các số, truyền index vô là làm đc rồi
		x = number[0] + number[number.length - 1]; // tại sao lại -1, vì number.length là = 6 phần tử trên kia, phải -1 nữa thì mới ra index [5] = số cuối cùng trong array là 100
		System.out.println("Tổng của số đầu và số cuối = " + x);
	}

	// @Test
	public void TC_03() { // hiển thị những số chẵn trong mảng
		for (int i = 0; i < number.length; i++) {
			if (number[i] % 2 == 0) {
				System.out.println("Số chẵn: " + number[i]);
			}
		}
	}

	// @Test
	public void TC_04() { // hiển thị những số >=0 và <=10
		int arr[] = { 3, -7, 2, 5, 9, -6, 10, 12 };

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] >= 0 && arr[i] <= 10) {
				System.out.println("Các số >= 0 và <= 10: " + arr[i]);
			}
		}
	}

	// @Test
	public void TC_05() { // hiển tính tổng các số và trung bình cộng
		// trung bình cộng là lấy tổng chia cho các phần tử trong mảng dưới, như ở dưới là có length 10 phần tử
		int arr[] = { 3, 5, 7, 30, 10, 5, 8, 23, 0, -5 };
		int sum = 0;

		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			// nghĩa là sum = sum + arr[i]
			// sum = 0 + 3 = 3 là arr[0] xong tới sum = 3 + 5 = 8 là arr[1] rồi cứ thế + cho đến cái arr[9] là ra tổng của 10 phần tử
		}
		System.out.println("Tổng 10 phần tử = " + sum);

		// do thằng trung bình cộng ra số thập phân nên mình tạo ra 1 cái float để in ra là số thập phân
		float trungBinhCong = sum / arr.length;
		System.out.println("Trung bình cộng của 10 phần tử = " + trungBinhCong);
	}

	@Test
	public void TC_06() {
		String fileNames[] = { "CSharp.png", "Java.png", "Python.png" };

		String filePath = GlobalConstants.UPLOAD_FILE;

		String fullFileName = "";
		for (String file : fileNames) {

			fullFileName = fullFileName + filePath + file + "\n";
		}
		fullFileName = fullFileName.trim();
		System.out.println(fullFileName);
	}

}
