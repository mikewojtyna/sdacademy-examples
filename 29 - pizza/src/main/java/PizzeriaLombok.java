public class PizzeriaLombok {
	public static void main(String[] args) {
		PizzaLombok pizzaLombok = PizzaLombok.robPizze()
			.dough("cross")
			.sauce("spacy")
			.topping("chicken").build();
		System.out.println(pizzaLombok);
	}
}
