package pl.sdacademy.db;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.h2.jdbcx.JdbcDataSource;

import javax.sql.DataSource;
import java.sql.SQLException;

public class DataSourceFactory {
	public static DataSource createDataSource() {
		return h2DataSource();
	}

	public static DataSource anonymousH2() {
		JdbcDataSource jdbcDataSource = new JdbcDataSource();
		jdbcDataSource.setUser("sa");
		jdbcDataSource.setPassword("sa");
		jdbcDataSource.setURL("jdbc:h2:mem:");
		return jdbcDataSource;
	}

	public static DataSource h2DataSource() {
		JdbcDataSource jdbcDataSource = new JdbcDataSource();
		jdbcDataSource.setUser("sa");
		jdbcDataSource.setPassword("sa");
		jdbcDataSource.setURL("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1");
		return jdbcDataSource;
	}

	public static DataSource mysqlDataSource() {
		try {
			MysqlDataSource jdbcDataSource = new MysqlDataSource();
			jdbcDataSource.setUser("root");
			jdbcDataSource.setCreateDatabaseIfNotExist(true);
			jdbcDataSource.setURL("jdbc:mysql://localhost/test");
			return jdbcDataSource;
		}
		catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
