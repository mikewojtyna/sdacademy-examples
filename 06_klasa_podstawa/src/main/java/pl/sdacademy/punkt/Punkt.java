package pl.sdacademy.punkt;

public class Punkt {
    private double x;
    private double y;

    public Punkt() {
    }

    public Punkt(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double distance(Punkt inny) {
        double x1 = this.x;
        double y1 = this.y;
        double x2 = inny.getX();
        double y2 = inny.getY();
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }

    public double sumX(Punkt ... punkts) {
        double suma = 0.0;
        for(Punkt punk : punkts) {
            suma += punk.getX();
        }
        return suma;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Punkt{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
