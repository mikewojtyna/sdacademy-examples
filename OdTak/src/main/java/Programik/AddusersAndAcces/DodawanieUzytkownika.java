package Programik.AddusersAndAcces;

import java.util.HashMap;
import java.util.Map;

public class DodawanieUzytkownika implements Mediator, WyslwietlanieUzytkownikow {
	@Override
	public String toString() {
		return "DodawanieUzytkownika{" + "uzytkownicy=" + uzytkownicy + "\n" + '}';
	}

	private HashMap<String, Uzytkownik> uzytkownicy = new HashMap<>();


	public void dodajUzytkownika(Uzytkownik u){
		u.zarejestrujMediatora(this);
		uzytkownicy.put(u.getId(), u);


	}

	public void wyswietlanieUzytkownikow() {
		for(Map.Entry<String, Uzytkownik> entry : uzytkownicy.entrySet()){
			System.out.println(entry);
		}
	}

}
