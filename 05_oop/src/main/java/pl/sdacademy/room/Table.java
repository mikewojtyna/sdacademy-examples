package pl.sdacademy.room;

import java.util.Objects;

class Table {

	private static int serialNumber = 0;
	private int tableNumber;

	Table(int width, int height) {
		this.width = width;
		this.height = height;
		this.tableNumber = serialNumber;
		serialNumber++;
	}

	private final int width;
	private final int height;

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Table table = (Table) o;
		return tableNumber == table.tableNumber;
	}

	@Override
	public int hashCode() {

		return Objects.hash(tableNumber);
	}

	int area() {
		return width * height;
	}
}
