package javaOOP;

public interface Topic_03_Abstract_Method_Interface {

	// Trong interface hàm dùng abstract thì ko sao
	public abstract void showPCRam();

	// nhưng hàm viết kiểu thường có phần thân {} như dưới thì sẽ bị lỗi
	// public void showComputerSpecs() {
	// System.out.println("Show spec ");
	// }

	// viết ko có thân thì sẽ ko sao
	public void showComputerSpecs(); // ko cần phải có chữ abstract cũng đc vì trong interface mình viết ra 1 hàm nó sẽ tự hiểu đây là 1 hàm abstract

	//// vì hàm abstract chỉ là cái khung nên khi các Class khác extends/implements thì phải override lại (tạo cái khung thân cho nó)
}
