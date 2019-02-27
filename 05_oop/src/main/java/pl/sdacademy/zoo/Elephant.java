package pl.sdacademy.zoo;

class Elephant extends Animal {

	Elephant(String name) {
		super(name);
	}

	Elephant() {
		super("Babar");
	}

	@Override
	// zdefiniowanie metody abstrakcyjnej przez slonia
	public void eat() {
		System.out.println("Elephant " + name + " eats!");
	}

	// metoda, ktora ma tylko slon (i klasy potomne po sloniu)
	void makeASound() {
		System.out.println("Elephant " + name + " makes a sound");
	}
}
