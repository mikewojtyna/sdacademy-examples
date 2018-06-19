## Algorytmy i struktury danych
Wprowadzenie do postawowych algorytmów i struktur danych.

### Notacja Big O
Notacja Big O pozwala wyrazić jak dużo operacji będzie wykonywać algorytm w zależności od danych wejściowych. 
Przykłady: ``O(n)`` - liczba operacji rośnie liniowo, ``O(n^2)`` - liczba operacji rośnie kwadratowo w zależności od 
danych wejściowych.

[Tutaj jest dobre praktyczne wyjaśnienie](https://rob-bell.net/2009/06/a-beginners-guide-to-big-o-notation/)

### Struktury danych
Java daje dostęp do wielu wbudowanych struktur danych. Najpopularniejsze z nich to:
1. [Listy](https://www.tutorialspoint.com/data_structures_algorithms/linked_list_algorithms.htm)
2. [Kolejki](https://www.tutorialspoint.com/data_structures_algorithms/dsa_queue.htm)
3. [Kopce](https://www.tutorialspoint.com/data_structures_algorithms/heap_data_structure.htm)
4. [Drzewa](https://www.tutorialspoint.com/data_structures_algorithms/tree_data_structure.htm)
5. [Grafy](https://www.tutorialspoint.com/data_structures_algorithms/graph_data_structure.htm)

#### Listy
Listy służą do przechowywania ciągu uporządkowanych elementów. Najpopularniejsze implementacje to ``ArrayList`` oraz 
``LinkedList``.

[Różnice między ``ArrayList`` a ``LinkedList``](https://beginnersbook.com/2013/12/difference-between-arraylist-and-linkedlist-in-java/)

### Algorytmy sortowania
Popularnym problemem algorytmicznym jest sortowanie elementów wg zadanego klucza. Przykłady takich algorytmów:
1. [Bubble sort](https://www.geeksforgeeks.org/bubble-sort/)
2. [Heapsort](https://www.geeksforgeeks.org/heap-sort/)
3. [Quicksort](https://www.geeksforgeeks.org/quick-sort/)
4. [Counting sort](https://www.geeksforgeeks.org/counting-sort/)

Naturalnie, nikt już nie implementuje tych algorytmów ręcznie. Gdy jest potrzeba posortować jakieś elementy, 
wystarczy skorzystać z gotowych rozwiązań z biblioteki standardowej lub dodać odpowiednią bibliotekę do zależności 
Mavena. Mimo to, dobrze jest rozumieć jak te algorytmy działają.

#### Zadania
W celu weryfikacji poprawności algorytmów należy użyć TDD, co ułatwi nam też ich implementację. Zauważmy, że 
mimo, iż TDD będzie doskonałym narzędziem do sprawdzenia poprawności algorytmu, to nie daje nam możliwości 
sprawdzenia samej wydajności. W celu weryfikacji wydajności można użyć bardzo prostego sposobu, który pobierze 
aktualny czas w milisekundach przed i po uruchomieniu algorytmu na dużym zbiorze danych, a następnie obliczy różnicę.
 Do tego celu można użyć np. ``System.currentTimeMillis()``. Dobrym pomysłem jest, aby stworzyć prostą klasę, która 
 opakuje dowolny kod i poda, jak długo operacja się wykonywała. Najprostszym sposobem jest użycie do tego celu 
 możliwości programowania funkcyjnego z Javy 8 (lub ewentualnie podawać w argumencie dowolny obiekt implementujący 
 interfejs ``Runnable``).

##### Sortowanie
Zaimplementować wszystkie wymienione algorytmy sortowania. Należy stworzyć interfejs, który umożliwi posortowanie 
dowolnej kolekcji. Interfejs ten ma zostać zaimplementowany przez 4 konkretne klasy, każda dla jednego algorytmu 
sortowania.
 
Jakie złożoności ma każdy z algorytmów?
 
##### Listy
Zaproponować przykłady, które przedstawią kiedy najlepiej użyć ``ArrayList`` oraz ``LinkedList``.

##### Złożoność obliczeniowa
Zaproponować przykłady kodu o następującej złożoności:

1. O(1)
2. O(n)
3. O(log n)
4. O(n^2)
5. O(2^n)
6. O(n^m)

##### Przeszukiwanie grafu
Zaimplementować algorytm przeszukiwania grafu na dwa sposoby:

1. [BFS](https://en.wikipedia.org/wiki/Breadth-first_search)
2. [DFS](https://en.wikipedia.org/wiki/Depth-first_search)

##### Znajdowanie elementów w Binary Tree
Zaimplementować algorytm, który znajdzie element o podanej wartości w drzewie binarnym.

[Binary Tree](https://en.wikipedia.org/wiki/Binary_tree)