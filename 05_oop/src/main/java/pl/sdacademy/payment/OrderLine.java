package pl.sdacademy.payment;

import java.util.Objects;

/**
 * Models a single line in the shopping cart.
 */
class OrderLine {
	// deklaracja pol klasy
	// te pola sa finalne - nie moga sie zmienic w trakcie
	// pola finalne moga byc ustawione tylko raz podczas konstrukcji obiektu
	private final String product;
	private final int price;
	private final int amount;

	// konstruktor, ktory przekazuje wartosci pol
	OrderLine(String product, int price, int amount) {
		this.product = product;
		this.price = price;
		this.amount = amount;
	}

	// nadpisanie metody toString wygenerowane implementacja
	@Override
	public String toString() {
		return "OrderLine{" + "product='" + product + '\'' + ", price=" + price + ", amount=" + amount + '}';
	}

	// nadpisanie metody equals uzywajac wygenerowanego kodu
	// ta metoda jest nadpisana aby moc porownywac obiekty order line
	// jest to prosta klasa tzw. Value Object (nie ma swojej tozsamosci), dlatego wszystkie pola biora udzial w
	// metodzie equals
	// innym przykladem Value Object sa np. pieniadze
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		OrderLine orderLine = (OrderLine) o;
		return price == orderLine.price && amount == orderLine.amount && Objects.equals(product, orderLine.product);
	}

	// hashcode musi byc zawsze nadpisany razem z equals
	// uzywany np. przez HashSet w celu wydajnego znajdowania obiektow
	@Override
	public int hashCode() {
		return Objects.hash(product, price, amount);
	}

	/**
	 * Cost of this order line.
	 *
	 * @return the cost of this order line ({@code price * amount})
	 */
	int cost() {
		return price * amount;
	}
}
