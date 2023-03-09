package javaOOP;

public class Person {
	private String personName;

	// class này đc gọi là Nested class hoặc innerclass (ít dùng)
	public class Pupil {
		String name = "ALo";
	}

	public static void main(String[] args) {
		Person person = new Person(); // Person là Class, còn person là instance/biến/object
		person.personName = "";

		Person.Pupil pupil = person.new Pupil();
		pupil.name = "";
	}
}
