package pl.sdacademy.car;

// Generally speaking this class is ok. However, we should not hardcode all
// available option types inside it. Using generic array would be probably a
// better idea. We don't really need to have specific class for every type of
// equipment.
class Options {
	private final Navigation navigation;
	private final AirConditioner airConditioner;
	private Airbag airbag;

	// Note this constructor is private! It's here only to be used by
	// OptionsBuilder.build() method.
	private Options(Navigation navigation, AirConditioner airConditioner,
			Airbag airbag) {
		this.navigation = navigation;
		this.airConditioner = airConditioner;
		this.airbag = airbag;
	}

	Navigation getNavigation() {
		return navigation;
	}

	Airbag getAirbag() {
		return airbag;
	}

	AirConditioner getAirConditioner() {
		return airConditioner;
	}

	static class OptionsBuilder {
		private Navigation navigation;
		private AirConditioner airConditioner;
		private Airbag airbag;

		static OptionsBuilder begin() {
			return new OptionsBuilder();
		}

		OptionsBuilder withNavigation(Navigation navigation) {
			this.navigation = navigation;
			return this;
		}

		OptionsBuilder withAirConditioner(AirConditioner
							  airConditioner) {
			this.airConditioner = airConditioner;
			return this;
		}

		OptionsBuilder withAirbag(Airbag airbag) {
			this.airbag = airbag;
			return this;
		}

		Options build() {
			return new Options(navigation, airConditioner, airbag);
		}
	}
}
