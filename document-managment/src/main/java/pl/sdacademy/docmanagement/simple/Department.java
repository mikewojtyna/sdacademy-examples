package pl.sdacademy.docmanagement.simple;

import java.util.Objects;

public class Department {
	private String name;
	private boolean documentProcessed;

	private Department() {

	}

	public Department(String name) {
		this.name = name;
		documentProcessed = false;
	}

	public String getName() {
		return name;
	}

	public boolean isDocumentProcessed() {
		return documentProcessed;
	}

	public void setDocumentProcessed(boolean documentProcessed) {
		this.documentProcessed = documentProcessed;
	}

	@Override
	public String toString() {
		return "Department{" + "name='" + name + '\'' + ", documentProcessed=" + documentProcessed + '}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Department that = (Department) o;
		return Objects.equals(name, that.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	void finishProcessing() {
		documentProcessed = true;
	}

	boolean isProcessingFinished() {
		return documentProcessed;
	}
}
