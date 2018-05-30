package pl.sdacademy.budynek;

public class Wiezowiec extends Budynek{

    private int liczbaPieter; //klasa wieżowiec posiada specyficzną dla siebie cechę - liczbę pięter, która jest wykorzystywana do obliczania powierzchni

    public Wiezowiec(int szerokosc, int dlugosc, int wysokosc, int liczbaPieter) {
        super(szerokosc, dlugosc, wysokosc); //w klasie pochodnej pierwszą wywoływaną metodą musi być konstruktor klasy bazowej. Jeśli klasa bazowa posiada bezargumentowy konstruktor domyślny, wtedy nie musimy wywoływać konstruktora super() - zostanie on i tak wywołany
        this.liczbaPieter = liczbaPieter;
    }

    /*
    @Override
    public int powierzchnia() {
        return super.powierzchnia() * liczbaPieter; //znów używamy istniejącej w klasie bazowej metody powierzchnia - liczy ona powierzchnię "podstawy" budynku, którą wystarczy pomnożyć przez liczbę pięter
    }
    */

    //powyżej znajduje się oczywista implementacja metody powierzchnia dla klasy Wiezowiec. Ale w przeciwienstwie do konstruktorów, w przeciążanych metodach nie musimy wywoływać przeciążanej metody klasy bazowej. Pole powierzchni możemy policzyć bez jej pomocy, np:

    @Override
    public int powierzchnia() {
        return getDlugosc() * getSzerokosc() * liczbaPieter; //w klasie Wiezowiec nie mamy bezpośredniego dostępu do pól klasy Budynek (są private), ale możemy pobrać ich wartości za pomocą publicznych getterów, które klasa Wiezowiec odziedziczyła po klasie Budynek.
    }



    public int getLiczbaPieter() {
        return liczbaPieter;
    }

    @Override
    public String toString() { //podobnie jak w klasie DomPiętrowy, chcemy żeby nasza klasa ładnie się przedstawiała, stąd przeciążona metoda to string i wywołania getterów.
        return "Wiezowiec{" +
                "liczbaPieter=" + liczbaPieter +
                ", szerokosc=" + getSzerokosc() +
                ", dlugosc=" + getDlugosc() +
                ", wysokosc=" + getWysokosc() +
                '}';
    }
}
