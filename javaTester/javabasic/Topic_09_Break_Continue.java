package javabasic;

public class Topic_09_Break_Continue {

	public static void main(String[] args) { // topic break-continue nhưng mấy bài demo dưới test continue là chủ yếu
												// continue trong java có ý nghĩa loại trừ, bỏ qua step này chứ ko phải tiếp tục
		// for (int i = 0; i < 10; i++) {
		// if (i == 5) {
		// continue;
		// }
		// System.out.println(i); // như test này khi in ra thì chỉ có số từ 1 đến 9 nhưng ko có số 5 vì thỏa đk if i = 5 trên kia
		// ở đây thằng continue ý nghĩa của nó là loại trừ, tức i = 5 thì ko thực hiện, bỏ qua => sysout ko in số 5
		// }

		//// trong for thì thường có cái gọi là nested for, tức for trong for, continue đc đặt ở for nào thì thực hiện trong for đó thôi
		// nested for cũng dễ giải thích, for đầu (gọi là for lớn đi) chạy vòng lặp từ 1 đến 9
		// còn cái for con mình cho chạy từ 1 đến 5
		// tức là trong 9 vòng lặp lớn thì mỗi vòng lặp lớn trong nó lại có chạy 1 vòng lặp nhỏ từ 1 đến 5
		// ngoài ra trong vòng lặp nhỏ lại thêm 1 vòng lặp nhỏ hơn cũng đc luôn

		// như ví dụ này for lớn có 5 vòng lặp và trong mỗi vòng lặp for lớn lại có 5 cái vòng lặp nhỏ (khi in ra cái số 4 sẽ bị loại trừ do đ/k if)
		for (int i = 1; i <= 5; i++) {
			System.out.println("Lần chạy của i (for lớn) = " + i);
			for (int j = 1; j <= 5; j++) {
				if (j == 4) {
					continue;
				}
				System.out.println("j = " + j);
			}
		}
	}

}
