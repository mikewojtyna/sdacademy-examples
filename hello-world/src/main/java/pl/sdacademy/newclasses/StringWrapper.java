package pl.sdacademy.newclasses;

import java.util.Objects;

public class StringWrapper {
	private String value;

	public StringWrapper(String value) {
		this.value = value;
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		StringWrapper that = (StringWrapper) o;
		return Objects.equals(value, that.value);
	}

	@Override
	public int hashCode() {

		return Objects.hash(value);
	}
}
