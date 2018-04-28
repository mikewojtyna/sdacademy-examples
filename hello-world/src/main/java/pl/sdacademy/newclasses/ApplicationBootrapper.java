package pl.sdacademy.newclasses;

public class ApplicationBootrapper {

	public static void start() {
		Fruit[] edibleFruits = new Fruit[]{fruit("Orange"), fruit
			("Apple"), fruit("Banana")};
		Elephant elephant = new Elephant(edibleFruits);

		elephant.eat(new Fruit("Orange"));
		elephant.eat(new Fruit("Pineapple"));

		String result = joinStrings("hello", "hello2", "hello3");
		System.out.println(result);
	}

	private static String joinStrings(String... args) {
		String result = "";
		for (String current : args) {
			result += current;
		}
		return result;
	}

	private static Fruit fruit(String name) {
		return new Fruit(name);
	}
}
