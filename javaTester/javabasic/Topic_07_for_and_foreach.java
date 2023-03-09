package javabasic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Topic_07_for_and_foreach {
	WebDriver driver;

	//@Test
	public void TC_01_for() { //ví dụ in 100 số
		//System.out.println(1); //thì éo ai viết 100 dòng sysout từ 1 đến 100 mà dùng vòng lặp for
		
		for (int i = 1; i <= 10; i++) {
			System.out.println(i);
		}//từ for ta in ra đc từ 1 đến 10
		
		
		
		//cách vận hành của hàm for theo ví dụ trên như sau
		
		//vòng lặp 1
		//xét i = 1, rồi xét 1 <= 10 (đúng)
		//rồi lúc này hàm in mới in như sau System.out.println(1); 
		//vì thằng i++ theo toán tử đã học là in i (là 1) trước rồi mới bắt đầu dùng ++ (tức +1) sau theo toán tử
		//đó, lúc này là sang vòng lặp 2 (i = 2) sau khi +1
		
		//xét i = 2, rồi xét 2 <= 10 (đúng)
		//rồi lúc này hàm in mới in như sau System.out.println(2); 
		//vì thằng i++ theo toán tử đã học là in i (là 2) trước rồi mới bắt đầu dùng ++ (tức +1) theo toán tử
		//đó, lúc này là sang vòng lặp 3 (i = 3) sau khi +1
		
		//xét i = 3, rồi xét 3 <= 10 (đúng)
		//rồi lúc này hàm in mới in như sau System.out.println(3); 
		//vì thằng i++ theo toán tử đã học là in i (là 3) trước rồi mới bắt đầu dùng ++ (tức +1) theo toán tử
		//đó, lúc này là sang vòng lặp 4 (i = 4) sau khi +1
		
		//cứ như vậy cho đến i = 10 là thỏa đk <= 10 
		
		//nó vẫn sẽ chạy cái i = 11 nhé nhưng ko thỏa đk <= 10 thì dừng, ko chạy nữa và ko in gì cả
		
		
		
		//Array - mảng
		String[] cityName = {"Ha Noi", "Ho Chi Minh", "Da Nang", "Can Tho"}; //nhớ dùm tao array dùng {}, mà tại sao học array mà kia là string vì cái string cityname nhiều thành phố kia là mảng string
		
		for (int i = 0; i < cityName.length; i++) {     //array thì dùng length, giống thằng List thì dùng là size ấy
			System.out.println(cityName[i]); 				//như này là in hết các thành ở mảng city ra
		}
		//Note: Array list set queue dùng index để lưu trữ dữ liệu nha, nên như trên nếu muốn in hết thì gán = 0, chứ nếu gán = 1 thì nó bắt đầu in từ HCM
		//mấy thằng mảng này ko bắt đầu index từ 1, mà bắt đầu từ 0, nên 0 chính là đầu tiên, 1 là thứ hai và tương tự .... như ví dụ trên nếu gán 4 thì lỗi vì 4 là nằm ngoài phạm vi rồi
	
		
		////for kết hợp if: thỏa mãn đk mới action
		//dùng điều kiện để filter
		//for if break thường hay kết hợp với nhau
		for (int i = 0; i < cityName.length; i++) {     
			if (cityName[i].equals("Da Nang")) { //thỏa đk là đà nẵng
				//thì mới action - ví dụ như in ra dòng này
				System.out.println("Ước gì được đi chơi đà lẵng"); 
				break; //dùng break để tìm ra rồi thì ngưng vòng lặp, nếu ko lỡ 1000 thành phố thì nó tìm hoài luôn
			}	
		}
	
	}
	
	@Test
	public void TC_02_for_each() {
		String[] cityName = {"Ha Noi", "Ho Chi Minh", "Da Nang", "Can Tho", "Hai Phong", "Khanh Hoa"};
		
		for (String city : cityName) { //ông thầy bảo cái city nó là biến phụ, giống như 1 người trung chuyển cho các thành phố đã nhập trên kia
			System.out.println(city);
			//in ra đc toàn bộ thành phố
			//lợi ích của for each đây, dùng biến phụ (city) để duyệt các phần tử các mảng mà ko cần lấy vị trí (index) của các phần tử
		}
		
		//ngoài ra liên quan đến phần javacollection, kế thừa class, interface lum la (để ý dòng list là inter còn araylist là class), ông thầy sẽ dạy sau
		
		////kết hợp với List
		List<WebElement> links = driver.findElements(By.xpath("")); 
		for (WebElement link : links) {
			
		}
	}
}
