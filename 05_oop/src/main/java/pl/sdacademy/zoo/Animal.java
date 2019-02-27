package pl.sdacademy.zoo;

abstract class Animal implements Eater, Greeter {

	private String name;

	Animal(String name) {
		this.name = name;
	}

	// wszystkie zwierzeta maja odziedziczona metode sayHi
	@Override
	public void sayHi() {
		System.out.println("Hello, my name is " + name);
	}
}
