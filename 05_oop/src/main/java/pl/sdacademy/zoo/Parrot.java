package pl.sdacademy.zoo;

class Parrot extends Animal {
	Parrot(String name) {
		super(name);
	}

	@Override
	// zdefiniowanie jak papuga je
	public void eat() {
		System.out.println("Parrot eats a cookie");
	}

	// metoda charakterystyczna tylko dla papugi
	void talk() {
		System.out.println("Parrot talks");
	}
}
