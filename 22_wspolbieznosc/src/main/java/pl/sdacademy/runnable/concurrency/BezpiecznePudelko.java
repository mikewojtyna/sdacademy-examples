package pl.sdacademy.runnable.concurrency;

public class BezpiecznePudelko implements Pudelko { //pudełko jest współdzielonym między wątki zasobem, służącym do
    // wymiany
    // np.
    // informacji. W naszym przypadku część wątków tylko te informacje wysyła (Producenci), a częśc odbiera (Konsumenci). Jednak często komunikacja ta odbywa się w dwie strony
    String zawartosc = null;

    @Override
    public  synchronized boolean wlozDoPudelka(String nowaZawartosc) { //metody oznaczona jako synchronized jest bezpieczna
        // dla wielu wątków - tylko jeden wątek na raz może w niej "przebywać" - nawet jeśłi zostanie wywłaszczony, inne wątki będą musiały poczekać aż wątek który zaczął tę funkcję, skończy ją
        while(zawartosc != null) { // dopóki pudełko nie jest puste
            try {
                wait(); //... nasz wątek zasypia. w przeciwieństwie do metody sleep, wait nie definiuje czasu zaśnięcia, ale czeka aż ktoś inny wywoła metodę notify lub notifyAll
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        zawartosc = nowaZawartosc; //kiedy pudełko jest już puste, wątek Producenta może w końcu włożyć do niego swoją zawartość
        notifyAll(); //następnie powiadamia inne wątki, że mogą próbować coś włożyć do pudełka
        return true;
    }

    @Override
    public synchronized String pobierzZawartosc() { //niestety metody i bloki oznaczone jako synchronized są dosyć kosztowne czasowo - wymagają założenia tzw. Locka, trzymanego przez szczęśliwy, pierwszy wątek. Po zakończeniu metody/bloku synchronized, lock jest zwalniany - ale takie zabezpieczenia kosztują nas czas procesora. Starajmy się tak projektować nasze współbieżne aplikację, by jak najrzadziej korzystały z synchronized, a jednocześnie były zabezpieczone przed tzw. race conditions.
        while(zawartosc == null) { //dopóki pudełko jest puste...
            try {
                wait(); //...wątek zasypia (j.w.)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        String pobranaZawartosc = zawartosc; //kiedy jest już pełne - można pobrać zawartość
        zawartosc = null; //a następnie wyczyścić pudełko
        notifyAll(); //powiadamiamy też inne wątki Konsumentów, aby próbowały pobrać zawartość pudełka (a nuż w miedzyczasie jakiś Producent znów je wypełnił?)
        return pobranaZawartosc;
    }
}
