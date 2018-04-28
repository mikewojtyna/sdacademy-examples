package pl.sdacademy.newclasses;

public class Elephant {

	private Fruit[] edibleFruits;

	public Elephant(Fruit[] edibleFruits) {
		this.edibleFruits = edibleFruits;
	}

	public void eat(Fruit fruit) {
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
/*		for (int i = 0; i < edibleFruits.length; i++) {
			Fruit currentFruit = edibleFruits[i];

			if (currentFruit.equals(fruit)) {
				return true;
			}
		}*/

		for (Fruit currentFruit : edibleFruits) {
			if (currentFruit.equals(fruit)) {
				return true;
			}
		}

		return false;
	}

}
