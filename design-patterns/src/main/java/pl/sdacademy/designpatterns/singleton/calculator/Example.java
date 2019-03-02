package pl.sdacademy.designpatterns.singleton.calculator;

public class Example {
	public static void main(String[] args) {
		for (int i = 0; i < 1_000; i++) {
			CalculatorSingleton calculatorSingleton = CalculatorSingleton.getInstance();
			System.out.printf("Instance: %s.\n", calculatorSingleton);
			int x = 2;
			int y = 10;
			System.out.printf("Result %d + %d = %d.\n", x, y, calculatorSingleton.add(x, y));
		}
	}
}
