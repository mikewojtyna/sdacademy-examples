package pl.sdacademy;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Osoba jan = new Pracownik("Jan", "Kowalski", 3400);
        Osoba zdzislaw = new Pracownik("Zdzislaw", "Kwiatkowski", 2100);
        Osoba gracjan = new Student("Gracjan", "Frywolny", 2345);


        List<Osoba> listaOsob = new ArrayList<>();
        listaOsob.add(jan);
        listaOsob.add(zdzislaw);
        listaOsob.add(gracjan);

        for (Osoba osoba : listaOsob) {
            osoba.opiszSie();
        }
    }
}
