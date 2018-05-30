package pl.sdacademy.pojazdy;

public interface Pojazd {
    default void jedz() { //od javy 1.8 możemy definiować domyślne implementacje interfejsów. Jeśli klasa implementująca interfejs nie zaimplementuje metody oznaczonej słówkiem default, zostanie użyta właśnie domyślna implementacja
        System.out.println("Pewien pojazd jedzie");
    }
}
