package pl.sdacademy;

public class Pracownik extends Osoba {

    private int placa;

    public Pracownik(String imie, String nazwisko, int placa) {
        super(imie, nazwisko);
        this.placa = placa;
    }

    @Override
    public void opiszSie() {
        System.out.println("Jestem pracownikiem " + getImie() + " moja placa to " + placa + " PLN");
    }
}
