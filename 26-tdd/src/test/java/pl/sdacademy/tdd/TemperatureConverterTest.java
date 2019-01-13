package pl.sdacademy.tdd;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.sdacademy.tdd.temperature.Coordinates;
import pl.sdacademy.tdd.temperature.TemperatureConverter;
import pl.sdacademy.tdd.temperature.TemperatureService;
import pl.sdacademy.tdd.temperature.TemperatureUnit;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TemperatureConverterTest {

	@DisplayName("should convert to fahrenheit")
	@Test
	void test0() throws Exception {
		// given
		Coordinates coordinates = new Coordinates(100, 50);
		TemperatureService service = mock(TemperatureService.class);
		when(service.temperatureCelsius(coordinates)).thenReturn(10);
		TemperatureConverter converter = new TemperatureConverter(service);

		// when
		int fahrenheit = converter.convert(coordinates, TemperatureUnit.FAHRENHEIT);

		// then
		assertThat(fahrenheit).isBetween(49, 51);
	}

	@DisplayName("should return -1 when temperature service fails")
	@Test
	void test1() throws Exception {
		// given
		TemperatureService service = mock(TemperatureService.class);
		Coordinates coordinates = new Coordinates(50, 20);
		when(service.temperatureCelsius(coordinates)).thenThrow(new RuntimeException("service failed"));
		TemperatureConverter converter = new TemperatureConverter(service);

		// when
		int result = converter.convert(coordinates, TemperatureUnit.FAHRENHEIT);

		// then
		assertThat(result).isEqualTo(-1);
	}
}
