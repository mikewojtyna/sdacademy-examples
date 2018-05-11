package pl.sdacademy.inheritance;

class Parrot extends Animal {
	private final String color;

	public Parrot(String name, String color) {
		super(name);
		this.color = color;
	}

	public void talk() {
		System.out.println(name + " wants a cookie!");
	}
}
