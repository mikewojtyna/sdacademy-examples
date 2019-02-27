package pl.sdacademy.zoo;

public class MaximumCapacityExceededException extends RuntimeException {
	public MaximumCapacityExceededException(String message) {
		super(message);
	}

	public MaximumCapacityExceededException(String message, Throwable cause) {
		super(message, cause);
	}
}
