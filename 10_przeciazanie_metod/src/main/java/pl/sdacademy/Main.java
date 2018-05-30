package pl.sdacademy;


import pl.sdacademy.budynek.Budynek;
import pl.sdacademy.budynek.DomPietrowy;
import pl.sdacademy.budynek.Wiezowiec;

public class Main {
    public static void main(String[] args) {
        Budynek hala = new Budynek(100, 200, 6);
        Budynek dom = new DomPietrowy(10, 10, 8); //korzystamy z polimorfizmu - nie określamy dokładnej implementacji - DomPiętrowy jest budynkiem dlatego posługujemy się Budynkiem
        Budynek businessCenter = new Wiezowiec(40, 30, 30, 10); //j.w.

        System.out.println("Hala: " + hala  );
        System.out.println("Dom: " + dom);
        System.out.println("Business Center: " + businessCenter);
    }
}
