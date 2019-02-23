package pl.sdacademy.tdd;

public class StringCalculator {
	public static int add(String numbers) {
		if (numbers.isEmpty()) {
			return 0;
		}
		String[] twoNumbers = numbers.split(",");
		if (twoNumbers.length == 2) {
			return Integer.parseInt(twoNumbers[0]) + Integer.parseInt(twoNumbers[1]);
		}
		return Integer.parseInt(numbers);
	}
}
