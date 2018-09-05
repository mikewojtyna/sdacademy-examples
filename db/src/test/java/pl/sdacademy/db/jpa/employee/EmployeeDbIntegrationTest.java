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

	/**
	 * @see <a href="https://vladmihalcea.files.wordpress.com/2014/07/jpaentitystates.png">See how JPA manages
	 * transition states</a>
	 */
	@DisplayName("create new department in first transaction, next create a new query in another transaction, " +
		"then set new department name and finally assert that this name is updated on commit")
	@Test
	void managedCase() {
		// given
		EntityManager entityManager = factory.createEntityManager();
		// right now, this is a transient entity - not managed by JPA context
		Department newDepartment = new Department();
		String findDepartmentQueryJpql = "SELECT dep FROM Department dep";

		// when
		// create new department in first transaction
		EntityTransaction departmentTransaction = entityManager.getTransaction();
		departmentTransaction.begin();
		newDepartment.setName("Fabryka Azbestu Sp. z o. o.");
		entityManager.persist(newDepartment);
		departmentTransaction.commit();
		// create a new query in another transaction...
		EntityTransaction updateDepNameTransaction = entityManager.getTransaction();
		updateDepNameTransaction.begin();
		Department foundDepartment = entityManager.createQuery(findDepartmentQueryJpql, Department.class)
			.getSingleResult();
		// ... And update the name of the department
		foundDepartment.setName("Fabryka Bezglutenowego Azbestu Sp. z o. o.");
		updateDepNameTransaction.commit();

		// then
		Department updatedDepartment = entityManager.createQuery(findDepartmentQueryJpql, Department.class)
			.getSingleResult();
		assertThat(updatedDepartment.getName()).isEqualTo("Fabryka Bezglutenowego Azbestu Sp. z o. o.");
	}

	/**
	 * @see <a href="https://vladmihalcea.files.wordpress.com/2014/07/jpaentitystates.png">See how JPA manages
	 * transition states</a>
	 */
	@DisplayName("create new department and persist it, next create another department with the same id but " +
		"different properties, and merge this new department and finally assert that original department is "
		+ "updated")
	@Test
	void mergeCase() {
		// given
		EntityManager entityManager = factory.createEntityManager();
		// original department
		Department originalDepartment = new Department();
		originalDepartment.setName("Original department");
		String findDepartmentQueryJpql = "SELECT dep FROM Department dep";

		// when
		// persist the original department (transient)
		EntityTransaction persistTransaction = entityManager.getTransaction();
		persistTransaction.begin();
		entityManager.persist(originalDepartment);
		persistTransaction.commit();
		// create the new department (detached)
		Department newDepartment = new Department();
		newDepartment.setName("New department");
		// must have the same id as original department - the id should be set by previous persist call
		newDepartment.setId(originalDepartment.getId());
		EntityTransaction mergeTransaction = entityManager.getTransaction();
		mergeTransaction.begin();
		entityManager.merge(newDepartment);
		mergeTransaction.commit();

		// then
		Department updatedDepartment = entityManager.createQuery(findDepartmentQueryJpql, Department.class)
			.getSingleResult();
		assertThat(updatedDepartment.getName()).isEqualTo("New department");
	}

	@DisplayName("should save department with two employees")
	@Test
	void saveDepartment() {
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
