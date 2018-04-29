package pl.sdacademy.car;

class Car {
	private final Engine engine;
	private final Wheel[] wheels;
	private final Body body;
	private final Options options;

	Car(Engine engine, Wheel[] wheels, Body body) {
		// super() is always called implicitly - by default Object
		// class is the parent
		this.engine = engine;
		this.wheels = wheels;
		this.body = body;
		// init options object without any items
		options = Options.OptionsBuilder.begin().build();
	}

	Car(Engine engine, Wheel[] wheels, Body body, Options options) {
		// super() is always called implicitly - by default Object
		// class is the parent
		this.engine = engine;
		this.wheels = wheels;
		this.body = body;
		this.options = options;
	}

	Navigation getNavigation() {
		// options is always initialized - every constructor
		// initializes it
		return options.getNavigation();
	}

	AirConditioner getAirConditioner() {
		// options is always initialized - every constructor
		// initializes it
		return options.getAirConditioner();
	}

	Airbag getAirbag() {
		// options is always initialized - every constructor
		// initializes it
		return options.getAirbag();
	}
}
