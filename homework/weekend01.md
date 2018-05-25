# Typy, tablice, pętle i podstawy OOP

Zadania oznaczone (+) są trochę trudniejsze.

## Typy
Zadania dotyczące typów danych.

##### Zakresy
Stwórz pod dwie zmienne wszystkich podstawowych typów liczbowych: ``int``, 
``long``, ``short``, ``float``, ``double``. Ustaw ich wartości na minimum i 
maksimum. Podpowiedzi jak to zrobić znajdują się w module ``type`` tego 
projektu (np. ``Integer.MIN_VALUE``). Następnie zwiększ wartości maksymalne o
 1\. Wartości minimalne zmniejsz o 1. Jakie są nowe wartości tych zmiennych? 

##### Boxed primitives
Parę razy pewnie widziałeś już np. klasę ``Integer``, ``Long`` etc. Są to tzw
. boxed primitives, czyli opakowania (klasy) na typy prymitywne. Dlaczego są 
one potrzebne zostanie wyjaśnione później (np. w kolekcjach). Zostały one 
także użyte w poprzednim zadaniu. Wykonaj następujący kod:
```java
public class App {
	public static void main(String[] args) {
		Integer intValBoxed = 10;
		Long longValBoxed = 10L;
		Short shortValBoxed = 10;
		Double doubleValBoxed = 10.0;
		Float floatValBoxed = 10.0F;		
	}
}
```
Czy zostały zwrócone jakieś błędy? Poszukaj w internecie, dlaczego tak się 
dzieje. Słowa kluczowe: java autoboxing.

## Tablice i pętle
Ćwiczenia z tablicami 1 i 2 wymiarowymi.

##### Operacje
Stwórz tablice dla wszystkich podstawowych liczbowych typów prymitywnych. 
Stwórz klasę, która ma metody ``sum``, ``multiply``, ``divide``, które 
odpowiednio zsumują, pomnożą i podzielą wszystkie liczby i zwrócą wynik 
odpowiedniego typu.

##### Szachownica
Stworzyć arraya 2D typu ``String[][]``. Każda komórka tej szachownicy ma 
zawierać znak ``X`` albo ``O`` (X - czarne pole, O - białe pole). Tak samo 
jak w prawdziwej szachownicy. Następnie wyświetlić tę szachownice na stdout.

##### Kopiowanie tablic
Jak dodać nowy element do tablicy? Np. jeśli mamy 5-elementową tablicę ``int[] 
array = new int[5]``. Jak "dodać" 6-ty element? Zauważ, że nie ma metody w 
tablicy umożliwiającej dodawanie elementów. Zamiast tego, trzeba kopiować 
elementy tablicy. Zaimplementuj metodę ``addElements`` z klasy ``pl.sdacademy
.array.add.ArrayAddElementTest`` z modułu ``array`` zgodnie ze specyfikacją 
metody wyrażonej w Javadocu (ten "komentarz" nad metodą). Klasa ``pl.sdacademy.array.add.ArrayAddElementTest`` jest klasą wykonywalną i zawiera w
 środku gotowy test. Jeśli implementacja będzie poprawna, wyświetli się napis
  ``Implementation OK!``, w przeciwnym wypadku aplikacja zakończy się błędem.
   Na początek zacznij po prostu od uruchomienia tej klasy i zobacz co się stanie.
   
## OOP
Trudniejsze zadania z podstaw programowania obiektowego.

##### Szachownica obiektowo (+)
Zaimplementować zadanie szachownica w postaci klasy ``ChessBoard``, która 
przechowuje swoje pola szachownicy i umożliwia ustalenie dowolnego rozmiaru. 
Ma też metodę ``print()``, która wyświetli tablicę na ekran. Jeśli ktoś chce 
wersję jeszcze trudniejszą - zamiast metody ``print()`` nadpisać metodę 
``toString()``, która zwróci stringa zawierającego gotową do 
wyświetlenia reprezentację szachownicy.

##### Klasa User (+)
Stworzyć klasę ``User``, która ma mieć obowiązkowe pola ``String firstName``, 
``String lastName`` oraz płeć ``String sex`` (male|female). Oprócz tego, 
mają być dostępne opcjonalne pola ``int height``, ``String birthDate`` (w 
formacie yyyy-MM-dd) oraz ``String[] interests`` (array zainteresowań). 
Stworzyć odpowiednie konstruktory, które pozwolą wprowadzić zarówno dane 
wymagane jak i opcjonalne. Zastanowić się jak najlepiej dodawać 
zainteresowania oraz w jaki sposób można wymusić, aby pole ``sex`` przyjęło 
tylko jedną z dwóch dostępnych wartości i czy na pewno String jest właściwym 
typem (podpowiedź - sprawdzić co to jest Enum).

##### Pani od HRu (+)
Rozbudować zadanie ``Klasa User`` tak, aby stworzyć apliakcję, która 
umożliwia przyjmowanie argumentów (przekazanych z ``stdin`` do metody 
``main``) określających dane użytkownika. Aplikacja ma umożliwiać wprowadzanie 
danych wymaganych oraz opcjonalnych i tworzyć z nich obiekt ``User``. Jeśli 
wymagane dane nie zostały przekazane, aplikacja ma się zakończyć stosownym komunikatem. Sposób wprowadzania danych może wyglądać np. następująco:
````shell
firstName=George lastName=Martin sex=male
````
Opcjonalne dane mają być przekazywane tak samo
````shell
height=180 birthDate=2010-10-20 interests="killing people","writing books",
"killing even more people","killing them all"
````
Naturalnie można łączyć dane wymagane z opcjonalnymi.
Można także wymyśleć własny format podawania danych z konsoli.