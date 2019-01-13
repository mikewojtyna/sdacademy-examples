# Exploding kittens

Ćwiczenie TDD kata na bazie gry Exploding Kittens.

https://explodingkittens.com/how-to-play/pl/

## Cel
Wymodelujemy niewielki kawałek gry eksplodujące kotki.

Skupmy się wyłącznie na mechanice ciągniecia kart i grania tury

### Przykłady:

1. Gdy stos kart jest pusty i gracz gra turę, wtedy rzućmy wyjątek oznaczający, że stan gry jest nieprawidłowy
2. Gdy stos kart zawiera eksplodującego kota i gracz nie ma karty rozbrojenia, w momencie gdy ciągnie kartę, to gracz przegrał
3. Gdy stos kart zawiera 2 karty i gracz ma na ręce kartę rozbrojenia i gra swoją turę, wtedy usuwa ze swojej ręki kartę rozbrojenia i na spód stosu kart trafia karta eksplodującego kotka i gracz jest żywy
4. Gdy stos kart zawiera dowolną liczbę kart i wierzchnia karta nie jest ekslpdującym kotkiem, wtedy gracz pobiera tę kartę i jest żywy