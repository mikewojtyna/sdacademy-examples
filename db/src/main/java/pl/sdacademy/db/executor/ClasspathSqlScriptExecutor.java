package pl.sdacademy.db.executor;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ClasspathSqlScriptExecutor implements SqlScriptExecutor {
	private Connection connection;

	public ClasspathSqlScriptExecutor(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void execute(String classpath) throws SqlScriptExecutorException {
		try {
			InputStream sqlScriptInputStream = getClass().getResourceAsStream("/" + classpath);
			String sql = IOUtils.toString(sqlScriptInputStream, "UTF-8");
			Statement statement = connection.createStatement();
			statement.execute(sql);
		}
		catch (IOException | SQLException e) {
			throw new SqlScriptExecutorException(String.format("Failed to execute script %s", classpath),
				e);
		}
	}
}
