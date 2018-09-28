package pl.sdacademy.db;

import org.h2.jdbcx.JdbcDataSource;

import javax.sql.DataSource;

public class DataSourceFactory {
	public static DataSource createDataSource() {
		JdbcDataSource jdbcDataSource = new JdbcDataSource();
		jdbcDataSource.setUser("sa");
		jdbcDataSource.setPassword("sa");
		jdbcDataSource.setURL("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1");
		return jdbcDataSource;
	}
}
