4. (Poziom 1) Utwórz klasę generyczną NazwaKlasy<T> z metodą public void wypiszNazwęKlasy(T obiekt). Nazwę klasy 
możesz pobrać za pomocš metody obiekt.getClass().getSimpleName().
5. (Poziom 2) Utwórz hierarchię klas: (abstrakcyjna) Auto, AutoOsobowe (rozszerza Auto), AutoCiężarowe (rozszerza 
Auto), wszystkie mają metodę void jedź wypisującą np. "Auto osobowe jedzie", "Auto ciężarowe jedzie". Dodaj klasę 
generyczną Flota<T extends Auto> z listš aut i metodš void dodajAuto(T auto) oraz metodš void flotaWyjedź(), 
uruchamiającą na wszystkich Autach w liśćie metodę jedź().
6. (Poziom 3) Utwórz metodę generycznš zwracającą losowy element z przekazanej tablicy pewnych obiektów.