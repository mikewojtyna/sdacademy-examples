package pl.sdacademy.thread.concurrency;

import java.util.Random;

public class MyThread extends Thread { //przeciążanie klasy Thread jest raczej niewskazane, ale czasami można się spotkać z taką impelemntacją współbieżności - starajmy się jednak korzystać z interfejsu Runnable

    private int counter = 0;
    private boolean stop = false;
    private Random random = new Random();

    @Override
    public void run() { //metoda run to najważniejsza metoda klasy Thread - ona definiuje co tak naprawdę robi nasz wątek.
        while(!stop) { //nasz wątek ma powtarzać jedną czynnosć aż warunek stop nie zmieni wartości
            counter++;
            System.out.println(getName() + " mówi: hej poraz " + counter);
            try {
                sleep(random.nextInt(20)); //metoda statyczna sleep jest wywoływana zawsze na rzecz wątku, z którego została wywołana. Służy ona do uśpienia wątku na porządany czas (w ms)
            } catch (InterruptedException e) {
                stop = true;
                e.printStackTrace();
            }
        }
    }

    public void zatrzymaj() {
        stop = true;
    }


}
