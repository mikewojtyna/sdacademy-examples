package pl.sdacademy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class SpringContextIntegrationTest {

	@Autowired
	private ApplicationContext context;

	@DisplayName("should load context")
	@Test
	public void contextLoads() {
		assertThat(context).isNotNull();
	}
}
