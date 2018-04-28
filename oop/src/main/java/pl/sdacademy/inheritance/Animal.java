package pl.sdacademy.inheritance;

public class Animal {
	protected final String name;

	public Animal(String name) {
		this.name = name;
	}

	public void eat() {
		System.out.println("omnononom");
	}

	void move() {
		printMove();
	}

	private void printMove() {
		System.out.println("Animal " + name + " moved");
	}
}
