package javabasic;

import org.testng.annotations.Test;

public class Topic_02_Exercise {

	//@Test 
	public void TC_01() {
		int a = 6;
		int b = 2;
		System.out.println("Tổng = " + (a+b));
		System.out.println("Hiệu = " + (a-b));
		System.out.println("Tích = " + (a*b));
		System.out.println("Thương = " + (a/b));
	}

	@Test 
	public void TC_02() {
		float lengthchieudai = 7.5f;
		float widthchieurong = 3.8f;
		
		System.out.println("S of rectangle = " + (lengthchieudai*widthchieurong));
		
	}
	
}
