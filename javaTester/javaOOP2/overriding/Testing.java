package javaOOP2.overriding;

public class Testing {

	public static void main(String[] args) {

		Student student = new Student();
		student.eat();
		student.sleep();
		student.workingTime();

		Employee emp = new Employee();
		emp.eat();
		emp.sleep();
		emp.workingTime();
	}

}
