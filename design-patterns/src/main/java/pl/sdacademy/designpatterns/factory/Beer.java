package pl.sdacademy.designpatterns.factory;

class Beer extends Drink {

	@Override
	protected String name() {
		return "beer";
	}
}
