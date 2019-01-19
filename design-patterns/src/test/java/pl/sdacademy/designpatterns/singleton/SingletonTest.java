package pl.sdacademy.designpatterns.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SingletonTest {
	@DisplayName("should get enum singleton")
	@Test
	void test() throws Exception {
		SingletonServiceEnum instance0 = SingletonServiceEnum.INSTANCE;
		SingletonServiceEnum instance1 = SingletonServiceEnum.INSTANCE;

		instance0.makeSomethingImportant();

		Assertions.assertThat(instance0 == instance1).isTrue();
	}

	@DisplayName("should get static singleton")
	@Test
	void test1() throws Exception {
		SingletonService instance0 = SingletonService.getInstance();
		SingletonService instance1 = SingletonService.getInstance();

		instance0.makeSomethingImportant();

		Assertions.assertThat(instance0 == instance1).isTrue();
	}
}
