package pl.sdacademy.db.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUserPopulator implements UserPopulator {

	private Connection connection;

	public JdbcUserPopulator(Connection connection) {
		this.connection = connection;
		createSchema();
	}

	private void createSchema() {
		try (Statement statement = connection.createStatement()) {
			// @formatter:off
			statement.execute(
				"CREATE TABLE users(id int PRIMARY KEY auto_increment, firstName varchar(100), " +
				    "surname varchar(100))");
			// @formatter:on
		}
		catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	@Override
	public void populateDbWith(User... users) {
		try {

			try (PreparedStatement insertStatement = connection.prepareStatement(
				// @formatter:off
				"INSERT INTO users(firstName, surname) VALUES(?, ?)")
			    	// @formatter:on
			) {
				for (User user : users) {
					insertStatement.setString(1, user.getName());
					insertStatement.setString(2, user.getSurname());
					insertStatement.execute();
				}
			}
		}
		catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}
}
