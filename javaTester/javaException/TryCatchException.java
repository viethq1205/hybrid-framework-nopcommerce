package javaException;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

public class TryCatchException { // tại sao ứng dụng dùng try/catch - lý do: khi bị exception nó ko dừng hoàn toàn lại đoạn code mà chỉ catch lại cái lỗi đó rồi vẫn chạy tiếp

	public static void main(String[] args) {
		int number = 10;

		try {
			// đúng -> chạy hết đoạn code và ko qua catch
			// sai -> gặp exception và bị catch lại rồi vẫn chạy tiếp bth
			number = number / 0;
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(number);
		System.out.println(number);
		System.out.println(number);
		System.out.println(number);
		System.out.println(number);
		System.out.println(number);
		System.out.println(number);
		System.out.println(number);
		System.out.println(number);

		String[] browserName = { "Chrome", "Firefox", "Edge" };

		try {
			browserName[0] = "Safari";
			browserName[3] = "Safari";
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (String browser : browserName) {
			System.out.println(browser);
		}

		//// Multiple Catch
		//// hoặc có thể gán chính xác tên lỗi vào để in ra cảnh báo chuẩn luôn
		//// như bên dưới index 11 đã vượt ngoài mảng nên khi ta gán chuẩn lỗi IndexException + Index vượt ngoài mảng sẽ ra dòng cảnh báo chuẩn của lỗi này luôn
		//// trường hợp kia để chuẩn index[9] nhưng chia cho 0 sẽ là lỗi ArithExcep - lỗi toán học
		try {
			int array[] = new int[10];
			array[11] = 30 / 1;
		} catch (ArithmeticException e) {
			System.out.println("Không thể chia cho 0");
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Index vượt ngoài mảng");
		}

		//// lỗi file và input/output của file
		try {
			FileOutputStream outputStream = new FileOutputStream("C://automationfc.txt");
			outputStream.write(65);
			outputStream.close();
		} catch (FileNotFoundException e) { // lỗi này sẽ hiện ra khi ko có file trong ổ đĩa
			e.printStackTrace();
		} catch (IOException e) { // lỗi Input/Output - khi có file trong ổ đĩa nhưng ta ghi (hàm write) gì vào đó (như ví dụ là viết vào số 65) ko đc thì sẽ hiện ra lỗi này
			e.printStackTrace();
		}

		//// Finally
		// nếu có exception hoặc ko cũng phải đóng file/ clean file - browser - database - datatest... hoàn toàn để người khác có test lại cũng ko có vấn đề gì xảy ra
		FileReader fileReader = null;
		try {
			fileReader = new FileReader("C:\\automationfc.jpg");
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (fileReader != null) {
					fileReader.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
