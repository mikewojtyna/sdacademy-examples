package pl.sdacademy.sprzeglo;

public class SportoweSprzeglo implements Sprzeglo {
    @Override
    public void wcisnijSprzeglo() {
        System.out.println("Wciskam sprzeglo");
    }

    @Override
    public void puscSprzeglo() {
        System.out.println("Puszczam sprzeglo");
    }
}
