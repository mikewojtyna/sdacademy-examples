package pl.sdacademy;

import pl.sdacademy.shapes.Ksztalt;
import pl.sdacademy.shapes.Kwadrat;
import pl.sdacademy.shapes.Trojkat;

public class Main {
    public static void main(String[] args) {
        Pudelko<String, Integer> pudelkoNaNapisy = new Pudelko<>();
        pudelkoNaNapisy.wlozDoPudelkaT("Jakis napis");
        pudelkoNaNapisy.wlozDoPudelkaS(1);


        Ksztalt[] ksztalty = {new Kwadrat(3),
                               new Trojkat(3,4),
                               new Kwadrat(5)};
        Kwadrat[] kwadraty = {new Kwadrat(5),
                               new Kwadrat(7)};
        Trojkat[] trojkaty = {new Trojkat(3,4),
                               new Trojkat(5,6)};

        PudelkoNaKsztalty<Ksztalt> pudelkoNaKsztalty = new PudelkoNaKsztalty<>(ksztalty);
        PudelkoNaKsztalty<Kwadrat> pudelkoNaKwadraty = new PudelkoNaKsztalty<>(kwadraty);
        PudelkoNaKsztalty<Trojkat> pudelkoNaTrojkaty = new PudelkoNaKsztalty<>(trojkaty);

        System.out.println("Suma powierzchni ksztaltow: " + pudelkoNaKsztalty.sumujPowierzchnie());
        System.out.println("Suma powierzchni kwadratow: " + pudelkoNaKwadraty.sumujPowierzchnie());
        System.out.println("Suma powierzchni trojkatow: " + pudelkoNaTrojkaty.sumujPowierzchnie());

        String [] tablicaStringow = {"ala", "ma", "kota"};
        Integer [] tablicaIntegerow = {3, 2, 4};
        Double [] tablicaDoubli = {6.5, 3.4, null};

        wypiszTablice(tablicaStringow);
        wypiszTablice(tablicaIntegerow);
        wypiszTablice(tablicaDoubli);
    }

    public static <E> void wypiszTablice(E [] tablica) {
        for (E element: tablica) {
            System.out.println(element);
        }
    }


}
