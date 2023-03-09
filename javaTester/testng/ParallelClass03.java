package testng;

import org.testng.annotations.Test;

import commons.BaseTest;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class ParallelClass03 extends BaseTest {
	WebDriver driver;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String brwoserName) {

		driver = getMultipleBrowserDriver(brwoserName);

	}

	@BeforeClass
	public void beforeClass() {
	}

	@Test
	public void TC_01_New_Product() {
	}

	public void TC_02_Edit_Product() {
	}

	public void TC_03_View_Product() {
	}

	public void TC_04_Delete_Product() {
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
