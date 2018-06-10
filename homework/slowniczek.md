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

##### Klasa
Model dla obiektów tego samego typu (czyli tej samej klasy). Opisuje cechy, definiujące stan obiektu (pola) oraz operacje, jakie obiekty udostępniają (metody)
```java
public class Point {
    private int x;
    private int y;
    (...)
    public int getX();
    public void setX(int x);
}
```

##### Metoda
Funkcja zdefiniowana na rzecz klasy, którą możemy wywoływać na rzecz obiektów (lub klasy, jeśli to metoda statyczna). Metoda składa się z deklaracji (czyli zadeklarowania wszystkich modyfikatorów, zwracanego typu, nazwy oraz listy parametrów wraz z typami, oraz definicji, czyli określenia tego, co metoda ma robić:
```java
public int add(int num1, int num2) { // deklaracja
    int result = num1 + num2;        //definicja
    return result;                   //definicja
}
```

##### Pole
Zdefiniowana na rzecz klasy zmienna, przechowujące dane określonego typu. Każdy z obiektów danej klasy posiada swoją wersję pól (chyba, że to pola statyczne - dostępne dla samej klasy i wspólne dla wszystkich jej obiektów). Zmiana stanu pola w jednym obiekcie nie wpływa na pola w innych obiektach danej klasy.

##### Konstruktor

##### Getter (akcesor)
Metody służące do "wyciągania" danych z obiektu. Najczęściej rozumiemy przez to bezpośrednie zwrócenie wartości pola.
```java
int getX() {
    return x;
}
```
##### Setter (mutuator)
Metody służące do modyfikacji stanu obiektu. Najczęściej rozumiemy przez to bezpośrednie nadpisanie wartości pola przez wartość przekazanego parametru
```java
public void setX(int x) {
    this.x = x;    
}
```

#### static
Słowo kluczowe "static" może być użyte w różnych kontekstach - pełni wtedy nieco inne role:
* static class - klasa może być statyczna jedynie jako wewnętrzna klasa innej klasy (oznacza to, że klasa najbardziej zewnętrzna nie może być statyczna). Jest to pewien sposób grupowania klas, natomiast zazwyczaj nie jest zalecany ani potrzebny. W przypadku, jeśli oznaczymy klasę jako static, dostęp do niej będzie z poziomu klasy a nie obiektu (podobnie jak do pól czy metod).
* static field - statyczne pole alokowane jest w momencie startu programu, ale co ważniejsze - przynależy do klasy, a nie do konkretnych obiektów tej klasy. Oznacza to, że kiedy je nadpisujemy albo pobieramy jego wartość, pracujemy na jednym i tym samym polu. Dostęp do niego mamy zarówno z poziomu klasy jak i obiektów danej klasy.
```java
public class MyClass {
    public static String staticField; //pole jest publiczne tylko na użytek tego przykładu - normalnie tego unikamy
(...)
    MyClass.staticField = "Hello";
    MyClass objectOfMyClass = new MyClass();
    objectOfMyClass.staticField = "World";
    boolean isTheSamePlaceInMemory = objectOfMyClass.staticField == MyClass.staticField; // =true
```
* static method - metody statyczne, podobnie jak pola, zdefiniowane są na rzecz klasy a nie obiektów. Możemy je wywoływać zarówno z poziomu klasy jak i obiektów tej klasy, jednak ciało takiej metody ma pewne ograniczenia - nie możemy w jego wnętrzu korzystać ze zwykłych (a więc niestatycznych) pól i metod naszej klasy.
```java
public class MyClass {
    private int someNumber;
    public MyClass(int someNumber) {
        this.someNumber = someNumber;
    }
    (... - gettery itd)
    
    public static int addTwoNumbers(int num1, int num2) {
        return num1 + num2; // OK
        return num1 + this.someNumber // ŹLE!
        
        MyClass objectOfMyClass = new MyClass(5);
        return num1 + objectOfMyClass.getSomeNumber(); //dobrze, bo nie użyłem 'this', ale utworzyłem obiekt i dopiero potem pobrałem jego wartość
```

##### final
Słowo kluczowe final, podobnie jak static, może istnieć w różnych kontekstach i oznacza wtedy różne rzeczy. W przypadku, kiedy final stoi przed deklaracją pola lub zmiennej, oznacza to, że może zostać zainicjalizowane (a więc wartość referencji - "adres" obiektu) może zostać przypisany tylko raz. Nie oznacz to, że samego obiektu nie można modyfikować jego metodami.
```java
public class MyClass {
    private final MyFieldClass myField = new MyClass(5); //inicjalizacja, a więc przypisanie początkowej wartości może odbyć się tylko raz - w przypadku pól albo w sposób statyczny (tak jak tutaj), albo w konstruktorze.
    private final MyClass myField2;
    
    public MyClass() {
        myField2 = new MyFieldClass(7);
    }
    
    public badMethodTriesToChangeFinalField() {
        this.myField = new MyFieldClass(8); //źle - próbujemy nadpisać wartość referencji, a więc przypisać nowy obiekt do pola final
    }
    
    pubic goodMethodChangesStateOfFinalObject() {
        this.myField.setNewNumber(9); //dobrze - modyfikujemy obiekt wewnętrznie, ale nie zmieniamy referencji pola
    }
```
Jeśli final stoi przed deklaracją metody, oznacza to, że nie można takiej metody przeciążyć (nadpisać) w klasach pochodnych od naszej klasy.
```java
public MyClass {
    public final void myMethod() { //tej metody nie przeciążymy w klasach pochodnych
    }
}

public class MyChildClass extend MyClass {
    @Override
    public final void myMethod() { //źle! nie możemy tej metody przeciążać
    }
}
```
Jeśli final stoi przed deklaracją klasy, oznacza, że nie możemy takiej klasy rozszerzać.
```java
public final MyClass {
}
public class MyChildClass extend MyClass { //źle! nie możmy rozszerzać klasy final!
}
```
    

## Zasady

##### Konwencje nazewnicze
W Javie przyjęło się wykorzystywanie poniższych konwerncji:
* zapis lowercase - wszystkie litery pisane są małą literą, nie stosujemy żadnych dodatkowych, specjalnych znaków - zastosowanie: nazwy paczek (nawet "zlepione" kilka wyrazów), np.:
```java
com.mylongpackage.utils
```
* zapis uppercase - wszystkie litery w wyrazie zapisujemy wielką literą, a wyrazy rozdzielamy znakiem podkreślnika "_", - zastosowanie: nazwy stałych i elementów enumów, np.
```java
public static final String SOME_NAME_OF_SOMETHING = "Special constant";
private CarType myCarType = CarType.HEAVY_TRUCK;
```
* zapis CamelCase - Ogólnie zapisujemy wszystko małą listerą, oprócz pierwszych liter poszczególnych wyrazów w nazwie - zastosowanie: nazwy wszystkich struktur "typowych" - klas, interfejsów, enumów, np:
```java
public class DatabaseService { //(...)
public enum CarType { //(...)
public interface MouseListener { //(...)
```
* zapis mixedCase (albo inaczej Lower CamelCase) - zasada taka sama jak dla CamelCase, z tą różnicą, że pierwszą literę zapisujemy jako małą - zastosowanie: nazwy zmiennych, pól i metod, np:
```java
String myName = "Antek"; //zmienna
(...)
private String myStringField; //pole

public String getMyStringField() { //(...) metoda
```

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
```java
public void someMethod(MyClass objectOne) {
    objectOne.getObjectTwo().getObjectThree().doSomething(); //prawo Demeter zostało złamane - metoda woła metodę obiektu spoza listy dopuszczalnych przez prawo Demeter
    objectOne.doSomethingUsinObjectTwoAndThenObjectThree(); //pomijając infantylną nazwę, prawo Demeter zostaje zachowane - wywołujemy metodę tylko na obiekcie przekazanym przez parametr
}
```
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

## Git
Git – rozproszony system kontroli wersji. Stworzył go Linus Torvalds jako narzędzie wspomagające rozwój jądra Linux. Git stanowi wolne oprogramowanie i został opublikowany na licencji GNU GPL w wersji 2.

Pierwsza wersja narzędzia Git została wydana 7 kwietnia 2005 roku, by zastąpić poprzednio używany w rozwoju Linuksa, niebędący wolnym oprogramowaniem, system kontroli wersji BitKeeper.

Źródło: [Wikipedia](https://pl.wikipedia.org/wiki/Git_(oprogramowanie))

#### Jak rozpocząć
Zasadniczo są możliwe dwa główne scenariusze.

##### Gdy jest już gotowe zdalne repo

1. ``git clone <adres-do-zdalnego repo>``
2. ``git fetch|pull`` aby zaciągnąc zmiany ze zdalnego repo
3. ``git push`` aby zaktualizować zdalnego brancha

W tym scenariuszu po sklonowaniu zdalnego repo mamy już z automatu ustawionego domyślnego upstreama o nazwie 
``origin``, który wskazuje na adres z którego sklonowaliśmy repo. Możemy zobaczyć to po wydaniu komendy
 
``git remote -v``

Jeśli chcemy stworzyć nowego lokalnego brancha i umieścić go na zdalnym repozytorium możemy użyć komendy

``git push -u origin new-branch``

Od tego momentu możemy łatwo pobierać zmiany z nowego zdalnego brancha za pomocą

``git pull``

##### Gdy tworzymy całkowicie nowe lokalne repo

1. ``git init``
2. ``git remote add <nazwa-upstreama> <adres-zdalnego-repo>`` aby rozpocząć pracę ze zdalnym repo

Wszystkie inne operacje tak samo jak w poprzedniej sekcji.

##### Jak synchronizować swojego forka z oryginalnym repo

1. Dodać nowego remote'a  wskazującego na oryginalne repo - ``git remote add <upstream> <adres-oryginalnego-repo>``
2. ``git fetch <upstream>``
3. ``git merge <upstream>/<zdalny-branch>``

[Oficjalna dokumentacja GitHuba](https://help.github.com/articles/syncing-a-fork/)

##### Szczegółowe informacje na temat GITa
https://git-scm.com/book/pl/v1/Pierwsze-kroki-Podstawy-Git

## Ogólne

##### API (Application Programming Iterface) (TODO)
