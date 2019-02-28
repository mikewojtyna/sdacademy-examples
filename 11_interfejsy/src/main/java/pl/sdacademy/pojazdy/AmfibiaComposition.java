package pl.sdacademy.pojazdy;

public class AmfibiaComposition implements Motorowka, Pojazd {

	private Pojazd pojazd;
	private Motorowka motorowka;

	public AmfibiaComposition(Pojazd pojazd, Motorowka motorowka) {
		this.pojazd = pojazd;
		this.motorowka = motorowka;
	}

	void jedzIPlyn() {
		pojazd.jedz();
		motorowka.plyn();
	}

	@Override
	public void plyn() {
		motorowka.plyn();
	}

	@Override
	public void jedz() {
		pojazd.jedz();
	}
}
