package Strategia;

class MaleKnightsValidator implements KnightValidator {

	public boolean validate(Knight knight) {
		String name = knight.getName();
		return name.charAt(name.length() - 1) != 'a';
	}

}