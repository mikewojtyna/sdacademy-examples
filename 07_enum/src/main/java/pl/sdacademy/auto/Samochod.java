package pl.sdacademy.auto;

public class Samochod {

    private final TypAuta typAuta; //pole ma być inicjalizowane w konstruktorze dlatego nie moze być static. Jednocześnie chcemy, aby raz utworzony obiekt samochód nie mógł zmienić swojego typu, dlatego typAuta jest stałą (final)
    private String nazwa;

    public Samochod(TypAuta typAuta, String nazwa) {
        this.typAuta = typAuta;
        this.nazwa = nazwa;
    }

    @Override
    public String toString() {
        return "Samochod{" +
                "typAuta=" + typAuta +
                ", nazwa='" + nazwa + '\'' +
                '}';
    }
}
