package pl.sdacademy.zoo;

class Main {
	public static void main(String[] args) {
		Zoo zoo = new Zoo();
		zoo.add(new Elephant("Adam"));
		zoo.add(new Parrot("Polly"));
		zoo.feed();
		zoo.helloAll();
		System.out.println(zoo.countAllAnimals());
	}
}
