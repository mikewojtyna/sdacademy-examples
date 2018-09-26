package pl.sdacademy.db.executor;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class ClasspathSqlScriptExecutor implements SqlScriptExecutor {
	private Connection connection;

	public ClasspathSqlScriptExecutor(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void execute(String classpath) throws SqlScriptExecutorException {
		try {
			String sql = IOUtils.toString(getClass().getResourceAsStream("/" + classpath), "UTF-8");
			connection.createStatement().execute(sql);
		}
		catch (IOException | SQLException e) {
			throw new SqlScriptExecutorException(String.format("Failed to execute script %s", classpath),
				e);
		}
	}
}
