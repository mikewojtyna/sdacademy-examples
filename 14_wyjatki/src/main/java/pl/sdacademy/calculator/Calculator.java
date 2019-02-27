package pl.sdacademy.calculator;

class Calculator {
	static int add(int x, int y) throws IllegalArgumentException {
		if (x < 0 || y < 0) {
			throw new IllegalArgumentException("Cannot be negative");
		}
		return x + y;
	}
}
