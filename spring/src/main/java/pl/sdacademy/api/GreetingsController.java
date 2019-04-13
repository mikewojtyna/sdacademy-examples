package pl.sdacademy.api;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/greetings")
public class GreetingsController {

	private GreetingsRepository greetingsRepository;

	public GreetingsController(GreetingsRepository greetingsRepository) {
		this.greetingsRepository = greetingsRepository;
	}

	@GetMapping
	public Greeting hello() {
		return new Greeting("Hi and hello!", "goobar");
	}

	@PostMapping
	public void addGreeting(@RequestBody Greeting greeting) {
		greetingsRepository.save(greeting);
	}

	@GetMapping("/all")
	public Iterable<Greeting> allGreetings(@RequestParam(required = false) String greeting) {
		if (greeting != null) {
			return greetingsRepository.findByMsg(greeting);
		}
		return greetingsRepository.findAll();
	}
}
