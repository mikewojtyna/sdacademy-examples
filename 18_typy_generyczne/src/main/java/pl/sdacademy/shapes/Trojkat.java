package pl.sdacademy.shapes;

public class Trojkat extends Ksztalt {

    private double wysokosc;
    private double podstawa;

    public Trojkat(double wysokosc, double podstawa) {
        this.wysokosc = wysokosc;
        this.podstawa = podstawa;
    }

    @Override
    public double polePowierzchni() {
        return wysokosc * podstawa / 2.0;
    }
}
