package pl.sdacademy.examples;

public class Animal {
	protected final String name;

	public Animal(String name) {
		this.name = name;
	}

	public void eat() {
	}

	void move() {
		printMove();
	}

	private void printMove() {
		System.out.println("Animal " + name + " moved");
	}
}
