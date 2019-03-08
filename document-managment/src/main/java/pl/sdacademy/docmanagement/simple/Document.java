package pl.sdacademy.docmanagement.simple;


import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Document {
	private String id;
	private Set<Department> associatedDepartments;

	private Document() {

	}

	public Document(String id) {
		this.id = id;
		associatedDepartments = new HashSet<>();
	}

	@Override
	public String toString() {
		return "Document{" + "id='" + id + '\'' + ", associatedDepartments=" + associatedDepartments + '}';
	}

	public Set<Department> getAssociatedDepartments() {
		return associatedDepartments;
	}

	private void setAssociatedDepartments(Set<Department> associatedDepartments) {
		this.associatedDepartments = associatedDepartments;
	}

	public String getId() {
		return id;
	}

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
