package exercies;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class DataICzas {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String date1 = scanner.nextLine();

        LocalDate dzisiaj = LocalDate.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        String napisDzisiaj = dzisiaj.format(dateFormatter);
        System.out.println("Dzisiejsza data: " + napisDzisiaj);

        LocalDate wczoraj = dzisiaj.minusDays(1);
        String napisWczoraj = wczoraj.format(dateFormatter);
        System.out.println("Wczoraj był " + napisWczoraj);

        System.out.println("Wczoraj było wcześniej? " + wczoraj.isBefore(dzisiaj));

        LocalTime taChwila = LocalTime.now();
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        System.out.println(taChwila.format(timeFormatter));

        LocalDateTime dzisiajDataCzas = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy -- HH:mm:ss");
        System.out.println(dzisiajDataCzas.format(dateTimeFormatter));

        ZonedDateTime czasParyz = ZonedDateTime.now(ZoneId.of("Europe/Paris"));
        ZonedDateTime czasTokio = ZonedDateTime.now(ZoneId.of("Asia/Tokyo"));
        ZonedDateTime czasLosAngeles = ZonedDateTime.now(ZoneId.of("America/Los_Angeles"));

        System.out.println("W Paryżu jest teraz " + czasParyz.format(dateTimeFormatter));
        System.out.println("W Tokio jest teraz " + czasTokio.format(dateTimeFormatter));
        System.out.println("W Los Angeles jest teraz " + czasLosAngeles.format(dateTimeFormatter));

        ZonedDateTime timeConverted = ZonedDateTime.of(dzisiajDataCzas, ZoneId.of("America/Los_Angeles"));
        System.out.println("Czas przekonwertowany z polski na los " +
                "angeles " + timeConverted.format(dateTimeFormatter));

        String urodzinyNapis1 = "13/09/1992";
        String urodzinyNapis2 = "13/10/1992";
        LocalDate urodziny1 = LocalDate.parse(urodzinyNapis1, dateFormatter);
        LocalDate urodziny2 = LocalDate.parse(urodzinyNapis2, dateFormatter);
        if(urodziny1.isAfter(urodziny2)) {
            System.out.println("Maciej jest młodszy od Michała");
        } else if(urodziny1.isBefore(urodziny2)) {
            System.out.println("Maciej jest starszy od Michała");
        } else {
            System.out.printf("Maciej ma urodziny dokładnie w dniu urodzin Michała");
        }

    }

}
