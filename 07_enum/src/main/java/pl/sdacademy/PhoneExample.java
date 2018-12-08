package pl.sdacademy;


import pl.sdacademy.telefon.MarkaTelefonu;

import java.util.Scanner;

public class PhoneExample
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj markę telefonu");
        String markaNapis = scanner.nextLine();

        switch(markaNapis.toUpperCase()) { //dzięki metodzie toUpperCase() możemy zapomnieć o wielkości liter marki wpisanej przez użytkownika

            case "SAMSUNG":
                wypiszMarkę(MarkaTelefonu.SAMSUNG);
                break;
            case "HUAWEI":
                wypiszMarkę(MarkaTelefonu.HUAWEI);
                break;
            case "IPHONE":
                wypiszMarkę(MarkaTelefonu.IPHONE);
                break;
            case "LENOVO":
                wypiszMarkę(MarkaTelefonu.LENOVO);
                break;
            case "XIAO MI": //dzięki temu zabiegowi program zachowa się poprawnie bez względu czy użytkownik wpisze nazwę ze spacją czy bez.
            case "XIAOMI":
                wypiszMarkę(MarkaTelefonu.XIAO_MI);
                break;
            default:
                System.out.println("Nie znam tej marki");

        }
    }

    public static void wypiszMarkę(MarkaTelefonu markaTelefonu) {
        System.out.println("Wybrana marka to " + markaTelefonu + ", jej popularność jest równa " + markaTelefonu.getPopularnosc());
    }
}
