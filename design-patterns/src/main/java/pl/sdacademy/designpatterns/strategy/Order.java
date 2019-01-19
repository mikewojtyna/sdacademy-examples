package pl.sdacademy.designpatterns.strategy;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

import java.math.RoundingMode;
import java.util.Collection;

public class Order {

	private Collection<LineItem> items;

	public Order(Collection<LineItem> items) {
		this.items = items;
	}

	public Money totalCost(DiscountPolicy discountPolicy) {
		// @formatter:off
		return items.stream()
			.map(LineItem::cost)
			.reduce(Money::plus).orElse(Money.zero(CurrencyUnit.USD))
			.multipliedBy(discountPolicy.discountFor(this), RoundingMode.HALF_UP);
		// @formatter:on
	}

}
