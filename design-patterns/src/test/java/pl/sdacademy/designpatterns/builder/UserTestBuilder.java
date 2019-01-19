package pl.sdacademy.designpatterns.builder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.*;


public class UserTestBuilder {
	@DisplayName("should create a user with name and date of birth")
	@Test
	void test() throws Exception {
		// given
		String name = "goobar";
		LocalDate date = LocalDate.now();

		// when
		User user = UserBuilder.start().withName(name).withDateOfBirth(date).build();

		// then
		assertThat(user.getName()).isEqualTo(name);
		assertThat(user.getDateOfBirth()).hasValue(date);
		assertThat(user.getSurname()).isEmpty();
	}
}
