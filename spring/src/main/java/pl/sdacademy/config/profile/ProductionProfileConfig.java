package pl.sdacademy.config.profile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import pl.sdacademy.api.GreetingsRepository;

@Profile("production")
@Configuration
public class ProductionProfileConfig {
	@Bean
	public GreetingsService greetingsService(GreetingsRepository repo) {
		return new ProductionGreetingsService(repo);
	}
}
