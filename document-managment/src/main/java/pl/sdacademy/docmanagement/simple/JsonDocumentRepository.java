package pl.sdacademy.docmanagement.simple;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

public class JsonDocumentRepository implements DocumentRepository {

	private Path dbDirectory;
	private ObjectMapper objectMapper;

	public JsonDocumentRepository(Path dbDirectory) {
		this.dbDirectory = dbDirectory;
		objectMapper = new ObjectMapper();
		objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
	}

	@Override
	public void save(Document document) throws DocumentRepositoryException {
		Path documentFile = createPathToDocumentFile(document.getId());
		try {
			if (!Files.exists(documentFile)) {
				Files.createFile(documentFile);
			}
			objectMapper.writeValue(documentFile.toFile(), document);
		}
		catch (IOException e) {
			throw new DocumentRepositoryException(String.format("Failed to save document %s to db file %s"
				, document, documentFile), e);
		}
	}

	private Path createPathToDocumentFile(String id) {
		return dbDirectory.resolve(id + ".json");
	}

	@Override
	public Optional<Document> findById(String id) throws DocumentRepositoryException {
		Path documentFile = createPathToDocumentFile(id);
		if (!Files.exists(documentFile)) {
			return Optional.empty();
		}
		try {
			Document document = objectMapper.readValue(documentFile.toFile(), Document.class);
			return Optional.of(document);
		}
		catch (IOException e) {
			throw new DocumentRepositoryException(String.format("Failed to find document by id %s. Error " + "when reading document db file %s", id, documentFile), e);
		}
	}
}
