package pl.sdacademy.zoo;

abstract class Animal {

	private String name;

	Animal(String name) {
		this.name = name;
	}

	// wszystkie konkretne zwierzeta musza zdefiniowac metode eat (tylko one wiedza, jak maja jesc)
	abstract void eat();

	// wszystkie zwierzeta maja odziedziczona metode sayHi
	void sayHi() {
		System.out.println("Hello, my name is " + name);
	}
}
