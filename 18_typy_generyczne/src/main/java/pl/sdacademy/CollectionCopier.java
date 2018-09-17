package pl.sdacademy;

import java.util.Collection;

public class CollectionCopier {
	static <T> void copy(Collection<? extends T> source, Collection<? super T> target) {
		source.forEach(target::add);
	}
}
