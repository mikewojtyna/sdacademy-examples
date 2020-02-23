package pl.sdacademy.db.blog;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
public class Comment {
	@Id
	@GeneratedValue
	private UUID id;
	private String content;
	private String author;

	public Comment(String content) {
		this.content = content;
	}
}
