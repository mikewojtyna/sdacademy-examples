package pl.sdacademy.company;

class Employee {
	private final String firstName;
	private final String lastName;

	Employee(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	Employee(String line) {
		String[] firstNameAndLastName = firstNameAndLastName(line);
		this.firstName = firstNameAndLastName[0];
		this.lastName = firstNameAndLastName[1];
	}

	private static String[] firstNameAndLastName(String line) {
		return line.split(" ");
	}

	String getLastName() {
		return lastName;
	}

	@Override
	public String toString() {
		return "Employee{" + "firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + '}';
	}

	String getFirstName() {
		return firstName;
	}
}
