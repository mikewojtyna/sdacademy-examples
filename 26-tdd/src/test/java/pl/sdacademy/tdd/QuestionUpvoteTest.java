package pl.sdacademy.tdd;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.sdacademy.tdd.kata.Question;

import static org.assertj.core.api.Assertions.*;

public class QuestionUpvoteTest {
	// @formatter:off
	@DisplayName(
		"given question with initial score 0 and author 'goobar', " +
		"when upvote the question by user 'foobar', " +
		"then score is 1"
	)
	// @formatter:on
	@Test
	void test0() throws Exception {
		// given
		Question question = new Question(0, "goobar");

		// when
		question.upvoteBy("foobar");

		// then
		assertThat(question.score()).isEqualTo(1);
	}

	// @formatter:off
	@DisplayName(
		"given question with initial score 0 and author 'george', " +
		"when upvote the question by user 'foobar', " +
		"then score is 1"
	)
	// @formatter:on
	@Test
	void test6() throws Exception {
		// given
		Question question = new Question(0, "george");

		// when
		question.upvoteBy("foobar");

		// then
		assertThat(question.score()).isEqualTo(1);
	}

	// @formatter:off
	@DisplayName(
		"given question with initial score 100 and author 'goobar', " +
		"when upvote the question by user 'foobar', " +
		"then score is 101"
	)
	// @formatter:on
	@Test
	void test4() throws Exception {
		// given
		Question question = new Question(100, "goobar");

		// when
		question.upvoteBy("foobar");

		// then
		assertThat(question.score()).isEqualTo(101);
	}

	// @formatter:off
	@DisplayName(
		"given question with initial score 0 and author 'goobar', " +
		"when upvote the question two times by user 'foobar', " +
		"then score is 1"
	)
	// @formatter:on
	@Test
	void test1() throws Exception {
		// given
		Question question = new Question(0, "goobar");
		String foobar = "foobar";

		// when
		question.upvoteBy(foobar);
		question.upvoteBy(foobar);

		// then
		assertThat(question.score()).isEqualTo(1);
	}

	// @formatter:off
	@DisplayName(
		"given question with initial score 0 and author 'goobar', " +
		"when upvote the question by author, " +
		"then score is 0"
	)
	// @formatter:on
	@Test
	void test2() throws Exception {
		// given
		String author = "goobar";
		Question question = new Question(0, author);

		// when
		question.upvoteBy(author);

		// then
		assertThat(question.score()).isEqualTo(0);
	}

	// @formatter:off
	@DisplayName(
		"given question with initial score 0 and author 'goobar', " +
		"when upvote the question by 'foobar' and 'hoobar', " +
		"then score is 2"
	)
	// @formatter:on
	@Test
	void test3() throws Exception {
		// given
		Question question = new Question(0, "goobar");

		// when
		question.upvoteBy("foobar");
		question.upvoteBy("hoobar");

		// then
		assertThat(question.score()).isEqualTo(2);
	}

	// @formatter:off
	@DisplayName(
		"given question with initial score 50, " +
		"when upvote the question by 20 different users other than author, " +
		"then score is 70"
	)
	// @formatter:on
	@Test
	void test5() throws Exception {
		// given
		String author = "goobar";
		Question question = new Question(50, author);

		// when
		upvoteNTimesByUsersDifferentThan(20, author, question);

		// then
		assertThat(question.score()).isEqualTo(70);
	}

	private void upvoteNTimesByUsersDifferentThan(int score, String author, Question question) {
		for (int i = 0; i < score; i++) {
			question.upvoteBy("non" + author + i);
		}
	}
}
