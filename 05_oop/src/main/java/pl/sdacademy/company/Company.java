package pl.sdacademy.company;


import java.util.Collection;

interface Company {
	void addEmployee(Employee employee);

	Collection<Employee> findAllEmployeesByLastName(String lastName);
}
