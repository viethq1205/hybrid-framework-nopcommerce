package javabasic;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Topic_06_Switch_Case {
	// giống ifelse nhưng gọn hơn và dùng file xml để chạy
	// thằng default có nghĩa là nếu ko có case nào thỏa yêu cầu thì sẽ rơi vào cái default này (giống cái else cuối cùng còn lại)
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	@Parameters("browser")
	// @Test
	public void TC_01(String browserName) {
		switch (browserName) {
		case "firefox": // nếu là firefox nó sẽ khởi tạo thằng ff lên xong break chuyển qua case tiếp theo
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		case "chrome": // chỗ này đã từng học nhưng nhắc lại vì quan trọng, sự khác biệt của switch case là ko cho trùng case nếu như mình nhập tiếp ở đây là ff, còn ifelse thì cho phép
			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case "edge":
			System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");
			driver = new EdgeDriver();
			break;
		default:
			throw new RuntimeException("Please input with correct browser name.");
		}
		driver.quit();
	}

	// có 1 cách gán làm cả case như này ngắn lại nhưng lười làm, biết thêm thì vào youtube topic này xem

	// @Test
	public void TC_02() { // yêu cầu là lát nhập vào console 1 tháng thì in ra số ngày của tháng đó, ví dụ nhập tháng 2 thì hiện ra 28 ngày
		Scanner scanner = new Scanner(System.in);
		int month = scanner.nextInt();

		// thằng này nếu dùng if else thì rất nhiều, nên dùng switch case gọn hơn
		// đây là if else
		/*
		 * if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) { //nhớ ko bị lỗi ghi month = nhé, vì = là gán, phải dùng 2 dấu ==, còn || là or System.out.println("Tháng " + month +
		 * " có 31 ngày"); } else if(month == 2) { System.out.println("Tháng " + month + " có 28 ngày"); } else if(month == 4 || month == 6 || month == 9 || month == 11){ System.out.println("Tháng " + month + " có 30 ngày"); }
		 */

		// đây là dùng switch case
		switch (month) {
		case 1: // vì 1 là int nên ko dùng "" của string
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			System.out.println("Tháng " + month + " có 31 ngày");
			break; // nhớ dùng break để ngăn 1 phạm vi này với phạm vi kia nhé, vì nếu ko break thì vd khi in ta nhập tháng 12, ngoài dòng tháng có 31 ngày nó sẽ ra cả dòng tháng có 28 ngày
		case 2:
			System.out.println("Tháng " + month + " có 28 ngày");
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			System.out.println("Tháng " + month + " có 30 ngày");
			break;
		default:
			System.out.println("nhập sai tháng rồi, vui lòng nhập lại");
			break;
		}
	}

	@Test
	public void TC_03() {
		Scanner scanner = new Scanner(System.in);
		int number = scanner.nextInt();

		switch (number) {
		case 1:
			System.out.println("One");
			break;
		case 2:
			System.out.println("Two");
			break;
		case 3:
			System.out.println("Three");
			break;
		case 4:
			System.out.println("Four");
			break;
		case 5:
			System.out.println("Five");
			break;
		case 6:
			System.out.println("Six");
			break;
		case 7:
			System.out.println("Seven");
			break;
		case 8:
			System.out.println("Eight");
			break;
		case 9:
			System.out.println("Nine");
			break;
		case 10:
			System.out.println("Ten");
			break;
		default:
			System.out.println("Đmm nhập ngoài phạm vi 1~10 rồi con chó, vui lòng nhập lại");
			break;
		}
	}

	// nhưng switch case nếu mình dùng để làm trường hợp như xếp điểm thì ko đc vì nó ko cho sử dụng float - số thập phân, ko dùng đc toán tử, chỉ có cách dùng if else
	// switch case chỉ sử dụng int, string, enum
}
