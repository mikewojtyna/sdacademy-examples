package pl.sdacademy.db.jdbc;

import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.sdacademy.db.DataSourceFactory;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class JdbcIntegrationTest {

	private DataSource dataSource;

	@BeforeEach
	void beforeEach() {
		dataSource = createDataSource();
	}

	@DisplayName("show how to use transactions")
	@Test
	void transaction() throws Exception {
		// names to assert
		Collection<String> names = new ArrayList<>();
		try (Connection connection = dataSource.getConnection()) {
			// given
			// populate the db with "goobar" and "foobar"
			createTable(connection);
			populate(connection, "goobar", "foobar");
			PreparedStatement updateNameStatement = connection.prepareStatement("UPDATE Employee SET " +
				"name=? " + "WHERE name=?");

			// when
			// should update name from "goobar" to "hoobar"
			try {
				// start transaction
				connection.setAutoCommit(false);
				// update the name "goobar" to "hoobar"
				updateNameStatement.setString(1, "hoobar");
				updateNameStatement.setString(2, "goobar");
				updateNameStatement.executeUpdate();
				throwEx();
				// commit the transaction
				connection.commit();
			}
			catch (Exception e) {
				System.err.println("Got exception - transaction rollbacked!");
				e.printStackTrace();
				// rollback the changes in case of an error
				connection.rollback();
			}
			finally {
				// end the transaction - always
				connection.setAutoCommit(true);
			}
			// collect the committed names
			ResultSet resultSet = connection.createStatement().executeQuery("SELECT * FROM Employee");
			while (resultSet.next()) {
				String name = resultSet.getString("name");
				names.add(name);
			}
		}

		// then
		// no change should be made because transaction is rolled back (after throwEx() throws exception)
		assertThat(names).containsExactly("goobar", "foobar");
	}

	private void throwEx() {
		throw new RuntimeException();
	}

	@DisplayName("show how to use prepared statements")
	@Test
	void preparedStatement() throws Exception {
		// given
		String findByNameSql = "SELECT * from Employee WHERE name = ?";

		// when
		String foundFirstName;
		String foundSecondName;
		String foundThirdName;
		try (Connection connection = dataSource.getConnection()) {
			createTable(connection);
			populate(connection, "foobar", "goobar", "hoobar");
			PreparedStatement preparedStatement = connection.prepareStatement(findByNameSql);
			// invoke this statement for each employee
			// for foobar
			preparedStatement.setString(1, "foobar");
			ResultSet foobarRs = preparedStatement.executeQuery();
			foobarRs.next();
			foundFirstName = foobarRs.getString("name");
			// for goobar
			preparedStatement.setString(1, "goobar");
			ResultSet goobarRs = preparedStatement.executeQuery();
			goobarRs.next();
			foundSecondName = goobarRs.getString("name");
			// for hoobar
			preparedStatement.setString(1, "hoobar");
			ResultSet hoobarRs = preparedStatement.executeQuery();
			hoobarRs.next();
			foundThirdName = hoobarRs.getString("name");
		}

		// then
		assertThat(foundFirstName).isEqualTo("foobar");
		assertThat(foundSecondName).isEqualTo("goobar");
		assertThat(foundThirdName).isEqualTo("hoobar");
	}

	private void populate(Connection connection, String... names) throws Exception {
		PreparedStatement insertEmployeePreparedStatement =
			connection.prepareStatement("INSERT INTO Employee" + "(name) VALUES(?)");
		Stream.of(names).forEach(name -> {
			try {
				insertEmployeePreparedStatement.setString(1, name);
				insertEmployeePreparedStatement.execute();
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		});
	}

	private void createTable(Connection connection) throws SQLException {
		connection.prepareStatement("CREATE TABLE Employee(emp_id int PRIMARY KEY AUTO_INCREMENT, name " +
			"varchar" + "(30))").execute();
	}

	@DisplayName("should run create script and find goobar")
	@Test
	void runScript() throws Exception {
		// given
		DataSource ds = createDataSource();

		// when
		try (Connection connection = ds.getConnection()) {
			populateUsingScript(connection);
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM Employee");
			resultSet.next();
			int empId = resultSet.getInt("emp_id");
			String name = resultSet.getString("name");
			// then
			assertThat(empId).isGreaterThan(-1);
			assertThat(name).isEqualTo("goobar");
		}
	}

	private void populateUsingScript(Connection connection) throws Exception {
		String script = IOUtils.toString(getClass().getResourceAsStream("/create.sql"), "UTF-8");
		connection.createStatement().execute(script);
	}

	private void populateInline(Connection connection) throws SQLException {
		Statement statement = connection.createStatement();
		statement.execute("CREATE TABLE Employee (emp_id int PRIMARY KEY AUTO_INCREMENT, name  varchar(30))");
		statement.execute("INSERT INTO Employee(name) VALUES('goobar')");
	}

	private DataSource createDataSource() {
		return DataSourceFactory.anonymousH2();
	}
}
