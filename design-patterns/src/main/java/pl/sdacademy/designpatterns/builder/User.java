package pl.sdacademy.designpatterns.builder;

import java.time.LocalDate;
import java.util.Optional;

public class User {
	private final String name;
	private final String surname;
	private final LocalDate dateOfBirth;

	private User(String name, String surname, LocalDate dateOfBirth) {
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

	public static class UserBuilder {

		private String name;
		private String surname;
		private LocalDate dateOfBirth;

		private UserBuilder() {

		}

		static UserBuilder start() {
			return new UserBuilder();
		}

		UserBuilder withName(String name) {
			this.name = name;
			return this;
		}

		UserBuilder withSurname(String surname) {
			this.surname = surname;
			return this;
		}

		UserBuilder withDateOfBirth(LocalDate date) {
			this.dateOfBirth = date;
			return this;
		}

		User build() {
			if (name == null) {
				throw new IllegalStateException("Cannot create a user without a name");
			}
			return new User(name, surname, dateOfBirth);
		}
	}
}
