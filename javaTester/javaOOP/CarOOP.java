package javaOOP;

public class CarOOP {
	private String carCompany;
	private String modelName;
	private String fuelType;
	private Float mileAge;
	private Double carPrice;

	public CarOOP(String carCompany, String modelName, String fuelType, Float mileAge, Double carPrice) {
		this.carCompany = carCompany;
		this.modelName = modelName;
		this.fuelType = fuelType;
		this.mileAge = mileAge;
		this.carPrice = carPrice;
	}

	protected String getCarCompany() {
		return carCompany;
	}

	protected void setCarCompany(String carCompany) {
		this.carCompany = carCompany;
	}

	protected String getModelName() {
		return modelName;
	}

	protected void setModelName(String modelName) {
		this.modelName = modelName;
	}

	protected String getFuelType() {
		return fuelType;
	}

	protected void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	protected Float getMileAge() {
		return mileAge;
	}

	protected void setMileAge(Float mileAge) {
		this.mileAge = mileAge;
	}

	protected Double getCarPrice() {
		return carPrice;
	}

	protected void setCarPrice(Double carPrice) {
		this.carPrice = carPrice;
	}

	protected void showCarInfo() {
		System.out.println("Company name = " + getCarCompany());
		System.out.println("Model name = " + getModelName());
		System.out.println("Fuel type = " + getFuelType());
		System.out.println("Mile age = " + getMileAge());
		System.out.println("Price = " + getCarPrice());
	}

	public static void main(String[] args) {
		CarOOP car = new CarOOP("BMW", "i7", "Electricity", 480f, 1200000d);
		car.showCarInfo();

	}

}
