package pl.sdacademy.runnable.concurrency;

import java.util.Random;

public class Konsument implements Runnable { //konsument implementuje interfejs Runnable - czyli określa przez przeciążenie metody run() zadanie dla wątków.

    private Random randomGenerator = new Random();
    private Pudelko pudelko;

    public Konsument(Pudelko pudelko) {
        this.pudelko = pudelko;
    }

    @Override
    public void run() { //zadaniem konsumenta jest odbieranie zawartości pudełka i jego konsumowanie - w naszym przypadku wypisanie zawartości na ekran
        for (int i = 0; i < 50; i++) {

            String otrzymanaZawartosc = pudelko.pobierzZawartosc();
            if (otrzymanaZawartosc == null) {
                System.out.println(Thread.currentThread().getName()
                        + " Konsument: Pudełko jest puste..."); // to jest sytuacja której chcemy uniknąć - bezsensowna praca wątku konsumenta w sytuacji, gdy pudełko jest puste
                try {
                    Thread.sleep(randomGenerator.nextInt(100));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println(Thread.currentThread().getName()
                        + " Konsument: Pudełko jest pełne! Pobieram: " + otrzymanaZawartosc);

            }
        }
    }
}
