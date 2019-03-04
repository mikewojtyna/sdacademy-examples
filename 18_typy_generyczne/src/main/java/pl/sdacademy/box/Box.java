package pl.sdacademy.box;

import java.util.Optional;

public interface Box<T> {
	void add(T element) throws CannotAddElementException;

	Optional<T> get();
}
