package com.wordpress.user;

import org.testng.annotations.Test;

import commons.BaseTest;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class Post_01_Create_Post extends BaseTest {

	private WebDriver driver;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String brwoserName) {

		driver = getMultipleBrowserDriver(brwoserName);

	}

	@Test
	public void Post_01_Create_Post() {

		log.info("Register - Step 01: Navigate to Register Page");
	}

	@Test
	public void Post_02_Search_Post() {

	}

	@Test
	public void Post_03_View_Post() {

	}

	@Test
	public void Post_04_Edit_Post() {

	}

	@Test
	public void Post_05_Delete_Post() {

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}

}