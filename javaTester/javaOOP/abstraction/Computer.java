package javaOOP.abstraction;

public abstract class Computer {
	// non-abstract method
	public void showCPU() {
		System.out.println("I7-12700K");
	}

	// abstract method
	public abstract void setRam();
}
