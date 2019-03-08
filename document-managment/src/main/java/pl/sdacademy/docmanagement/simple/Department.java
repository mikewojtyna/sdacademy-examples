package pl.sdacademy.docmanagement.simple;

import java.util.Objects;

/**
 * Klasa modelująca wydział w firmie. W tej chwili wszystko co musimy wiedzieć, to jaka jest nazwa wydziału i czy
 * wydział zakończył swoje przetwarzanie w kontekście klasy {@link Document}. Oznacza to, że na tym etapie klasa
 * {@link Department} nie występuje nigdzie "samodzielnie" (może być tylko częścią klasy {@link Document}).
 */
public class Department {
	private String name;
	private boolean documentProcessed;

	private Department() {

	}

	/**
	 * Tworzy wydział o nazwie.
	 *
	 * @param name nazwa wydziału
	 */
	public Department(String name) {
		this.name = name;
		documentProcessed = false;
	}

	/**
	 * Zwraca nazwę wydziału.
	 *
	 * @return nazwa wydziału
	 */
	public String getName() {
		return name;
	}

	/**
	 * Ten getter jest potrzebny tylko ze względu na bibliotekę Jackson. Nie używać ręcznie.
	 *
	 * @return
	 */
	public boolean isDocumentProcessed() {
		return documentProcessed;
	}

	/**
	 * Ten setter jest potrzebny tylko ze względu na bibliotekę Jackson. Nie używać ręcznie.
	 *
	 * @param documentProcessed
	 */
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

	/**
	 * Kończy przetwarzanie dokumentu przez ten wydział.
	 */
	void finishProcessing() {
		documentProcessed = true;
	}

	/**
	 * Zwraca informację, czy wydział zakończył przetwarzanie swojej części dokumentu.
	 *
	 * @return true jeśli zakończył
	 */
	boolean isProcessingFinished() {
		return documentProcessed;
	}
}
