package pl.sdacademy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.sdacademy.shapes.Ksztalt;
import pl.sdacademy.shapes.Kwadrat;
import pl.sdacademy.shapes.Trojkat;

import static org.assertj.core.api.Assertions.*;

public class PudelkoNaKsztaltyTest {
	@DisplayName("mozna do pudelka na ksztalty wlozyc zarowno kwadraty oraz trojkaty oraz obliczyc ich pole")
	@Test
	void test() {
		// given
		PudelkoNaKsztalty<Ksztalt> ksztalty = new PudelkoNaKsztalty<>(shegemege());

		// when
		double powierzchnie = ksztalty.sumujPowierzchnie();

		// then
		assertThat(powierzchnie).isEqualTo(2550);
	}

	@DisplayName("mozna zbudowac pudelko wylacznie na trojkaty i policzyc ich powierzchnie")
	@Test
	void trojkaty() {
		// given
		PudelkoNaKsztalty<Trojkat> pudelkoNaTrojkaty = new PudelkoNaKsztalty<>(tylkoTrojkaty());

		// when
		double powierzchnia = pudelkoNaTrojkaty.sumujPowierzchnie();

		// then
		assertThat(powierzchnia).isEqualTo(68);
	}

	private Trojkat[] tylkoTrojkaty() {
		return new Trojkat[]{new Trojkat(10, 10), new Trojkat(6, 6)};
	}

	private Ksztalt[] shegemege() {
		return new Ksztalt[]{new Trojkat(10, 10), new Kwadrat(50)};
	}
}
