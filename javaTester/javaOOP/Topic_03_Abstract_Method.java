package javaOOP;

public abstract class Topic_03_Abstract_Method { // abstract trong abstraction - tính trừu tượng, đây là 1 tính chất trong JavaOOP
	// muốn biết tính trừu tượng của OOP ntn thì có 2 yếu tố là abstract class và interface (do 2 thằng này nó mới chứa abstract method)

	// Normal method
	public void showComputerSpecs() {
		System.out.println("Show spec ");
	}

	// Abstract method
	public abstract void showPCRam(); // hàm abstract ko có {}

	// vì hàm abstract chỉ là cái khung nên khi các Class khác extends/implements thì phải override lại (tạo cái khung thân cho nó)

}
