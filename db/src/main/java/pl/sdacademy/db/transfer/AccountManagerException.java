package pl.sdacademy.db.transfer;

public class AccountManagerException extends RuntimeException {
	public AccountManagerException(String message) {
		super(message);
	}

	public AccountManagerException(String message, Throwable cause) {
		super(message, cause);
	}
}
