package pl.sdacademy.mvc;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface MsgRepository extends JpaRepository<Msg, Long> {
	Collection<Msg> findByContent(String content);

	Collection<Msg> findByNumberBetween(int firstNumber, int secondNumber);
}
