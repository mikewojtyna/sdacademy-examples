package pl.sdacademy.db.transfer;

public class TransferFailedException extends AccountManagerException {
	public TransferFailedException(String message) {
		super(message);
	}

	public TransferFailedException(String message, Throwable cause) {
		super(message, cause);
	}
}
