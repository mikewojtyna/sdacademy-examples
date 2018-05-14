package pl.sdacademy.tdd;

public class EmailValidator {

	public boolean isValid(String email) {
		return email.contains("@") && countChars(email, "@") < 2;
	}

	private int countChars(String text, String character) {
		int counter = 0;
		int currentIndex = 0;
		while(text.contains(character)) {
			currentIndex = text.indexOf(character.charAt(0), 0) + 1;
			text = text.substring(currentIndex, text.length() - 1);
			counter ++;
		}
		return counter;
	}
}
