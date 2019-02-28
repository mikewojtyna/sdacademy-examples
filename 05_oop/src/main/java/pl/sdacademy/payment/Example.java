package pl.sdacademy.payment;

import java.util.Scanner;

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
		System.out.println("Choose payment gateway. Available options: [CREDITCARD, PAYU]");
		Scanner scanner = new Scanner(System.in);
		String strategy = scanner.next();
		// probuje stworzyc enuma w oparciu o wartosc odczytana ze standardowego wejscia
		// nazwy wprowadzane przez uzytkownika musza byc dokladnie takie same jak nazwy dostepnych wartosci
		// enum PaymentMethod (czyli np. CREDITCARD lub PAYU)
		// inaczej, jak nie bedzie dostepnej wartosci, to ta metoda rzuci wyjatek
		PaymentMethod paymentMethod = PaymentMethod.valueOf(strategy);

		// na podstawie wybranej metody platnosci, zwracamy rozne implemntacje systemu platnosci
		switch (paymentMethod) {
			case CREDITCARD:
				return new CreditCardPaymentGateway();
			default:
				return new PayU();
		}
	}
}
