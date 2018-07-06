package pl.sdacademy.employee.db;

import pl.sdacademy.employee.Employee;

import java.util.List;

public class EmployeesMain {
	public static void main(String[] args) {
		EmployeeDatabase employeeDatabase = new EmployeeDatabase();

		Employee employee0 = new Employee("George", "Martin", "male", "11-01-1011");
		employeeDatabase.saveEmployee(employee0);
		Employee employee1 = new Employee("Martin", "John", "male", "01-01-1012");
		employeeDatabase.saveEmployee(employee1);
		Employee employee2 = new Employee("Ragnar", "Bloodhammer", "male", "01-01-1011");
		employeeDatabase.saveEmployee(employee2);

		List<Employee> employees = employeeDatabase.readAllEmployees();

		for (Employee employee : employees) {
			System.out.println(employee);
		}
	}
}
