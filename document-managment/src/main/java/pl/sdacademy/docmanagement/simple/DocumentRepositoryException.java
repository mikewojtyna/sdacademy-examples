package pl.sdacademy.docmanagement.simple;

public class DocumentRepositoryException extends RuntimeException {
	public DocumentRepositoryException(String message) {
		super(message);
	}

	public DocumentRepositoryException(String message, Throwable cause) {
		super(message, cause);
	}
}
