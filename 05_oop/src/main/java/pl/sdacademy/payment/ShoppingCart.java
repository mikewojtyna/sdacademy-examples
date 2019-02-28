package pl.sdacademy.payment;

import java.util.Arrays;
import java.util.List;

class ShoppingCart {

	// wszystkie zamowienia w koszyku
	private List<OrderLine> orderItems;

	// konstruktor, ktory umozliwia stworzyc koszyk z danymi zamowieniami
	// uwaga: jest to pewne uproszczenie, gdyz w rzeczywistosci pewnie cheilibysmy miec mozliwosc dodawnia
	// zamowien do koszyka (a nie tylko jednorazowego stworzenia)
	// te ... kropki oznaczaja varargs (zmienna liczbe argumentow) i sa po to, aby klient mogl wygodnie recznie
	// dodawac zamowienia (czyli np. new ShoppingCart(order0, order1, order2) etc
	ShoppingCart(OrderLine... orderItems) {
		// wewnatrz varargs sa widoczne po prostu jako tablica OrderLine[]
		// dlatego zamieniami ja na liste - bo tak zdefiniowalismy pole
		this.orderItems = Arrays.asList(orderItems);
	}

	/**
	 * Pays for all orders in this shopping cart.
	 *
	 * @param paymentGateway the strategy to perform the payment
	 */
	// metoda, ktora sluzy do oplacenia koszyka wykorzystujac podany sposob platnosci
	void payForOrder(PaymentGateway paymentGateway) {
		paymentGateway.pay(totalCost());
	}

	// liczy calkowity koszt koszyka
	private int totalCost() {
		int sum = 0;
		for (OrderLine item : orderItems) {
			sum += item.cost();
		}
		return sum;
	}
}
