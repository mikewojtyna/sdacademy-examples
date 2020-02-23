package pl.sdacademy.db.blog;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import static org.assertj.core.api.Assertions.*;

public class CreatePostIntegrationTest {

	private EntityManager entityManager;

	@BeforeEach
	void setup() {
		entityManager = Persistence.createEntityManagerFactory("test").createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.createQuery("DELETE FROM Post");
		transaction.commit();
	}

	// @formatter:off
	@DisplayName(
		"given title 'My First Post' with description 'This is my first post, hooray!', " +
		"when create, " +
		"then post with given title and description can be found"
	)
	// @formatter:on
	@Test
	void create() throws Exception {
		// given
		PostCrudService postCrudService = new JpaPostCrudService(entityManager);
		String title = "My First Post";
		String description = "This is my first post, hooray!";

		// when
		Post createdPost = postCrudService.create(title, description);

		// then
		Post foundPost = postCrudService.find(createdPost.getId()).get();
		assertThat(foundPost.getTitle()).isEqualTo(title);
		assertThat(foundPost.getDescription()).isEqualTo(description);
	}

	// @formatter:off
	@DisplayName(
		"given post with title 'My First Post' and description 'This is my first post, hooray!', " +
		"when update the old post with new post having title 'My Fixed Title', " +
		"then title of the old post is updated"
	)
	// @formatter:on
	@Test
	void update() throws Exception {
		// given
		PostCrudService postCrudService = new JpaPostCrudService(entityManager);
		String title = "My First Post";
		String description = "This is my first post, hooray!";
		Post oldPost = postCrudService.create(title, description);
		Post newPost = new Post("My Fixed Title", description);
		newPost.setId(oldPost.getId());

		// when
		postCrudService.update(newPost);

		// then
		Post foundPost = postCrudService.find(oldPost.getId()).get();
		assertThat(foundPost.getTitle()).isEqualTo("My Fixed Title");
		assertThat(foundPost.getDescription()).isEqualTo(description);
	}

	// @formatter:off
	@DisplayName(
		"given post without comments, " +
		"and new comments 'I'm first' and 'Lol', " +
		"when updating post with given comments, " +
		"then these comments are added to the post"
	)
	// @formatter:on
	@Test
	void createWithComments() throws Exception {
		// given
		PostCrudService postCrudService = new JpaPostCrudService(entityManager);
		String title = "My First Post";
		String description = "This is my first post, hooray!";
		Post oldPost = postCrudService.create(title, description);
		Comment firstComment = new Comment("I'm first");
		Comment lolComment = new Comment("Lol");
		Post postWithComment = new Post(title, description);
		postWithComment.setId(oldPost.getId());
		postWithComment.getComments().add(firstComment);
		postWithComment.getComments().add(lolComment);

		// when
		postCrudService.update(postWithComment);

		// then
		Post foundPost = postCrudService.find(oldPost.getId()).get();
		// @formatter:off
		assertThat(foundPost.getComments())
			.extracting("content")
			.containsExactlyInAnyOrder("I'm first",	"Lol");
		// @formatter:on
	}

	// @formatter:off
	@DisplayName(
		"given post with comments, " +
		"when delete post, " +
		"then post is deleted"
	)
	// @formatter:on
	@Test
	void delete() throws Exception {
		// given
		PostCrudService postCrudService = new JpaPostCrudService(entityManager);
		String title = "My First Post";
		String description = "This is my first post, hooray!";
		Post oldPost = postCrudService.create(title, description);
		Comment firstComment = new Comment("I'm first");
		Comment lolComment = new Comment("Lol");
		Post postWithComment = new Post(title, description);
		postWithComment.setId(oldPost.getId());
		postWithComment.getComments().add(firstComment);
		postWithComment.getComments().add(lolComment);
		postCrudService.update(postWithComment);

		// when
		postCrudService.delete(oldPost.getId());

		// then
		assertThat(postCrudService.find(oldPost.getId())).isEmpty();
	}
}
