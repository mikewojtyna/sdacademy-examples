package pl.sdacademy.budynek;

public class DomPietrowy extends Budynek {

    //klasa dom piętrowy nie posiada żadnych wyjątkowych cech (pól) względem klasy Budynek - jedyne czym się różni to metoda powierzchnia

    public DomPietrowy(int szerokosc, int dlugosc, int wysokosc) {
        super(szerokosc, dlugosc, wysokosc);//w klasie pochodnej pierwszą wywoływaną metodą musi być konstruktor klasy bazowej. Jeśli klasa bazowa posiada bezargumentowy konstruktor domyślny, wtedy nie musimy wywoływać konstruktora super() - zostanie on i tak wywołany
    }


    @Override
    public int powierzchnia() {
        return super.powierzchnia() * 2; // używamy istniejącej w klasie bazowej metody powierzchnia - liczy ona powierzchnię "podstawy" budynku, którą wystarczy pomnożyć przez 2
    }

    @Override
    public String toString() { // metoda to string mogłaby pozostać nienadpisywana (mielibyśmy ją z klasy budynek), ale wtedy zostałoby wypisane "Budynek" zamiast "DomPiętrowy"
        return "DomPietrowy{" +
                "szerokosc=" + getSzerokosc() +
                ", dlugosc=" + getDlugosc() +
                ", wysokosc=" + getWysokosc() +
                '}';
    }
}
