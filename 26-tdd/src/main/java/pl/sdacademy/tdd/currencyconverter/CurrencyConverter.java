package pl.sdacademy.tdd.currencyconverter;


import java.util.Collection;

public class CurrencyConverter {
	private CurrencyProvider provider;

	public CurrencyConverter(CurrencyProvider provider) {
		this.provider = provider;
	}

	public double convert(double amount, String from, String to) throws CurrencyPairNotFoundException {
		Collection<CurrencyRatio> currencies = null;
		try {
			currencies = provider.getCurrencies();
		}
		catch (CurrencyProviderException e) {
			throw new CurrencyPairNotFoundException(String.format("Currency pair %s:%s cannot be found " + "on list returned by currency provider.", from, to), e);
		}
		for (CurrencyRatio currency : currencies) {
			if (from.equals(currency.getLeft()) && to.equals(currency.getRight())) {
				return amount * currency.getRatio();
			}
		}
		throw new CurrencyPairNotFoundException(String.format("Currency pair %s:%s cannot be found on list " + "returned by currency provider.", from, to));
	}
}
