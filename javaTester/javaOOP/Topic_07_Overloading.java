package javaOOP;

public class Topic_07_Overloading { // overloading là nạp chồng - chồng hàm, và nó có tính chất đa hình (tính đa hình là gì thì mình đã học rồi)
	private int firstNumber;
	private int secondNumber;

	public void sumNumber() {
		System.out.println(this.firstNumber + this.secondNumber);
	}

	public void sumNumber(int number) {
		System.out.println(number + (number * 100) / 10);
	}

	public void sumNumber(int firstNumber, int secondNumber) {
		System.out.println(firstNumber + secondNumber);
	}

	public void sumNumber(float firstNumber, float secondNumber) {
		System.out.println(firstNumber + secondNumber);
	}

	public void sumNumber(int firstNumber, float secondNumber) {
		System.out.println(firstNumber + secondNumber);
	}

	public static void main(String[] args) {

	}

}
