package pl.sdacademy.tdd.currencyconverter;

public class CurrencyPairNotFoundException extends RuntimeException {
	public CurrencyPairNotFoundException(String message) {
		super(message);
	}

	public CurrencyPairNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
}
