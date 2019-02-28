package pl.sdacademy.company;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public class InMemoryCompany implements Company {
	private Collection<Employee> employees;

	public InMemoryCompany() {
		employees = new ArrayList<>();
	}

	@Override
	public void addEmployee(Employee employee) {
		employees.add(employee);
	}

	@Override
	public Collection<Employee> findAllEmployeesByLastName(String lastName) {
		return employees.stream().
			filter(employee -> lastName.equals(employee.getLastName())).collect(Collectors.toList());
	}
}
