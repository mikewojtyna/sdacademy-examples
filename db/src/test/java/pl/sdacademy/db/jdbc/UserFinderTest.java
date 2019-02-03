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
			UserFinder userFinder = new JdbcStatementUserFinder(connection);
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

	@DisplayName("should allow to execute sql injection using statement user finder")
	@Test
	void test1() throws Exception {
		try (Connection connection = DriverManager.getConnection("jdbc:h2:mem:")) {
			// given
			UserPopulator userPopulator = new JdbcUserPopulator(connection);
			UserFinder userFinder = new JdbcStatementUserFinder(connection);
			// create some users in the db
			User goobar = userWithName("goobar");
			User foobar = userWithName("foobar");
			User hoobar = userWithName("hoobar");
			userPopulator.populateDbWith(goobar, foobar, hoobar);

			// when
			// now, the real SQL looks like this
			// SELECT * FROM users WHERE firstName = '' OR ''=''
			Collection<User> users = userFinder.findByName("' OR ''='");

			// then
			assertThat(users).containsExactlyInAnyOrder(goobar, foobar, hoobar);
		}
	}

	@DisplayName("should not allow to execute sql injection using prepared statement user finder")
	@Test
	void test2() throws Exception {
		try (Connection connection = DriverManager.getConnection("jdbc:h2:mem:")) {
			// given
			UserPopulator userPopulator = new JdbcUserPopulator(connection);
			UserFinder userFinder = new JdbcPreparedStatementUserFinder(connection);
			// create some users in the db
			User goobar = userWithName("goobar");
			User foobar = userWithName("foobar");
			User hoobar = userWithName("hoobar");
			userPopulator.populateDbWith(goobar, foobar, hoobar);

			// when
			// because we prepared statements inside the JdbcPreparedStatementUserFinder, we are unable
			// to execute SQL injection, because name param is EXACTLY equal to ' OR ''='
			Collection<User> users = userFinder.findByName("' OR ''='");

			// then
			assertThat(users).isEmpty();
		}
	}

	private User userWithName(String name) {
		return new User(name, "any surname");
	}
}
