# Lussen met `while`

Voor de volgende opgaven gebruik je uitsluitend een `while` lus.

## Elk begin heeft een einde

Schrijf een programma `StartStop.java` dat de gebruiker om een beginwaarde en een eindwaarde vraagt en dan alle gehele getallen (inclusief) tussen die twee waarden schrijft.

```console
> java StartStop.java
Enter Start:
5
Enter End:
9

5
6
7
8
9
```

## Woord echo

Schrijf een programma `WordEcho.java` dat de gebruiker vraagt een woord in te voeren. Het programma herhaalt het woord vervolgens zo vaak als het tekens bevat:

```console
> java WordEcho.java
Enter word:
Hallo

Hallo
Hallo
Hallo
Hallo
Hallo
```

````note
Om dit te doen moet je de `length()` methode gebruiken die het aantal karakters in een string telt:

```java
String inputString;
int times;

# ...

times = inputString.length()
```
````

## Punten vullen

Schrijf een programma `DotPadWords.java` dat de gebruiker vraagt om twee woorden in te voeren. Het programma drukt vervolgens beide woorden af op één regel. De woorden worden gescheiden door voldoende punten, zodat de totale regellengte 30 is:

```console
> java PadWords.java
Enter first word:
schildpad
Enter second word:
153

schildpad..................153
```

```{note}
Dit zou bijvoorbeeld gebruikt kunnen worden als onderdeel van een index voor een boek. Om de punten af te drukken, gebruik je `System.out.print(".")` binnen de lus.
```
---
Copyright © [Bradley Kjel](http://chortle.ccsu.edu/)