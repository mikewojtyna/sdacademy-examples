package pl.sdacademy.shapes;

public class Kwadrat extends Ksztalt {

    private double bok;

    public Kwadrat(double bok) {
        this.bok = bok;
    }

    @Override
    public double polePowierzchni() {
        return bok * bok;
    }
}
