package pl.sdacademy.thread;


import pl.sdacademy.thread.concurrency.MyThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        /*
        MyThread myThread = new MyThread(); //tworzymy obiekt wątku
        myThread.start(); //metoda start uruchamia nowy wątek
        try {
            Thread.sleep(5000); //uzywamy metody statycznej sleep - zostanie ona wywołana na rzecz wątku, w którym uruchomiona jest funkcja main - czyli głównego wątku
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        myThread.zatrzymaj(); //dodatkowa metoda zatrzymaj spowoduje, że warunek pętli nie zostanie spełniony. Nie mamy jednak pewności w którym miejscu jest aktualnie wątek myThread - może więc się okazać, że zanim zostanie zakończony to wypisze jeszcze raz na konsoli i zaśnie, dopiero potem przejdzie do warunku pętli i się zatrzyma

        System.out.println("wszyscy skonczyli pracę, kończę program");
        */


        ExecutorService executorService = Executors.newFixedThreadPool(10); //obiekty executor service służą do zarządzania życiem tworzonych przez nas wątków. Jest ich kilka typów - w naszym przypadku używamy serwisu ze stałą ilością wątków
        for (int i = 0; i < 10; i++) {
            executorService.submit(new MyThread()); //serwisowi przekazujemy dziesięć obiektów naszych wątków, które
            // zostaną uruchomione.
        }
        executorService.shutdown(); //funkcja shutdown() spowoduje, że serwis nie przyjmie już więcej zadań (wywołań mettody submit() ) do wykonania - istniejące zadania będą przebiegały aż do końca. Metoda shutdown nie spowoduje, że wątek,który ją wywołuje (w naszym przypadku wątek główny) będzie czekał na zakónczenie zadań serwisu.
        try {
            executorService.awaitTermination(10, TimeUnit.SECONDS);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
