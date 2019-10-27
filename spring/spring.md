# Spring Framework

Spring Framework jest najpopularniejszym frameworkiem dla języka Java. Jest także jednym z największych frameworków w
 ogóle. Dostarcza narzędzia niezbędne do stworzenia szerokiego zakresu projektów.
 
Spring korzysta z wielu różnych technologii, zamiast implementować je od nowa. Dzięki temu Spring jest łatwy w 
integracji z różnymi systemami.

## Framework vs biblioteka

Podstawowa różnica: my korzystamy z biblioteki vs framework wywołuje nasz kod.

Korzystając z frameworka musimy dostosować się do przyjętej konwencji.

Bibliotekę możemy używać w dowolny sposób, nie narzuca nam ona żadnej struktury projektu.

## Jak uczyć się Spring Framework

Spring Framework istnieje od 2003 roku. Dokument ten napisany został pod koniec roku 2019. W trakcie 16 lat Spring 
ulegał gwałtownym zmianom, jednocześnie nieustannie zyskując popularność. Powstało wiele materiałów, które są już po 
prostu nieaktualne. Często zdarza się też, że programiści nie aktualizują swojej wiedzy na temat Springa, 
jednocześnie publikując różne wpisy na temat tego frameworka. Jeśli chcesz nauczyć się Springa we właściwy sposób, 
powinieneś dołożyć starań, aby korzystać z aktualnych materiałów.

Algorytm nauki Spring Framework:
1. Odwiedź stronę Spring Framework
2. Przejdź do sekcji z przewodnikami (guides)
3. Wybierz interesujący Ciebie temat (np. moduł Spring Data)
4. Przejdź przez zaproponowany tutorial
5. Jeśli nie zrozumiesz czegokolwiek w tutorialu (np. adnotacja, konfiguracja), poszukaj odpowiedniej sekcji w 
oficjalnej dokumentacji (w momencie pisania https://spring.io/docs/reference).
6. Gdy zrozumiesz o co chodzi, zmodyfikuj przykład w tutorialu dodając drobne zmiany.
7. Stwórz własny projekt (od podstaw), który skorzysta z nowo poznanego modułu.
8. Rozwijaj projekt, ucząc się nowych modułów (goto krok 3)
9. Zakończ naukę, kiedy stworzysz swój wymarzony projekt ;)

## Najważniejsze moduły

- Spring Data
- Spring Web MVC
- Spring Security

## Jak działa Spring?

Najważniejszą częścią Spring Framework jest kontener Dependency Injection. Jest to taka wielka fabryka, która 
umożliwia tworzenie komponentów ze wszystkimi zależnościami.

Spring umożliwia rejestrację komponentów w swoim kontenerze za pomocą następujących metod:
- Adnotacja @Service lub @Component nad klasą, która ma być komponentem. @Service ma dodatkowe znaczenie sematyczne, 
które oznacza, że klasa jest serwisem aplikacyjnym (czyli komponentem koordynującym wywołania naszej logiki biznesowej).
- Stworzenie klasy oznaczonej @Configuration z metodami oznaczonymi adnotacją @Bean. Umożliwia to skonfigurowanie 
instancji naszych komponentów ręcznie i daje największe możliwości.
- Konfigurację w plikach XML (współcześnie już się tego raczej nie używa).