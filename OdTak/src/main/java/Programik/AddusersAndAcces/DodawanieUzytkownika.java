package Programik.AddusersAndAcces;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class DodawanieUzytkownika implements Mediator {
	@Override
	public String toString() {
		return "DodawanieUzytkownika{" + uzytkownicy + "\n"  + '}';
	}

	private HashMap<String , Uzytkownik> uzytkownicy = new HashMap<>();
	private HashMap<String, Uzytkownik> urzadzenia = new HashMap<>();
	private Map<Integer, TreeMap<String, Uzytkownik>> mapa = new TreeMap<>();



	public void dodajUzytkownika(Uzytkownik u) {
		u.zarejestrujMediatora(this);
		mapa.put(u.getId(), u.getImieDodawane(), u);
		//uzytkownicy.put(u.getImieDodawane(), u);
		//urzadzenia.put(u.getId(), u);
	}
}
