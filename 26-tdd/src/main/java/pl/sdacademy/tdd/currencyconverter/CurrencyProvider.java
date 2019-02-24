package pl.sdacademy.tdd.currencyconverter;

import java.util.Collection;

public interface CurrencyProvider {
	/**
	 * Provides the currencies.
	 *
	 * @return the currencies
	 * @throws CurrencyProviderException if service fails
	 */
	Collection<CurrencyRatio> getCurrencies() throws CurrencyProviderException;

}
