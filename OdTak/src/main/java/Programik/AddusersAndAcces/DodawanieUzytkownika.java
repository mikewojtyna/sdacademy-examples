package Programik.AddusersAndAcces;

import java.util.HashMap;
import java.util.Map;

public class DodawanieUzytkownika implements Mediator {
	@Override
	public String toString() {
		return "DodawanieUzytkownika{" + uzytkownicy + "\n"  + '}';
	}

	private HashMap<String, Uzytkownik> uzytkownicy = new HashMap<>();
	private HashMap<String, Uzytkownik> urzadzenia = new HashMap<>();


	public void dodajUzytkownika(Uzytkownik u) {
		u.zarejestrujMediatora(this);
		uzytkownicy.put(u.getImieDodawane(), u);
		urzadzenia.put(u.getId(), u);
	}
}
