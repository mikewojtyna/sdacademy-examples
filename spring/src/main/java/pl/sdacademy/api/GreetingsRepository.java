package pl.sdacademy.api;

import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface GreetingsRepository extends CrudRepository<Greeting, Long> {
	Collection<Greeting> findByMsg(String msg);
}
