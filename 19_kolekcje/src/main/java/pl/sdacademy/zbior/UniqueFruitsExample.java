package pl.sdacademy.zbior;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UniqueFruitsExample {
	public static void main(String[] args) {
		List<String> fruits = Arrays.asList("orange", "apple", "orange", "banana", "pineapple", "raspberry",
			"pineapple");
		Set<String> fruitTypes = new HashSet<>(fruits);

		System.out.println(fruitTypes);
	}
}
