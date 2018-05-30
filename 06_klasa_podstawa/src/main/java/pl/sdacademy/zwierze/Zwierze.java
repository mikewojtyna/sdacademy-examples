package pl.sdacademy.zwierze;

import javax.swing.*;

// klasy nie będące klasami wewnętrznymi (ang. nested class) mają modyfikator public lub dostęp domyślny - package private
// klasy wewnętrzne to klasy zdefiniowane wewnątrz klasy.
public class Zwierze {

    //na początku definiujemy pola. Jeśli używamy stałych (np. static final double PI = 3.14 - przyp.), zazwyczaj umieszczamy je nad pozostałymi polami
    private String imie;
    private int wiek;
    private String gatunek;

    // w następnej kolejności dodajemy konstruktory - zazwyczaj są publiczne, ale w niektórych szczególnych przypadkach celowo
    // stosuje się modyfikator private lub protected (np. we wzorcu Singleton)
    // Klasa może posiadać wiele konstruktorów - tworzenie obiektu może być przeprowadzane na wiele sposobów.
    // Klasy nie dziedziczą konstruktorów, ale jeśli nie zdefiniujemy żadnego, klasa będzie posiadała bezargumentowy konstruktor domyślny
    // Napisanie jakiegokolwiek konstruktora powoduje, że konstruktor domyślny nie będzie przez javę generowany.
    public Zwierze(String imie, int wiek, String gatunek) {
        // konstruktor służy do nadania początkowego stanu naszego obiektu - jest wywoływany podczas użycia go w kontekście słowa kluczowego new.
        // w tym przypadku wszystkim polom nadajemy początkowe wartości.
        this.imie = imie;
        this.wiek = wiek;
        this.gatunek = gatunek;
    }

    // po konstruktorach (pamiętajmy, że może być ich wiele), następują metody publiczne - czyli interfejs (nie mylić z Interface) jaki nasza klasa
    // udostępnia jej użytkownikom

    // bardzo często klasy posiadają gettery (inna nazwa: akcesory) oraz settery (inna nazwa: mutuatory) - czyli metody służące kolejno
    // do pobierania wartości/referencji pola oraz jego aktualizacji. Nasze klasy powinny być pisane zgodnie z regułą hermetyzacji
    // nie udostępniamy naszych pół bezpośrednio (poprzez tworzenie pól publicznych), ale kontrolujemy do nich dostęp właśnie przez
    // gettery i settery, a najlepiej przez jeszcze bardziej abstrakcyjny interfejs
    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public int getWiek() {
        return wiek;
    }

    public void setWiek(int wiek) {
        this.wiek = wiek;
    }

    public String getGatunek() {
        return gatunek;
    }

    public void setGatunek(String gatunek) {
        this.gatunek = gatunek;
    }


    // publiczna metoda naszej klasy - inne klasy mogą korzystać z tej metody na obiektach naszej klasy, do których mają dostęp (które np.
    // utworzyły jako własne pola lub zmienne w metodach
    public boolean czyGrozny() {
        return gatunek.equals("Lew") || gatunek.equals("Tygrys") || gatunek.equals("Rekin"); //można zapisać to dłużej z wykorzystaniem if else, ale po co?
    }

    //adnotacja override służy do oznaczania przeciążeń (w przypadku nadpisywania metod klasy bazowej) lub implementacji (w przypadku metod impelementowanego
    // interfejsu bądź metody abstrakcyjnej. Oprócz wizualnego zaznaczenia, że jest to przeciążana metoda, dzięki tej adnostacji dowiemy się,
    // jeśli tak naprawdę nie przeciążamy metody, choć myślimy że przeciążamy :) np. gdybyśmy zrobili literówkę i napisali toStringg zamiast toString
    // dzięki adnotacji @Override zostaniemy ostrzeżeni
    // przeciążana metoda musi mieć taką samą nazwę, zwracany typ oraz liczbę i typy argumentów
    // co więcej, przeciążana metoda nie może zawężać dostępu, tzn. jeśli w klasie bazowej metoda była public, to nie możemy zrobić z niej private w
    // klasie pochodnej
    @Override
    public String toString() {
        return "Zwierze{" +
                "imie='" + imie + '\'' +
                ", wiek=" + wiek +
                ", gatunek='" + gatunek + '\'' +
                '}';
    }


}
