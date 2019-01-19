package pl.sdacademy.designpatterns.facade;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringCalculatorTest {

	private StringCalculator stringCalculator;

	@BeforeEach
	void setup() {
		stringCalculator = new StringCalculator(new MathBasicCalculator());
	}

	@DisplayName("should calculate sum of two integers")
	@Test
	void test() throws Exception {
		// given
		String data = "+1,2";

		// when
		int sum = stringCalculator.calculate(data);

		// then
		assertThat(sum).isEqualTo(3);
	}

	@DisplayName("should calculate multiplication of two integers")
	@Test
	void test1() throws Exception {
		// given
		String data = "*1,2";

		// when
		int multiplication = stringCalculator.calculate(data);

		// then
		assertThat(multiplication).isEqualTo(2);
	}
}
