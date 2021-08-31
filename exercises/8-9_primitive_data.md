# Primitieve gegevenstypen

## Nijpend tekort

Het volgende programma gebruikt het type `short`, één van de Java primitieve gegevenstypen:

```{code-block} java
---
lineno-start: 1
emphasize-lines: 3, 4
---
public class Shortfall {
    public static void main(String[] args) {
        short value = 32;
        System.out.println("A short: " +  value);
    }
}
```

In dit programma is op regel 3 `value` een **variabele**, een *naam* die verwijst naar een deel van het geheugen dat gegevens bevat van een bepaald gegevenstype.

In dit geval is `value` de naam voor *16 bits geheugen* dat wordt gebruikt om een geheel getal te representeren. Met andere woorden, het programma kent op regel 5 de waarde 32 toe aan de variabele `value` van type `short`.

De uitvoer van dit programma is als volgt:

```console
> java Shortfall
A short: 32
```

Op regel 4 in het programma wordt de waarde van de variabele `value` opgehaald en wordt samen met de tekst "A short: " op scherm geprint.

### Opgave

1.  Compileer `Shortfall.java` en voer het programma uit. Controleer of het volgende wordt geprint:

    ```text
    A short: 32
    ```

2.  Pas `Shortfall.java` aan en wijzig de waarde 32 van `value` in een ander (klein) getal, bijvoorbeeld 356. Compileer en voer het programma uit en controleer het resultaat:

    ```console
    > java Shortfall
    A short: 356
    ```

3.  Verander vervolgens de waarde van `value` naar 35000 en voer het programma nogmaals uit. Dit zal nu een fout geven

    ```console
    Exception in thread "main" java.lang.Error: Unresolved compilation problem:
        Type mismatch: cannot convert from int to short
    ```

    Dit getal is blijkbaar te groot voor het gegevenstype `short` (met andere woorden, het kan niet worden gerepresenteerd in 16 bits). Kan je verklaren wat hier gebeurt? Wat is het grootste getal dat met `short` kan  worden gerepresenteerd?

4.  Pas het type `short` aan naar `int` (maar verander de waarde 35000 niet) en voer het programma uit. Wat is het verschil? Wat is het grootste getal dat met `int` kan  worden gerepresenteerd?

```{attention}
Let op dat je na **elke wijziging** het programma eerst *compilereert*

:::{code-block} console
> javac Shortfall.java
:::

om het vervolgens te kunnen uitvoeren

:::{code-block} console
> java Shortfall
:::

Als je de eerste stap (compileren) vergeet zal altijd de *laatst* gecompileerde versie van jouw programma worden uitgevoerd en zijn de meeest recente wijzigingen niet zichtbaar!

Ontwikkelomgevingen als [IntelliJ](https://www.jetbrains.com/idea/) vereenvoudigen deze handelingen en zorgen er voor dat de code altijd eerst wordt gecompileerd voordat het wordt uitgevoerd.
```

## Dubbel gevaar

Het volgende programma gebruikt het primitieve gegevenstype `double`:

```java
public class DoubleJeopardy {
    public static void main(String[] args){
        double value = 32;
        System.out.println("A double: " +  value);
    }
}
```

In dit programma is `value` de naam voor een variabele die het gegevenstype `double` gebruikt om zwevendekommagetallen (*floating point*) weer te geven. Dit gegevenstype gebruikt 64 bits.

Het is geen probleem om de naam `value` te gebruiken in dit en in het vorige programma. Een naam voor een variabele helpt te beschrijven wat je wilt dat het programma doet. Het reserveert niet permanent een deel van het computergeheugen voor een bepaald gebruik.

### Opgave

1.  Compileer het programma en voer het uit. Verschilt de uitvoer (wat er op het scherm verschijnt) van de uitvoer van de vorige oefening?

2.  Verander de 32 in 32.0 en kijk of dat een verschil maakt wanneer je het programma compileert en uitvoert.

3.  Probeer nu het programma te "breken". Verander 32 in een waarde die te groot is voor `double` en je een *floating point number too large* fout ziet.

    ```{hint}
    De hoogste waarde van een 64 bit getal is $2^{63} - 1$. Je zou hier misschien een wetenschappelijke notatie willen gebruiken om grote getallen uit te drukken. Bijvoorbeeld $3.14 \times 10^{23}$ kan je schrijven als

    :::{code-block} java
    double value = 3.14e23;
    :::
    ```

## Exponentiële explosie

Het volgende programma gebruikt ook het primitief gegevenstype `double`. Dit programma berekent en schrijft de waarde uit van `Math.exp(32)`. Dit is het getal $e$ verheven tot de macht 32. ($e$, ook wel de [constante van Napier](https://nl.wikipedia.org/wiki/E_(wiskunde)) genoemd, is het grondtal van de [natuurlijke logaritme](https://nl.wikipedia.org/wiki/Natuurlijke_logaritme). Maak je hier niet te veel zorgen over. Het punt van het programma is niet de wiskunde maar de zwevendekommagetallen).

```java
public class ExponentialExplosion {
    public static void main(String[] args) {
        double value = 32;
        System.out.println("e to the power value: " +  Math.exp(value));
    }
}
```

### Opgave

Compileer het programma en voer het uit. Compileert het succesvol en wordt het correct uitgevoerd? Verander nu de 32 in steeds grotere getallen tot iets fout gaat.

## Karaktermoord

Het volgende programma gebruikt het primitieve gegevenstype `char`:

```java
public class CharAssassination {
    public static void main(String[] args) {
        char ch = 'A' ;
        System.out.println("A char: " +  ch);
    }
}
```

De variabele `ch` is 16 bits geheugen dat het gegevenstype `char` gebruikt om karakters weer te geven. De uitvoer van het programma is:

```console
A char: A
```

### Opgave

1.  Wijzig `'A'` naar `'Z'` en voer het programma uit.
2.  Wijzig `'A'` naar `'AA'` en voer het programma uit.
3.  Wijzig `'A'` naar `' '` en voer het programma uit.

    **Let op**: er is een *enkele* spatie tussen de twee `'` tekens.

4.  Wijzig `'A'` naar `''` en voer het programma uit.

    **Let op**: er is *geen* karakter tussen de twee `'` tekens.

5.  Wijzig `'A'` naar `"A"` en voer het programma uit.

    **Let op**: gebruik dubbele (`"`) in plaats van enkele aanhalingstekens.

Observeer en verklaar wat werkt en wat niet werkt in het bovenstaande.

```{caution}
De laatste bewerking zal de volgende fout geven:

:::{code-block} console
incompatible types: java.lang.String cannot be converted to char
:::

Dubbele aanhalingstekens betekenen een gegevenstype `String` en dit is iets anders dan een `char`. Enkele- en dubbele aanhalingstekens hebben speciale betekenis!
```
