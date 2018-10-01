package pl.sdacademy.twitter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class DashboardTest {

	private Dashboard dashboard;

	@BeforeEach
	void beforeEach() {
		dashboard = new Dashboard();
	}

	@DisplayName("author should be able to create a new tweet")
	@Test
	void twitAuthor() {
		// given
		String msg = "content";
		String author = "goobar";

		// when
		Tweet tweet = dashboard.create(msg, author);

		// then
		assertThat(tweet.getAuthor()).isEqualTo(author);
		assertThat(tweet.getMessage()).isEqualTo(msg);
	}

	@DisplayName("should load created tweet from the dashboard")
	@Test
	void db() {
		// given
		String msg = "content";
		String author = "goobar";
		Tweet tweet = dashboard.create(msg, author);

		// when
		Stream<Tweet> allTweets = dashboard.load();

		// then
		assertThat(allTweets).containsOnly(tweet);
	}
}
