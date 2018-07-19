package Mediator;

public class PrzykladoweUzycieMediatora {
	public static void main(String[] args) {
		Kolega rene = new Kolega("rene");
		Kolega toni = new Kolega("toni");
		Kolega kim = new Kolega("kim");

		Mediator m = new RzeczywistyMediator();
		m.zarejestrujKolege(rene);
		m.zarejestrujKolege(toni);
		m.zarejestrujKolege(kim);

		kim.wyslij("toni", "Siema");
		rene.wyslij("kim", "No elo");
	}
}
