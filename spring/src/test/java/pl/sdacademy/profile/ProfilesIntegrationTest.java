package pl.sdacademy.profile;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import pl.sdacademy.config.profile.DevGreetingsService;
import pl.sdacademy.config.profile.GreetingsService;
import pl.sdacademy.config.profile.ProductionGreetingsService;

import static org.assertj.core.api.Assertions.*;

public class ProfilesIntegrationTest {

	@DisplayName("dev profile tests")
	@Nested
	@SpringBootTest
	@ActiveProfiles("dev")
	class DevProfileIntegrationTest {
		@Autowired
		private GreetingsService greetingsService;

		@Value("${spring.application.name}")
		private String applicationName;

		@DisplayName("given dev profile, then load dev greetings service")
		@Test
		void test() throws Exception {
			assertThat(greetingsService).isInstanceOf(DevGreetingsService.class);
		}

		@DisplayName("given dev profile, then load dev application name from properties")
		@Test
		void test1() throws Exception {
			assertThat(applicationName).isEqualToIgnoringCase("dev app");
		}
	}

	@DisplayName("production profile tests")
	@Nested
	@SpringBootTest
	@ActiveProfiles("production")
	class ProductionProfileIntegrationTest {
		@Autowired
		private GreetingsService greetingsService;

		@Value("${spring.application.name}")
		private String applicationName;

		@DisplayName("given production profile, then load dev greetings service")
		@Test
		void test() throws Exception {
			assertThat(greetingsService).isInstanceOf(ProductionGreetingsService.class);
		}

		@DisplayName("given production profile, then load dev application name from properties")
		@Test
		void test1() throws Exception {
			assertThat(applicationName).isEqualToIgnoringCase("production app");
		}
	}
}
