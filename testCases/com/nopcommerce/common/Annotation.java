package com.nopcommerce.common;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class Annotation { // chạy thử đoạn dưới và ta có kết quả trình tự chạy từng phần (tương ứng y chang bên file xml) là suite, test, class, testcase, class, test
	@Test
	public void TC_01() {
		System.out.println("Run test case");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("Run before class");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("Run after class");

	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("Run before test");

	}

	@AfterTest
	public void afterTest() {
		System.out.println("Run before test");

	}

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Run before suite");

	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("Run after suite");

	}

}
