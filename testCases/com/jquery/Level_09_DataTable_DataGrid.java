package com.jquery;

import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.jQuery.dataTable.HomePageObject;
import pageObjects.jQuery.dataTable.PageGeneratorManager;
import pageUI.jQuery.dataTable.HomePageUI;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_09_DataTable_DataGrid extends BaseTest {
	private WebDriver driver;
	HomePageObject homePage;
	List<String> actualAllCountryValues;
	List<String> expectedAllCountryValues;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appURL) {

		driver = getMultipleBrowserDriver(browserName, appURL);

		homePage = PageGeneratorManager.getHomePageObject(driver);

	}

	// @Test
	public void Table_01_Paging() {
		homePage.openPagingByNumber("10");
		Assert.assertTrue(homePage.isPageNumberActive("10"));

		homePage.openPagingByNumber("18");
		Assert.assertTrue(homePage.isPageNumberActive("18"));

	}

	// @Test
	public void Table_02_Search() {
		homePage.searchByLabel("Country", "Argentina");
		homePage.searchByLabel("Females", "338282");
		homePage.searchByLabel("Male", "349238");
		homePage.searchByLabel("Total", "687522");

		homePage.refreshPage(driver);

	}

	// @Test
	public void Table_03_Value_Each_Row_of_All_Pages() {
		actualAllCountryValues = homePage.getValueEachRowAtAllPage();
		Assert.assertEquals(actualAllCountryValues, expectedAllCountryValues);
	}

	@Test
	public void Table_04_Enter_to_Textbox_At_Any_Row() {
		homePage.clickLoadButton();
		homePage.sleepInSecond(2);

		// nhập dữ liệu (td) vào textbox tại row bao nhiêu (tr), tên header (th) của cái column đó là gì để chuẩn cột mà nhập dữ liệu vào
		homePage.enterToTextboxAtARowByColumnName("Company", "1", "Zalo"); // Company là tên header và cũng chính là cột mình muốn điền, 2 là hàng (row) 2, alo là dữ liệu

		homePage.enterToTextboxAtARowByColumnName("Contact Person", "3", "Alo");

		homePage.selectDropDownByColumnName("Country", "1", "Taiwan");
		homePage.sleepInSecond(1);

		homePage.selectDropDownByColumnName("Country", "3", "Japan");
		homePage.sleepInSecond(1);

		homePage.checkToCheckboxByColumnName("NPO?", "2");

		homePage.checkToCheckboxByColumnName("NPO?", "3");

		homePage.checkToCheckboxByColumnName("NPO?", "6");

		homePage.checkToCheckboxByColumnName("NPO?", "7");

		homePage.checkToCheckboxByColumnName("NPO?", "8");

		homePage.uncheckToCheckboxByColumnName("NPO?", "1");

		homePage.uncheckToCheckboxByColumnName("NPO?", "4");

		homePage.uncheckToCheckboxByColumnName("NPO?", "5");

		homePage.clickToIconByRowNumber("1", "Remove Current Row");
		homePage.sleepInSecond(1);
		homePage.clickToIconByRowNumber("1", "Insert Row Above");
		homePage.sleepInSecond(1);
		homePage.clickToIconByRowNumber("3", "Move Up");
		homePage.sleepInSecond(1);

		homePage.clickToIconByRowNumber("8", "Remove Current Row");
		homePage.sleepInSecond(1);
		homePage.clickToIconByRowNumber("7", "Remove Current Row");
		homePage.sleepInSecond(1);
		homePage.clickToIconByRowNumber("6", "Remove Current Row");
		homePage.sleepInSecond(1);
		homePage.clickToIconByRowNumber("5", "Remove Current Row");
		homePage.sleepInSecond(1);
		homePage.clickToIconByRowNumber("4", "Remove Current Row");
		homePage.sleepInSecond(1);
		homePage.clickToIconByRowNumber("3", "Remove Current Row");
		homePage.sleepInSecond(1);
		homePage.clickToIconByRowNumber("2", "Remove Current Row");
		homePage.sleepInSecond(1);
		homePage.clickToIconByRowNumber("1", "Remove Current Row");
		homePage.sleepInSecond(1);
	}

	@AfterClass
	public void afterClass() {
		// driver.quit();
	}

}
