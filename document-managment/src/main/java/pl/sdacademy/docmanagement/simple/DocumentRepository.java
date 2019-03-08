package pl.sdacademy.docmanagement.simple;

import java.util.Optional;

public interface DocumentRepository {
	void save(Document document) throws DocumentRepositoryException;

	Optional<Document> findById(String id) throws DocumentRepositoryException;
}
