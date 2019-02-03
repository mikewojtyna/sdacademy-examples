package pl.sdacademy.db.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class JdbcPreparedStatementUserFinder implements UserFinder {

	private Connection connection;

	public JdbcPreparedStatementUserFinder(Connection connection) {
		this.connection = connection;
	}

	@Override
	public Collection<User> findByName(String name) {
		try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE firstName = " +
			"?")) {
			statement.setString(1, name);
			ResultSet resultSet = statement.executeQuery();
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
