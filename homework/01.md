1. Utwórz klasę punkt, posiadającą pola publiczne: double x, double y. Utwórz dwa obiekty tej klasy w funkcji main i wyświetl ich zawartość.
2. Dodaj do klasy punkt gettery (accessor) i settery (mutuator) oraz metodę statyczną double distance(Point other), 
obliczającą odległość euklidesową. Wzór: sqrt((x1-x2)^2 + (y1-y2)^2)
4. (+)Zaprogramuj prostą grę. Utwórz klasę abstrakcyjną Bohater z metodami podroz(MiejsceEnum celPodrozy), 
zwiekszPoziom(), którą będą rozszerzały klasy Wojownik, Czarodziejka i Złodziej. Utwórz klasę abstrakcyjną Potwór, którą rozszerzą klasy Wampir, Smok i Jin.
   Utwórz interfejs Broń z polem int życie i metodą atak(Potwor potwor), którą zaimplementują klasy Miecz, Łuk, Topór, Sztylet i MagicznyKij. Każda z broni powinna inaczej reagować (zadawać inne obrażenia) na każdy rodzaj potwora (potwór powinien mieć enum ze swoją "klasą" - fizyczny, latający, magiczny).
   W każdym z napotkanych miejsc gracz może spotkać losowego potwora, którego zaatakuje bronią, którą posiada. Kiedy gracz wygra, dostaje kolejny poziom.
   Po przegranej wyświetlany jest aktualny poziom gracza.
5. Napisz program odczytujący od użytkownika dwie liczby - dzielną i dzielnik. Jeśli użytkownik jako dzielnik poda 0, rzuć wyjątek DzieleniePrzezZeroException i obsłuż go (wyświetl odpowiedni komunikat).
6. Napisz klasę Firma z polem budżetPłacowy, przechowującą listę/tablicę pracowników. Firma posiada metodę dodaj pracownika. Pracownik to klasa abstrakcyjna z metodami pensja(), opisStanowiska(), klasy które ją rozszerzają to Księgowa, Ochroniarz i Magazynier.
   Do metody dodajPracownika klasy Firma dołóż rzucanie wyjątku BudżetPrzekroczonyException i obsłuż go w metodzie main.
   
##### NEW!!!

7. Zdefniniuj typ enum HealthInfluence, z wartościami HEALTHY, NEUTRAL, UNHEALTHY. Dodaj do projektu klasę Product z polem HealthInfluence influence oraz String name. Z wykorzystaniem Scannera, wczytuj od użytkownika kolejne produkty do tablicy o wielkości 7. Na koniec wyświetl zestawienie produktów zdrowych, neutralnych oraz niezdrowych. Wyświetl użytkownikowi, że odżywia się zdrowo, jeśli liczba zdrowych produktów przekracza połowę wszystkich produktów w tablicy, podobnie w pozostałych dwóch przypadkach. Jeśli użytkownik odżywia się niezdrowo, zaloguj informację do pliku z pomocą Loggera (pamiętaj o pliku log4j.properties w katalogu resources)
8. Utwórz hierarchię klas - klasę abstrakcyjną Formatter z metodą addText(String newText) (dodaje tekst do tablicy) oraz abstrakcyjną metodę print(), dodaj dwie klasy pochodne implementujące metodę print. Pierwsza powinna wyświetlić:  
\<jablko\>\<gruszka\>\<pomarancza\>  
a druga:  
\#jablko\#  
\#gruszka\#  
\#pomarancza\#

9. Napisz klasę, posiadającą jedną metodę - countVovels(String text), liczącą samogłoski w podanym napisie. Zastosuj zaprezentowaną na zajęciach metodykę TDD.
Tip:
```java
Scanner scanner = new Scanner(System.in);
        String date1 = scanner.nextLine();
```