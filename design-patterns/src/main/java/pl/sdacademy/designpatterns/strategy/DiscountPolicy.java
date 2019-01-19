package pl.sdacademy.designpatterns.strategy;

/**
 * A policy to calculate discounts for orders.
 */
public interface DiscountPolicy {
	/**
	 * Calculates the discount for a given order.
	 *
	 * @param order an order
	 * @return the discount in value from 0.0 to 1.0 describing the discount percentage
	 */
	double discountFor(Order order);
}
