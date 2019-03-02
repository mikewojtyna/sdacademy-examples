package pl.sdacademy.payment;

import java.util.Scanner;

public class CliPaymentGatewayFactory implements PaymentGatewayFactory {
	@Override
	public PaymentGateway createPaymentGateway() {
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
