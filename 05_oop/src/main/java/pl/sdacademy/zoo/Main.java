package pl.sdacademy.zoo;

class Main {
	public static void main(String[] args) {
		// zmien maxCapacity na 1, aby zobaczyc obsluge wyjatkow

		// zmien typ np. na Elephant i zobacz co sie stanie
		Zoo<Animal> zoo = new Zoo<>(10);
		zoo.add(new Elephant("Adam"));
		try {
			zoo.add(new Parrot("Polly"));
		}
		catch (MaximumCapacityExceededException e) {
			System.out.println("You cannot add more than 1 animal");
		}
		// mozemy tez zlapac ogolny wyjatek, jesli nie zostal obsluzony wczesniej przez konkretne bloki catch
		// zazwyczaj nie robi sie tego czesto (np. 1 miejsce w calej aplikacji, aby stworzyc ogolny handler i
		// zalogowac wyjatek)
		catch (Exception e) {
			// TODO: handle generic exception
		}
		zoo.feed();
		zoo.helloAll();
		System.out.println(zoo.countAllAnimals());
	}
}
