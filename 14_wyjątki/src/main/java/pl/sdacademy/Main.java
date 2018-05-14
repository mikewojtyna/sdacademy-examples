package pl.sdacademy;


import org.apache.log4j.Logger;
import pl.sdacademy.exception.BadEmailException;
import pl.sdacademy.users.User;

public class Main {

    static Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        User user = new User(); //konstruktor bezargumentowy nie rzuca wyjątku - nie musimy więc otaczać go klauzulą try/catch
        user.setName("Janek");
        //ale już metoda setEmail musi być zabezpieczona:
        try {
            user.setEmail("janek.com");
            System.out.println(user);
        } catch (BadEmailException ex) {
            logger.error("Wyjątek! Wiadomość: ", ex); //obiekt wyjątku (ex) przetrzymuje wiadomość którą
            // zostałą dodana w trakcie jego rzucania. często okazuje się to bardzo pomocne
        } finally {
            logger.debug("To jest blok finally");
        }

        //teraz użyjemy drugiego konstruktora - musimy otoczyć klauzulą try/catch tworzenie obiektu bo ten konstruktor wyrzuca wyjątek BadEmailException
        User user2 = null;
        try {
            user2 = new User("Janek", "janek.com");
            System.out.println(user2);
        } catch (Exception ex) { //możemy użyć klasy bazowej - wtedy złapalibyśmy też ewentualne inne wyjątki dziedziczące po klasie Exception
            logger.error("To już drugi wyjątek! Wiadomość: ", ex);
        }

        //zróbmy to jeszcze raz, ale użyjmy w końcu poprawnego adresu - wyjątek nie powinien zostać rzucony
        User user3 = null;
        try {
            user3 = new User("Adam", "adam@example.com");
        } catch (BadEmailException ex) {
            logger.error("No nie! Trzeci wyjątek! Nie przesadzasz? Wiadomość: ", ex);
        }
    }
}
