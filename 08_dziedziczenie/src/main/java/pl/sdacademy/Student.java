package pl.sdacademy;

public class Student extends Osoba {

    private int numerIndeksu;

    public Student(String imie, String nazwisko, int numerIndeksu) {
        super(imie, nazwisko);
        this.numerIndeksu = numerIndeksu;
    }

    @Override
    public void opiszSie() {
        System.out.println("Jestem studentem o indeksie " + numerIndeksu + " imie " + getImie());
    }
}
