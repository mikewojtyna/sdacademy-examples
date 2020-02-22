package pl.sdacademy.db.transfer;

import org.h2.jdbcx.JdbcDataSource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;

import static org.assertj.core.api.Assertions.*;

public class TransferMoneyIntegrationTest {

	private DataSource dataSource;

	@BeforeEach
	void initDataSource() {
		JdbcDataSource h2DataSource = new JdbcDataSource();
		h2DataSource.setUrl("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1");
		dataSource = h2DataSource;
	}

	// @formatter:off
	@DisplayName(
		"given account A and account B with original amounts equal to $100 and $200, " +
		"when transfer $50 from account A to account B, " +
		"then amount of account A is now $50 and amount of account B is $250"
	)
	// @formatter:on
	@Test
	void test() throws Exception {
		// given
		createBankSchema();
		populateDb("A", 100, "B", 200);
		AccountManager transferManager = new JdbcAccountManager(dataSource);

		// when
		transferManager.transfer("A", "B", 50);

		// then
		Collection<Account> accounts = transferManager.allAccounts();
		Account accountA = getAccount("A", accounts);
		assertThat(accountA.getAmount()).isEqualTo(50);
		Account accountB = getAccount("B", accounts);
		assertThat(accountB.getAmount()).isEqualTo(250);
	}

	private Account getAccount(String accountNumber, Collection<Account> accounts) {
		return accounts.stream().filter(account -> accountNumber.equals(account.getAccountNumber())).findAny().get();
	}

	private void populateDb(String firstAccountNumber, double firstAccountAmount, String secondAccountNumber,
				double secondAccountAmount) throws SQLException {
		try (Connection connection = dataSource.getConnection()) {
			PreparedStatement insertStatement = connection.prepareStatement("INSERT INTO accounts" +
				"(accountNumber, amountOfMoney) VALUES(?, ?)");
			insertStatement.setString(1, firstAccountNumber);
			insertStatement.setDouble(2, firstAccountAmount);
			insertStatement.execute();

			insertStatement.setString(1, secondAccountNumber);
			insertStatement.setDouble(2, secondAccountAmount);
			insertStatement.execute();
		}
	}

	private void createBankSchema() throws SQLException {
		try (Connection connection = dataSource.getConnection()) {
			Statement statement = connection.createStatement();
			statement.execute("CREATE TABLE accounts(id int auto_increment, accountNumber varchar(100), " + "amountOfMoney " + "double)");
		}
	}


}
