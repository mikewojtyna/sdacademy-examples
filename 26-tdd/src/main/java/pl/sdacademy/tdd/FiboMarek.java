package pl.sdacademy.tdd;


import java.util.Scanner;
import java.text.DecimalFormat;

public class FiboMarek {

	static DecimalFormat ft = new DecimalFormat("###,###,###,###,###,###");


	public static long Fibonacci(long number) {
		if (number == 0 || number == 1) {
			return number;
		}

		return (Fibonacci(number - 1)) + (Fibonacci(number - 2));

	}

	public static void main(String[] args) {
		int N;
		Scanner odczyt = new Scanner(System.in);
		System.out.println("Podaj liczbę: ");

		N = odczyt.nextInt();
		long startAll = System.currentTimeMillis();
		for (int i = 1; i <= N; i++){
			long start = System.currentTimeMillis();
			System.out.print(i + ": " + ft.format(Fibonacci(i)));
			long end = System.currentTimeMillis();
			System.out.println("   time: " + ft.format((end - start)) + " miliseconds");
		}
		long endAll = System.currentTimeMillis();

		System.out.println("Program run time: " + ft.format((endAll - startAll)) + " miliseconds");
	}
}