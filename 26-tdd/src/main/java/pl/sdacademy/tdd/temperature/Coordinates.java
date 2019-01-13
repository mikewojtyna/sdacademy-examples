package pl.sdacademy.tdd.temperature;

import java.util.Objects;

public class Coordinates {
	private int longitutde;
	private int aptitude;


	public Coordinates(int longtitude, int aptitude) {
		this.longitutde = longtitude;
		this.aptitude = aptitude;
	}

	@Override
	public String toString() {
		return "Coordinates{" + "longitutde=" + longitutde + ", aptitude=" + aptitude + '}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Coordinates that = (Coordinates) o;
		return longitutde == that.longitutde && aptitude == that.aptitude;
	}

	@Override
	public int hashCode() {
		return Objects.hash(longitutde, aptitude);
	}
}
