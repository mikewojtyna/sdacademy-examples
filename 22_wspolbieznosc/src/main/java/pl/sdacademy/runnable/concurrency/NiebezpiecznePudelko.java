package pl.sdacademy.runnable.concurrency;

public class NiebezpiecznePudelko implements Pudelko{
	String zawartosc = null;

	@Override
	public boolean wlozDoPudelka(String nowaZawartosc) {
		if (zawartosc == null) {
			zawartosc = nowaZawartosc;
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public String pobierzZawartosc() {
		if (zawartosc != null) {
			String zwracanaZawartosc = zawartosc;
			zawartosc = null;
			return zwracanaZawartosc;
		} else {
			return null;
		}
	}
}
