package pl.sdacademy.callable;


import pl.sdacademy.callable.concurrency.LosowyNapis;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<Future<String>> listaPrzyszlychNapisow = new ArrayList<>(); //ponieważ inne wątki działają niezależnie od naszego głównego wątku - trudno przewidzieć kiedy otrzymamy wynik ich działania. być mozę zakończą działąnie natychmiast, ale rónie dobrze mogą coś obliczać kilka minut
        // do określania takich wartości, które mają pojawić się w przyszłości - służy interfejs Future.

        for (int i = 0; i < 100; i++) { //powołujemy do życia i uruchamiamy sto wątków, które zwracają losowy napis.
            Future<String> przyszlyNapis = executorService.submit(new LosowyNapis()); //wynik ich działania jest obiektem typu Future - czyli wartością mającą się pojawić w przyszłości
            listaPrzyszlychNapisow.add(przyszlyNapis);
        }
        executorService.shutdown();
        for(Future<String> przyszlyNapis : listaPrzyszlychNapisow) { //iterujemy po liście naszych Future'ów
            try {
                String prawdziwyNapis = przyszlyNapis.get(); //metoda get zwróci wartość naszego Future'a o ile już się pojawiła. W przeciwnym wypadku będzie czekać na jej pojawienie. Dopiero wtedy program ruszy dalej.
                System.out.println(prawdziwyNapis);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

    }
}
