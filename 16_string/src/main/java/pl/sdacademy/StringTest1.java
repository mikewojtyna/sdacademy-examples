package pl.sdacademy;

public class StringTest1 {
    public static void main(String[] args) {
        String napis1 = "Ala ma kota";
        String napis2 = "aLa";
        System.out.println(napis1.toLowerCase().contains(napis2.toLowerCase()));
        napis1 = napis1.toLowerCase();
        napis2 = napis2.toLowerCase();
        System.out.println(napis1.contains(napis2));
    }
}
