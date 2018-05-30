package pl.sdacademy;

import pl.sdacademy.pojazdy.Amfibia;
import pl.sdacademy.pojazdy.Motorowka;
import pl.sdacademy.pojazdy.Pojazd;

public class Main {

    public static void main(String[] args) {
        Amfibia amfibia = new Amfibia(); //w tej linii nie korzystamy z tego, że amfibia implementuje jakieś interfejsy - tworzymy "dosłowny" obiekt amfibii
        amfibia.jedz();
        amfibia.plyn();

        Pojazd pojazd = new Amfibia();
        pojazd.jedz(); //ponieważ zmienna pojazd jest typu Pojazd, ma jedynie metody które udostępnia interfejs Pojazd, czyli jedź(). Gdybyśmy mieli więcej klas implementujących interfejs Pojazd, wtedy do tej zmiennej moglibyśmy przypisać obiekty które rzeczywiście byłyby klas Samochód albo Traktor - nie obchodziłoby nas czym rzeczywiście jest pojazd, ważne że jeździ! (czyli posiada metodę jedz() )

        Motorowka motorowka = new Amfibia(); //teraz chcemy mieć coś pływającego, na szczęście Amfibia jest tak wszechstronna, że implementuje interfejs Motorowka - dlatego może też pływać
        motorowka.plyn();
    }
}
