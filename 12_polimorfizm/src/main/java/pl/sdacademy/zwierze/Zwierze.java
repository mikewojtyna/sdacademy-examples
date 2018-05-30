package pl.sdacademy.zwierze;

public abstract class Zwierze {
    private String nazwa;

    public Zwierze(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getNazwa() {
        return nazwa;
    }

    public abstract void dajGlos();

    public abstract int ileJe();

}
