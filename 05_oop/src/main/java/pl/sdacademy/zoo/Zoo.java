package pl.sdacademy.zoo;

import java.util.ArrayList;
import java.util.Collection;

class Zoo {

	private Collection<Animal> animals;
	private int maxCapacity;

	Zoo() {
		maxCapacity = 10;
		animals = new ArrayList<>();
	}

	Zoo(int maxCapacity) {
		this.maxCapacity = maxCapacity;
		animals = new ArrayList<>();
	}

	/**
	 * Adds a new animal.
	 *
	 * @param animal a new animal
	 * @throws MaximumCapacityExceededException if there's no room
	 */
	void add(Animal animal) throws MaximumCapacityExceededException {
		if (animals.size() == maxCapacity) {
			throw new MaximumCapacityExceededException("There's no room in this zoo");
		}
		animals.add(animal);
	}

	void feed() {
		for (Animal animal : animals) {
			// zoo nie musi wiedziec, z jakimi dokladnie zwierzetami ma do czynienia, gdyz maja ten sam
			// interfejs (kazde zwierze moze jesc)
			animal.eat();
		}
	}

	void helloAll() {
		for (Animal anim : animals) {
			// kazde zwierze moze sie przywitac
			anim.sayHi();
		}
	}

	int countAllAnimals() {
		return animals.size();
	}
}