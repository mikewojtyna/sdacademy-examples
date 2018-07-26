package Programik.AddusersAndAcces;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class DodawanieUzytkownika implements Mediator {

	private Map<String, Map<Integer, Uzytkownik>> mapaUzytkownikow = new TreeMap<>();
	Map<Integer, Uzytkownik> mapaUzytkownikow1 = new TreeMap<>();


	public void dodajUzytkownika(Uzytkownik u) {
		u.zarejestrujMediatora(this);
		mapaUzytkownikow1.put(u.getId(), u);
		mapaUzytkownikow.put(u.getImieUzytkownika(), mapaUzytkownikow1);
	}
}
