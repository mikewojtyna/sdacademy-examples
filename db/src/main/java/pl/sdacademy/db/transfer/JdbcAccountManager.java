package pl.sdacademy.db.transfer;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class JdbcAccountManager implements AccountManager {
	private DataSource dataSource;

	public JdbcAccountManager(DataSource dataSource) {  // to jest pattern "dependency injection", który
		// wstrzyka wcześniej skonfigurowane data source (dependencies - zależności)
		this.dataSource = dataSource;
	}

	@Override
	public void transfer(String from, String to, double howMuch) {
		try (Connection connection = dataSource.getConnection()) {
			runInTransaction(connection, () -> {
				double originalAmountOfFromAccount = getAmount(connection, from);
				double originalAmountOfToAccount = getAmount(connection, to);
				setAmountOfMoney(connection, from, originalAmountOfFromAccount - howMuch);
				setAmountOfMoney(connection, to, originalAmountOfToAccount + howMuch);
			});
		}
		catch (SQLException e) {
			// wrap-owanie wyjątków, tzn. opakowywanie
			throw new TransferFailedException(String.format("Transfer from account %s to account %s with " + "amount %s failed because of SQL errors.", from, to, howMuch), e);
		}
	}

	@Override
	public Collection<Account> allAccounts() {
		try (Connection connection = dataSource.getConnection()) {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM accounts");
			ArrayList<Account> allAccounts = new ArrayList<>();
			while (resultSet.next()) {
				String accountNumber = resultSet.getString("accountNumber");
				double amountOfMoney = resultSet.getDouble("amountOfMoney");
				Account account = new Account(accountNumber, amountOfMoney);
				allAccounts.add(account);
			}
			return allAccounts;
		}
		catch (SQLException e) {
			throw new AccountManagerException("Failed to find all accounts.", e);
		}
	}

	private void setAmountOfMoney(Connection connection, String accountNumber, double newAmount) throws SQLException {
		PreparedStatement transferStatement = connection.prepareStatement(
			// @formatter:off
						"UPDATE accounts SET amountOfMoney = ? WHERE accountNumber = ?"
						// @formatter:on
		);
		transferStatement.setString(2, accountNumber);
		transferStatement.setDouble(1, newAmount);
		transferStatement.execute();
	}

	private double getAmount(Connection connection, String accountNumber) throws SQLException {
		PreparedStatement amountQuery = connection.prepareStatement(
			// @formatter:off
					"SELECT amountOfMoney from accounts WHERE accountNumber = ?"
					// @formatter:on
		);
		amountQuery.setString(1, accountNumber);
		ResultSet amountQueryResultSet = amountQuery.executeQuery();
		amountQueryResultSet.next();
		return amountQueryResultSet.getDouble(1);
	}

	private void runInTransaction(Connection connection, ThrowingRunnable runnable) {
		try {
			boolean initialAutoCommitValue = connection.getAutoCommit();
			connection.setAutoCommit(false);

			try {
				runnable.run();
				connection.commit();
			}
			catch (Exception e) {
				connection.rollback();
			}
			finally {
				connection.setAutoCommit(initialAutoCommitValue);
			}
		}
		catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
