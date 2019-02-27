package pl.sdacademy.payment;

import java.util.Arrays;
import java.util.List;

class ShoppingCart {

	private List<OrderLine> orderItems;

	ShoppingCart(OrderLine... orderItems) {
		this.orderItems = Arrays.asList(orderItems);
	}

	void payForOrder(PaymentGateway paymentGateway) {
		paymentGateway.pay(totalCost());
	}

	private int totalCost() {
		int sum = 0;
		for (OrderLine item : orderItems) {
			sum += item.cost();
		}
		return sum;
	}
}
