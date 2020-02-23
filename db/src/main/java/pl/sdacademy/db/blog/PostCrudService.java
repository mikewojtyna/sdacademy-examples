package pl.sdacademy.db.blog;

import java.util.Optional;
import java.util.UUID;

public interface PostCrudService {
	Post create(String title, String description);

	void update(Post newPost);

	Optional<Post> find(UUID id);

	void delete(UUID id);
}
