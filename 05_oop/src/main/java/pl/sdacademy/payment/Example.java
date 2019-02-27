package pl.sdacademy.payment;

import java.util.Scanner;

class Example {
	public static void main(String[] args) {
		PaymentGateway paymentGateway = choosePaymentGateway();
		ShoppingCart cart = makeAnOrder();
		cart.payForOrder(paymentGateway);
	}

	private static ShoppingCart makeAnOrder() {
		return new ShoppingCart(new OrderLine("tea", 50, 10), new OrderLine("coffee", 60, 5));
	}

	private static PaymentGateway choosePaymentGateway() {
		System.out.println("Choose payment gateway. Available options: [CREDITCARD, PAYU]");
		Scanner scanner = new Scanner(System.in);
		String strategy = scanner.next();
		PaymentMethod paymentMethod = PaymentMethod.valueOf(strategy);

		switch (paymentMethod) {
			case CREDITCARD:
				return new CreditCardPaymentGateway();
			default:
				return new PayU();
		}
	}
}
