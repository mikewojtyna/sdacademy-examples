package pl.sdacademy.eater;

class ApplicationBootrapper {
	static void start() {
		Fruit[] edibleFruits = new Fruit[]{fruit("Orange"), fruit
			("Apple"), fruit("Banana")};
		Elephant elephant = new Elephant(edibleFruits);

		elephant.eat(new Fruit("Orange"));
		elephant.eat(new Fruit("Pineapple"));
	}

	private static Fruit fruit(String name) {
		return new Fruit(name);
	}
}
