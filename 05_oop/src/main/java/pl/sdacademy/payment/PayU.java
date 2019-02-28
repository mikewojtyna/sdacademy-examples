package pl.sdacademy.payment;

class PayU implements PaymentGateway {
	@Override
	// metoda, ktora udaje, ze przeprowadza platnosc przez payu - w prawdziwym systemie nastapilo by tutaj
	// polaczenie z prawdziwym zewnetrznym systemem
	public void pay(int amount) throws PaymentGatewayException {
		System.out.printf("Client pays %d using PayU service\n", amount);
	}
}
