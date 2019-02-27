package pl.sdacademy.payment;

import java.util.Objects;

/**
 * Models a single line in the shopping cart.
 */
class OrderLine {
	private final String product;
	private final int price;
	private final int amount;

	OrderLine(String product, int price, int amount) {
		this.product = product;
		this.price = price;
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "OrderLine{" + "product='" + product + '\'' + ", price=" + price + ", amount=" + amount + '}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		OrderLine orderLine = (OrderLine) o;
		return price == orderLine.price && amount == orderLine.amount && Objects.equals(product,
			orderLine.product);
	}

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
