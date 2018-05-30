package pl.sdacademy.stream;

import pl.sdacademy.stream.movie.Film;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class FilmMain {
    public static void main(String[] args) {

        List<Film> filmy = Arrays.asList( //nasza biblioteczka filmów jest skromna, ale wiele można z nią zrobić
          new Film("Obcy",
                  "Riddley Scott",
                  LocalDate.of(1990, 10, 31),
                  39.99, Arrays.asList("Akcja", "Horror"),
                  Arrays.asList("Sigourney Weaver", "Bradd Pitt")),
          new Film("Casablanca",
                    "Michael Curtis",
                    LocalDate.of(1942, 11, 26),
                    29.99, Arrays.asList("Dramat", "Kryminał"),
                    Arrays.asList("Humphrey Bogart", "Ingrid Bergman")),
          new Film("Troya",
                    "Michael Curtis",
                    LocalDate.of(2008, 11, 26),
                    59.99, Arrays.asList("Akcja", "Historyczny"),
                    Arrays.asList("Bradd Pitt", "Orlando Bloom"))
            );

        List<String> tytuły = filmy.stream()
                .map(film -> film.getTytuł()) //na rozgrzewkę chcemy uzyskać po prostu listę tytułów. Wystarczy obiekt typu Film zamienić na to co zwraca jego metoda getTytuł()
                .collect(Collectors.toList());
        System.out.println(tytuły);

        List<String> zBraddem = filmy.stream() //ten stream jest poważniejszy - chcemy na końcu uzyskać listę filmów z braddem pittem
                .filter(film -> film.getListaAktorów().contains("Bradd Pitt")) //podajemy warunek dla filtru (czyli lambdę typu Predicate) - warunkiem jest zawieranie w liście aktorów właśnie bradda pitta
                .map(film -> film.getTytuł()) //pozotałe, przefiltrowane filmy chcemy zamienić na ich tytuły - nie potrzebujemy całych obiektów
                .map(tytul -> tytul.toUpperCase()) //dodatkowo mapujemy funkcję toUpperCase na każdym pozostałym tytule
                .filter(duzyTytuł -> duzyTytuł.length() > 5) //większosć funkcji wywoływanych na streamie zwraca ten sam stream, dlatego możemy za pomocą kropki sklejać go dalej z kolejnymi wywołaniami funkcji
                .collect(Collectors.toList()); // jak zazwyczaj, na końcu zbieramy efekty naszej pracy metodą collect, przekazując odpowiedni obiekt kolekcjujący (w tym przypadku chcemy po prostu listę)
        System.out.println("Z Braddem: " + zBraddem);

        DoubleSummaryStatistics cenaStatystyki = filmy.stream()
                .mapToDouble(Film::getCenaDVD).summaryStatistics(); //analogicznie do przykłądu wyżej, zbieramy statystyki dotyczące ceny - tym razem używamy typu zmiennoprzecinkowego Double.
        System.out.format("Srednia cena filmu to %.2f\n", cenaStatystyki.getAverage());

        Set<String> aktorzyWMoichFilmach = filmy.stream()
                .flatMap(film -> film.getListaAktorów().stream()) //funkcją flatMap w naszym streamie "spłaszczamy" strukturę naszych filmów - nie jest to już lista obiektów zawierających listy aktorów, ale stream zawierający elementy wszystkich list aktorów - jest więc "płaski"-
                .collect(Collectors.toSet()); //aby uniknąć powtórzeń, naszą listę zamieniamy na zbiór - Set
        System.out.println("Aktorzy: " + aktorzyWMoichFilmach);

        Map<String, List<Film>> grupowaniePoRezyserach = filmy.stream()
                .collect(Collectors.groupingBy(Film::getRezyser)); //metodą groupingBy możemy wskazać w jaki sposób chcemy pogrupować obiekty - w naszym przypadku dostaniemy mapę, której kluczami będą reżyserzy, a wartościami listy filmów, które wyreżyserowali
        System.out.println("Grupowanie: " + grupowaniePoRezyserach);
        System.out.println(grupowaniePoRezyserach.get("Michael Curtis")
            .stream().map(film -> film.getTytuł()).collect(Collectors.toList()));

        List<Film> filmyWDolarach = filmy.stream()
                .map(film -> {
                    Film filmUSD = new Film(film); //aby nie modyfikować obiektów oryginalnej listy, tworzymy kopię elementu...
                    filmUSD.setCenaDVD(film.getCenaDVD() / 3.8D); // ...którą to następnie modyfikujemy...
                    return filmUSD; //... i zwracamy jako efekt działania naszej lambdy
                })
                .collect(Collectors.toList());
        System.out.println("W dolarach: " + filmyWDolarach);
        System.out.println("Oryginalne : " + filmy);

        System.out.println("Oryginalne zmodyfikowane filmy: " + filmy);

    }
}
