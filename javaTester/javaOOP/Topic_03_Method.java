package javaOOP;

public class Topic_03_Method {

	void showCarName() {
		System.out.println("Hyundai Tucson");
	}

	static void showCarColor() {
		System.out.println("Black");
	}

	public static void main(String[] args) {
		// showcarname();
		showCarColor(); // đã nói r nhưng nhắc lại, hàm static có thể gọi trực tiếp ko cần thông qua object nào

		// còn thằng showCarName muốn dùng thì phải có object/instance như này
		Topic_03_Method obj = new Topic_03_Method();
		obj.showCarName();

	}

}
