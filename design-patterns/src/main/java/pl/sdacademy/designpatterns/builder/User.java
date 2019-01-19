package pl.sdacademy.designpatterns.builder;

import java.time.LocalDate;
import java.util.Optional;

public class User {
	private String name;
	private String surname;
	private LocalDate dateOfBirth;

	User(String name, String surname, LocalDate dateOfBirth) {
		this.name = name;
		this.surname = surname;
		this.dateOfBirth = dateOfBirth;
	}

	public String getName() {
		return name;
	}

	public Optional<String> getSurname() {
		return Optional.ofNullable(surname);
	}

	public Optional<LocalDate> getDateOfBirth() {
		return Optional.ofNullable(dateOfBirth);
	}
}
