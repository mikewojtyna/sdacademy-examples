#Słowniczek pojęć

Chwilowo w kolejności niealfabetycznej :)

## Język

##### Zmienna
Byt pozwalający przetrzymywać dane i operować na nich. Każda zmienna posiada określony typ oraz nazwę. Tworzenie 
zmiennej skłąda się zazwyczaj z dwóch etapów, deklaracji:
```java
int number;
```
oraz inicjalizacji (nadania wartości początkowej):
```java
number = 3;
```
Można ten proces scalić i zapisać w jednej linii:
```java
int number = 3;
```
##### Typ prosty
Typy proste przechowują wartości bezpośrednio w miejscu odwołania (a więc ich wartość jest przechowywana w pamięci 
zwanej stosem - stack). Wywodzą się bezpośrednio z języka C (oprócz typu boolean).
##### Typ złożony (referencyjny)
Typ złożony określa zmienne, których wartość jest referencją - oznacza to, że tak jak zmienne typów prostych są 
tworzone w pamięci nazywanej stosem, ale nie przechowują wartości swoich obiektów, a referencje do nich (czyli jakby 
informację, gdzie rzeczywiście obiekt się znajduje). Rzeczywisty obiekt, utrzorzony słówkiem new, znajduje się w 
innym typie pamięci, zwanym stertą (heap):
```java
MyReferenceType someVariable = new MyReferenceType;
```
##### Instrukcja
Instrukcja to wszystko to, co kończy się średnikiem, np:
```java
int number = 3;
System.out.println("Hello world!");
```
do instrukcji zaliczamy też pętle i ify, jako instrukcje złożone.

##### Wyrażenie
Wyrażeniem nazywamy każdy napis, który ma wartość (czyli można np. go przypisać, wykorzystać jako warunek, itd). Np.:
```java
someVar = 3 + 34 * 43; // wyrażenie to '3 + 34 + 43'
if(obj.isBigObject()) // wyrażenie to 'obj.isBigObject()'
```

##### Operacja
Operację rozpoznajemy po tym, że występują w niej operatory :D Np:
```java
number += 3; //operacja przypisania
number1 > number2 //operacja porównania
number1 + number2 //operacja arytmetyczna
```

##### Instrukcje sterujące
Instrukcje sterujące są elementami języka, pozwalającymi na rozgałęzienie ścieżek wykonania programu. Droga, jaką 
obierze nasz program zależy, czy spełniony jest warunek, tzn. czy wyrażenie przekazane takiej instrukcji ma wartość 
prawda czy fałsz (więc jego typ to boolean)

##### Operator
Specjalny symbol (mogący składać się z więcej niż jednego znaku) wykonujący odpowiednie operacje na tzw. operandach. 
Ich liczba, w zależności od operatora, równa jest 1, 2 lub 3. Np.:
```java
number = 3 // operator '=' jest operatorem przypisania, 'number' jest pierwszym operandem, a '3' drugim
-number // operator '-' jest w tym przypadku jednoargumentowy (ma tylko jeden operand - 'number')
number1 - number2 // w tym przypadku '-' jest operatorem dwuargumentowym - ma dwa operandy ('number1' i 'number2')
obj.isBig() ? obj.getX() : obj.getY() // ?: jest operatorem trzyargumentowym - ma 3 operandy ('obj.isBig()', 
// 'obj.getX()' oraz 'obj.getY()'
```

##### Pętla
Pętla jest instrukcją złożoną pozwalającą na powtarzanie zdefiniowanych w jej ciele instrukcji, dopóki spełniony jest
 warunek. W javie wyśtępują pętle:
 - while
 - do-while
 - for
 - foreach (warunek nie jest jawny, ale jest nim "istnienie elementów w iterowalnym obiekcie") 

##### Iteracja 
Proces przechodzenia przez kolejne elementy struktury przechowującej wiele danych.

##### L-wartość
W skrócie - to, co moze stać po lewej stronie operatora przypisania, np. zmienne:
```java
int number = 3; //number jako zmienna typu prostego jest L-wartością
3 = number //źle! do stałej symbolicznej nie możemy przypisać niczego. '3' jest R-wartością
```
##### R-wartość 
W skrócie - to, co może stać po prawej stronie operatora przypisania:
```java
number1 = number2; // number2 jest zmienną, więc można ją przypisać
number1 = int; // źle! nazwy typu nie można przypisać zmiennej
```

##### Klasa (TODO)

##### Metoda (TODO)

##### Pole (TODO)

## Zasady

##### Zasady SOLID (TODO)
 - S - Single Responsibility Principle
 - O - Open-Closed Principle
 - L - Liskov Substitute Principle
 - I - Interface Segregation Principle
 - D - Dependency Inversion Principle

##### Zasady GRASP (TODO)
General Responsibility Assignment Software Patterns 
##### Zasada DRY
Don't Repeat Yourselves - takie same lub podobne fragmenty kodu należy zamykać w jednym miejscu, np. metodzie 
prywatnej lub klasie bazowej. W ten sposób, w przypadku konieczności zmiany tego fragmentu, musimy zrobić to w tylko 
jednym miejscu, a nie kilku.

##### Zasada KISS
Keep IT Systems Simple (lub żartobliwie Keep It Simple, Stupid!) - wg tej zasady kod naszego programu powinien dążyć 
do jak największej prostoty - wtedy będzie go mniej, nie łatwiejszy w rozwijaniu i utrzymaniu, oraz będzie robił 
tylko to, czego się od niego oczekuje

##### Prawo Demeter
Prawo Demeter mówi, że metoda może wywoływać jedynie metody z:
 - tego samego obiektu,
 - dowolnego parametru przekazanego do niej,
 - dowolnego obiektu przez nią stworzonego,
 - dowolnego składnika klasy, do której należy dana metoda

Dzięki zachowaniu tej reguły, nasza klasa nie musi znać zbyt wielu szczegółów implementacyjnych obiektów, z których 
korzysta, a więc zależność od nich staje się słabsza.

## OOP

##### Dziedziczenie
Paradygmat programowania obiektowego oraz zorientowego obiektowo wykorzystuje dziedziczenie do zamykania wspólnych 
cech i możliwośći klas w klasach bazowych oraz implementację polimorfizmu.

##### Hermetyzacja
Paradygmat programowania obiektowego oraz zorientowego obiektowo opiera się na hermetyzacji (danych), dzięki której 
klienci naszych klas dostają to, czego naprawdę potrzebują, a nie poszczególne, surowe dane. Przydatność naszych klas
 objawia się w tym, że robią coś pożytecznego z danymi (nie dotyczy klas, których zadaniem jest JEDYNIE 
 przechowywanie danych), jednocześnie chroniąc swoje dane przed niewłaściwym wykorzystaniem.

##### Abstrakcja a Implementacja (TODO)

##### Wzorce projektowe (TODO)

## Ogólne

##### API (Application Programming Iterface) (TODO)