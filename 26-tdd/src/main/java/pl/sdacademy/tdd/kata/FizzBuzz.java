package pl.sdacademy.tdd.kata;

public class FizzBuzz {
	/**
	 * Returns a "Fizz" when {@code number} if divisible by 3, "Buzz" when divisible by 5, "FizzBuzz" when
	 * divisible by 3 and 5, and finally a string representation of a {@code number} in any other case (e.g. "1"
	 * for 1, "2" for 2).
	 *
	 * @param number a number
	 * @return the string according to the specification
	 */
	public static String msg(int number) {
		boolean divisibleBy5 = number % 5 == 0;
		boolean divisibleBy3 = number % 3 == 0;
		if (divisibleBy3 && divisibleBy5) {
			return "FizzBuzz";
		}
		if (divisibleBy3) {
			return "Fizz";
		}
		if (divisibleBy5) {
			return "Buzz";
		}
		return String.valueOf(number);
	}
}
