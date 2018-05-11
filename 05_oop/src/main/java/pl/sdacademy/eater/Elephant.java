package pl.sdacademy.eater;

class Elephant {
	private final Fruit[] edibleFruits;

	Elephant(Fruit[] edibleFruits) {
		this.edibleFruits = edibleFruits;
	}

	void eat(Fruit fruit) {
		if (isEdible(fruit)) {
			System.out.println("Elephant ate the fruit named: " +
				fruit);
		}
		else {
			System.out.println("Elephant didn't eat the fruit " +
				"named: " + fruit);
		}
	}

	private boolean isEdible(Fruit fruit) {
		// You can implement this using classic for loop
		for (int i = 0; i < edibleFruits.length; i++) {
			Fruit currentFruit = edibleFruits[i];

			if (currentFruit.equals(fruit)) {
				return true;
			}
		}

		// ... Or foreach loop
/*		for (Fruit currentFruit : edibleFruits) {
			if (currentFruit.equals(fruit)) {
				return true;
			}
		}*/

		return false;
	}
}
