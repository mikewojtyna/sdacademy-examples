package pl.sdacademy.box;

public class BoundedBox<T> extends UnboundedBox<T> {
	private int maxCapacity;

	public BoundedBox(int maxCapacity) {
		this.maxCapacity = maxCapacity;
	}

	@Override
	public void add(T element) throws CannotAddElementException {
		if (elements.size() >= maxCapacity) {
			throw new CannotAddElementException(String.format("Failed to add new elements %s. Exceeded " + "max capacity of size %d. Current capacity: %d.", element, maxCapacity, elements.size()));
		}
		super.add(element);
	}
}
