package pl.sdacademy.payment;

class Example {
	// przyklad uzycia tego systemu platnosci
	public static void main(String[] args) {
		// wybieramy sposob platnosci
		PaymentGateway paymentGateway = choosePaymentGateway();
		// tworzymy przykladowy koszyk, aby zademonstrowac jak to wszystko dziala
		ShoppingCart cart = makeAnOrder();
		// oplacamy zamowienia w koszyku wykorzystujac wybrany przez uzytkownika system platnosci
		cart.payForOrder(paymentGateway);
	}

	// tworzymy jakis przykladowy koszyk o lacznej wartosci zamowien 800, ktory zawiera pozycje tea i coffeee
	private static ShoppingCart makeAnOrder() {
		return new ShoppingCart(new OrderLine("tea", 50, 10), new OrderLine("coffee", 60, 5));
	}

	// ta metoda wybiera sposob platnosci, proszac uzytkownika o podanie sposobu przez interfejs command line
	private static PaymentGateway choosePaymentGateway() {
		PaymentGatewayFactory paymentGatewayFactory = new CliPaymentGatewayFactory();
		return paymentGatewayFactory.createPaymentGateway();
	}
}
