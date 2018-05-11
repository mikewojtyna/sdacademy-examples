package pl.sdacademy.zwierze;

public class Lew extends Zwierze {

    public Lew(String nazwa) {
        super(nazwa);
    }

    @Override
    public void dajGlos() {
        System.out.println("Lew " + getNazwa() + " ryczy! RRR!!");
    }

    @Override
    public int ileJe() {
        return 20 * getNazwa().hashCode();
    }
}
