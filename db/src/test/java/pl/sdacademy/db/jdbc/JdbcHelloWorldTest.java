package pl.sdacademy.db.jdbc;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class JdbcHelloWorldTest {
	@DisplayName("show how to connect to database using jdbc")
	@Test
	void test() throws Exception {
		try (Connection connection = DriverManager.getConnection("jdbc:h2:mem:"); Statement statement =
			connection.createStatement()) {
			statement.execute("CREATE TABLE my_table(id int auto_increment, name varchar(30))");
			statement.execute("INSERT INTO my_table(name) VALUES('goobar')");
			ResultSet resultSet = statement.executeQuery("SELECT * FROM my_table");
			resultSet.next();
			String name = resultSet.getString("name");
			
			assertThat(name).isEqualTo("goobar");
		}
	}
}
