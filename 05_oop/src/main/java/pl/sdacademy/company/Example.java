package pl.sdacademy.company;

import java.util.Collection;

public class Example {
	public static void main(String[] args) {
		Company company = createCompany();

		Employee janAbacki = new Employee("Jan", "Abacki");
		company.addEmployee(janAbacki);
		Employee janKowalski = new Employee("Jan", "Kowalski");
		company.addEmployee(janKowalski);

		Collection<Employee> allEmployeesMatchingLastName = company.findAllEmployeesByLastName("Abacki");

		System.out.println(allEmployeesMatchingLastName);
	}

	private static Company createCompany() {
		return new InMemoryCompany();
		// return new FileCompany(Paths.get("files", "employees-db.txt"), Charset.forName("UTF-8"));
	}
}
