package javaOOP.abstraction;

public interface IAnimal { // trong interface ko có private protected
	public int number = 100;

	String getName();

	void setName(String name);

	abstract String getAdress();

	abstract void setAdress();
}
