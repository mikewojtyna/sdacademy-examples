package pl.sdacademy.db.jpa;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

class JpaIntegrationTest {
	@DisplayName("should save user using JPA")
	@Test
	void jpa() {
		// given
		// create entity manager
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("test");
		EntityManager entityManager = factory.createEntityManager();
		// create a user to persist
		User user = new User("goobar", "fake@email.com", "password");

		// when
		// create and begin transaction
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		// persist transient user entity
		entityManager.persist(user);
		// commit the transaction - now the user should be persisted
		transaction.commit();

		// then
		// find saved user
		User foundUser = entityManager.createNamedQuery("User.findByName", User.class).setParameter("name",
			"goobar").getSingleResult();
		Assertions.assertThat(foundUser.getName()).isEqualTo("goobar");
	}
}
