package pl.sdacademy.tdd;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Fail.fail;

// TODO: write your tests inside this class
class FizzBuzzTest {

	// this is how a test look like
	@DisplayName("do nothing - this pseudo test is here only to show how to create your own tests")
	@Test
	void nothing() {
		// this is how you write assertions
		assertThat(1).isEqualTo(1);
		assertThat(1).isNotEqualTo(2);
		fail("remove this pseudo test and start writing your own real tests");
	}
}
