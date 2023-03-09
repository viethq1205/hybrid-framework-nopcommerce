package javabasic;

import java.util.Scanner;

import org.testng.annotations.Test;

//class
public class Topic_08_While_Do_while {
	//// Note:
	// while: kiểm tra đk trước rồi mới vào phần thân
	// Do-while: cho chạy phần thân trước ít nhất 1 lần rồi mới kiểm tra điều kiện
	static Scanner scanner = new Scanner(System.in);

	// function
	public static void main(String[] args) {
		int i = 0;
		// block code
		// for (int i = 0; i < 5; i++) {
		// System.out.println("For: " + i);

		// if (i == 3) {
		// break;
		// }
		// }

		// int i = 0; // i này khác i trên, mình từng học rồi ấy, i trên nhìn phát hiểu ngay i cục bộ của cái block code for
		// while (i < 5) {
		// System.out.println("While: " + i);
		// i++;

		// if (i == 3) {
		// break;
		// }
		// }
		// 2 thằng trên có tính chất giống y như nhau khi chưa thêm break (in được đến số 4)

		// nhưng khi thêm break thì có chút khác nhau ở cách câu lệnh chạy
		// for thì in trước + kiểm tra đk i=3 (tức làm phần thân trước) rồi cái i mới bắt đầu ++ => thằng này in đc tới số 3
		// nhưng thằng while nó lại ++i trước rồi mới kiểm tra đk (phần thân) => chỉ in tới 2

		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		for (i = 0; i < 5; i++) {
			System.out.println("For: " + i);

		}
		System.out.println("Biến i sau khi done vòng for: " + i);

		// sau khi done vòng for, nếu mình in ở ngoài (ko có cái đk <5) thì i tới 5 lận, và lúc này khi chạy đến cái while thì while như đã nói trên kia là nó kiểm tra cái đk trc rồi mới vào phần thân
		// nên khi mình run cả 3 thằng này sẽ ko thấy thằng while đc in vì ko thỏa đk i<5

		while (i < 5) {
			System.out.println("While: " + i);
			i++;

		}

		// do-while thì có chút khác biệt
		// do while cũng đã nói trên là phần thân sẽ chạy trc 1 lần rồi mới kiểm tra đk => nên nó sẽ có 1 lần in ra = 5
		// nhưng lần in tiếp sau nó kt đk thì ko thỏa i<5 (i lúc này lên tới 5, 6) nên ngừng ko in nữa
		do {
			System.out.println("Do-While: " + i);
			i++;
		} while (i < 5);

		// TC_01_Bai_tap_1();
		// TC_02_Bai_tap_2();
		// TC_03_Bai_tap_3();
		TC_04_Bai_tap_4();
	}

	// thầy bảo khi làm chủ yếu dùng for, while đc rồi
	// dùng do-while ít thôi vì nếu ko thành thạo rất dễ bị lỗi

	// @Test
	public static void TC_01_Bai_tap_1() {
		int number = scanner.nextInt();

		for (int i = number; i < 100; i++) {
			if (i % 2 == 0) { // như này là i chia hết cho 2 dư 0
				System.out.println(i);
			}

		}
	}

	// @Test
	public static void TC_02_Bai_tap_2() { // dùng while
		int number = scanner.nextInt();

		while (number < 100) {
			if (number % 2 == 0) {
				System.out.println(number);
			}
		}
	}

	// @Test
	public static void TC_03_Bai_tap_3() { // dùng do-while
		int number = scanner.nextInt();

		do {
			if (number % 2 == 0) {
				System.out.println(number);
			}
			number++;
		} while (number < 100);
	}

	// @Test
	public static void TC_04_Bai_tap_4() {
		int number = scanner.nextInt();

		while (number < 100) {
			// yêu cầu chia hết cho 3 và 5
			if (number % 3 == 0 && number % 5 == 0) {
				System.out.println(number);
			}
			number++;
			// thằng ++ nên để ngoài if nhé, vì nếu để trong block code if, khi mình nhập 15 (thỏa đk => in ra) nhưng sau đó ++ nó sẽ lên 16, nhưng vì đk là chia hết 3,5
			// nên đến 16 là tạch luôn do ko thỏa đk, dẫn đến chỉ in 15 là xong chứ ko có các số khác mà thỏa đk như 30 45 60 90 lum la....
		}

	}

	// @Test
	public void TC_05_Bai_tap_5() { // yêu cầu bt, ví dụ mình nhập 7 trong console thì sẽ ra kết quả 16 (do các số lẻ trước 7 cộng lại vào nhau như 1+3+5+7)
		int number = scanner.nextInt();
		int i = 0;
		while (number > 0) {
			// yêu cầu số lẻ nên ghi như sau
			if (number % 2 != 0) { // nghĩa là chia cho 2 nhưng dư ra chứ ko phải = 0 => số lẻ
				System.out.println(number);
				i += number; // theo toán tử là i = i + number
			}
			number--; // -- này nên để như bài tập trên, ko để trong if
			// vì sao lại dùng -- vì mình đang cần tìm những con số lẻ đằng trước số mình nhập mà (như nhập 9 thì in ra cần hiện những số 9 7 5 3 1 nên dùng -- là vô lý)
		}
		System.out.println(i); // in ngoài đây nhé, đặt ở trên trên kia thì sai vì còn nằm trong block code
	}

	@Test
	public void TC_06_Bai_tap_6() { // yêu cầu bài tập nhập giai thừa là như này nè 5!
		int number = scanner.nextInt();
		int i = 1; // ko thể i = 0 nhé vì =0 nhân vào ra 0 thì làm làm cái gì nữa
		while (number > 0) {

			i *= number; // i = i x number
			number--; // tại sao lại -- (giảm), vì ví dụ nhập 5, thì giai thừa 5 là 1x2x3x4x5 nên cần các số đằng trước nó, nhập ++ là sai

		}
		System.out.println(i); // in ngoài đây nhé, đặt ở trên trên kia thì sai vì còn nằm trong block code
	}
}
