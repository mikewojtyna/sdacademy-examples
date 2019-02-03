package pl.sdacademy.db.jdbc;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Collection;

import static org.assertj.core.api.Assertions.*;


public class UserFinderTest {

	@DisplayName("should find user by name")
	@Test
	void test() throws Exception {
		try (Connection connection = DriverManager.getConnection("jdbc:h2:mem:")) {
			// given
			UserPopulator userPopulator = new JdbcUserPopulator(connection);
			UserFinder userFinder = new JdbcUserFinder(connection);
			// create some users in the db
			User goobar = userWithName("goobar");
			User foobar = userWithName("foobar");
			User hoobar = userWithName("hoobar");
			userPopulator.populateDbWith(goobar, foobar, hoobar);

			// when
			Collection<User> users = userFinder.findByName("goobar");

			// then
			assertThat(users).containsOnly(goobar);
		}
	}

	private User userWithName(String name) {
		return new User(name, "any surname");
	}
}
