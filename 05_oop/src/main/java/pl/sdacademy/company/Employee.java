package pl.sdacademy.company;

public class Employee {
	private final String firstName;
	private final String lastName;

	public Employee(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getLastName() {
		return lastName;
	}

	@Override
	public String toString() {
		return "Employee{" + "firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + '}';
	}
}
