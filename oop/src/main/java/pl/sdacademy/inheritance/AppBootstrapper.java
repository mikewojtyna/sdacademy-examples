package pl.sdacademy.inheritance;

class AppBootstrapper {
	public static void start() {

		// create an elephant called Babar and tell it to move and eat
		Elephant babar = new Elephant("Babar");
		babar.move();
		babar.eat();

		// create an elephant called Adam and tell it to move and eat
		Elephant adam = new Elephant("Adam");
		adam.move();
		babar.eat();

		// create a parrot called Polly and tell it to move, eat and
		// talk
		Parrot polly = new Parrot("Polly", "Red");
		polly.move();
		polly.talk();
	}
}
