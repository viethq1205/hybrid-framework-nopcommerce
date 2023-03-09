package javabasic;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Topic_05_Condition_Exercise {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	
	//@Test
	public void TC_01() {
		Scanner scanner = new Scanner(System.in); //nhập phím ảo trong phần console (lúc in sysout thì nhấn số đc trong bảng console), bài này trong phần console của topic 02
		int number = scanner.nextInt();
		//yêu cầu bt chứng minh n số chẵn thì in ra n la so chan, con ko n la so le
		if (number % 2 == 0) { //vì số chẵn chia hết cho 2 và ko dư ra số nào nên phải so sánh == 0 (xem lại topic operator)
			System.out.println("Số: " + number + " là số chẵn"); //ví dụ 10:2=5 dư 0 => số chẵn
		} else {
			System.out.println("Số: " + number + " là số lẻ"); //ví dụ 9:2=4 dư 1 => số lẻ
		}
		//bài này nhớ run test rồi thao tác nhập số trong console mới đc nhé
	}
	
	//@Test
	public void TC_02() {
		Scanner scanner = new Scanner(System.in);
		int numberA = scanner.nextInt();
		int numberB = scanner.nextInt();
		
		if (numberA >= numberB) { 
			System.out.println(numberA + " lớn hơn hoặc bằng " + numberB); 
		} else {
			System.out.println(numberA + " nhỏ hơn " + numberB); 
		}
		//cái scanner ít dùng, ở đây ông thầy demo cho hs thấy thôi
	}
	
	//@Test
	public void TC_03() { //yêu cầu là lát nhập vào console 3 số nguyên, sysout in ra cho kq hiện số nguyên lớn nhất
		Scanner scanner = new Scanner(System.in);
		int numberA = scanner.nextInt();
		int numberB = scanner.nextInt();
		int numberC = scanner.nextInt();
		
		if (numberA > numberB && numberA > numberC) {
			System.out.println("numberA lớn nhất là số: " + numberA);
		} else if(numberB > numberA && numberB > numberC) {
			System.out.println("numberB lớn nhất là số: " + numberB);
		} else {
			System.out.println("numberC lớn nhất là số: " + numberC);
		}
	}
	
	//@Test
	public void TC_04() { //yêu cầu là lát nhập vào console 1 con số và test xem nó có in ra kq nằm trong 10~100 ko, ko thì in ra kq ko nằm trong 10~100
		Scanner scanner = new Scanner(System.in);
		int numberA = scanner.nextInt();
		
		if (numberA > 10 && numberA < 101) { //vậy viết đk con số này lớn 10 và bé hơn 101(?)
			System.out.println(numberA + " nằm trong khoảng từ 10 đến 100");
		} else 
			System.out.println(numberA + " không nằm trong khoảng từ 10 đến 100");
	}
	
	//@Test
	public void TC_05() { //yêu cầu là lát nhập vào console 1 con số (điểm) và test xem nó nằm ở khung điểm nào, A B C hay D
		Scanner scanner = new Scanner(System.in);
		float studentPoint = scanner.nextFloat(); //dùng float vì điểm số thì có phần thập phân
		
		if (studentPoint <= 10 && studentPoint >= 8.5) { 
			System.out.println(studentPoint + " đạt hệ số A");
		} else if(studentPoint < 8.5 && studentPoint >= 7.5) {
			System.out.println(studentPoint + " đạt hệ số B");
		} else if(studentPoint < 7.5 && studentPoint >= 5) {
			System.out.println(studentPoint + " đạt hệ số C");
		} else if(studentPoint < 5 && studentPoint >= 0) { //phải ghi như này lỡ nhập số âm cũng ra kq thì sao
			System.out.println(studentPoint + " đạt hệ số D");
		} else {
			System.out.println(studentPoint + " là con số sai, vui lòng nhập lại"); //nếu như nhập 10đ mà lộn thành -10 thì sẽ báo lỗi, oke chưa
		}
			
	}

		@Test
		public void TC_06() { //yêu cầu là lát nhập vào console 1 tháng thì in ra số ngày của tháng đó, ví dụ nhập tháng 2 thì hiện ra 28 ngày
			Scanner scanner = new Scanner(System.in);
			int month = scanner.nextInt();
			
			//thằng này nếu dùng if else thì rất nhiều, nên dùng switch case gọn hơn
			//nhưng vì đang học if else nên dùng if else
			if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) { //nhớ ko bị lỗi ghi month = nhé, vì = là gán, phải dùng 2 dấu ==, còn || là or
				System.out.println("Tháng " + month + " có 31 ngày");
			} else if(month == 2) {
				System.out.println("Tháng " + month + " có 28 ngày");
			} else if(month == 4 || month == 6 || month == 9 || month == 11){
				System.out.println("Tháng " + month + " có 30 ngày");
			}
		}
}

