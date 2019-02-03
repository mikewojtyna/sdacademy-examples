package pl.sdacademy.db.jdbc;

import org.h2.jdbcx.JdbcDataSource;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class JdbcHelloWorldTest {
	@DisplayName("show how to connect to database using jdbc driver manager")
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

	@DisplayName("show how to connect to database using jdbc data source")
	@Test
	void test1() throws Exception {
		DataSource dataSource = createH2DataSource();

		try (Connection connection = dataSource.getConnection(); Statement statement =
			connection.createStatement()) {
			statement.execute("CREATE TABLE my_table(id int auto_increment, name varchar(30))");
			statement.execute("INSERT INTO my_table(name) VALUES('goobar')");
			ResultSet resultSet = statement.executeQuery("SELECT * FROM my_table");
			resultSet.next();
			String name = resultSet.getString("name");

			assertThat(name).isEqualTo("goobar");
		}
	}

	private DataSource createH2DataSource() {
		JdbcDataSource dataSource = new JdbcDataSource();
		dataSource.setUrl("jdbc:h2:mem:");
		return dataSource;
	}
}
