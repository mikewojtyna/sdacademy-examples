package pl.sdacademy.zwierze;

public class Slon extends Zwierze { //słoń to prosta klasa, rozszerzająca klasę Zwierzę. Dzięki przeciążaniu jej
    // metod, może zachowywać się inaczej niż obiekty innych klas, ale użytkownik zmiennej nie musi znać szczegółów
    // implementacji poszczególnych metod.

    public Slon(String nazwa) {
        super(nazwa);
    }

    @Override
    public void dajGlos() {
        System.out.println("Slon " + getNazwa() + " trąbi! Turrruuum!"); //słoń trąbi - w specyficzny dla siebie
        // sposób. Inne Klasy mogę definiować to zachowanie zupełnie inaczej
    }

    @Override
    public int ileJe() {
        return 20 * getNazwa().length();
    } // ilość jedzenia, jakie zjada słoń zależy od długości jego imienia - ta implementacja jest bez sensu, ale kto
    // nam zabroni?
}
