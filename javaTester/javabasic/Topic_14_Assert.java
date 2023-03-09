package javabasic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import commons.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(commons.MethodListener.class) // note: khi chạy có listener nhớ apply dòng này vào (chỉ có trong class này) hoặc apply trong file xml (apply vào xml thì khi run test thì class nào cũng tự có)
public class Topic_14_Assert extends BaseTest {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
	}

	@Test
	public void TC_01_Assert() {

		String loginPageUrl = driver.getCurrentUrl();

		Assert.assertEquals(loginPageUrl, "https://www.facebook.com/");

		String loginPageTitle = driver.getTitle();

		// chỉnh sai đoạn text
		Assert.assertEquals(loginPageTitle, "Facebook – log in or sign up...");

		Assert.assertTrue(driver.findElement(By.xpath("//form[@data-testid='royal_login_form']")).isDisplayed());

		Assert.assertTrue(driver.findElement(By.xpath("//form[@data-testid='royal_login_form']")).isDisplayed());

		Assert.assertTrue(driver.findElement(By.xpath("//form[@data-testid='royal_login_form']")).isDisplayed());

		// kết quả runtest thì fail và dừng ngay chỗ facebook login vì sai kết quả so với trên UI
		// ta có thể thấy Assert sẽ dừng ngay khi fail và ko chạy tiếp
	}

	@Test
	public void TC_02_Verify() { // test verify khi có lỗi nó vẫn chạy tiếp

		String loginPageUrl = driver.getCurrentUrl();

		verifyEquals(loginPageUrl, "https://www.facebook.com/");

		String loginPageTitle = driver.getTitle();

		// chỉnh sai đoạn text
		verifyEquals(loginPageTitle, "Facebook – log in or sign up...");

		verifyTrue(driver.findElement(By.xpath("//form[@data-testid='royal_login_form']")).isDisplayed());

		verifyTrue(driver.findElement(By.xpath("//input[@name='login_source']")).isDisplayed()); // locator bị ẩn => false

		verifyTrue(driver.findElement(By.xpath("//div[@id='reg_pages_msg']")).isDisplayed());

		// kết quả runtest thì fail nhưng ko dừng ngay chỗ facebook login
		// ta có thể thấy khác với Assert sẽ dừng ngay khi fail và ko chạy tiếp, Verify làm điều ngược lại
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
