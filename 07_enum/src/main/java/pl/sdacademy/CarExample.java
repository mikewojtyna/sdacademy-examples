package pl.sdacademy;


import pl.sdacademy.auto.Samochod;
import pl.sdacademy.auto.TypAuta;

public class CarExample {
    public static void main(String[] args) {
        Samochod bmw = new Samochod(TypAuta.OSOBOWY, "BMW serii 5");
        Samochod iveco = new Samochod(TypAuta.CIEZAROWY, "Iveco");
        Samochod ferrari = new Samochod(TypAuta.SPORTOWY, "Ferrari F430");

        System.out.println(bmw);
        System.out.println(iveco);
        System.out.println(ferrari);
    }
}
