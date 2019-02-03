package pl.sdacademy.db.jdbc;

import java.util.Collection;

public interface UserFinder {
	Collection<User> findByName(String name);
}
