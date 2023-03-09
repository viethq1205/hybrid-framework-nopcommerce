package com.facebook.register;

import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.facebook.LoginPageObject;
import pageObjects.facebook.PageGeneratorManager;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class Level_12_ELement_Undisplayed extends BaseTest { // bài này mình từng học 1 bài cũng dạng ntn ở bên webdriver topic Element Condition
	private WebDriver driver;
	private LoginPageObject loginPage;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appURL) {
		driver = getMultipleBrowserDriver(browserName, appURL);

		loginPage = PageGeneratorManager.getLoginPageObject(driver);
	}

	@Test
	public void TC_01_Verify_Element_Displayed() {

		loginPage.clickToCreateNewAccountButton();

		verifyTrue(loginPage.isEmailTextboxDisplayed());

	}

	@Test
	public void TC_02_Verify_Element_Undisplayed() {

		loginPage.enterToEmailTextbox("automationfc@gmail.com");
		loginPage.sleepInSecond(2);
		// verify sau khi nhập mail thì có hiện thêm cái textbox nhập lại email trên UI ko, hiện element trong DOM
		verifyTrue(loginPage.isConfirmEmailAddressTextboxDisplayed());

		loginPage.enterToEmailTextbox("");
		loginPage.sleepInSecond(2);
		// verify sau khi xóa dòng mail thì cái textbox nhập lại email sẽ biến mất, element ko có trong DOM
		verifyFalse(loginPage.isConfirmEmailAddressTextboxDisplayed());
		// tại sao dùng false thì từng gặp trường hợp này 1 lần r đó, hàm isDisplayed nhưng ko có element => false, mà đang dùng verifyFalse, vậy false + false = true - chứng minh đc cái textbox này biến mất
	}

	@Test
	public void TC_03_Verify_Element_Undisplayed_Not_in_DOM() {
		loginPage.clickClosePopupCreateNewAccount();
		loginPage.sleepInSecond(1);

		// trường hợp này ko thể dùng cái isDisplayed vì trong hàm displayed nó có bước driver.find cái element mà ở đây element ko có trong DOM => fail
		// cho nên mình sẽ custom lại hàm isdisplayed với try catch (xem trong basepage) nhưng sẽ gặp 1 issue tốn kha khá time (implicit) để verify 1 element ko có trong DOM (ko tối ưu)
		// verifyFalse(loginPage.isConfirmEmailAddressTextboxDisplayed());

		// nên dùng cách này có hàm isElementUndisplayed mới đc thêm vào BasePage sẽ ổn hơn, ko bị tốn quá nhiều thời gian tìm cái element ko có trong DOM
		verifyTrue(loginPage.isConfirmEmailTextboxUndisplayed());

	}

	@AfterClass
	public void afterClass() {
		// driver.quit();
	}

}
