package pl.sdacademy.config.profile;

import pl.sdacademy.api.Greeting;
import pl.sdacademy.api.GreetingsRepository;

public class ProductionGreetingsService implements GreetingsService {

	private GreetingsRepository greetingsRepository;

	public ProductionGreetingsService(GreetingsRepository greetingsRepository) {
		this.greetingsRepository = greetingsRepository;
	}

	@Override
	public String sayHi() {
		return greetingsRepository.findByMsg("hi").stream().map(Greeting::getMsg).findAny().orElse("default " + "greeting");
	}
}
