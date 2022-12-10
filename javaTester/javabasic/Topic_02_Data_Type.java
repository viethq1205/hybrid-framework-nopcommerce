package javabasic;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Topic_02_Data_Type {
//như đã học ở bài trước, thì nếu mình khai báo ở đây thì đc gọi là global variable (biến toàn cục)
	
	public static void main(String[] args) {
		//còn khai báo ở đây là local variable (biến cục bộ)
		 int studentNumber = 0; //thằng này là khai báo trong local nên phải bắt buộc phải tạo dữ liệu, chứ ko đc khai báo trống trơn kiểu này int studentNumber;
	}

	//ghi chú thêm 1 ít thôi chứ trọng tâm topic này vẫn là data type
	
	////primitive type: nguyên thủy
	byte bNumber;
	
	short sNumber;
	
	int iNumber;
	
	long lNumber;
	
	float fNumber = 15.98f;  //để ý 2 thằng float/double cuối số thường thêm f/d để phân biệt
	
	double dNumber = 12.05d; 
	
	char cChar; //nằm trong nháy đơn ko phải nháy đôi như bên string 
	
	boolean bStatus; //status là false true của boolean ấy
	
	////reference type: tham chiếu (hoặc non primititve type cũng đc)
	
	//string
	String address = "Ho Chi Minh";
	
	//array kiểu dữ liệu đc define trc (tức là biết có bao nhiêu số lượng và cùng 1 mảng như string, boolean, class, int ... nhưng ko kết hợp 1 lúc nhiều mảng nhé)
	String[] studentCity = {address, "Ha Noi", "Da Nang"};
	Integer[] studentNumber = {12, 5, 20};
	
	//class
	Topic_02_Data_Type topic; //topic gọi là biến/đối tượng đại diện cho cái class này
	
	//interfaces 
	WebDriver driver; //webdriver là I = interface
	
	//Object
	Object aObject; //Object là 1 kiểu dữ liệu class nhưng cũng thể coi nó là kiểu dữ liệu object cũng đc, và thằng này nó có khả năng đặc biệt là convert sang các data type cùng loại class như String, ....
	
	//Colection
	//có list, set, map, queue
	List<WebElement> homePageLink = driver.findElements(By.tagName("a")); //note" list cho lưu trùng
	Set<String> allWindow = driver.getWindowHandles(); //set thì ko
	
	List<String> productName = new ArrayList<String>();
	
	//tìm hiểu sự khác biệt của kiểu nguyên thủy và tham chiếu là gì
	// 1. đó là mấy cái biến của tham chiếu nó có function (hàm) đi kèm, còn nguyên thủy thì ko
	public void clickToElement() {
		//iNumber. //nguyên thủy ko có gì cả
		
		//nhưng biến của tham chiếu thì khác
		topic.clickToElement();
		driver.findElement(By.cssSelector(""));
		aObject.toString(); 
		//collection cũng có 
		homePageLink.size();
		allWindow.clear();
	
	// 2. và cái khác biệt rõ nhất là cách thức 2 loại này lưu trữ dữ liệu (liên quan đến phần cứng Ram, trong ram có 2 phần là stack và heap)
		//stack lưu trữ nguyên thủy còn heap lưu trữ tham chiếu
		//nhưng nên nhớ là thằng tham chiếu nó khác biệt ở chỗ cái biến driver, topic, .... nó đc lưu bên stack nhé, còn value của nó lưu bên heap
		//mỗi khi run thì nó từ bên stack đối chiếu sang bên heap cho nên mới gọi là hàm tham chiếu
		//note: có 1 điều quan trọng cần nhớ là nguyên thủy khi đc gán value nó cố định luôn chứ ko thay đổi đc linh hoạt như tham chiếu
		//vd int x = 8, int y = x thì lúc này cả y và x = nhau, nhưng khi thay y = 10 thì in ra x = 8, y = 10
		//nhưng tham chiếu int number = 8; Topic_02_Data_Type bien1 = new Topic_02_Data_Type ;
		//							       Topic_02_Data_Type bien2 = bien1;
		//lúc này cả 2 biến đều = 8, nhưng biến 2 đổi thành 15 thì in ra biến 1 cũng đổi thành 15 luôn, đây chính là 1 khác biệt nữa của nguyên thủy và tham chiếu
		//đây cũng là 1 bài học của Compare trong topic 3 datatype rồi nhé
	}
	
	
}
