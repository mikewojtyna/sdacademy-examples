package pl.sdacademy.tdd.currencyconverter;

import java.util.Objects;

public class CurrencyRatio {
	private String left;
	private String right;
	private double ratio;

	public CurrencyRatio(String left, String right, double ratio) {
		this.left = left;
		this.right = right;
		this.ratio = ratio;
	}

	public String getLeft() {
		return left;
	}

	public String getRight() {
		return right;
	}

	public double getRatio() {
		return ratio;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		CurrencyRatio that = (CurrencyRatio) o;
		return Double.compare(that.ratio, ratio) == 0 && Objects.equals(left, that.left) && Objects.equals(right, that.right);
	}

	@Override
	public int hashCode() {
		return Objects.hash(left, right, ratio);
	}
}
