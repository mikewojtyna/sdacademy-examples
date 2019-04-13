package pl.sdacademy.api;

import org.springframework.data.repository.CrudRepository;

public interface GreetingsRepository extends CrudRepository<Greeting, Long> {
	Iterable<Greeting> findByMsg(String msg);
}
