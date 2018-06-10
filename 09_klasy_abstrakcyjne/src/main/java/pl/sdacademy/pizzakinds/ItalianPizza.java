package pl.sdacademy.pizzakinds;


public class ItalianPizza extends Pizza {

	String dodatkowySer;
	String zioła;

	public ItalianPizza(int rozmiar, int ileSera, String dodatkowySer, String zioła) {
		super(rozmiar, ileSera);
		this.dodatkowySer = dodatkowySer;
		this.zioła = zioła;
	}


	@Override
	public void opiszSie() {
		throw new UnsupportedOperationException("implement this");
	}
}
