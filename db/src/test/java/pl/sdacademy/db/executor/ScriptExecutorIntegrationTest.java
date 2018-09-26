package pl.sdacademy.db.executor;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import static org.assertj.core.api.Assertions.*;

class ScriptExecutorIntegrationTest {
	@DisplayName("should execute script using script executor")
	@Test
	void test() throws Exception {
		try (Connection connection = DriverManager.getConnection("jdbc:h2:mem:test")) {
			// given
			SqlScriptExecutor executor = new ClasspathSqlScriptExecutor(connection);

			// when
			executor.execute("executor-test-script.sql");

			// then
			ResultSet resultSet = connection.createStatement().executeQuery("SELECT id " + "FROM " +
				"any_table");
			resultSet.next();
			assertThat(resultSet.getInt("id")).isEqualTo(1);
		}
	}
}
