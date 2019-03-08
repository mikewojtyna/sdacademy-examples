package pl.sdacademy.docmanagement.simple;


import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Centralna klasa naszego sytemu - zawiera informacje o tym, czy dokument został już przetworzony przez wszystkie
 * powiązane wydziały.
 */
public class Document {
	private String id;
	private Set<Department> associatedDepartments;

	private Document() {

	}

	/**
	 * Tworzy nowy dokument o podanym id.
	 *
	 * @param id id dokumentu
	 */
	public Document(String id) {
		this.id = id;
		associatedDepartments = new HashSet<>();
	}

	@Override
	public String toString() {
		return "Document{" + "id='" + id + '\'' + ", associatedDepartments=" + associatedDepartments + '}';
	}

	/**
	 * Wymagane przez Jackson. Nie używać ręcznie.
	 *
	 * @return
	 */
	public Set<Department> getAssociatedDepartments() {
		return associatedDepartments;
	}

	/**
	 * Wymagane przez Jackson. Nie używać ręcznie.
	 *
	 * @param associatedDepartments
	 */
	private void setAssociatedDepartments(Set<Department> associatedDepartments) {
		this.associatedDepartments = associatedDepartments;
	}

	/**
	 * Zwraca id dokumentu.
	 *
	 * @return id dokumentu
	 */
	public String getId() {
		return id;
	}

	/**
	 * Wymagane przez Jackson. Nie używać ręcznie.s
	 *
	 * @param id
	 */
	private void setId(String id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Document document = (Document) o;
		return Objects.equals(id, document.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	/**
	 * Po wywołaniu tej metody wydział {@code department} rozpoczyna pracę nad tym dokumentem.
	 *
	 * @param department wydział, który ma rozpocząć pracę nad tym dokumentem
	 */
	public void associateWith(Department department) {
		associatedDepartments.add(department);
	}

	/**
	 * Marks this document as finished by the department.
	 *
	 * @param department a department
	 */
	public void finishProcessingBy(String department) {
		associatedDepartments.stream().filter(d -> d.getName().equals(department)).forEach(d -> d.finishProcessing());
	}

	/**
	 * Returns true if all departments associated with this document report that their processing is done.
	 *
	 * @return
	 */
	@JsonIgnore
	public boolean isProcessed() {
		for (Department department : associatedDepartments) {
			if (!department.isProcessingFinished()) {
				return false;
			}
		}
		return true;
	}
}
