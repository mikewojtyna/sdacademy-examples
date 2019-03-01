package pl.sdacademy.company;

import java.util.Collection;
import java.util.Scanner;

class CommandLineInterface implements AutoCloseable {
	private Company company;
	private Scanner scanner;

	public CommandLineInterface(Company company) {
		this.company = company;
		scanner = new Scanner(System.in);
		scanner.useDelimiter("\n");
	}

	void initInterface() {
		addSingleData();
		findEmployees();
	}

	private void addSingleData() {
		System.out.println("Enter new employee data in format: [<firstName> <lastName>]");
		// e.g.: George Martin
		String firstNameAndLastName = scanner.next();
		Employee employee = new Employee(firstNameAndLastName);
		company.addEmployee(employee);
	}

	private void findEmployees() {
		System.out.println("Enter last name to find the employee");
		String lastName = scanner.next();
		Collection<Employee> employees = company.findAllEmployeesByLastName(lastName);
		System.out.println(employees);
	}

	@Override
	public void close() {
		scanner.close();
	}
}
