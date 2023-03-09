package javabasic;

public class Topic_03_Operator {

	public static void main(String[] args) {
		int number = 10;
		//number = number + 5; nhưng thay vì ghi dài như này mình ghi gọn lại như dưới
		number += 5;
		System.out.println("tong = " + number);
		
		//15/5 = 3
		System.out.println(number/5);
		
		//15%6 = 2 dư 3
		System.out.println(number%6); //thằng này lấy phần dư ra tức = 3, cũng tương tự 15%7 (15:7=2 mà 2x7=14 rồi + 1 mới ra 15) thì nó lấy kq dư ra = 1

		////mấy cái trên đc gọi là assign (gán)
		
		
		////quan hệ true/false
		String address = "Ho Chi Minh";
		
		if (address == "Ha Noi") {
			System.out.println("Dia chi giong nhau"); //thằng này ko cho ra kq gì vì HCM khac HN
		}
		
		if (address != "Ha Noi") {
			System.out.println("Dia chi khong giong nhau"); //thì thằng này cho ra kết quả vì sử đụng ký tự khác nhau là !=
		}
		
		//xem thêm ở phần relation
		
		////Logic
		if (address != "Ha Noi" && address != "Da Nang") {
			System.out.println("Dia chi khong giong nhau"); //hàm && của logic (2 cái cùng đúng tức khác HCM thì in đc)
		}
		
		if (address != "Ha Noi" || address == "Da Nang") {
			System.out.println("Dia chi khong giong nhau"); //hàm || or của logic (1 cái thỏa mãn điều kiện khác HCM thôi là in đc k/q dia chi ko giong nhau)
		}
		
		////hàm phủ định !
		if (address == "Ha Noi") {
			System.out.println("Dia chi khong giong nhau"); //nếu như này thì ko in đc vì address là HCM chu ko phai = Ha Noi
		}
		//ở đây ta ứng dụng phủ định ! vào address == "HN"
		
		if (!(address == "Ha Noi")) {
			System.out.println("Dia chi khong giong nhau"); //nhu nay thi in đc, vi ta phủ định việc address = HN
		}
		//thằng phủ định hay đc dùng để check cái checkbox đã đc chọn hay chưa
		
		
		////Condition hay biểu thức tam nguyên, vì dùng thằng này thường có 3 dấu "= ? :"
		boolean status = (address == "Ha Noi") ? true : false; //thằng status nếu đúng address = HN nó nhảy vào true, còn ko là false
		System.out.println("ket qua = " + status); //kq in ra la false
		

		
	}

}
