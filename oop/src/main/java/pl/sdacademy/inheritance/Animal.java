package pl.sdacademy.inheritance;

class Animal {
	protected final String name;

	Animal(String name) {
		this.name = name;
	}

	void eat() {
		System.out.println("omnononom");
	}

	void move() {
		printMove();
	}

	private void printMove() {
		System.out.println("Animal " + name + " moved");
	}
}
