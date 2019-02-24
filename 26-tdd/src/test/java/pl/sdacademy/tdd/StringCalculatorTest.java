package pl.sdacademy.tdd;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pl.sdacademy.tdd.kata.StringCalculator;

import static org.assertj.core.api.Assertions.*;

public class StringCalculatorTest {

	// @formatter:off
	@DisplayName(
		"given any numbers string, " +
		"then return sum of all numbers"
	)
	@ParameterizedTest(name = "given: {0}, ex: {1}")
	@CsvSource({
		"'', 0",
		"'1', 1",
		"'5', 5",
		"'1,2', 3",
		"'1,2,3', 6",
		"'1\n2', 3",
		"'//;\n1;2', 3",
		"'//%\n1%2%10', 13",
		"'//%\n1%2,10\n20', 33"
	})
	// @formatter:on
	void test(String numbers, int expectedSum) throws Exception {
		// when
		int sum = StringCalculator.add(numbers);

		// then
		assertThat(sum).isEqualTo(expectedSum);
	}

	// @formatter:off
	@DisplayName(
		"given any negative number, " +
		"then illegal argument exception is thrown"
	)
	// @formatter:on
	@Test
	void test1() throws Exception {
		// given
		String numbers = "1,-2";

		// when
		Throwable ex = catchThrowable(() -> StringCalculator.add(numbers));

		// then
		assertThat(ex).isInstanceOf(IllegalArgumentException.class);
	}

}
