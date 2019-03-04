package pl.sdacademy;

import pl.sdacademy.box.BoundedBox;
import pl.sdacademy.box.BoundedTransparentBox;
import pl.sdacademy.box.CannotAddElementException;
import pl.sdacademy.box.UnboundedBox;

import java.util.Collection;

public class BoxExample {
	public static void main(String[] args) {
		// unbounded box example
		UnboundedBox<Integer> unboundedBox = new UnboundedBox<>();
		unboundedBox.add(1);
		unboundedBox.add(2);
		unboundedBox.add(3);
		System.out.println(unboundedBox.get());
		System.out.println(unboundedBox.get());
		System.out.println(unboundedBox.get());
		System.out.println(unboundedBox.get());

		// bounded box example
		try {
			BoundedBox<Integer> boundedBox = new BoundedBox<>(2);
			boundedBox.add(1);
			boundedBox.add(2);
			boundedBox.add(3);
		}
		catch (CannotAddElementException e) {
			e.printStackTrace();
		}

		// bounded and transparent box example
		BoundedTransparentBox<Integer> boundedTransparentBox = new BoundedTransparentBox<>(3);
		boundedTransparentBox.add(1);
		boundedTransparentBox.add(2);
		boundedTransparentBox.add(3);
		Collection<Integer> allElements = boundedTransparentBox.inspect();
		System.out.println(allElements);
		allElements.clear();
		System.out.println(boundedTransparentBox.inspect());
	}
}
