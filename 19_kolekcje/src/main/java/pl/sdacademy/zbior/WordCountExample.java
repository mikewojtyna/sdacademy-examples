package pl.sdacademy.zbior;

import java.util.HashMap;
import java.util.Map;

public class WordCountExample {
	public static void main(String[] args) {
		String text = "ala ma kota i drugiego kota a nawet trzeciego kota bo to jest ala";

		Map<String, Integer> wordCount = new HashMap<>();

		String[] words = text.split(" ");

		for (String word : words) {
			Integer oldCount = wordCount.get(word);
			if (oldCount != null) {
				wordCount.put(word, oldCount + 1);
			}
			else {
				wordCount.put(word, 1);
			}
		}

		//		Stream.of(words).forEach(word -> wordCount.merge(word, 1, (old, value) -> old +
		//		value));

		System.out.println(wordCount);
	}
}
