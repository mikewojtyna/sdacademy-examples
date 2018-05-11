package pl.sdacademy.budynek;

public class Budynek {

    private int szerokosc;
    private int dlugosc;
    private int wysokosc;

    public Budynek(int szerokosc, int dlugosc, int wysokosc) {
        this.szerokosc = szerokosc;
        this.dlugosc = dlugosc;
        this.wysokosc = wysokosc;
    }

    public Budynek() {
    }

    public int powierzchnia() {
        return szerokosc * wysokosc;
    }

    public int getSzerokosc() {
        return szerokosc;
    }

    public int getDlugosc() {
        return dlugosc;
    }

    public int getWysokosc() {
        return wysokosc;
    }


    @Override
    public String toString() {
        return "Budynek{" +
                "szerokosc=" + szerokosc +
                ", dlugosc=" + dlugosc +
                ", wysokosc=" + wysokosc +
                '}';
    }
}
