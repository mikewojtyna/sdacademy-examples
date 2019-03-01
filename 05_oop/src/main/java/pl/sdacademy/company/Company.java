package pl.sdacademy.company;


import java.util.Collection;

/**
 * An interface to access company database.
 */
interface Company {
	/**
	 * Adds a new employee to the company db.
	 *
	 * @param employee a new employee
	 */
	void addEmployee(Employee employee);

	/**
	 * Finds all employees with the given last name.
	 *
	 * @param lastName a last name
	 * @return all employees matching the criteria
	 */
	Collection<Employee> findAllEmployeesByLastName(String lastName);
}
