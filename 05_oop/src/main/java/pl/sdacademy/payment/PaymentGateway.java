package pl.sdacademy.payment;

/**
 * A payment strategy.
 */
interface PaymentGateway {
	/**
	 * Performs the payment.
	 *
	 * @param amount amount to be paid
	 * @throws PaymentGatewayException if the underlying service failed
	 */
	void pay(int amount) throws PaymentGatewayException;
}
