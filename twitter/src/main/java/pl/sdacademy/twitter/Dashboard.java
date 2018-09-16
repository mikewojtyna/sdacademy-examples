package pl.sdacademy.twitter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Stream;

public class Dashboard {

	private Collection<Twit> twits;

	public Dashboard() {
		twits = new ArrayList<>();
	}

	public Twit create(String msg, String author) {
		Twit newTwit = new Twit(msg, author);
		twits.add(newTwit);
		return newTwit;
	}

	public Stream<Twit> load() {
		return twits.stream();
	}
}
