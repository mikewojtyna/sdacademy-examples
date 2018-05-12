package pl.sdacademy.smartfon;

public class Smartfon implements Telefon, Komputer{

	@Override
	public void przegladarka(String adres) {
		System.out.println("Przgladam adres" + adres);
	}

	@Override
	public void kalkulator(int liczba1, int liczba2) {
		System.out.println(liczba1 + " + " + liczba2 + " = " + (liczba1 + liczba2));
	}

	@Override
	public void wyslijSMS(String numer) {
		System.out.println("Wysylam SMS na numer " + numer);
	}

	@Override
	public void dzwonDO(String numer) {
		System.out.println("Dzwonie na numer " + numer);
	}
}
