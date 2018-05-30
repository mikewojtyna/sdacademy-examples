package pl.sdacademy;

public class StringTest1 {
    public static void main(String[] args) {
        String napis1 = "Ala ma kota";
        String napis2 = "aLa";
        System.out.println(napis1.contains(napis2));
        System.out.println(napis1.toUpperCase().contains(napis2.toLowerCase()));
        napis1 = napis1.toLowerCase();
        napis2 = napis2.toLowerCase();
        System.out.println(napis1.contains(napis2));
        napis1.charAt(4);

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Hello");
        stringBuilder.append(" poraz ");
        stringBuilder.append(3);
        stringBuilder.reverse();
        System.out.println(stringBuilder);
        String ostatecznyString = stringBuilder.toString();
        String test1 = "Ala" + " ma " + "kota";
        String test2 = "Ala".concat(" ma ").concat("kota");
        ostatecznyString.concat("other string");
    }
}
