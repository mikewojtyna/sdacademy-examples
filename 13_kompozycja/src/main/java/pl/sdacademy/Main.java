package pl.sdacademy;


import pl.sdacademy.silnik.SilnikV6;
import pl.sdacademy.skrzynia.SportowaSkrzyniaBiegow;
import pl.sdacademy.sprzeglo.SportoweSprzeglo;

public class Main {
    public static void main(String[] args) {
        Samochod samochod = new Samochod(
                new SilnikV6(),
                new SportowaSkrzyniaBiegow(),
                new SportoweSprzeglo()
        );

        samochod.jedzDoPrzodu();
    }
}
