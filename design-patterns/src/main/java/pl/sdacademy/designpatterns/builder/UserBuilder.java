package pl.sdacademy.designpatterns.builder;

import java.time.LocalDate;

public class UserBuilder {

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
