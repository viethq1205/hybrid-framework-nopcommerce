package javabasic;

import java.util.Calendar;
import java.util.Random;

public class Topic_15_Random_Java {

	public static void main(String[] args) throws InterruptedException {
		System.out.println(getRandomNumber());
		Thread.sleep(1000);
		System.out.println(getRandomNumber(50, 99));
		Thread.sleep(1000);
		System.out.println(getRandomEmail());
		Thread.sleep(1000);

		System.out.println(getRandomNumberByDateTime());
		Thread.sleep(1000);

	}

	// random 3 numbers
	public static int getRandomNumber() {
		int uLimit = 999;
		int lLimit = 100;
		Random rand = new Random();
		return lLimit + rand.nextInt(uLimit - lLimit);
	}

	public static int getGenerateRandomNumber() {
		Random rand = new Random();
		return rand.nextInt(99999);
	}

	// random theo cái range (theo số nhỏ nhất đến lớn nhất 90~150, 900~1000 kiểu vậy)
	public static int getRandomNumber(int minimum, int maximum) {
		Random rand = new Random();
		return minimum + rand.nextInt(maximum - minimum);
	}

	public static String getRandomEmail() {
		return "automation" + getRandomNumberByDateTime() + "@live.com";
	}

	// Get random number by date time minute second (rất khó bị duplicate)
	public static long getRandomNumberByDateTime() {
		return Calendar.getInstance().getTimeInMillis() % 100000;
	}
}
