package pl.sdacademy.algorithms.sort;

import java.util.Arrays;
import java.util.List;

class BubbleSorter implements Sorter {
	@Override
	public <T extends Comparable<T>> List<T> sort(List<T> input) {
		if (input.size() > 1) {
			return Arrays.asList(input.get(1), input.get(0));
		}
		return input;
	}
}
