package pl.sdacademy.db.executor;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Fail.fail;

class ScriptExecutorIntegrationTest {
	@DisplayName("should execute script using script executor")
	@Test
	void test() throws Exception {
		// given
		SqlScriptExecutor executor = null;

		// when
		executor.execute("executor-test-script.sql");

		// then
		// 1. Open the connection to the db
		// 2. Read the row inserted by executor-test-script
		// 3. Assert that row contains the same test data
		try (Connection connection = DriverManager.getConnection("url")) {
			ResultSet resultSet = connection.createStatement().executeQuery("SELECT id " + "FROM " +
				"any_table");
			resultSet.next();

			assertThat(resultSet.getInt("id")).isEqualTo("1");
		}
		fail("Write your test");
	}
}
