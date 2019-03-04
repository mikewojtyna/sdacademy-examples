package pl.sdacademy.box;

import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;

public class UnboundedBox<T> implements Box<T> {
	protected Queue<T> elements;

	public UnboundedBox() {
		elements = new LinkedList<>();
	}

	@Override
	public void add(T element) throws CannotAddElementException {
		elements.add(element);
	}

	@Override
	public Optional<T> get() {
		return Optional.ofNullable(elements.poll());
	}
}
