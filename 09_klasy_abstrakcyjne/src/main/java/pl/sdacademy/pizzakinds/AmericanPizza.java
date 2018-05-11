package pl.sdacademy.pizzakinds;


public class AmericanPizza extends Pizza {

    private int grubosc;

    public AmericanPizza(int rozmiar, int ileSera, int grubosc) {
        super(rozmiar, ileSera);
        this.grubosc = grubosc;
    }

    @Override
    public void opiszSie() {
        System.out.println("Amerykańska pizza o rozmiarze "
            + getRozmiar() + " ma " + getIleSera()
            + ", jest gruba na " + grubosc + "cm");
    }
}
