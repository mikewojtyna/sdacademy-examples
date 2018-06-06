#### Java IO - utrwalanie umiejętności

1. Zaimplementuj metodę ``pl.sdacademy.swing.homework.ClasspathResourceReader.readAllLines`` zgodnie ze specyfikacją 
wyrażoną w testach ``pl.sdacademy.swing.homework.ClasspathResourceReaderTest`` i javadocu klasy 
``ClasspathResourceReader``. Testy znajdują się w katalogu ``src/test/java``. Aby uruchomić testy wybierz plik z 
testem, p-klik a potem run. Klasa powinna odczytywać wszystkie linie pliku z classpatha projektu.

2. Zaimplementuj kopiowianie plików w klasie ``pl.sdacademy.swing.homework.FileCopier`` zgodnie ze zpecyfikacją z 
testu ``CopyFileTest``.

3. Dodaj do klasy ``FileCopier`` z zadania 2 metodę ``copyDir`` umożliwiającą kopiowanie całego katalogu. Metoda 
powinna zachowywać się podobnie do metody ``copy`` z zadania 2. Postaraj się stworzyć odpowiednie testy samodzielnie,
 wzorując się na przykładzie testów z ``CopyFileTest``. Postaraj się napisać te testy zanim jeszcze rozpoczniesz 
 pisanie ciała metody ``copyDir``. [Ten tutorial](https://docs.oracle.com/javase/tutorial/essential/io/walk.html) 
 może być przydatny w tym zadaniu.
 
 4. (+) Dodaj przeciążoną metodę ``copyDir``, która umożliwia kopiowanie tylko wybranych typów plików (np. png). 
 Metoda ta ma przyjmować dodatkowy argument, który będzie strategią definiującą, które pliki mają zostać skopiowane. 
 Interfejs tego obiektu może nazywać się np. ``FileCopyFilter`` i posiadać jedną metodę ``boolean filter(Path path)``, 
 która zwróci ``true`` gdy plik ma zostać skopiowany, ``false`` zaś w przeciwnym wypadku. Ponownie, zaprojektuj testy
  samodzielnie i postaraj się napisać je jeszcze przed implementacją. Dlaczego ten design jest lepszy niż po prostu 
  dodanie ``if`` do metody ``copyDir``?
  
#### Swing

1. Dostosuj dawne zadanie z szachownicą tak, aby wyświetlała się ona w postaci aplikacji okienkowej. Layout 
``GridLayout`` może być przydatny w tym zadaniu. Jak dużo kodu musiałeś zmienić? (+) Jak zaprojektować szachownicę 
tak, aby nie trzeba było dużo zmieniać podczas wyświetlania jej na różne sposoby (np. konsola, swing, html etc).

2. Zmodyfikuj dawny program "Pani od HR" tak, aby użytkownik mógł obsługiwać go z poziomu aplikacji okienkowej Swing.

3. Używając rozwiązań stworzonych w zadaniu 3 z listy "Java IO - utrwalanie umiejętności", zbuduj 
aplikację graficzną, która będzie opakowaniem klasy ``FileCopier``. Aplikacja powinna umożliwiać podanie katalogu 
źródłowego oraz docelowego. Wywołanie metod z klasy ``FileCopier`` powinno odbywać się w osobnym wątku. Zauważ, że ta
 aplikacja graficzna praktycznie nie zawiera żadnej logiki (po prostu zbiera dane i przekazuje do ``FileCopier``), a 
 więc nie ma po co pisać testów sprawdzających logikę kopiowania plików (to już zostało zrobione w poprzednich 
 zadanich).
 
4. (+) Rozbuduj program z zadania 3 tak, aby umożliwiał podawanie filtrów kopiowania plików (np. kopiuj tylko pliki *
.png). Ten 
filtr ma zostać 
następnie 
użyty podczas kopiowania plików ze źródłowego katalogu. 
 Oprócz tego, dodaj do 
 aplikacji dwa panele, 
 które 
 pokazują zawartość katalogu 
 źródłowego i 
 docelowego.
  Pliki w panelu katalogu docelowego powinny pokazywać się natychmiast po ich skopiowaniu. [Ten tutorial o klasie SwingWorker](https://docs.oracle.com/javase/tutorial/uiswing/concurrency/worker.html) może być przydatny. Zastanów się, jak 
  najlepiej zaprojektować/rozbudować istniejące klasy lub jakie nowe klasy/interfejsy muszą zostać dodane aby można 
  było przetestować całość logiki bez potrzeby interakcji z warstwą graficzną. 