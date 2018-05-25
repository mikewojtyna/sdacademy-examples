package pl.sdacademy.lambda;

import pl.sdacademy.user.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {


        Consumer<User> wypisz = System.out::println; //interfejs Consumer służy do definiowania lambd (czyli funkcji) przyjmujących 1 argument i nie zwracający niczego (czyli void). Wartość podana do funkcji jest jakby "konsumowana" - niczego nie zwraca (stąd nazwa)
        // Jeśli nasza lambda składa się z wywołania jednej metody (nie jest złożona), a przyjmowane argumenty (ich typ i liczba) oraz zwracana wartość (o ile funkcja coś zwraca - akurat Consumer nic nie zwraca, podobnie jak funkcja System.out::println) są takie same,
        // możemy przypisać do obiektu o typie danego interfejsu, tą właśnie metodę. Przekazywana metoda wygląda tak: klasa::metoda, warto zauważyć, że po nazwie metody nie występują żadne nawiasy okrągłe - świadczyłyby one o wywołaniu metody a my chcemy tę metodę jedynie wysłać
        User staszek = new User("Staszek", "Nowak", 23);
        User zdzisiek = new User("Zdzisiek", "Kowslaki", 34);
        wypisz.accept(staszek); //interfejs Consumer posiada metodę accept do uruchomienia drzemiącej w obiekcie funkcji

        Function<User, Integer> podajWiek = usr -> usr.getWiek(); //inna wersja lambdy - za pomocą strzałki -> mozemy definiować lambdy proste i złożone (które po prawej stronie mają blok kodu). Z lewej strony strzałki znajdują się argumenty -
        // w przeciwieństwie do zwykłych funkcji nie musimy podawać ich typów (chociaż możemy). Jeśli lambda przyjmuje tylko jeden argument, nie musimy go otaczać nawiasami okrągłymi. Jeśli argumentów jest więcej - umieszczamy je po przecinku w takich nawiasach
        // za strzałką może znajdować się pojedyncza instrukcja (zauważmy, że nie musimy w niej wcale używać przekazanego argumentu lambdy) lub blok kodu z wieloma instrukcjami - ale w takim przypadku jeśli lambda powinna coś zwracać, w bloku musimy umieścić słowo return
        System.out.println(podajWiek.apply(staszek)); // wynik działania naszej lambdy mozemy od razu podać innej funkcji

        BiFunction<User, Integer, User> dodajLata = (usr, wiek) -> { //w tym przypadku używamy dwóch argumentów (tak jak wymaga interfejs BiFunction) i złożonej instrukcji (bloku kodu) oraz słówka return (nasz interfejs BiFunction oczekuje dwóch argumentów, pierwszego typu User, drugiego typu Integer, natomiast trzeci typ podany w nawiasach <> informuje, że lambda powinna zwrócić obiekt typu User
            usr.setWiek(usr.getWiek() + wiek);
            return usr;
        };

        //wypisz.accept(dodajLata.apply(staszek, 20));

        Porownaj porownajWiek = (usr1, usr2) -> usr1.getWiek() > usr2.getWiek(); //tutaj przypisaliśmy lambdę do własnego interfejsu - ważne, żeby liczba, typy argumentów oraz typ zwracany były takie same jak w interfejsie
        Porownaj porownajDlugoscImion = (usr1, usr2) -> usr1.getImie().length() > usr2.getImie().length();

        System.out.println("Czy staszek jest starszy od zdziśka: "
                + porownajWiek.porownaj(staszek, zdzisiek));

        System.out.println("Czy staszek ma dłuższe imie niż zdzisiek: "
                + porownajDlugoscImion.porownaj(staszek, zdzisiek));

        List<String> imiona = Arrays.asList("Adam", "Asia", "Krysia", "Basia", "Zdzisiek", "Staszek");

        List<String> imionaWielkie = new ArrayList<>();
        imiona.forEach(imie -> imionaWielkie.add(imie.toUpperCase())); //interfejs List posiada nową metodę - forEach, przyjmującą obiekt Consumer - czyli lambdę przyjmującą jeden argument i niczego nie zwracającą. W środku lambdy możemy korzystać z zewnętrznych zmiennych (tutaj: imionaWielkie), ale nie możemy zmieniać (przypisywać) im referencji (lub w przypadku typów prostych - wartości) - są jakby stałe w kontekście lambdy
        System.out.println(imionaWielkie);
        imionaWielkie.forEach(System.out::println); //metoda System.out::println jest dobrym Consumerem - przyjmuje jeden argument i niczego nie zwraca - dlatego mozemy wrzucić ją jako argument dla metody forEach.

        Function<List<String>, String> sklejListe = (listaNapisow ->
                String.join(";", listaNapisow)); //nasze lambdy mogą pracować na bardziej złożonych strukturach, takich jak lista czy mapa

        System.out.println(sklejListe.apply(imiona));
    }

    public interface Porownaj {
        boolean porownaj(User usr1, User usr2);
    }
}













