package pl.sdacademy.db.blog;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.Optional;
import java.util.UUID;

public class JpaPostCrudService implements PostCrudService {

	private EntityManager entityManager;

	public JpaPostCrudService(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public Post create(String title, String description) {
		Post post = new Post(title, description);
		runInTransaction(() -> entityManager.persist(post));
		return post;
	}

	@Override
	public void update(Post newPost) {
		runInTransaction(() -> entityManager.merge(newPost));
	}

	@Override
	public Optional<Post> find(UUID id) {
		return Optional.ofNullable(entityManager.find(Post.class, id));
	}

	@Override
	public void delete(UUID id) {
		runInTransaction(() -> {
			Post post = entityManager.find(Post.class, id);
			entityManager.remove(post);
		});
	}

	private void runInTransaction(Runnable runnable) {
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			runnable.run();
			transaction.commit();
		}
		catch (Exception e) {
			transaction.rollback();
		}
	}
}
