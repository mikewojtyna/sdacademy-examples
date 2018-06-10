package pl.sdacademy;

public class StringExcptMain {
	public static void main(String[] args) {
		String someStrin = null;

		try {
			someStrin.length();
		} catch(NullPointerException ex) {
			System.out.println("Obiekt nie może być nullem!");
		}
	}
}
