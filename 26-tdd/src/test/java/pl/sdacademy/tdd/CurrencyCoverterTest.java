package pl.sdacademy.tdd;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pl.sdacademy.tdd.currencyconverter.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class CurrencyCoverterTest {
	@DisplayName("Should calculate amount after conversion")
	@Test
	void test() throws Exception {
		// given
		// @formatter:off
		List<CurrencyRatio> currencies = Arrays.asList(
			new CurrencyRatio("USD", "GBP", 1.20),
			new CurrencyRatio("USD", "PLN", 3.00)
			);
		// @formatter:on
		CurrencyProvider currencyProvider = Mockito.mock(CurrencyProvider.class);
		Mockito.when(currencyProvider.getCurrencies()).thenReturn(currencies); // configure the
		// currencyconverter
		CurrencyConverter converter = new CurrencyConverter(currencyProvider);

		// when
		double amountInPln = converter.convert(10.00, "USD", "PLN");

		// then
		assertThat(amountInPln).isEqualTo(30.00);
	}

	@DisplayName("Should throw exception when currency list doesn't contain the requested pair")
	@Test
	void test2() throws Exception {
		// given
		// @formatter:off
		List<CurrencyRatio> currencies = Arrays.asList(
			new CurrencyRatio("USD", "GBP", 1.20),
			new CurrencyRatio("USD", "PLN", 3.00)
			);
		// @formatter:on
		CurrencyProvider currencyProvider = Mockito.mock(CurrencyProvider.class);
		Mockito.when(currencyProvider.getCurrencies()).thenReturn(currencies); // configure the
		// currencyconverter
		CurrencyConverter converter = new CurrencyConverter(currencyProvider);

		// when
		Throwable ex = catchThrowable(() -> converter.convert(10.00, "USD", "CHR"));

		// then
		assertThat(ex).isInstanceOf(CurrencyPairNotFoundException.class);
		assertThat(ex).hasMessageContaining("pair USD:CHR");
	}

	@DisplayName("Should throw exception when currency list is empty")
	@Test
	void test3() throws Exception {
		// given
		// @formatter:off
		List<CurrencyRatio> currencies = Collections.emptyList();
		// @formatter:on
		CurrencyProvider currencyProvider = Mockito.mock(CurrencyProvider.class);
		Mockito.when(currencyProvider.getCurrencies()).thenReturn(currencies); // configure the
		// currencyconverter
		CurrencyConverter converter = new CurrencyConverter(currencyProvider);

		// when
		Throwable ex = catchThrowable(() -> converter.convert(10.00, "USD", "CHR"));

		// then
		assertThat(ex).isInstanceOf(CurrencyPairNotFoundException.class);
		assertThat(ex).hasMessageContaining("pair USD:CHR");
	}

	@DisplayName("Should throw currency not found exception when currency provider fails")
	@Test
	void test4() throws Exception {
		// given
		CurrencyProvider currencyProvider = Mockito.mock(CurrencyProvider.class);
		Throwable currencyProviderException = new CurrencyProviderException("currency provider failed");
		Mockito.when(currencyProvider.getCurrencies()).thenThrow(currencyProviderException); // configure the
		// currencyconverter
		CurrencyConverter converter = new CurrencyConverter(currencyProvider);

		// when
		Throwable ex = catchThrowable(() -> converter.convert(10.00, "USD", "CHR"));

		// then
		assertThat(ex).isInstanceOf(CurrencyPairNotFoundException.class);
		assertThat(ex).hasMessageContaining("pair USD:CHR");
		assertThat(ex).hasCause(currencyProviderException);
	}
}
