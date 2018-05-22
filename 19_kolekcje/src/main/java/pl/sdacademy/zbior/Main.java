package pl.sdacademy.zbior;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String napis = "ala ma kota fff ala ma czajnik\tale\nnie ma gwizdka ma też drugiego kota";
        //Set<String> zbiorSlow = new HashSet<>(Arrays.asList(napis.split("\\s")));
        String [] napisyTablica = napis.split("\\s");


        Set<Character> uniqueChars = new HashSet<>();
        for(char character : napis.toCharArray()) {
            uniqueChars.add(character);
        }

        System.out.println("UNIQUE CHARS: " + uniqueChars);

        List<String> napisyLista = Arrays.asList(napisyTablica);
        System.out.println("Napisy lista: " + napisyLista);
        Set<String> zbiorSlow = new HashSet<>(napisyLista);
        System.out.println("Napisy zbior: " + zbiorSlow);

        String napis2 = "Napis 1";
        boolean warunek = !napis.equals("exit");

    }
}
