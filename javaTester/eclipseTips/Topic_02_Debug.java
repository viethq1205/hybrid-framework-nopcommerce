package eclipseTips;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Topic_02_Debug { // cách sử dụng thì m thấy phía bên trái có các số tt ko, nhấp 2 lần là đánh dấu
								// debug, cách run debug thì cũng đơn giản, chuột phải debug as
	// bài này trong topic IDE tips, ko nhớ thì xem lại clip IDE tips
	WebDriver driver;

	@Test
	public void TC_01() {
		System.setProperty("webdriver.gecko.driver", ".\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();

	}
}
