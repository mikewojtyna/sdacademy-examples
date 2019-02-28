package pl.sdacademy.payment;

class CreditCardPaymentGateway implements PaymentGateway {
	@Override
	// metoda udajaca, ze przeprowadza platnosc za pomoca karty kredytowej - w prwadziwym systemie nastapilo by
	// tutaj polaczenie do zewnetrznego systemu obslugujacego platnosci
	public void pay(int amount) throws PaymentGatewayException {
		System.out.printf("Client pays %d using credit card payment service\n", amount);
	}
}
