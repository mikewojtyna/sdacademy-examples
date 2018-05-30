#### Java IO

1. (Poziom 1) Wczytaj utworzony wcześniej plik i wypisz go na ekranie. Dla każdej linii wypisz ile ma znaków.
2. (Poziom 1) Zapisz do pliku wczytane od użytkownika linie aż do napotkania słowa exit. Dodatkowo, na końcu linii 
dodaj ile ma znaków.
3. (Poziom 2) Utwórz klasę User z polami imię, nazwisko, wiek. Utwórz klasę BazaUserów z metodami List<User> 
wczytajUserów() i void zapiszUsera(User user). Nowi userzy nie powinni być usuwani - trzeba dodawać ich na końcu pliku.
4. (Poziom 3) Utwórz klasy z poprzedniego ćwiczenia, ale dodaj możliwość usuwania wybranego użytkownika z pliku na 
podstawie imienia.
Wszystki zadania zrób wykorzystując java io i new io

#### Java Concurrency

1. (Poziom 1) Napisz program, który wypisze na ekranie "Witaj! Tu Thread-0!" z 10 wątków. Czy zawsze wątki są ustawione kolejno?
2. (Poziom 1) Napisz program, który wypisze na ekranie z 10 wątków "Tu Thread-0, idę spać na x sekund" po czym zaśnie na wylosowaną liczbę sekund a następnie wypisze po obudzeniu "Tu Thread-0 - właśnie wstałem!" po czym zakończy pracę.
3. (Poziom 2) Napisz program, który wczyta linie z pliku tekstowego. Następnie obliczy długość napisu, ilość Wielkich liter, ilość małych liter oraz ilość wystąpień wszystkich samogłosek w linii. Następnie statystyki zwróci w formie obiektu napisanej klasy LineStats. Statystyki liczone są przez 10 wątków.
4. (Poziom 3) Zaimplementuj problem "obiadujących filozofów" i doprowadź do deadlocka. Czy rozumiesz czym jest deadlock (zakleszczenie)? Następnie zabezpiecz program tak, aby do deadlocka nie dochodziło.
5. (Poziom 4+) Zaimplementuj program liczący całkę z funkcji (3x^3)+(2x^2)-3x+1 na odcinku [-1, 1]. Użyj metody prostokątów: http://eduinf.waw.pl/inf/alg/004_int/0002.php i dokładności 0,01. Zaimplementuj ten problem w sposób zrównoleglony (użyj interfejsu Callable)

#### Java Functional

1. (Poziom 2) Znajdź program (w jednym z projektów z poprzednich zajęć) wyszukujący daty i godzinę w napisach. Jego metoda getDate i getTime zwracała obiekt LocalDate lub LocalTime w przypadku powodzenia oraz null w przypadku niepowodzenia. Wykorzystaj go do utworzenia listy Optional<LocalDate> i Optional<LocalTime> na podstawie wczytanego z pliku tekstu zawierającego poprawne daty i czas. Przetwórz listę tak, aby do nienullowych dat dodać jeden dzień, a do nienullowych czasów dodać jedną godzinę. Następnie wyświetl wszytkie daty i czasy z optionali, które nie zawierają nulla. Do przetwarzania wykorzystaj odpowiednią lambdę.
2. (Poziom 2) Wykonaj zadanie 10, zamiast optionali zastosuj stream - wynik powinien być taki sam.
3. (Poziom 3+) Zaimplementuj klasę PozycjaProgramTV, zawierającą pola:
  - String tytuł
  - LocalDateTime czasStartuEmisji
  - LocalDateTime czasZakonczeniaEmisji
  - boolean czyDlaDzieci
  Dodaj 7 pozycji do listy zawierającej programy telewizyjne. Następnie wykorzystując stream uzyskaj:
  - Listę pozycji programu tv emitowanych wczoraj i przeznaczonych dla dzieci
  - Mapę zawierającą jako klucz tytuł programu a jako wartość jego długość w minutach (wykorzystaj klasę Duration)
4. (Poziom 4+) Zaimplementuj zadanie 5 wykorzystując parallelStream.
5. (Poziom 3) Zaimplementuj wyszukiwarkę podobnych napisów - napis jest podobny do zadanego, jeżeli jego długość nie 
różni się o więcej niż dwa znaki, a zbiór użytych liter ma taką samą wielkość i nie różni się o więcej niż 1 literę. Np. porównujemy napis "baza" do napisu "bez":
   1. długość napisu "baza" = 4, napisu "bez" = 3 więc pierwszy warunek jest spełniony
   2. zbiór liter napisu "baza" to 'a', 'b' 'z' , napisu "bez" to 'b', 'z', 'e' - oba zbiory liter mają rozmiar 3 i różnią się o jedną literę więc uznajemy że napisy są podobne 
   Dodaj do listy kilkanaście napisów, następnie przefiltruj ją na podstawie podobieństwa do napisu podanego przez użytkownika.
6. (Poziom 4+) Zaimplementuj zadanie 14 z wykorzystaniem jednego ze znanych algorytmów porównywania podobieństwa 
napisów, np. https://en.wikipedia.org/wiki/Damerau%E2%80%93Levenshtein_distance (inne algorytmy można znaleźć wpisując w google "string similarity comparison"


#### Java Swing

1. (Poziom 3) Zaimplementuj program z graficznym interfejsem użytkownika służący do kopiowania plików z jednego 
miejsca na dysku w inne. Kopiowanie powinno odbywać się w oddzielnym wątku, na raz można kopiować kilka plików. Postęp kopiowania należy odzwierciedlić za pomocą ProgressBara, a jego stan aktualizować na bieżąco. Spróbuj skopiować kilka dużych plików (>3GB). Spróbuj zaimplementować ten problem używając jednego wątku i Java I/O (nie New I/O). Jak zachowuje się program?
2. (Poziom 4+) Zaimplementuj powyższy program z wykorzystaniem co najwyżej jednego dodatkowego wątku i Java New I/O -
 skorzystaj z selektorów.
3. (Poziom 2) Zaimplementuj równoległą maszynę lotto - każdą z 6 liczb losuje inny wątek. Wykorzystaj interfejs Callable
4. (Poziom 1) Zaimplementuj (wykorzystując bibliotekę Swing) stoper, który co sekundę zaktualizuje wyświetlany czas. 
Wykorzystaj wątek i metodę Thread.sleep(). Do wyświetlania czasu stopera możesz użyć np. JLabel.

* zadania z "+" wykraczają poza standardowy zakres bloku Wstęp do języka JAVA.


