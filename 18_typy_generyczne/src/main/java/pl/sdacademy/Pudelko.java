package pl.sdacademy;

public class Pudelko<T, S> {
    private T obiekt1;
    private S obiekt2;

    public void wlozDoPudelkaT(T obiekt) {
        this.obiekt1 = obiekt;
    }

    public void wlozDoPudelkaS(S obiekt) { this.obiekt2 = obiekt; }

    public T wyjmijZPudelkaT() {
        return obiekt1;
    }

    public S wyjmijZPudelkaS() {
        return obiekt2;
    }
}
