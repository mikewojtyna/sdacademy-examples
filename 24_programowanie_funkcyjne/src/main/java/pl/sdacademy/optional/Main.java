package pl.sdacademy.optional;

import pl.sdacademy.user.User;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        String napis = "Jakis nie";
        napis = null;
        Optional<String> opcjonalnyNapis = Optional.ofNullable(napis); //nowy optional możemy utworzyć za pomocą metod: empty(), of(object) i ofNullable(object). Pierwsza utworzy pusty optional - czyli taki trzymający obiekt null. Druga utworzy Optional z potencjalną zawartością, ale jeżeli przekażemy jej null, wyrzuci wyjątek. Ostatnia utworzy Optional z potencjalną zawartością - może to być prawidłowy obiekt lub też null
        System.out.println("opcjonalnyNapis coś zawiera: "
                + opcjonalnyNapis.isPresent());
        String zawszePelny = opcjonalnyNapis.orElse("DOMYSLNY NAPIS"); //wartość trzymaną przez optional mozemy pobrać za pomocą metody get(), ale jeśli w środku znajdował się null - metoda wyrzuci wyjątek. Dzięki metodzie orElse możemy ustawić wartość (obiekt), który będzie zwracany w przypadku, gdy w Optionalu znajduje się null. W wyniku tego metoda orElse nigdy nie zwróci wartości null.
        System.out.println(zawszePelny);

        Optional<String> przetworzonyNapis = opcjonalnyNapis.map(str -> str.toUpperCase()); //metoda map służy do wykonania jakiejś operacji na zawartości, o ile ta zawartość istnieje (w przeciwnym wypadku po prostu nic się nie stanie). Metoda map przyjmuje obiekt Function - może być to jakaś lambda przyjmująca jeden argument (który jest zawartością Optionala) i zwracającą obiekt tego samego typu. W środku więc mozemy przetworzyć zawartość optionala i taką zmienioną zawartość umieścić w naszym Optionalu
        przetworzonyNapis.ifPresent(System.out::println);

        Optional<String> krotkiNapis = opcjonalnyNapis.filter(str -> str.length() < 10);  // metoda filter przyjmuje lambdę Predicate (przyjmującą jeden argument i zwracającą wartośc logiczną - boolean). Jeśli obiekt w optionalu spełnia warunek (czyli lambda dla tego obiektu zwróci prawdę), obiekt pozostanie w optionalu, w przeciwnym wypdaku zostanie zastąpiony nullem
        krotkiNapis.ifPresent(System.out::println); //metoda ifPresent optionala przyjmuje obiekt typu Function (czyli np. lambdę przyjmującą jeden argument i nic nie zwracającą). Lambda na obiekcie zostanie wykonana tylko wtedy, kiedy ten obiekt istnieje, czyli w optionalu jest coś innego niż null

        User ktos = new User("Adam", "Kowalski", 24);
        ktos = null;
        //zad 1 utwórz optional dla usera "ktoś"
        //zad 2 jeżeli user w optionalu jest = null, wyświetl usera z danymi
        //      (imie="NN", nazwisko="NN", wiek=-1)
        //zad 3 pewna baza danych potrzebuje imiona i nazwiska pisane z wielkiej litery.
        //     Przetworz usera na string ale pisany wielkimi literami.
        //     Wyswietl go jeżeli nie jest nullem
        //zad 4 Sprawdz czy user ktos jest starszy niz 20 lat, potem niz 30 lat.
        //     Jesli nie spełnia tego warunku - usuń go.
    }
}
