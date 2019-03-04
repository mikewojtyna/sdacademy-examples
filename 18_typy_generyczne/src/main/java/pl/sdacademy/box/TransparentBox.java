package pl.sdacademy.box;

import java.util.Collection;

public interface TransparentBox<T> extends Box<T> {
	Collection<T> inspect();
}
