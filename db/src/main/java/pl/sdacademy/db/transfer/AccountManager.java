package pl.sdacademy.db.transfer;

import java.util.Collection;

public interface AccountManager {
	void transfer(String from, String to, double howMuch) throws TransferFailedException;

	Collection<Account> allAccounts() throws AccountManagerException;
}
