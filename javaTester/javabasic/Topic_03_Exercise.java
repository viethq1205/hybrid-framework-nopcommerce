package javabasic;

import org.testng.annotations.Test;

public class Topic_03_Exercise {

 @Test
 public void swapNumber() {
	 int a = 5;
	 int b = 6;
	 a = a + b;
	 b = a - b;
	 a = a - b;
System.out.println(a);
System.out.println(b);
//in ra thấy giờ a = 6, b = 5 => thành công
 }
	
	
	
}
