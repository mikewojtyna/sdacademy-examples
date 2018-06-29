package pl.sdacademy.room;

public class Table {
	private final int width;
	private final int height;

	public Table(int width, int height) {
		this.width = width;
		this.height = height;
	}

	public int area() {
		return width * height;
	}
}
