package pl.sdacademy.algorithms.sort;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class SortingTest {
	private static Stream<Arguments> params() {
		return Stream.of(
			// input: empty list, expected: empty list
			Arguments.of(Collections.emptyList(), Collections.emptyList()),
			// input: {0}, expected: {0}
			Arguments.of(Collections.singletonList(0), Collections.singletonList(0)),
			// input: {1, 0}, expected: {0, 1}
			Arguments.of(Arrays.asList(1, 0), Arrays.asList(0, 1)),
			// input: {0, 1}, expected: {0, 1}
			Arguments.of(Arrays.asList(0, 1), Arrays.asList(0, 1)),
			// input: {1, 0, 2}, expected: {0, 1, 2}
			Arguments.of(Arrays.asList(1, 0, 2), Arrays.asList(0, 1, 2)),
			// input: {2, 1, 0}, expected: {0, 1, 2}
			Arguments.of(Arrays.asList(2, 1, 0), Arrays.asList(0, 1, 2)),
			// input: {5, 3, 10, 1}, expected: {1, 3, 5, 10}
			Arguments.of(Arrays.asList(5, 3, 10, 1), Arrays.asList(1, 3, 5, 10)),
			// input: range from 99 to 0, expected: range from 0 to 99
			Arguments.of(range(99, 0), range(0, 99))
			// end of test cases
		);
	}

	private static List<Integer> range(int from, int to) {
		if (from < to) {
			return IntStream.rangeClosed(from, to).boxed().collect(Collectors.toList());
		}
		return IntStream.rangeClosed(to, from).boxed().sorted(Collections.reverseOrder()).collect(Collectors
			.toList());
	}

	@DisplayName("should sort input list ascending")
	@ParameterizedTest(name = "given input list = {0}, expected sorted list = {1}")
	@MethodSource(value = "params")
	void sort(List<Integer> input, List<Integer> expected) {
		// given
		Sorter sorter = new BubbleSorter();

		// when
		List<Integer> sortedList = sorter.sort(input);

		// then
		assertThat(sortedList).isEqualTo(expected);
	}

	@DisplayName("should not modify input list and create a new copy instead")
	@Test
	void copy() {
		// given
		Sorter sorter = new BubbleSorter();
		List<Integer> input = Arrays.asList(3, 0, 2, 1);

		// when
		List<Integer> sortedList = sorter.sort(input);

		// then
		assertThat(sortedList).isNotSameAs(input);
	}
}
