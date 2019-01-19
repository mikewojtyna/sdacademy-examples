package pl.sdacademy.designpatterns.facade;

public class MathBasicCalculator implements BasicCalculator {
	@Override
	public int sum(int x, int y) {
		return Math.addExact(x, y);
	}

	@Override
	public int multiply(int x, int y) {
		return Math.multiplyExact(x, y);
	}
}
