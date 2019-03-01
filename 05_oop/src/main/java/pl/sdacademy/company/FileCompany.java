package pl.sdacademy.company;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class FileCompany implements Company {

	private Path pathToEmployeesFile;
	private Charset charset;

	FileCompany(Path pathToEmployeesFile, Charset charset) {
		this.pathToEmployeesFile = pathToEmployeesFile;
		this.charset = charset;
	}

	@Override
	public void addEmployee(Employee employee) {
		List<String> singleEmployeeLine = Collections.singletonList(convertToString(employee));
		try {
			Files.write(pathToEmployeesFile, singleEmployeeLine, charset, StandardOpenOption.CREATE,
				StandardOpenOption.APPEND);
		}
		catch (IOException e) {
			String msg = String.format("Failed to add employee %s to company db. Cannot access the db " +
				"file" + " %s.", employee, pathToEmployeesFile);
			throw wrapException(msg, e);
		}
	}

	private RuntimeException wrapException(String detailedMesage, IOException cause) {
		return new RuntimeException(detailedMesage, cause);
	}

	private String convertToString(Employee employee) {
		return employee.getFirstName() + " " + employee.getLastName();
	}

	@Override
	public Collection<Employee> findAllEmployeesByLastName(String lastName) {
		try {
			return Files.
				lines(pathToEmployeesFile, charset).map(line -> new Employee(line)).filter(employee -> employee.getLastName().equals(lastName)).collect(Collectors.toList());
		}
		catch (IOException e) {
			throw wrapException(String.format("Failed to find employees from file %s",
				pathToEmployeesFile), e);
		}
	}
}
