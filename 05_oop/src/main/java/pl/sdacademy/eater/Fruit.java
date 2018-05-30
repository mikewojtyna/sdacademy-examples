package pl.sdacademy.eater;

import java.util.Objects;

class Fruit {
	private final String name;

	Fruit(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Fruit fruit = (Fruit) o;
		return Objects.equals(name, fruit.name);
	}

	@Override
	public int hashCode() {

		return Objects.hash(name);
	}
}
