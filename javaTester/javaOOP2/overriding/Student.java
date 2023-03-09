package javaOOP2.overriding;

public class Student extends Person implements IWork { // đây là đang kế thừa Class bth, có thể tùy ý override hoặc ko đều đc, nhưng nếu kế thừa class abstract thì sẽ BẮT BUỘC phải override cái hàm rỗng của class abstract

	@Override
	public void eat() {
		System.out.println("Suất cơm 15k"); // override lại hàm eat trên class cha person
		// note: khi override thì phải viết lại hàm y chang hàm ở class cha
	}

	@Override
	public void sleep() {
		System.out.println("Ngủ 8 tiếng");

	}

	@Override
	public void workingTime() {
		System.out.println("học 8 tiếng");

	}

}
