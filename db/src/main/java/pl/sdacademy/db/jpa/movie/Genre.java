package pl.sdacademy.db.jpa.movie;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Collection;

// Genre is the owned side of the relation
@Entity
public class Genre {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	// mappedBy means the field of the Movie class which references genre
	@ManyToMany(mappedBy = "genres")
	private Collection<Movie> movies;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Collection<Movie> getMovies() {
		return movies;
	}

	public void setMovies(Collection<Movie> movies) {
		this.movies = movies;
	}
}
