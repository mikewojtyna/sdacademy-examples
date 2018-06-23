package pl.sdacademy.algorithms.sort;

import java.util.List;

interface Sorter {
	<T extends Comparable<T>> List<T> sort(List<T> input);
}
