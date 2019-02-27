package pl.sdacademy.payment;

class CreditCardPaymentGateway implements PaymentGateway {
	@Override
	public void pay(int amount) throws PaymentGatewayException {
		System.out.printf("Client pays %d using credit card payment service\n", amount);
	}
}
