package pl.sdacademy.designpatterns.strategy;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class DiscountPolicyTest {
	@DisplayName("should apply discount policy after calculating the total cost of the order")
	@Test
	void test() throws Exception {
		// given
		LineItem firstItem = itemWithPriceAndCount(10.00, 2);
		LineItem secondItem = itemWithPriceAndCount(5.00, 1);
		Order order = orderWithItems(firstItem, secondItem);

		// when
		Money totalCost = order.totalCost(o -> 0.5);

		// then
		assertThat(totalCost).isEqualTo(money(12.50));
	}

	private Money money(double value) {
		return Money.of(CurrencyUnit.USD, value);
	}

	private Order orderWithItems(LineItem... items) {
		return new Order(Arrays.asList(items));
	}

	private LineItem itemWithPriceAndCount(double value, int count) {
		return new LineItem("any product", count, Money.of(CurrencyUnit.USD, value));
	}
}
