package pl.sdacademy.algorithms.sort;

import java.util.Arrays;
import java.util.List;

class BubbleSorter implements Sorter {
	@Override
	public <T extends Comparable<T>> List<T> sort(List<T> input) {
		if (input.size() > 1) {
			T firstElement = input.get(0);
			T secondElement = input.get(1);
			if (firstElement.compareTo(secondElement) > 0) {
				return Arrays.asList(secondElement, firstElement);
			}
		}
		return input;
	}
}
