package data_waznosci;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SprawdzaczWaznosci {

    public static void sprawdzWaznosc(Produkt produkt) {
        String produktDataWaznosciNapis = produkt.getDataWażności();
        DateTimeFormatter dataFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate produktDataWaznosci = LocalDate.parse(produktDataWaznosciNapis, dataFormatter);
        LocalDate teraz = LocalDate.now();

        if(teraz.isAfter(produktDataWaznosci)) {
            System.out.println("Produkt " + produkt.getNazwa() + " jest przeterminowany");
        } else {
            System.out.println("Produkt " + produkt.getNazwa() + " jest przydatny do spożycia");
        }
    }
}
