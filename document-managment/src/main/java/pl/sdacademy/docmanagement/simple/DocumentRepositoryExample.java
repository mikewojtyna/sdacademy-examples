package pl.sdacademy.docmanagement.simple;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

/**
 * Przykład użycia repozytorium.
 */
public class DocumentRepositoryExample {
	public static void main(String[] args) {
		Path dbDir = Paths.get("files", "docmanagement", "db");
		DocumentRepository documentRepository = new JsonDocumentRepository(dbDir);

		// prepare an example document
		// document enters the system
		String documentId = UUID.randomUUID().toString();
		Document document = new Document(documentId);

		// document is associated with financial department and executive department
		Department financialDep = new Department("Financial Department");
		document.associateWith(financialDep);
		Department executiveDepartment = new Department("Executive Department");
		document.associateWith(executiveDepartment);
		// financial department finishes processing the document
		document.finishProcessingBy("Financial Department");
		// finish processing document by executive department
		document.finishProcessingBy("Executive Department");

		documentRepository.save(document);
		documentRepository.findById(documentId).ifPresent(System.out::print);

	}
}
