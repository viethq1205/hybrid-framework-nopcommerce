package javaOOP;

public class CarPOP { // POP là viết tắt của Procedure Oriented Programming tức Lập trình hướng thủ tục
	// điểm yếu của thằng này so với OOP là nó chỉ phù hợp với những bài toán, dự án ở mức đơn giản, trung bình thôi
	// nếu dự án mở rộng ra và phức tạp hơn thì khó apply (ko có tính kế thừa, đa hình, trừu tượng, đóng gói...), xem thêm kiến thức ở topic OOP 02

	static String carCompany;
	static String modelName;
	static String fuelType;
	static Float mileAge;
	static Double carPrice;

	public static void main(String[] args) {
		carCompany = "BMW";
		modelName = "i7";
		fuelType = "Electricity";
		mileAge = 480f;
		carPrice = 120000d;
		System.out.println("*********************************");
		System.out.println("Company name = " + carCompany);
		System.out.println("Model name = " + modelName);
		System.out.println("Fuel type = " + fuelType);
		System.out.println("Mile age = " + mileAge);
		System.out.println("Price = " + carPrice);
		System.out.println("*********************************");

	}

}
