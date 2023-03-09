package testng;

import org.testng.annotations.Test;

import commons.BaseTest;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class ParallelClass extends BaseTest { // đây là phần học trong topic 97 Test Case Dependencies
	WebDriver driver;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {

		driver = getMultipleBrowserDriver(browserName);

	}

	@BeforeClass
	public void beforeClass() {
	}

	@Test
	public void TC_01_New_Account() {
	}

	public void TC_02_Edit_Account() {
	}

	public void TC_03_View_Account() {
	}

	public void TC_04_Delete_Account() {
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
