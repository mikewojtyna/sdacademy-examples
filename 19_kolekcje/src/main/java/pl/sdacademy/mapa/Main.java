package pl.sdacademy.mapa;


import java.util.*;

public class Main {
    public static void main(String[] args) {

        Map<String, Integer> imionaWiek = new HashMap<>();
        imionaWiek.put("Gracjan", 25);
        imionaWiek.put("Zenobia", 57);
        imionaWiek.put("Gertruda", 45);
        imionaWiek.put("Eustachy", 90);

        System.out.println(imionaWiek);

        Map<String, List<String>> pracownicy = new HashMap<>();
        List<String> magazynierzy = new ArrayList<>();
        magazynierzy.add("Staszek");
        magazynierzy.add("Bogdan");

        List<String> managerowie = new ArrayList<>();
        managerowie.add("Kacper");
        managerowie.add("Ksawery");

        pracownicy.put("Magazynierzy", magazynierzy);
        pracownicy.put("Managerowie", managerowie);

        System.out.println(pracownicy);

        String napis = "ala ma kota kot ma mleko ale ale ala ala ala nie ma mleka kota pognał pies pies jest duzy i jest czarny";
        List<String> napisyRozdzielone = Arrays.asList(napis.split("\\s"));
        System.out.println(napisyRozdzielone);
        Map<String, Integer> liczbaWystapien = new HashMap<>();
        for(String elem: napisyRozdzielone) {
            if(liczbaWystapien.containsKey(elem)) {
                liczbaWystapien.put(elem, liczbaWystapien.get(elem) + 1);
            } else {
                liczbaWystapien.put(elem, 1);
            }
        }
        System.out.println(liczbaWystapien);

    }
}
