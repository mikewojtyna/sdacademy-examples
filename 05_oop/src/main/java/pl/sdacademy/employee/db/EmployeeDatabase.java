package pl.sdacademy.employee.db;

import pl.sdacademy.employee.Employee;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class EmployeeDatabase {
	private Path pathToFile = Paths.get("files/employees-db.txt");

	/**
	 * Reads all employees from a database.
	 *
	 * @return a list containing all employees
	 */
	List<Employee> readAllEmployees() {
		try {
			List<String> lines = Files.readAllLines(pathToFile);
			List<Employee> employees = new ArrayList<>();

			for (String currentLine : lines) {
				String[] split = currentLine.split(" ");
				employees.add(new Employee(split[0], split[1], split[2], split[3]));
			}

			return employees;
		}
		catch (IOException e) {
			e.printStackTrace();
			return new ArrayList<>();
		}
	}

	/**
	 * Saves a new employee in the database.
	 *
	 * @param employee a new employee
	 * @throws CannotSaveEmployeeException thrown when employee cannot be saved
	 */
	void saveEmployee(Employee employee) throws CannotSaveEmployeeException {
		String line = employee.getFirstName() + " " + employee.getLastName() + " " + employee.getSex() + " " +
			employee.getBirthDate();
		try {
			Files.write(pathToFile, Arrays.asList(line), StandardOpenOption.CREATE, StandardOpenOption
				.APPEND);
		}
		catch (IOException originalException) {
			throw new CannotSaveEmployeeException("Cannot save a new employee", originalException);
		}
	}
}
