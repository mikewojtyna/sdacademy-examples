package pl.sdacademy.exception;

public class BadEmailException extends Exception { //nasz wyjątek powinien zazwyczaj dziedziczyć po klasie exception lub po jakimś bardziej specyficznym wyjątku np. IOException itd

    public BadEmailException(String message) { //chcemy przekazać razem z wyjątkiem jakąś informację dla obsługującego wyjątek, dlatego definiujemy własny konstruktor, w którym wywołujemy odpowiedni konstruktor klasy bazowej
        super(message);
    }

}
