package pl.sdacademy.db.jdbc;

import java.util.Objects;

public class User {
	private String name;
	private String surname;
	private int id;

	public User(String name, String surname, int id) {
		this.name = name;
		this.surname = surname;
		this.id = id;
	}

	public User(String name, String surname) {
		this.name = name;
		this.surname = surname;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		User user = (User) o;
		return Objects.equals(name, user.name) && Objects.equals(surname, user.surname);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, surname);
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	@Override
	public String toString() {
		return "User{" + "name='" + name + '\'' + ", surname='" + surname + '\'' + ", id=" + id + '}';
	}

}
