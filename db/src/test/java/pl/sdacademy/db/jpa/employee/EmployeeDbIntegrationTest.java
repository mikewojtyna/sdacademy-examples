package pl.sdacademy.db.jpa.employee;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class EmployeeDbIntegrationTest {

	private EntityManagerFactory factory;

	@BeforeEach
	void beforeEach() {
		factory = Persistence.createEntityManagerFactory("test");
	}

	@AfterEach
	void afterEach() {
		factory.close();
	}

	@DisplayName("should save department with two employees")
	@Test
	void department() {
		// given
		EntityManager entityManager = factory.createEntityManager();
		Employee goobar = employeeWithName("goobar");
		Employee foobar = employeeWithName("foobar");
		Department department = departmentWithEmployees(goobar, foobar);

		// when
		// begin transaction
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(department);
		// commit transaction
		transaction.commit();

		// then
		Department foundDepartment = entityManager.createQuery("SELECT dep FROM Department " + "dep",
			Department.class).getSingleResult();
		assertThat(foundDepartment.getEmployees()).extracting("name").containsExactlyInAnyOrder("goobar",
			"foobar");
	}

	private Department departmentWithEmployees(Employee... employees) {
		Department department = new Department();
		department.setEmployees(Arrays.asList(employees));
		return department;
	}

	private Employee employeeWithName(String name) {
		Employee employee = new Employee();
		employee.setName(name);
		return employee;
	}
}
