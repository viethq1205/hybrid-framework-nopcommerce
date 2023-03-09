package javaException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class HandleException {

	public static void main(String[] args) throws InterruptedException, IOException {
		// String fullName = 15; //sai loại dữ liệu nên báo lỗi ngay khi đang viết code, gọi là Compiler time

		// Run time là khi chạy code

		// Thread.sleep(5000); // cũng báo lỗi rồi mình throw lỗi lên cái hàm main là hết báo lỗi, gọi là checked

		// lỗi numberformatexception
		// String name = "Automation Testing";
		// int number = Integer.parseInt(name);

		// int i = Integer.parseInt("10");
		// float f = Float.parseFloat("4.5a");

		// System.out.println(i);
		// System.out.println(f);

		// lỗi FileNotFoundException
		// File file = new File("C:\\automationfc.jpg"); // file này ko có trong PC mình
		// FileReader fr = new FileReader(file);
		// fr.close();
	}
}
