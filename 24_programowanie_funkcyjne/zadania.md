#### Lambda
1. Utwórz funkcję Consumer przeprowadzającą napis w wyświetlenie tego napisu na ekranie
2. Utwórz funkcję Fuction przeprowadzającą napis na napis wielkimi literami
3. Utwórz funkcję BiFunction, przeprowadzającą dwie liczby Integer na ich sumę, różnicę i iloczyn
4. Utwórz funkcję jak w zadaniu drugim, ale wykorzystaj własny interfejs z operacją String operacja(String napis)
5. Utwórz funkcję jak w zadaniu trzecim, ale wykorzytaj własny interfejs z operacją int operacja(int liczba1, int liczba2)
6. Utwórz listę napisów, przetwórz ją za pomocą metody forEach(). Metoda ta przyjmuje obiekt Consumer. Utwórz dwa takie obiekty, jeden wypisze wiadomość, drugi wypisze wiadomość a pod spodem aktualny timestamp


#### Optional
7. Utwórz pusty Optional wykorzystując metodę empty()
8. Utwórz pusty Optional wykorzystując pusty obiekt i metodę ofNullable() i of(). Jaka jest różnica? Sprawdź zawartość Optionala metodą isPresent()
9. Utwórz pusty Optional wykorzysując normalny obiekt i metodę ofNullable() lub of()
10. Utwórz pusty i niepusty Optional, wywołaj na niej metodę ifPresent()
11. Utwórz pusty i niepusty Optional, następnie utwórz kolejny optional wywołując metodę orElse()
12. Utwórz pusty i niepusty Optional, następnie przetwórz go metodą map() oraz filter()


##### Stream
13. Utwórz listę napisów. Przefiltruj ją w ten sposób, że zostaną tylko napisy zawierające literę 'a'
14. Utwórz listę napisów. Przefiltruj ją w ten sposób, że zostaną tylko napisy dłuższe niż 3 znaki
15. Utwórz listę napisów. Przekształć ją w ten sposób, że napisy będą pisane wielkimi literami
16. Utwórz listę napisów. Przekształć ją tak, żę dostaniesz jeden napis zawierający napisy w liście oddzielone przecinkiem i spacją, czyli ", "
17. Utwórz listę napisów. Wygeneruj statystyki dla długości napisów: wyświetl średnią długość, minimalną, maksymalną i sumę wszystkich długości.
18. Klasę film z polami: tytuł, rezyser, rokPremiery, cenaDVD, lista gatunków, lista aktorów. Utwórz listę 5 takich filmów
  a). Utwórz statystyki dla ceny filmów w liście: min, max, średnia
  b). Pogrupuj filmy w mapie wg rezysera i wg roku premiery
  c). Wyświetl listę aktorów, jacy wystąpili w filmach z listy
  d). Wyświetl do jakich gatunków należą filmy w liście.

#### Static code analysis
19. Utwórz klasę user z getterami, setterami. Sprawdź inspekcję checkstyle. Popraw błędy.
20. Utwórz klasę Arytmetyka z działaniami: dodaj, odejmij, pomnóż oraz klasę logika z operacjami koniunkcja, alternatywa i zaprzeczenie. Dodaj testy do swoich metod. Uruchom testy w Coverage Mode.