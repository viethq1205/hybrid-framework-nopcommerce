package javabasic;

import java.util.Arrays;
import java.util.List;

public class Topic_10_Array { // thằng này khó vãi L mà hóa ra nay học mới biết thằng này ít xài

	public static void main(String[] args) {

		// này là dạng array đã đc define cố định số lượng phần tử sẵn (rất nên làm, ko nên vừa run code vừa thêm phần tử)
		int number[] = { 10, 12, 5, 7, 15 };
		int[] studentNumber = { 10, 12, 5, 7, 15 };
		// 2 cách viết trên đều cùng là khai báo mảng, viết kiểu nào cũng đc

		// ví dụ lấy ra phần tử đầu tiên (lấy theo index)

		System.out.println(number[0]);
		// index 0 tức là vị trí đầu tiên => in ra số 10

		System.out.println(studentNumber[2]);
		// index 2 tức là vị trí thứ 3 => in ra số 5

		// nếu truyền index vượt quá số lượng đã set thì lỗi thôi

		// String array (cũng đc define rồi)
		String hocsinh[] = { "Tân lân", "Vịt", "Sôn lờn", "Nôn làm" };
		for (int i = 0; i < hocsinh.length; i++) { // này là hàm for xài array, cái
			System.out.println("Tên mấy thằng đần: " + hocsinh[i]);
		}
		// cách chọn phần tử cũng truyền index vào như trên

		// có nhiều cách gán array khác (xem thêm trên ggdocs) nhưng cách trên là phổ biến nhất rồi

		// ví dụ 1 kiểu array khác là khai báo từng phần tử (dài dòng)
		int a[] = new int[10]; // khai báo mảng a có 10 phần tử
		a[0] = 12;
		a[1] = 5;
		a[2] = 1997;
		// đó như trên có 10 phần tử, xong ngồi set từng cái phần tử nó có giá trị gì, nói chung là ko nên xài kiểu này

		// 1 cách viết khai báo phần tử khác (như trên thôi ko khác gì)
		int[] intArr = new int[5];
		System.out.println(intArr.length); // thằng này có 5 phần tử, hàm length xác định độ dài phần tử

		// Chuyển từ Array qa List
		List<String> names = Arrays.asList("Tom", "Jerry", "Donald"); // thằng Arrays ở đây là 1 class nên nó cũng có các phương thức để thao tác .asList là 1 ví dụ
		for (String name : names) {
			System.out.println("Name: " + name);
		}

		// Chuyển một mảng thành chuỗi (string), in ra sẽ thấy
		String stdName = Arrays.toString(hocsinh);
		System.out.println(stdName);
	}

}
