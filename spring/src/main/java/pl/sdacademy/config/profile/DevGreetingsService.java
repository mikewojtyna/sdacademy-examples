package pl.sdacademy.config.profile;

public class DevGreetingsService implements GreetingsService {
	@Override
	public String sayHi() {
		return "hi!";
	}
}
