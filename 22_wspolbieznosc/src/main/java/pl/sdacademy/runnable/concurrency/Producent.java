package pl.sdacademy.runnable.concurrency;

import java.util.Random;

public class Producent implements Runnable {

    private static String[] NAPISY = {"ALA", "KOT", "PIES", "ŻABA"};
    private Pudelko pudelko;
    private Random randomGenerator = new Random();

    public Producent(Pudelko bezpiecznePudelko) {
        this.pudelko = bezpiecznePudelko;
    }

    @Override
    public void run() { //zadaniem producenta jest umieszczanie w pudełku zawartości - losowo wybranego napisu
        for (int i = 0; i < 50; i++) {
            String nowyElement = pobierzLosowyElement();
            boolean czySieUdalo = pudelko.wlozDoPudelka(nowyElement);
            if (czySieUdalo) {
                System.out.println(Thread.currentThread().getName()
                    + "Producent: udało mi się włożyć do pudełka nowy element " + nowyElement);
            } else {
                System.out.println(Thread.currentThread().getName()
                    + "Producent: nie udało mi się włożyć nowego elementu do pudełka..."); // podobnie jak w przypadku konsumenta, chcemy uniknąć niepotrzebnej pracy producenta gdy pudełko jest pełne i nie da się do niego nic włożyć
                try {
                    Thread.sleep(randomGenerator.nextInt(100));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private String pobierzLosowyElement() {
        return NAPISY[randomGenerator.nextInt(NAPISY.length)];
    } //metoda prywatna skrywa (niezbyt skomplikowaną, ale mniej czytlną niż napis "pobierzLosowyElement") logikę pobrania losowego napisu
}
