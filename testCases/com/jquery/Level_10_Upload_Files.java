package com.jquery;

import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.jQuery.uploadFile.HomePageObject;
import pageObjects.jQuery.uploadFile.PageGeneratorManager;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_10_Upload_Files extends BaseTest {
	private WebDriver driver;

	public HomePageObject homePage;

	String csharpFileName = "CSharp.jpg";
	String javaFileName = "Java.jpg";
	String pythonFileName = "Python.jpg";
	String rubyFileName = "Ruby.png";

	String multipleFiles[] = { csharpFileName, javaFileName, pythonFileName, rubyFileName };

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appURL) {

		driver = getMultipleBrowserDriver(browserName, appURL);

		homePage = PageGeneratorManager.getHomePageObject(driver);
	}

	@Test
	public void Upload_File_01_One_File_Per_Time() {
		homePage.uploadOneOrMultipleFiles(driver, javaFileName);

		// verify đúng tên file mình chọn chưa
		Assert.assertTrue(homePage.isFileLoadedByName(javaFileName));

		homePage.clickToStartButton();

		// verify đúng file mình chọn chưa sau khi nhấn nút start upload file bên trên (up thành công thì tên file nó trở thành 1 cái link)
		Assert.assertTrue(homePage.isFileLinkUploadedByName(javaFileName));

		// verify đúng hình ảnh file đã đc upload
		Assert.assertTrue(homePage.isImageUploadedByName(javaFileName));
	}

	@Test
	public void Upload_File_02_Multiple_Files_Per_Time() {
		homePage.refreshPage(driver);

		homePage.uploadOneOrMultipleFiles(driver, multipleFiles);

		// verify đúng tên file mình chọn chưa
		Assert.assertTrue(homePage.isFileLoadedByName(javaFileName));
		Assert.assertTrue(homePage.isFileLoadedByName(csharpFileName));
		Assert.assertTrue(homePage.isFileLoadedByName(pythonFileName));
		Assert.assertTrue(homePage.isFileLoadedByName(rubyFileName));

		homePage.clickToStartButton();

		// verify đúng file mình chọn chưa sau khi nhấn nút start upload file bên trên (up thành công thì tên file nó trở thành 1 cái link)
		Assert.assertTrue(homePage.isFileLinkUploadedByName(javaFileName));
		Assert.assertTrue(homePage.isFileLinkUploadedByName(csharpFileName));
		Assert.assertTrue(homePage.isFileLinkUploadedByName(pythonFileName));
		Assert.assertTrue(homePage.isFileLinkUploadedByName(rubyFileName));

		// verify đúng hình ảnh file đã đc upload
		Assert.assertTrue(homePage.isImageUploadedByName(javaFileName));
		Assert.assertTrue(homePage.isImageUploadedByName(csharpFileName));
		Assert.assertTrue(homePage.isImageUploadedByName(pythonFileName));
		Assert.assertTrue(homePage.isImageUploadedByName(rubyFileName));

	}

	@AfterClass
	public void afterClass() {
		// driver.quit();
	}

}
