# Lussen met `for`

Voor de volgende opgaven gebruik je uitsluitend een `for` lus.

## De grootte een schaapskudde

Een groep van 20 schapen wordt uitgezet in een beschermd gebied op Texel. Verwacht wordt dat bij zorgvuldig beheer het aantal schapen, *N*, na *t* jaar zal worden gegeven door de formule

$$
N = 220 / (1 + 10(0.83)^t )
$$

en dat de schapenpopulatie zichzelf zonder verder toezicht zal kunnen handhaven zodra de populatie een omvang van 80 heeft bereikt.

Schrijf een programma (met een `for`-lus) waarin de waarde van *N* voor *t* wordt uitgeschreven, beginnend bij nul en oplopend tot 25. Hoeveel jaar moet de schapenpopulatie onder toezicht staan?

```{note}
Bereken $(0,83)^t$ niet elke keer "from scratch" als de formule wordt gebruikt. Gebruik een variabele `power` die in elke iteratie van de lus met 0,83 wordt vermenigvuldigd. Met welke waarde moet die *geïnitialiseerd* worden?
```

## Maximum van gehele getallen

Gegeven het volgende fragment dat de getallen 0 tot en met 5 bij elkaar optelt en vervolgens de totale waarde `sum` print:

```java
int count, sum;
sum = 0;

for (count = 0; count <= 5; count++) {
    sum = sum + count;
}

System.out.println("sum is: " + sum);
```

Schrijf een programma `MaxNumber.java` dat 1 of meerdere getallen als argument accepteert, de maximale waarde bepaalt en deze waarde op het scherm afdrukt. Breidt het bovenstaande fragment uit en voeg een nieuwe `int` variabele `max` toe `max` die je *initialiseert* met de *eerste* waarde van de input. Om het maximum te berekenen heb je een `if` statement nodig, *genest* in de lus. Na jouw aanpassingen zal een voorbeeld uitvoer als volgt zijn:

```console
> java MaxNumber.java 6 4 7 9 8 2 6
sum is: 42
max is: 9
```

```{tip}
Het aantal keren dat je de `for`-lus zal moeten laten doorlopen is gelijk aan het aantal argumenten dat je ontvangt. Het aantal elementen in een array kan je als volgt bepalen:

:::{code-block} java
int numArgs = args.length;
:::
```

