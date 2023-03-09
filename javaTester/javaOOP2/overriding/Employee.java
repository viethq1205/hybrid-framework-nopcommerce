package javaOOP2.overriding;

public class Employee extends Person implements IWork {

	@Override
	public void eat() {
		System.out.println("Suất cơm 25k");
	}

	@Override
	public void sleep() {
		System.out.println("Ngủ 7 tiếng");

	}

	@Override
	public void workingTime() {
		System.out.println("Làm 9 tiếng");

	}

}
