package pl.sdacademy.algorithms.sort;

import java.util.List;

class BubbleSorter implements Sorter {
	@Override
	public <T extends Comparable<T>> List<T> sort(List<T> input) {
		return input;
	}
}
