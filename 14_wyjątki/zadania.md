1. Napisz program odczytujący od użytkownika dwie liczby - dzielną i dzielnik. Jeżli użytkownik jako dzielnik poda 0,
 rzuć wyjątek DzieleniePrzezZeroException i obsłuż go (wyświetl odpowiedni komunikat).
2. Utwórz zmienną klasy String, przypisz do niej wartość null. Następnie spróbuj wywołać na zmiennej metodę length() - 
uruchom program i sprawdź, jaki wyjątek został rzucony.
3. Obsłuż wyjątek z powyższego zadania - wypisz na ekranie "Zanim wywołasz metodę, sprawdź czy zmienna nie
 jest nullem!" w bloku catch obsługującym wyjątek. Dodaj blok finally tak, żeby zawsze wypisywany był tekst "Teraz 
 mogę w spokoju skończyć program..."