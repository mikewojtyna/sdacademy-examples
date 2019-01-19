package pl.sdacademy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import static org.assertj.core.api.Assertions.*;

public class CollectionCopierTest {
	@DisplayName("should copy collection of Strings to collection of Objects")
	@Test
	void copyStrToObj() {
		// given
		Collection<String> strings = Arrays.asList("one", "two", "three");
		Collection<Object> objects = new ArrayList<>();

		// when
		CollectionCopier.copy(strings, objects);

		// then
		assertThat(objects).containsOnly("one", "two", "three");
	}

	@DisplayName("should copy collection of Integers to collection of Numbers")
	@Test
	void copyIntToNumbers() {
		// given
		Collection<Double> integers = Arrays.asList(1.0, 2.0, 3.0);
		Collection<Object> numbers = new ArrayList<>();

		// when
		CollectionCopier.copy(integers, numbers);

		// then
		assertThat(numbers).containsOnly(1.0, 2.0, 3.0);
	}
}
