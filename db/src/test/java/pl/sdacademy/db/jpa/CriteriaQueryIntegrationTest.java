package pl.sdacademy.db.jpa;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import static org.assertj.core.api.Assertions.*;

class CriteriaQueryIntegrationTest {
	@DisplayName("show how to use the criteria query api")
	@Test
	void test() {
		EntityManagerFactory entityManagerFactory = null;
		try {
			// create the entity manager
			entityManagerFactory = Persistence.createEntityManagerFactory("test");
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			// insert some data
			EntityTransaction transaction = entityManager.getTransaction();
			transaction.begin();
			entityManager.persist(new User("goobar", "fake@email.com", "password"));
			transaction.commit();

			// create the criteria query that will return User objects
			CriteriaBuilder builder = entityManager.getCriteriaBuilder();
			CriteriaQuery<User> criteriaQuery = builder.createQuery(User.class);
			// specify the query
			Root<User> user = criteriaQuery.from(User.class);
			criteriaQuery.select(user).where(builder.equal(user.get(User_.name), "goobar"));

			// finally create the query and get the results
			TypedQuery<User> query = entityManager.createQuery(criteriaQuery);
			User foundUser = query.getSingleResult();
			assertThat(foundUser.getName()).isEqualTo("goobar");
			assertThat(foundUser.getEmail()).isEqualTo("fake@email.com");
			assertThat(foundUser.getPassword()).isEqualTo("password");
		}
		finally {
			if (entityManagerFactory != null) {
				entityManagerFactory.close();
			}
		}
	}
}
