package pl.sdacademy.loop.vararg;

public class App {
	public static void main(String[] args) {
		String result = joinStrings("hello", "hsello2", "hello3");
		//System.out.println(result);
		System.out.printf("%d, %s, %f", 10, "Halo", 3.42);

	}

	private static String joinStrings(String... args) {
		// TODO: we should use StringBuilder instead
		// string concatenation is very inefficient
		String result = "";
		for (String current : args) {
			result += current;
		}
		return result;
	}
}
