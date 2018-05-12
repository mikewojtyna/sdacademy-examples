package pl.sdacademy.zwierze;

public class Main {
    public static void main(String[] args) {
        Zwierze [] zoo = {
                 new Zwierze("Leon", 2, "Lew"),
                new Zwierze("Jadźka", 3, "Owca"),
                new Zwierze("Reksio", 1, "Rekin")
            };

        for (Zwierze zwierze: zoo) {
            if(zwierze.czyGrozny()) {
                System.out.println(zwierze.getGatunek() + " " + zwierze.getImie() + " jest groźnym zwierzęciem! Lepiej uciekaj");
            }
            else {
                System.out.println(zwierze.getGatunek() + " " + zwierze.getImie() + " nie jest groźnym zwierzęciem - można pogłaskać");
            }
        }


    }
}
