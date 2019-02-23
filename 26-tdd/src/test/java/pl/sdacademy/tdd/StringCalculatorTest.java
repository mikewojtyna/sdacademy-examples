package pl.sdacademy.tdd;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
		"'1,2', 3"
	})
	// @formatter:on
	void test(String numbers, int expectedSum) throws Exception {
		// when
		int sum = StringCalculator.add(numbers);

		// then
		assertThat(sum).isEqualTo(expectedSum);
	}

}
