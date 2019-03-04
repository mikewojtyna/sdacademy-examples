package pl.sdacademy.box;

import java.util.Optional;

public class BottomlessBox<T> implements Box<T> {
	@Override
	public void add(T element) throws CannotAddElementException {

	}

	@Override
	public Optional<T> get() {
		return Optional.empty();
	}
}
