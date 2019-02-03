package pl.sdacademy.db.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

public class JdbcStatementUserFinder implements UserFinder {

	private Connection connection;

	public JdbcStatementUserFinder(Connection connection) {
		this.connection = connection;
	}

	@Override
	public Collection<User> findByName(String name) {
		try (Statement statement = connection.createStatement()) {
			ResultSet resultSet =
				statement.executeQuery("SELECT * FROM users WHERE firstName = '" + name + "'");
			Collection<User> users = new ArrayList<>();
			while (resultSet.next()) {
				int userId = resultSet.getInt("id");
				String userName = resultSet.getString("firstName");
				String userSurname = resultSet.getString("surname");
				User user = new User(userName, userSurname, userId);
				users.add(user);
			}
			return users;
		}
		catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}
}
