package pl.sdacademy.tdd;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pl.sdacademy.tdd.kata.FizzBuzz;

import static org.assertj.core.api.Assertions.*;

// TODO: write your tests inside this class
class FizzBuzzTest {
	@DisplayName("should return string according to FizzBuzz specification")
	@ParameterizedTest(name = "expecting \"{1}\" when given {0}")
	// @formatter:off
	@CsvSource({
		// given: 1, expected "1"
		"1, 1",
		// given: 2, expected "2"
		"2, 2",
		// given: 3, expected "Fizz"
		"3, Fizz",
		// given: 5, expected "Buzz"
		"5, Buzz",
		// given: 6, expected: "Fizz"
		"6, Fizz",
		// given: 10, expected: "Buzz"
		"10, Buzz",
		// given: 15, expected: "FizzBuzz"
		"15, FizzBuzz",
		// given: 30, expected: "FizzBuzz"
		"30, FizzBuzz"
	})
	// @formatter:on
	void fizzBuzz(int number, String expected) {
		// when
		String msg = FizzBuzz.msg(number);

		// then
		assertThat(msg).isEqualTo(expected);
	}

}
