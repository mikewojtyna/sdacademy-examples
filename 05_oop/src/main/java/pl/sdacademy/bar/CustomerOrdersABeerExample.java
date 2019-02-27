package pl.sdacademy.bar;

class CustomerOrdersABeerExample {
	public static void main(String[] args) {
		// creates a simple bar
		Bar bar = new SimpleBar();

		// customer orders a beer
		Drink drink = bar.order(MenuItem.BEER);
		// and drinks it - everything is ok, because simple bar implementation can server beers
		drink.drinkBy("goobar");

		// but, when we try to order a coffee, then an exception is thrown, because simple bar can server
		// only beers
		bar.order(MenuItem.COFFEE);
	}
}
