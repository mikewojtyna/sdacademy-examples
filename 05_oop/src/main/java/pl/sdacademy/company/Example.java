package pl.sdacademy.company;

import java.util.Collection;

public class Example {
	public static void main(String[] args) {
		Company company = createCompany();

		Employee janKowalski = new Employee("Jan", "Kowalski");
		company.addEmployee(janKowalski);
		Employee janAbacki = new Employee("Jan", "Abacki");
		company.addEmployee(janAbacki);

		Collection<Employee> allEmployeesMatchingLastName = company.findAllEmployeesByLastName("Abacki");

		System.out.println(allEmployeesMatchingLastName);
	}

	private static Company createCompany() {
		return new InMemoryCompany();
	}
}
