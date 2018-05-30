package pl.sdacademy.silnik;

public class SilnikV6 implements Silnik{
    int obroty = 0;

    @Override
    public void dajGazu(int stopien) {
        obroty += 20 * stopien;
        System.out.println("Silnik V6 przyspiesza! Aktualne obroty: " + obroty);
    }

    @Override
    public void puscGaz(int stopien) {
        obroty -= 20 * stopien;
        System.out.println("Silnik V6 zwalnia! Aktualne obroty" + obroty);
    }

    @Override
    public int pobierzObroty() {
        return obroty;
    }
}
