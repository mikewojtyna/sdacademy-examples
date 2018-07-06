package pl.sdacademy.employee.db;

class CannotSaveEmployeeException extends RuntimeException {

	CannotSaveEmployeeException(String message) {
		super(message);
	}

	CannotSaveEmployeeException(String message, Throwable cause) {
		super(message, cause);
	}
}
