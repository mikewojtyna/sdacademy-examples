package pl.sdacademy.box;

public class CannotAddElementException extends RuntimeException {
	public CannotAddElementException(String message) {
		super(message);
	}

	public CannotAddElementException(String message, Throwable cause) {
		super(message, cause);
	}
}
