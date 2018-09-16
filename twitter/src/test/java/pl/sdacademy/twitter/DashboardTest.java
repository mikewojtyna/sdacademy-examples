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

	@DisplayName("author should be able to create a new twit")
	@Test
	void twitAuthor() {
		// given
		String msg = "content";
		String author = "goobar";

		// when
		Twit twit = dashboard.create(msg, author);

		// then
		assertThat(twit.getAuthor()).isEqualTo(author);
		assertThat(twit.getMessage()).isEqualTo(msg);
	}

	@DisplayName("should load created twit from the dashboard")
	@Test
	void db() {
		// given
		String msg = "content";
		String author = "goobar";
		Twit twit = dashboard.create(msg, author);

		// when
		Stream<Twit> allTwits = dashboard.load();

		// then
		assertThat(allTwits).containsOnly(twit);
	}
}
