package pl.sdacademy.db.mongo;

import java.util.Collection;

public class Movie {
	private String title;
	private Collection<String> genres;

	public Collection<String> getGenres() {
		return genres;
	}

	public void setGenres(Collection<String> genres) {
		this.genres = genres;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
