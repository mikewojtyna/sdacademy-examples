package pl.sdacademy.twitter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Stream;

public class Dashboard {

	private Collection<Tweet> tweets;

	public Dashboard() {
		tweets = new ArrayList<>();
	}

	public Tweet create(String msg, String author) {
		Tweet newTweet = new Tweet(msg, author);
		tweets.add(newTweet);
		return newTweet;
	}

	public Stream<Tweet> load() {
		return tweets.stream();
	}
}
