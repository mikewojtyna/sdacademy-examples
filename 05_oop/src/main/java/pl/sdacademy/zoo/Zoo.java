package pl.sdacademy.zoo;

import java.util.ArrayList;
import java.util.Collection;

class Zoo {

	private Collection<Animal> animals;

	Zoo() {
		animals = new ArrayList<>();
	}

	void add(Animal animal) {
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