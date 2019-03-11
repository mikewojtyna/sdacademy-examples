package pl.sdacademy.docmanagement.simple;

public interface DocumentService {
	void registerDocument(String id);

	void associateDocumentWithDepartment(String documentId, String department);

	void finishDocumentProcessingBy(String documentId, String department);

	boolean isDocumentProcessed(String documentId);
}
