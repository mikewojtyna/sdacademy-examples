package pl.sdacademy.examples;

public class AppBootstrapper {
	public static void start() {
		Elephant babar = new Elephant("Babar");
		babar.move();

		Elephant adam = new Elephant("Adam");
		adam.move();
	}
}
