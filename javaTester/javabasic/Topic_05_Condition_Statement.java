package javabasic;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Topic_05_Condition_Statement { //biểu thức điều kiện if else  //các toán tử tham gia biểu thức điều kiện xem thêm trong ggdocs
WebDriver driver;
String projectPath = System.getProperty("user.dir");

	 { //thằng if hoặc if else thì phải có condition, và cái đk này là dạng boolean true/false
		boolean status = 5 > 3; //đây như này 5 lớn hơn 3 là chuẩn rồi => nếu mình in ra k/q là true
		
		//hàm if sẽ nhận 1 điều kiện đúng true
		//loại if này mới chỉ là dạng kiểm tra duy nhất 1 điều kiện
		if (status) {
			// đúng thì vào phần thân của if và action còn sai thì bỏ qua
			System.out.println("nếu condition đúng là true thì vào if và in được"); //run => in đc
			//còn nếu trên status đổi thành 5<3 => ko in đc
		}
		
		
		//trường hợp khác, thằng if này đc sử dụng hiệu quả = việc tìm element ko có trong dom và popup ko hiển thị mình đã làm ở bài random popup ấy
		WebDriver driver = new FirefoxDriver();
		
		//vì ko có element trong dom nên chứng minh = việc hiển thị isdisplayed hay ko là ko thể
		//ta sẽ dùng list elements để chứng minh ko có "số lượng" element nào trong dom, tức = 0, nếu có thì dùng cách này cũng đc, = 1 2 3 4 gì đó nhưng nếu có element thì ko ai dùng cách này, isdisplay là gọn nhất
		List<WebElement> salePopups = driver.findElements(By.cssSelector(""));
		if (salePopups.size()>0 && salePopups.get(0).isDisplayed()) {
			//phần thân nó là action gì đó - nếu có element thì nhập thông tin ... vào popup
			//nhưng tất nhiên là ko có rồi và cái action này cũng ko thực hiện đc
		}
		//ko có gì xảy ra và chuyển qua step tiếp theo
	}
	
	//trên là if giờ tới if else (cách dùng IE như nào thì nhìn nó là hiểu nghĩa)
	//@Test
	public void TC_if_else() {
		
		System.setProperty("webdriver.ie.driver", projectPath + "\\browserDrivers\\IEDriverServer.exe");
		driver = new InternetExplorerDriver();
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		//yêu cầu bài tập: nếu driver chạy với các browser chrome/edge/ff thì dùng click của selenium webelement
		//còn chạy IE thì dùng click của javascriptexecutor
		if (driver.toString().contains("internet explorer")) { //dùng to string bởi vì driver khi chạy sẽ có cái ID => mới nhận diện đc điều kiện để click = jsexe (dùng sysout driver.toString() sẽ thấy ID)
			System.out.println("click bang jsexecutor");
		} else {
			System.out.println("click bang builtin cua selenium");
		}
		}
	
	
	@Parameters("browser")
	//@Test
	public void TC_if_else_if_else(String browserName) { //thằng này từng làm qua ở bài testng parameter multiple browser
		//if else có nghĩa là nếu đk này ko thỏa mãn thì nhảy sang đk kia (2 điều kiện), thì if else if else ... có nhiều điều kiện hơn nữa thôi
		if (browserName.equalsIgnoreCase("firefox")) { //hàm ignorecase này có mục đích là ko phân biệt chữ hoa or thường
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");
			driver = new EdgeDriver();
		} else if (browserName.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", projectPath + "\\browserDrivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		} else {
			//và những browser còn lại - nhưng nếu mình chỉ muốn mấy cái browser trên kia thôi, thì nếu sợ lỗi mình throw ra cái exception để xem nếu có lỗi thì lỗi là gì, nằm ở đâu
			throw new RuntimeException("Please input with correct browser name.");
		}
		
		//và cái bất cập của quá nhiều if else cũng đã nói ở bài tập testng parameter
	}
	

	@Test
	public void TC_tam_nguyen() { //và toán tử tam nguyên (3 dấu = ? :) cũng chính là 1 dạng của if else nhưng gọn hơn kha khá
		int age = 20;
		String access = (age < 18) ? "May ko dc truy cap" : "Chao mung ban den voi trang web giai tri so 1 VN";
		
		//if (age < 18) {   //đây chính là viết chuẩn if else của dòng trên
			//System.out.println("May ko dc truy cap");
		//} else {
			//System.out.println("Chao mung ban den voi trang web giai tri so 1 VN");
		//}
		
	}
	

	}
	//Note 1: = và == khác nhau nhé, = là gán assign còn == là so sánh bằng (thằng này trả ra k/q khi run là true/false)
	//Note 2: == chỉ nên dùng cho so sánh số, dùng cho text thì cũng đc nhưng ko nên dùng nhiều, do thằng == thuộc kiểu nguyên thủy
