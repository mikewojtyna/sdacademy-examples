package data_waznosci;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        Produkt jablka = new Produkt("Jabłka", "12/07/2017");
        Produkt sliwki = new Produkt("śliwki", "20-08-2018");
        SprawdzaczWaznosci.sprawdzWaznosc(jablka);
        SprawdzaczWaznosci.sprawdzWaznosc(sliwki);
        LocalDate teraz = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate potem = LocalDate.parse("22-07-2017", formatter);
        System.out.println(potem.minusDays(teraz.getDayOfMonth()));

    }
}
