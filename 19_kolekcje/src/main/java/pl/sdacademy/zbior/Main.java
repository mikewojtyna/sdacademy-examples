package pl.sdacademy.zbior;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String napis = "ala ma kota ala ma czajnik\tale\nnie ma gwizdka ma też drugiego kota";
        //Set<String> zbiorSlow = new HashSet<>(Arrays.asList(napis.split("\\s")));
        String [] napisyTablica = napis.split("\\s");
        List<String> napisyLista = Arrays.asList(napisyTablica);
        System.out.println("Napisy lista: " + napisyLista);
        Set<String> zbiorSlow = new HashSet<>(napisyLista);
        System.out.println("Napisy zbior: " + zbiorSlow);

    }
}
