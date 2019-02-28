package pl.sdacademy.payment;

/**
 * A payment strategy.
 */
// interfejs umozliwiajacy placenie
interface PaymentGateway {
	/**
	 * Performs the payment.
	 *
	 * @param amount amount to be paid
	 * @throws PaymentGatewayException if the underlying service failed
	 */
	// placi podana ilosc - faktyczne dzialanie jest dostarczone przez klasy implementujace ten interfejs
	void pay(int amount) throws PaymentGatewayException;
}
