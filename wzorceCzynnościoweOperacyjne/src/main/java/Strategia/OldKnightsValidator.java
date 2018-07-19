package Strategia;

class OldKnightsValidator implements KnightValidator {

	public boolean validate(Knight knight) {

		return knight.getAge() > 60;
	}

}