package pl.sdacademy.designpatterns.facade;

public class StringCalculator {

	private BasicCalculator calculator;

	public StringCalculator(BasicCalculator calculator) {
		this.calculator = calculator;
	}

	/**
	 * @param data examples: "+1,2" or "*1,2"
	 * @return
	 */
	int calculate(String data) {
		int firstArg = parseFirstArg(data);
		int secondArg = parseSecondArg(data);
		if (data.startsWith("+")) {
			return calculator.sum(firstArg, secondArg);
		}
		else {
			return calculator.multiply(firstArg, secondArg);
		}
	}

	private int parseSecondArg(String data) {
		return Integer.parseInt(splitNumbers(data)[1]);
	}

	private int parseFirstArg(String data) {
		return Integer.parseInt(splitNumbers(data)[0]);
	}

	private String[] splitNumbers(String data) {
		String numbers = data.substring(1);
		String[] splitNumbers = numbers.split(",");
		return splitNumbers;
	}
}
