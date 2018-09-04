package pl.sdacademy.db.jpa.movie;

import javax.persistence.*;
import java.util.Collection;

// movie is the owning side of the relation
@Entity
public class Movie {
	@Id
	@GeneratedValue
	private int id;
	private String title;
	private int year;
	// also persist children - genres
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(
		// name of the join table
		name = "Movie_Genre",
		// column of the join table referencing the owning side
		joinColumns = {@JoinColumn(name = "movie_id")},
		// column of the join table referencing the owned side
		inverseJoinColumns = {@JoinColumn(name = "genre_id")})
	private Collection<Genre> genres;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public Collection<Genre> getGenres() {
		return genres;
	}

	public void setGenres(Collection<Genre> genres) {
		this.genres = genres;
	}
}
