package pl.sdacademy.db.blog;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
public class Post {
	@Id
	@GeneratedValue
	private UUID id;
	private String title;
	private String description;
	@OneToMany(cascade = CascadeType.MERGE)
	@JoinColumn(name = "fk_post")
	private Collection<Comment> comments = new ArrayList<>();

	public Post(String title, String description) {
		this.title = title;
		this.description = description;
	}
}
