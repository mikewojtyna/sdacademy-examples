package pl.sdacademy.db.executor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.sdacademy.db.DataSourceFactory;
import pl.sdacademy.db.DbCleaner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import static org.assertj.core.api.Assertions.*;

class ScriptExecutorIntegrationTest {
	private DataSource dataSource;

	@BeforeEach
	void beforeEach() throws Exception {
		dataSource = DataSourceFactory.createDataSource();
		DbCleaner.clean("any_table", dataSource);
	}

	@DisplayName("should execute script using script executor")
	@Test
	void test() throws Exception {
		// given
		SqlScriptExecutor executor = new ClasspathSqlScriptExecutor(dataSource);

		// when
		executor.execute("executor-test-script.sql");

		// then
		try (Connection connection = dataSource.getConnection(); Statement statement = connection
			.createStatement()) {
			ResultSet resultSet = statement.executeQuery("SELECT id " + "FROM " + "" + "any_table");
			resultSet.next();
			assertThat(resultSet.getInt("id")).isEqualTo(1);
		}
	}
}
