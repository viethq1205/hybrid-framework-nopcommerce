package eclipseTips;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Topic_01_Template {
	static WebDriver driver = null;
	
	public static void main(String[] args) {
		//cách vào setting chỗ cài đặt key word và nhấn nhanh ra đủ dòng code giống nhấn sysout xong ctrl V là ra cả dòng lệnh in ấy
		//window => preferences => Java => editor => templates
		//ví dụ như dưới nhập wdfe rồi ctrl space là ra dòng dưới
		WebElement field = driver.findElement(By.xpath("//a"));
		WebElement hello = driver.findElement(By.cssSelector(""));
		
		//nhưng ko nên lạm dùng nhiều cái này
		Assert.assertTrue(false);

	}

}
