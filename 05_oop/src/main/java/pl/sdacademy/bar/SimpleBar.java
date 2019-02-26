package pl.sdacademy.bar;

class SimpleBar implements Bar {
	@Override
	public Drink order(Menu type) {
		if (Menu.BEER.equals(type)) {
			return createBeer();
		}
		throw new IllegalArgumentException("I have beer only!");
	}

	private Drink createBeer() {
		return new Beer();
	}

}
