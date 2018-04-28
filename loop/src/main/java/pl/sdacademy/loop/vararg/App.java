package pl.sdacademy.loop.vararg;

public class App {
	public static void main(String[] args) {
		String result = joinStrings("hello", "hello2", "hello3");
		System.out.println(result);
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
