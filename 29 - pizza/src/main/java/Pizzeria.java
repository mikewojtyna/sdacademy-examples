public class Pizzeria {
	public static void main(String[] args) {
		Pizza pizza = Pizza.newBuilder()
			.withDough("cross")
			.withSauce("spacy")
			.withTopping("chicken")
			.build();
		System.out.println(pizza);
	}
}
