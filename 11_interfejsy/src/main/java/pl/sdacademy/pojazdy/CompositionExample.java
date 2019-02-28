package pl.sdacademy.pojazdy;

public class CompositionExample {
	public static void main(String[] args) {
		AmfibiaComposition amfibia = new AmfibiaComposition(new PojazdImpl(), new MotorowkaImpl());

		amfibia.jedz();
		amfibia.plyn();

		amfibia.jedzIPlyn();
	}
}
