package pl.sdacademy.pojazdy;

public class Amfibia implements Motorowka, Pojazd { // w przeciwieństwie do dziedziczenia klas, możemy impelementować wiele interfejsów - w ten sposób nasza klasa może realizować wiele zachowań


    @Override
    public void plyn() { //tę metodę MUSIMY zaimpelementować - nie ma domyślnej implementacji w interfejsie Motorowka
        System.out.println("Amfibia płynie!");
    }

    @Override
    public void jedz() { //impelementacja tej metody jest opcjonalna bo interfejs Pojazd posiada jej domyślną implementację
        System.out.println("Amfibia jedzie");
    }


}
