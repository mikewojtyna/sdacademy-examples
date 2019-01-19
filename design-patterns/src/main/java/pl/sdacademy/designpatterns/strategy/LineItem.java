package pl.sdacademy.designpatterns.strategy;

import org.joda.money.Money;

import java.util.Objects;

public class LineItem {
	private final String productName;
	private final int count;
	private final Money productPrice;

	public LineItem(String productName, int count, Money productPrice) {
		this.productName = productName;
		this.count = count;
		this.productPrice = productPrice;
	}

	@Override
	public String toString() {
		return "LineItem{" + "productName='" + productName + '\'' + ", count=" + count + ", productPrice=" + productPrice + '}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		LineItem lineItem = (LineItem) o;
		return count == lineItem.count && Objects.equals(productName, lineItem.productName) && Objects.equals(productPrice, lineItem.productPrice);
	}

	@Override
	public int hashCode() {
		return Objects.hash(productName, count, productPrice);
	}

	public Money cost() {
		return productPrice.multipliedBy(count);
	}
}
