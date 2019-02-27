package pl.sdacademy.payment;

class PayU implements PaymentGateway {
	@Override
	public void pay(int amount) throws PaymentGatewayException {
		System.out.printf("Client pays %d using PayU service\n", amount);
	}
}
