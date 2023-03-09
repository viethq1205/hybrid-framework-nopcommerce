package javaOOP;

public class Topic_05_This_and_Super {
	private int firstNumber;
	private int secondNumber;

	public Topic_05_This_and_Super(int fNumber, int sNumber) {
		this.firstNumber = fNumber;
		this.secondNumber = sNumber;
	}

	public void sumNumber() {
		System.out.println(firstNumber + secondNumber);
	}

	public void showNumber() {
		this.sumNumber();
	}

	public static void main(String[] args) {
		Topic_05_This_and_Super topic = new Topic_05_This_and_Super(15, 7);
		topic.sumNumber();
	}

	// Phần super có thể xem trên clip topic 63 (khoảng phút 35 trở đi) và note Zalo - cũng khá dễ hiểu
}
