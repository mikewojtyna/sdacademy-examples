package pl.sdacademy.stream;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExerciseMain {

    public static void main(String[] args) {
        List<String> imiona = Arrays.asList("Adam", "Jola", "Agnieszka", "Marcin", "Michał", "Jacek"); //do naszej zabawy potrzebujemy jakąś strukturę którą nasz stream będzie mógł wykorzystać jako źróło danych. Może to być tablica, lista, set czy mapa
        Stream.of(imiona); //aby utworzyć stream, możemy użyć statycznej metody of() klasy Stream...
        List<String> duzeImiona = imiona.stream() // ...lub zwrócić go ze struktury za pomocą metody stream(). Podstawowe kolekcje posiadają taką metodę od javy 8.
                .map(String::toUpperCase) // na takim strumieniu mozemy wykonać wiele operacji przetwarzających dane - w tym przypadku funkcja toUpperCase będzie "zmapowana" na każdy element naszej źródłowej listy
                .collect(Collectors.toList()); //zazwyczaj na końcu sekwencji metod wywoływanych na streamie wywołujemy metodę collect, aby zebrać wyniki działania streama w jakąś strukturę. Klasa Collectors posiada wiele przydatnych "zbieraczy" (metod przetwarzjących stream na jakąś strukturę czy kolekcję), w tym przypadku zamieniamy stream z powrotem na listę.
        System.out.println(duzeImiona);
        Map<String, Integer> dlugoscImion = imiona.stream()
                .collect(Collectors.toMap(imie -> imie, imie -> imie.length())); //aby przetworzyć stream na mapę, musimy dać mu zasady wg. których ma tworzyć klucze i wartości tej mapy - metoda toMap przyjmuje dwie lambdy typu Function. Pierwsza służy do utworzenia klucza - w naszym przypadku jest to dosłownie ten sam element co w liście. Druga lambda służy do zdefiniowania na jakiej zasadzie mają być tworzone wartości - w naszym przypadku będzie to długość napisu.
        System.out.println(dlugoscImion);

        String napisZImion = imiona.stream()
                .collect(Collectors.joining(";")); //w klasie Collectors znajduje się np. metoda do klejenia elementó streama za pomocą ustawionego delimitera
        System.out.println(napisZImion);

        IntSummaryStatistics statystyki = imiona.stream() //w tym przypadku chcemy uzyskać statystyki liczbowe o typie całkowitym Integer (są też odpowiedniki innych typów liczbowych, np. Double)
                .mapToInt(napis -> napis.length()) //przetwarzamy nasze napisy tak, żeby dostać liczbę. W naszym przypadku chcemy przetworzyć napis na jego długość
                .summaryStatistics(); //funkcja summaryStatistics zwraca obiekt summary statistics odpowiedniego typu.
        System.out.println("Max dlugosc napisu: " + statystyki.getMax());
        System.out.println("Srednia dlugosc napisu: " + statystyki.getAverage());
    }
}














