package Mediator;

import java.util.HashMap;

class RzeczywistyMediator implements Mediator {
	private HashMap<String, Kolega> koledzy = new HashMap<String, Kolega>();

	public void zarejestrujKolege(Kolega k){
		k.zarejestrujMediatora(this);
		koledzy.put(k.getId(), k);
	}

	public void wyslij(String id, String wiadomosc){
		koledzy.get(id).odbierz(wiadomosc);
	}

}
