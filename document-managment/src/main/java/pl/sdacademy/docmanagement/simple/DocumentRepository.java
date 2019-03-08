package pl.sdacademy.docmanagement.simple;

import java.util.Optional;

/**
 * <a href="https://github.com/iluwatar/java-design-patterns/tree/master/repository">Repozytorium</a>
 * dostępu do {@link Document}ów.
 */
public interface DocumentRepository {
	/**
	 * Zapisuje zmiany (lub tworzy nowy) dokument w bazie danych.
	 *
	 * @param document dokument do zaktualizowania/dodania do bazy
	 * @throws DocumentRepositoryException jeśli repozytorium nie zadziałało
	 */
	void save(Document document) throws DocumentRepositoryException;

	/**
	 * Znajduje dokument po identyfikatorze. Jeśli nie ma takiego dostępu, zwracany jest pusty {@link Optional}.
	 *
	 * @param id id dokumentu
	 * @return optional zawierający (lub nie) dokument
	 * @throws DocumentRepositoryException jeśli repozytorium nie zadziałało
	 */
	Optional<Document> findById(String id) throws DocumentRepositoryException;
}
