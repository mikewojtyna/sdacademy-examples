package pl.sdacademy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class PudelkoTest {
	@DisplayName("mozna wlozyc do pudelka String jako pierwszy typ a nastepnie go wybrac")
	@Test
	void test() {
		// given
		Pudelko<String, Object> pudelkoNaStringi = new Pudelko<>();

		// when
		pudelkoNaStringi.wlozDoPudelkaT("stringi");

		// then
		String stringi = pudelkoNaStringi.wyjmijZPudelkaT();
		assertThat(stringi).isEqualTo("stringi");
	}
}
