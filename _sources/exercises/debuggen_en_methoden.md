# Debuggen en methoden

## Debuggen

Je zal fouten maken in code en vooral *logische* fouten zijn soms lastig op te sporen. We gebruiken IntelliJ als standaardeditor en in deze opgave ga je beter bekend raken met de debug faciliteiten van IntelliJ.

Ga naar [Debug your first Java application](https://www.jetbrains.com/help/idea/debugging-your-first-java-application.html), dit is onderdeel van de IntelliJ documentatie. Volg deze korte tutorial voor een eerste kennismaking.

In de tutorial wordt een klasse `AverageFinder` gebruikt die concepten bevat die nog worden behandeld, zoals lussen. Als je moeite hebt dit te lezen kan je het volgende voorbeeld gebruiken voor debuggen

```{code-block} java
---
lineno-start: 1
---
public class Circle {

    public static double calculateArea(double radius) {
        double result = Math.PI * radius * radius;
        return result;
    }

    public static void main(String[] args) {
        double diameter = 10.0;
        double area = calculateArea(diameter);

        System.out.println(area);
    }
}
```

De correcte uitkomst van de aanroep met diameter 10 zal afgerond 78,54 moeten zijn. maar dat is hier niet het geval. De klasse `Circle` bevat een *logische* fout, een *bug*, kan jij deze vinden?

## Multadd

```{note}
Deze opgave kan je ook in het boek terugvinden in [hoofdstuk 4](https://books.trinket.io/thinkjava2/chapter4.html).
```

Veel berekeningen kunnen beknopter worden uitgedrukt met de "multadd" bewerking, die drie operanden neemt en `a * b + c` berekent. Sommige processoren bieden zelfs een hardware-implementatie van deze bewerking voor zwevendekommagetallen (*floating-point* getallen).

1.  Maak een nieuw programma `Multadd.java`.

2.  Schrijf een methode `multadd` die drie `double`'s als parameters accepteert en het resultaat van `a * b + c` teruggeeft.

3.  Schrijf een `main` methode die `multadd` test door het aan te roepen met een paar eenvoudige parameters, zoals `1.0, 2.0, 3.0`.

4.  Ook in `main`, gebruik de methode `multadd` om de volgende waarden te berekenen:

    ```{math}
    :label: one
    \sin \frac{\pi}{4} + \frac{\cos \frac{\pi}{4}}{2}
    ```

    ```{math}
    :label: two
    \log 10 + \log 20
    ```

5.  Schrijf een methode `expSum` die een `double` als parameter accepteert en `multadd` gebruikt om te berekenen:

    ```{math}
    :label: three
    x e^{-x} + \sqrt{1 - e^{-x}}
    ```

    ```{hint}
    De methode om *e* tot een macht te verheffen is `Math.exp`.
    ```

In het laatste deel van deze oefening moet je een methode schrijven die een andere methode aanroept die jij geschreven hebt. Wanneer je dat doet, is het een goed idee om de eerste methode zorgvuldig te testen voordat je aan de tweede gaat werken. Anders zul je misschien twee methoden tegelijk moeten debuggen, wat lastig kan zijn.

Een van de doelen van deze oefening is het oefenen van *pattern-matching*: de vaardigheid om een specifiek probleem te herkennen als een instantie van een algemene categorie van problemen.

## Fermat

```{note}
Deze opgave kan je ook in het boek terugvinden in [hoofdstuk 5](https://books.trinket.io/thinkjava2/chapter5.html).
```

De [Laatste Stelling van Fermat](https://nl.wikipedia.org/wiki/Laatste_stelling_van_Fermat) zegt dat er geen gehele getallen $a$, $b$, $c$ en $n$ bestaan zodat $a^n + b^n = c^n$, behalve als $n \leq 2$ is.

Schrijf een programma `Fermat.java` dat vier gehele getallen invoert `a`, `b`, `c`, en `n`) en kijkt of de stelling van Fermat geldt.
Als $n$ groter is dan 2 en $a^n + b^n = c^n$, dan zou het programma moeten weergeven "Potverdorie, Fermat had geen gelijk!"
Zo niet, dan moet het programma "Nee, dat werkt niet." weergeven.

```{tip}
Je zou hier misschien `Math.pow` willen gebruiken.
```
