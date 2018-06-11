## Test-driven development
Na początek posłuchajmy trochę zrzędzenia Uncle Boba

[Uncle Bob krótko o TDD](https://www.youtube.com/watch?v=GvAzrC6-spQ)

[Przykład zastosowania TDD krok po kroku](https://www.youtube.com/watch?v=qkblc5WRn-U)

Swoje rozwiązania umieszczamy w module 26-tdd.

### TDD Katas
Proste ćwiczenia wdrażające do myślenia za pomocą TDD.

#### FizzBuzz
Wykonajmy proste TDD Kata (ćwiczenie) o nazwie FizzBuzz zgodnie ze specyfikacją wyrażoną w klasie ``pl.sdacademy
.tdd.FizzBuzz`` z modułu ``26-tdd``. Nie chodzi tutaj o uzyskanie poprawnego wyniku, lecz o proces. Testy muszą 
być pisanie przed implementacją na zasadzie cyklu "test-implementacja".

Możemy posłużyć się tym przykładem jako referencją dobrze odzwierciedlającą process TDD:

[FizzBuzz TDD Kata](https://www.youtube.com/watch?v=aoX0UTzhx80&feature=youtu.be)

#### FizzBuzzWhiz
Analogiczne zadanie jak FizzBuzz, ale dodatkowo ma wypisywać "Whizz" gdy liczba jest pierwsza.

[FizzBuzzWhiz](https://github.com/mwhelan/Katas/tree/master/Katas.FizzBuzzWhiz)

#### Fibonacci
Zaimplementujmy ciąg Fibonacciego za pomocą TDD.

[Fibonacci](https://github.com/mwhelan/Katas/tree/master/Katas.Fibonacci)

#### Anagramy
Znajdźmy wszystkie anagramy.

[Anagramy](https://github.com/mwhelan/Katas/tree/master/Katas.Anagrams)

### Pani od HRu (+)
Wróćmy na chwilę do znanego nam przykładu. Pomyślmy, jak możemy dodać nowe funkcjonalności do naszego programu za 
pomocą TDD i w jaki sposób wpłynie to na design naszego kodu.

W tej chwili ten program po prostu przyjmuje dane z linii poleceń (ewentualnie aplikacji okienkowej jeśli zrobiliśmy 
zadanie z poprzedniego tygodnia). Dodajmy parę nowych funkcjonalności:

1. Walidacja danych - zabezpieczmy się np. przed podawaniem pustych danych, wprowadźmy datę urodzenia zmiast wieku i 
sprawdźmy, czy użytkownik wprowadza właściwe dane. Można tutaj eksperymentować do woli z różnymi opcjami, które 
przyjdą nam do głowy.
2. Dodajmy wczytywanie danych z pliku
3. Dodajmy zapisywanie danych do pliku
4. Dodajmy bardzo proste wyszukiwanie danych z naszej plikowej bazy danych (np. wyszukaj wszystkich, którzy mają na 
imię "Andrzej"). Na tym etapie wystarczą bardzo proste filtry (np. tylko dokładnie "Andrzej", bez łączenia tego z 
innymi filtrami).