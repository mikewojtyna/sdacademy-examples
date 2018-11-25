package pl.sdacademy.point;

public class Main {
	public static void main(String[] args) {
		try {
			// @formatter:off
			new Rectangle(
				new Point(1000, 10),
				new Point(10, 10),
				new Point(0, 0),
				new Point(10, 0));
			// @formatter:on

			System.out.println("It's correct rectangle");
		}
		catch (IllegalArgumentException e) {
			System.out.println("Illegal argument exception was thrown");
			System.out.println(e.getMessage());
		}
	}
}
