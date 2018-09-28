package pl.sdacademy.db;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DbCleaner {
	public static void clean(String tableName, DataSource dataSource) throws SQLException {
		try (Connection connection = dataSource.getConnection(); Statement statement = connection
			.createStatement()) {
			statement.execute("DROP TABLE IF EXISTS " + tableName);
		}
	}
}
