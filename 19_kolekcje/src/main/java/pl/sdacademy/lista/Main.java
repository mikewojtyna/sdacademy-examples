package pl.sdacademy.lista;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
	public static void main(String[] args) {
		List<String> napisy = new ArrayList<>();
		napisy.add("Ala");
		napisy.add("ma");
		napisy.add("kota");
		String resztaZdania = "kot lubi mleko";
		napisy.add(resztaZdania);
		napisy.add("kot pije mleko");

		System.out.println("5 elementowa lista: " + napisy);

		napisy.remove(0);
		System.out.println("Usunąłem 1 element: " + napisy);
		napisy.remove(resztaZdania);
		System.out.println("Usunałem zmienną resztaZdania: " + napisy);
		System.out.println("Czy w liscie jest 'ma' : " + napisy.contains("ma"));

		Random randGenerator = new Random();
		int randValue = randGenerator.nextInt();

		List<String> napisy2 = new ArrayList<>();
		napisy2.add("ma");
		napisy2.add("kota");
		System.out.println("Czy wszystkie elementy napisy2 znajdują się w napisy? : " + napisy.containsAll
                        (napisy2));
		List<String> napisy3 = new ArrayList<>();
		napisy3.add("kota");
		napisy3.add("ma");

		System.out.println("czy listy są takie same " + napisy2.equals(napisy3));

	}
}
