package pl.sdacademy;

import pl.sdacademy.zwierze.Lew;
import pl.sdacademy.zwierze.Slon;
import pl.sdacademy.zwierze.Zwierze;

public class Main2 {
    public static void main(String[] args) {
        Zwierze lewLeon = new Lew("Leon");
        Zwierze slonAntek = new Slon("Antek");

        //obie zmienne mają typ Zwierzę, ale zachowują się właściwie do rzeczywistej klasy obiektów przypisanych do
        // tych zmiennych
        lewLeon.dajGlos();
        slonAntek.dajGlos();
        System.out.println("Zwierze "
                + lewLeon.getNazwa()
                + " je "
                + lewLeon.ileJe()
                + " KG");
    }
}
