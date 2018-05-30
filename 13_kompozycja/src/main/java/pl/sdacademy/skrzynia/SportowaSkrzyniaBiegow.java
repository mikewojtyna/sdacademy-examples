package pl.sdacademy.skrzynia;

public class SportowaSkrzyniaBiegow implements SkrzyniaBiegow {
    private static final int MAX_LICZBA_BIEGOW = 6;
    private int aktualnyBieg = 0;

    @Override
    public void zwiekszBieg() {
        if(aktualnyBieg + 1 < MAX_LICZBA_BIEGOW) {
            aktualnyBieg++;
            System.out.println("Sportowa skrzynia: zwiększam bieg" + aktualnyBieg);
        }
    }

    @Override
    public void zmniejszBieg() {
        if (aktualnyBieg - 1 > 0) {
            aktualnyBieg--;
            System.out.println("Sportowa skrzynia: zmniejszam bieg " + aktualnyBieg);
        }
    }
}
