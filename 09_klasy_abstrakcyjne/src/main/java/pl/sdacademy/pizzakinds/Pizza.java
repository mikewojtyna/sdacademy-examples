package pl.sdacademy.pizzakinds;

public abstract class Pizza {

    private int rozmiar;
    private int ileSera;

    public Pizza(int rozmiar, int ileSera) {
        this.rozmiar = rozmiar;
        this.ileSera = ileSera;
    }

    public int getRozmiar() {
        return rozmiar;
    }

    public int getIleSera() {
        return ileSera;
    }

    public abstract void opiszSie();
}
