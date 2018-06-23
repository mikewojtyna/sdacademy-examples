package pl.sdacademy.algorithms.sort;

import java.util.ArrayList;
import java.util.List;

class BubbleSorter implements Sorter {
	@Override
	public <T extends Comparable<T>> List<T> sort(List<T> input) {
		ArrayList<T> sortedList = new ArrayList<>(input);
		if (input.size() > 1) {
			for (int i = 0; i < input.size() - 1; i++) {
				for (int j = 0; j < input.size() - 1; j++) {
					swapAdjacentElements(j, sortedList);
				}
			}
		}
		return sortedList;
	}

	private <T extends Comparable<T>> void swapAdjacentElements(int currentIndex, List<T> list) {
		T currentElement = list.get(currentIndex);
		int nextIndex = currentIndex + 1;
		T nextElement = list.get(nextIndex);
		if (currentElement.compareTo(nextElement) > 0) {
			list.set(currentIndex, nextElement);
			list.set(nextIndex, currentElement);
		}
	}
}
