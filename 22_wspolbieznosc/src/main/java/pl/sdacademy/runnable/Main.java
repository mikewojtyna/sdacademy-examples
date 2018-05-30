package pl.sdacademy.runnable;


import pl.sdacademy.runnable.concurrency.*;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        Pudelko bezpiecznePudelko = new BezpiecznePudelko();
        Pudelko niebezpiecznePudelko = new NiebezpiecznePudelko();

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            executorService.submit(new Konsument(bezpiecznePudelko));
            executorService.submit(new Producent(bezpiecznePudelko));
        }
        executorService.shutdown();
    }
}
