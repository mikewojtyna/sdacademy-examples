package pl.sdacademy;

public class StringTest2 {
    public static void main(String[] args) {
        int counter = 0;
        String text = "ala ma kota kot ma mleko";
        String letter = "a";
        int currentIndex = 0;
        while(text.contains(letter)) {
            currentIndex = text.indexOf(letter.charAt(0), 0) + 1;
            text = text.substring(currentIndex, text.length() - 1);
            counter ++;
        }
        System.out.println(counter);
    }
}
