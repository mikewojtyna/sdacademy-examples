package pl.sdacademy.staticexample;

public class User {
	private static String name;

	public static String getName() {
		return name;
	}

	public static void setName(String name) {
		User.name = name;
	}
}
