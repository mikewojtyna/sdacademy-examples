package pl.sdacademy.box;

import java.util.ArrayList;
import java.util.Collection;

public class BoundedTransparentBox<T> extends BoundedBox<T> implements TransparentBox<T> {
	public BoundedTransparentBox(int maxCapacity) {
		super(maxCapacity);
	}

	@Override
	public Collection<T> inspect() {
		return new ArrayList<>(elements);
	}
}
