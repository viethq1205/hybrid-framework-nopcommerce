package javabasic;

public class Topic_11_String {

	public static void main(String[] args) {
		// System.setProperty("webdriver.gecko.driver", ".\\browserDrivers\\geckodriver.exe");
		// WebDriver Driver = new FirefoxDriver();

		// String s1 = "Cat";
		// String s2 = s1;
		// String s3 = new String("Cat");
		// NOTE: phần này mình từng học ở cái bộ nhớ ram liên quan đến lưu trữ kiểu dữ liệu nguyên thủy và tham chiếu ấy
		// 2 cái s1 và s2 lưu cùng bộ nhớ heap nên khi chúng thay đổi sẽ đc thay đổi cùng nhau chứ ko bị cố định như kiểu nguyên thủy
		// tuy nhiên cái s3 tùy cùng kiểu String nhưng vì khi new lên nó đc lưu ở 1 chỗ khác, nên tuy cùng value Cat nhưng s1, s2 lại khác nhau so với s3 (vùng nhớ khác nhau)
		// ví dụ: nếu mình so sánh bằng s1 == s2 thì sẽ ra true nhưng s1 == s3 sẽ ra false
		// System.out.println(s1 == s2);
		// System.out.println(s1 == s3);
		// System.out.println(s2 == s3);

		// nhưng nếu dùng equals kết quả sẽ khác
		// System.out.println(s1.equals(s3));
		// System.out.println(s2.equals(s3));
		// vì hàm equals này chỉ so sánh cái value Cat chứ ko liên quan đến vùng nhớ => True
		// nên khi làm code liên quan đến String mình nên sử dụng equals

		// NOTE: trên kia mình có nói "khi chúng thay đổi sẽ đc thay đổi cùng nhau" nhưng lưu ý 1 điều khi thay đổi giá trị ví dụ thay từ Cat sang Dog
		// cái String sẽ lưu cái giá trị Dog này vào 1 cái vùng nhớ mới, chứ String ko cập nhật or thay đổi hoàn toàn vùng nhớ Cat thành Dog

		//// Ngoài ra 2 cách khởi tạo dưới còn đc định nghĩa như sau
		// Khởi tạo kiểu nguyên thủy (theo t tự hiểu gọi là cơ bản đúng hơn, cách này xài nhiều)
		// String s1 = "Cat";
		// String s2 = s1;
		// đây là khởi tạo theo kiểu đối tượng
		// String s3 = new String("Cat");

		// 1 số demo các phương thức của string
		String schoolName = "Automation Testing Advanced";
		String schoolAddress = "Ho Chi Minh";

		System.out.println("Độ dài schoolName = " + schoolName.length()); // length này khác length bên array, bên này đếm số chữ (cũng bắt đầu từ index 0)

		System.out.println("Lấy ra 1 ký tự schoolName = " + schoolName.charAt(2)); // index 2 thì lấy ra đc chữ t trong automation

		System.out.println("Nối 2 chuỗi: " + schoolName.concat(schoolAddress)); // đây là hàm nối chuỗi nhưng thực tế ít ai xài vì có cách ngắn hơn
		// thực tế chỉ cần nối như dưới là xong, đơn giản
		System.out.println("Nối 2 chuỗi: " + schoolName + schoolAddress);

		System.out.println("Kiểm tra 2 chuỗi bằng nhau: " + schoolName.equals(schoolAddress)); // kq ra false vì value 2 thằng khác nhau
		System.out.println("Kiểm tra 2 chuỗi bằng nhau: " + schoolName.equals("Automation Testing Advanced")); // true vì đúng giá trị
		String courseName = "automation testing advanced";
		System.out.println("Kiểm tra 2 chuỗi bằng nhau: " + schoolName.equalsIgnoreCase(courseName)); // ra true vì cái hàm so sánh này nó ko quan tâm chữ viết hoa thường, giống nhau nội dung là đc

		// startwith, contains, endwith tính chất hàm giống cái mình học bên xpath
		System.out.println("Có chứa 1 ký tự/chuỗi ký tự: " + schoolName.contains("Automation")); // in ra true

		System.out.println("Tách 1 ký tự/ chuỗi ký tự từ schoolName: " + schoolName.substring(11)); // bắt đầu từ 11 ko có kết thúc thì tách ra đc Testing Advanced
		System.out.println("Tách 1 ký tự/ chuỗi ký tự từ schoolName: " + schoolName.substring(11, 15)); // tương tự như trên nhưng có khởi đầu, kết thúc => ra đc 4 chữ Test

		///////////////////////////////////////////// hàm split/////////////////////////////////////////////////////
		String text = "Viewing 72 of 1879 results";
		String[] subString = text.split(" ");
		for (int i = 0; i < subString.length; i++) {
			System.out.println("Vi tri thu " + i + ": " + subString[i]);
		}
		// như trên là đã tách (split) cho ta thấy vị trí index nhưng theo cả cụm từ như 0 là viewing, 1 là 72
		// giờ ví dụ mình lấy vị trí index 3 để ra 1879
		System.out.println(subString[3]); // => in ra 1879

		///////////////////////////////////////////// hàm replace/////////////////////////////////////////////////////
		String productPrice = "$100.00";
		// h mình muốn bỏ/thay thế cái $100.00 thành 100.00 thì dùng replace
		productPrice = productPrice.replace("$", "");
		System.out.println(productPrice); // mình gán lại cái productPrice trên sau khi replace, giờ in ra đc k/q mới là 100.00

		// nâng cao thêm tý
		// ở trên 100.0 vẫn đang là String, h mình convert nó dạng số float hay double gì đó đều đc
		double productPriceD = Double.parseDouble(productPrice);
		System.out.println("Value Double = " + productPriceD);

		// h nó đang dạng số thì convert lại về string dùng hàm valueof như sau
		// gán lại tên
		productPrice = String.valueOf(productPriceD);
		System.out.println("Value String = " + productPrice);

		// còn ứng dụng của thằng này tại sao phải replace là vì đang dạng string mình sẽ làm sao để convert nó về dạng số để dùng sort data (sắp xếp tăng/giảm dần)
		// sau này sẽ học

		///////////////////////////////////////////// hàm Upper/ Lower/////////////////////////////////////////////////////
		// Cách ứng dụng thằng này
		// String osName = System.getProperty("os.name");
		// System.out.println(osName); // ở đây mình lấy đc cái Os mình đang xài đc viết chuẩn là Windows 10
		// ví dụ mình đang set chạy test trên nhiều nền tảng
		// if (osName.toLowerCase().contains("windows")) { // ví dụ như dòng này mình quen tay viết tên OS ko đầy đủ chính xác mà chỉ ghi windows thì hàm lowercase phát huy khả năng của nó
		// Keys key = Keys.CONTROL;
		// } else {
		// Keys key = Keys.COMMAND;
		// }
		// còn set chạy test trên nhiều browser thì lại sử dụng toUpperCase nhiều hơn
		// còn vài trường hợp nữa mà h ghi lại cũng éo nhớ, có gì xem lại clip topic String thời gian loanh 1 tiếng 17p ~ 1 tiếng 18p

		///////////////////////////////////////////// hàm trim/////////////////////////////////////////////////////
		// dùng để xóa khoảng trắng xuống dòng, lum la
		String testing = "  \t \n   Automation Testing Tutorials        \n        ";
		System.out.println(testing); // vừa có khoảng trắng vừa có xuống dòng
		System.out.println("Xóa khoảng trắng + xuống dòng = " + testing.trim()); // đã xóa hết
	}

}