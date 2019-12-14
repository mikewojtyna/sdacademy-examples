package pl.sdacademy.config.profile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class DevProfileConfig {
	@Bean
	public GreetingsService myService() {
		return new DevGreetingsService();
	}
}
