package pl.sdacademy.calculator;

public class Main {
	public static void main(String[] args) {
		// nie musimy lapac wyjatkow IllegalArgumentExcpetion, bo jest to runtime exception
		System.out.println(Calculator.add(2, 5));
		// te wywolania rzuca wyjatki
		try {
			Calculator.add(-1, 5);
			// linie ponizej tego wywolania sie nie wykonuja - bo add rzuca wyjatek i od razu trafia do
			// catch
			System.out.println("Ta linia sie nie wywola");
		}
		catch (IllegalArgumentException e) {
			System.out.println("Adding -1 and 5 failed");
		}
		// ten tez rzuca wyjatek
		try {
			Calculator.add(2, -2);
		}
		catch (IllegalArgumentException e) {
			System.out.println("Adding 2 and -2 failed");
		}
	}
}
