package pl.sdacademy.db.jdbc;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Objects;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Fail.fail;

class JdbcHelloWorldIntegrationTest {
	@DisplayName("show how to connect to h2 using JDBC")
	@Test
	void test0() throws Exception {
		try (Connection connection = DriverManager.getConnection("jdbc:h2:mem:test")) {
			Statement statement = connection.createStatement();
			statement.execute("CREATE TABLE test_table(id int primary key)");
			statement.execute("INSERT INTO test_table(id) VALUES (1)");

			ResultSet resultSet = statement.executeQuery("SELECT * FROM test_table");
			resultSet.next();
			int id = resultSet.getInt("id");

			assertThat(id).isEqualTo(1);
		}
	}

	@DisplayName("should create two tweets and read them as objects")
	@Test
	void test1() {
		// 1. Create connection to the database
		// 2. Create a Tweet table with id and message columns
		// 3. Read all tweet records and translate them to Tweet objects again
		// 4. Assert that read tweets have the same messages as we saved in the database
		fail("Write your test");
	}

	private class Tweet {
		private int id;
		private String message;

		public Tweet(int id, String message) {
			this.id = id;
			this.message = message;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) {
				return true;
			}
			if (o == null || getClass() != o.getClass()) {
				return false;
			}
			Tweet tweet = (Tweet) o;
			return Objects.equals(message, tweet.message);
		}

		@Override
		public int hashCode() {

			return Objects.hash(message);
		}
	}


}
