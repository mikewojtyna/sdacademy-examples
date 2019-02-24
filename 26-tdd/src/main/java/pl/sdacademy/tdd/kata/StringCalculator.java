package pl.sdacademy.tdd.kata;

public class StringCalculator {
	public static int add(String numbers) {
		if (numbers.isEmpty()) {
			return 0;
		}
		String[] xNumbers = extractNumbers(numbers);
		return sumNumbers(xNumbers);
	}

	private static String[] extractNumbers(final String numbers) {
		String allDelimiters = ",\n";

		String numbersLocal = numbers;

		if (numbersLocal.startsWith("//")) {
			char delimiter = numbersLocal.charAt(2);
			allDelimiters += delimiter;
			numbersLocal = numbersLocal.substring(4);
		}

		return numbersLocal.split("[" + allDelimiters + "]");
	}

	private static int sumNumbers(String[] xNumbers) {
		int result = 0;
		for (String x : xNumbers) {
			int number = Integer.parseInt(x);
			if (number < 0) {
				throw new IllegalArgumentException("Negatives not allowed");
			}
			result += number;
		}
		return result;
	}
}
