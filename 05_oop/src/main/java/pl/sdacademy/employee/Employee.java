package pl.sdacademy.employee;

import java.util.Arrays;

public class Employee {
	private final String firstName;
	private final String lastName;
	private final String sex;
	private final String birthDate;
	private int height;
	private String[] interests;

	/**
	 * Creates a new employee with given parameters.
	 *
	 * @param firstName a first name
	 * @param lastName  a last name
	 * @param sex       a sex (male|female)
	 * @param birthDate a birth date
	 * @throws IllegalArgumentException thrown when sex is not "male" or "female"
	 */
	public Employee(String firstName, String lastName, String sex, String birthDate) throws
		IllegalArgumentException {
		this.firstName = firstName;
		this.lastName = lastName;
		if (isInvalid(sex)) {
			throw new IllegalArgumentException("Sex is invalid");
		}
		this.sex = sex;
		this.birthDate = birthDate;
		this.interests = new String[0];
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getSex() {
		return sex;
	}

	public String getBirthDate() {
		return birthDate;
	}

	private boolean isInvalid(String sex) {
		return !(sex.equals("male") || sex.equals("female"));
	}

	void setHeight(int height) {
		this.height = height;
	}

	void addNewInterest(String... interests) {
		for (String interest : interests) {
			addNewInterest(interest);
		}
	}

	void addNewInterest(String interest) {
		String[] oldInterests = interests;
		String[] newInterests = new String[oldInterests.length + 1];
		for (int i = 0; i < oldInterests.length; i++) {
			newInterests[i] = oldInterests[i];
		}
		newInterests[newInterests.length - 1] = interest;
		interests = newInterests;
	}

	@Override
	public String toString() {
		return "Employee{" + "firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + ", sex='" +
			sex + '\'' + ", birthDate='" + birthDate + '\'' + ", height=" + height + ", interests=" +
			Arrays.toString(interests) + '}';
	}
}
