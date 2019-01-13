package pl.sdacademy.tdd.temperature;

public class TemperatureConverter {

	private TemperatureService service;

	public TemperatureConverter(TemperatureService service) {
		this.service = service;
	}

	public int convert(Coordinates coordinate, TemperatureUnit targetUnit) {
		try {
			int temperature = service.temperatureCelsius(coordinate);
			return convertCelsiusTo(temperature, targetUnit);
		}
		catch (RuntimeException e) {
			return -1;
		}
	}

	private int convertCelsiusTo(int temperature, TemperatureUnit targetUnit) {
		if (targetUnit == TemperatureUnit.FAHRENHEIT) {
			return (int) (temperature * (double) 9 / 5 + 32);
		}
		throw new UnsupportedOperationException(String.format("Target unit %s is not supported", targetUnit));
	}
}
