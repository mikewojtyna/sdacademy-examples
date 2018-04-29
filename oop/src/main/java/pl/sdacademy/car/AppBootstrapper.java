package pl.sdacademy.car;

class AppBootstrapper {
	static void start() {
		// create car without options
		Car carWithoutOptions = new Car(new Engine(), Wheel.fourWheels
			(), new Body());
		printOptions(carWithoutOptions, "carWithoutOptions");
		// create car with navigation
		Car carWithNavigation = new Car(new Engine(), Wheel.fourWheels
			(), new Body(), Options.OptionsBuilder.begin()
			.withNavigation(new Navigation()).build());
		printOptions(carWithNavigation, "carWithNavigation");

		// So, now how do I enable options dynamically?
		Options options = enableOptions();
		Car carWithDynamicOptions = new Car(new Engine(), Wheel
			.fourWheels(), new Body(), options);
		printOptions(carWithDynamicOptions, "carWithDynamicOptions");

		// We can also easily "chain-add" any number of optional
		// equipments (that's called "fluent interface").
		// Note that order of invocations doesn't matter.
		Options allOptions = Options.OptionsBuilder.begin().withAirbag
			(new Airbag()).withAirConditioner(new AirConditioner()
		).withNavigation(new Navigation()).build();
		Car carWithAllOptions = new Car(new Engine(), Wheel.fourWheels
			(), new Body(), allOptions);
		printOptions(carWithAllOptions, "carWithAllOptions");
	}

	private static void printOptions(Car car, String name) {
		System.out.println(name + ".getNavigation() = " + car
			.getNavigation());
		System.out.println(name + ".getAirConditioner() = " + car
			.getAirConditioner());
		System.out.println(name + ".getAirbag() = " + car.getAirbag());
		System.out.println("-------------------------");
	}

	private static Options enableOptions() {
		Options.OptionsBuilder optionsBuilder = Options.OptionsBuilder
			.begin();
		if (clientPaidForNavigation()) {
			optionsBuilder.withNavigation(new Navigation());
		}
		if (clientPaidForAirConditioner()) {
			optionsBuilder.withAirConditioner(new AirConditioner
				());
		}
		if (clientPaidForAirbag()) {
			optionsBuilder.withAirbag(new Airbag());
		}
		return optionsBuilder.build();
	}

	private static boolean clientPaidForAirbag() {
		return true;
	}

	private static boolean clientPaidForAirConditioner() {
		// no air conditioner for you!
		return false;
	}

	private static boolean clientPaidForNavigation() {
		return true;
	}
}
