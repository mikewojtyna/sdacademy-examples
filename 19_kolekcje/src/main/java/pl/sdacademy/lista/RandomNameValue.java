package pl.sdacademy.lista;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class RandomNameValue {
	public static void main(String[] args) {

		Map<String, Integer> nameRandomValue = new HashMap<>();
		Scanner scanner = new Scanner(System.in);
		Random randGenerator = new Random();

		String name = scanner.nextLine();

		while(!name.equals("exit")) {
			if(!nameRandomValue.containsKey(name)) {
				nameRandomValue.put(name, randGenerator.nextInt());
			}
			name = scanner.nextLine();
		}

		for(Map.Entry<String, Integer> nameEntry : nameRandomValue.entrySet()) {
			System.out.println("Imię " + nameEntry.getKey() + " ma przypisaną wartość " + nameEntry
				.getValue());
		}
	}
}
