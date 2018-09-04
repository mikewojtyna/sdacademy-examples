package pl.sdacademy.db.jpa.movie;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

import static org.assertj.core.api.Assertions.*;

public class MovieDbIntegrationTest {
	private EntityManagerFactory factory;

	@BeforeEach
	void beforeEach() {
		factory = Persistence.createEntityManagerFactory("test");
	}

	@AfterEach
	void afterEach() {
		factory.close();
	}

	@DisplayName("should save movie and two genres")
	@Test
	void movieMany2Many() {
		// given
		EntityManager entityManager = factory.createEntityManager();
		// movie
		Movie movie = new Movie();
		movie.setTitle("movie");
		// first genre
		Genre genre0 = new Genre();
		genre0.setName("genre0");
		genre0.setMovies(Arrays.asList(movie));
		// second genre
		Genre genre1 = new Genre();
		genre1.setName("genre1");
		genre1.setMovies(Arrays.asList(movie));
		// add genres to the movie
		Collection<Genre> genres = Arrays.asList(genre0, genre1);
		movie.setGenres(genres);

		// when
		// begin transaction
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(movie);
		// commit transaction
		transaction.commit();

		// then
		Movie foundMovie = entityManager.createQuery("SELECT mov FROM Movie " + "mov", Movie.class)
			.getSingleResult();
		Collection<Genre> foundMovieGenres = foundMovie.getGenres();
		// assert genres from movie
		assertThat(foundMovieGenres).extracting("name").containsExactlyInAnyOrder("genre0", "genre1");
		// assert movies from genres
		Iterator<Genre> genresIterator = foundMovieGenres.iterator();
		assertThat(genresIterator.next().getMovies()).extracting("title").containsOnly(movie.getTitle());
		assertThat(genresIterator.next().getMovies()).extracting("title").containsOnly(movie.getTitle());
	}
}
