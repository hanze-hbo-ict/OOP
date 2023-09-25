# Geneste cirkels

Doel:

-   Oefenen met recursie
-   Werken met externe bibliotheken

## Inleiding

In deze opgave ga je gebruik maken van een *externe* bibliotheek [`stdlib`](https://introcs.cs.princeton.edu/java/stdlib/). Deze bibliotheek (een *jar* bestand, of *Java Archive*) bevat een aantal klassen, onder andere voor het eenvoudig tekenen van geometrische figuren.

Je gaat voornamelijk gebruik maken van de klasse `StdDraw` uit deze bibliotheek, lees de [documentatie](https://introcs.cs.princeton.edu/java/stdlib/) voor deze klasse door om een eerste indruk te krijgen van de functionaliteit. Het projectbestand dat je gaat downloaden zal IntelliJ zo configuren dat het `stdlib` herkent als *afhankelijkheid* en daarmee ook documentatie als contextuele hulp zal aanbieden wanneer je `StdDraw` methoden gaat gebruiken.

## Opgave

In deze opgave ga je het volgende programmma schrijven

-   `NestedSquares.java`

Voordat je aan deze opgave begint zal je eerst het voorbeeld programma `NestedCircles.java` gaan bestuderen en uitvoeren. Dit programma maakt gebruik van de klasse `StdDraw` uit de bibliotheek `stdlib` en je zal deze bibliotheek ook gaan gebruiken in de opgave.

De bibliotheek `stdlib` hoef je niet zelf te downloaden, deze is opgenomen in het projectbestand voor deze opgave. Download het projectbestand <a href="../../projects/nested_circles.zip">nested_circles.zip</a> en pak het uit.

## Voorbeeld

In dit voorbeeld zie je hoe de klasse `NestedCircles` methoden van de klasse `StdDraw` gebruikt voor het recursief tekenen van geneste cirkels in willekeurige kleuren.

De coördinaten van het canvas waar de figuren op worden getekend zijn als volgt:

![Canvas coordinates](images/canvas_coordinates.png)

Het *eerste* niveau zal het volledige canvas gebruiken, dit betekent dat voor de eerste figuur het middelpunt van de cirkel zich op `(0.5, 0.5)` zal bevinden. Voor elk volgend niveau zal zowel links als rechts van het voorgaande middelpunt een cirkel worden getekend zoals je kan zien in figuur {ref}`nested_circles_coordinates`.

```{figure} images/nested_circles_dimension.png
:name: nested_circles_coordinates
De coördinatenbepaling van een cirkel
```

Elke cirkel zal *random* met een kleur worden gevuld, je zal zien dat hier gebruik wordt gemaakt van `StdRandom`, ook een klasse uit `stdlib`.

```{figure} images/nested_circles_1.png
---
name: nested_circle_1
---
Geneste cirkels met diepte 1
```

In figuur {ref}`nested_circle_1` zie je het resultaat voor niveau $N = 1$. Volgens de bepaling van de coördinaten van het middelpunt zal vervolgens voor niveau $N = 2$ twee cirkels worden getekend aan beide zijden van het vorige middelpunt, zie figuur {ref}`nested_circle_2`.

```{figure} images/nested_circles_2.png
---
name: nested_circle_2
---
Geneste cirkels met diepte 2
```

Het patroon zal zich gaan herhalen voor elk volgend niveau, zie bijvoorbeeld figuur {ref}`nested_circle_3` en {ref}`nested_circle_4` voor zowel $N = 3$ als $N = 4$.

```{figure} images/nested_circles_3.png
---
name: nested_circle_3
---
Geneste cirkels met diepte 3
```

```{figure} images/nested_circles_4.png
---
name: nested_circle_4
---
Geneste cirkels met diepte 4
```

### `NestedCircles`

Je ziet hier de klasse `NestedCircles`, we gaan de methoden één voor één langslopen.

```java
public class NestedCircles {

    // draw a circle with some embellishments
    // the center is (x, y) with the specified radius
    public static void fancyCircle(double x, double y, double radius) {

        // equally likely 0 or 1
        int randomBit = StdRandom.uniform(2);

        // pick circle color
        if (randomBit == 0)
            StdDraw.setPenColor(StdDraw.CYAN);
        else
            StdDraw.setPenColor(StdDraw.YELLOW);

        // draw circle
        StdDraw.filledCircle(x, y, radius);

        // draws gray outline around each circle
        StdDraw.setPenColor(StdDraw.GRAY);
        StdDraw.circle(x, y, radius);
    }

    // draw a nested circle of order n, centred at (x, y) with
    // the specified radius
    public static void draw(int n, double x, double y, double radius) {
        if (n == 0) {  // base case
            return;
        }

        // recursive case
        fancyCircle(x, y, radius);

        // draw two nested circles of order n-1
        double halfRadius = radius / 2;

        draw(n - 1, x - halfRadius, y, halfRadius);
        draw(n - 1, x + halfRadius, y, halfRadius);
    }

    // takes an integer command-line argument n
    // and plots an order n circle
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        double x = 0.5, y = 0.5; // biggest circle centred at (0.5, 0.5)
        draw(n, x, y, 0.5);      // radius fills up [0,1] x [0,1] view
    }
}
```

### Stap voor stap

We lichten als eerste de methode `draw` er uit om regel voor regel na te gaan wat nu precies gebeurt. Bedenk dat alles in relatie is tot het huidige niveau `n` met een centrum van (`x`, `y`).

```{code-block} java
---
lineno-start: 1
---
public static void draw(int n, double x, double y, double radius) {
    if (n == 0) {  // base case
        return;
    }

    // recursive case
    fancyCircle(x, y, radius);

    // draw two nested circles of order n-1
    double halfRadius = radius / 2;

    draw(n - 1, x - halfRadius, y, halfRadius);
    draw(n - 1, x + halfRadius, y, halfRadius);
}
```

-   Regels **2-4**

    De *base case*, het geval dat er niet gehandelt hoeft te worden. Op niveau $N = 0$ kan er geen cirkel getekend worden.

-   Regel **7**

    Voor de huidige coördinaten en radius wordt een cirkel getekend door de methode `fancyCircle`.

-   Regel **10**

    Bereken de helft van de huidige radius

-   Regels **12 en 13**

    De *recursieve case*. Ten opzichte van de huidige cirkel zullen aan weerszijden cirkels getekend moeten worden voor $N - 1$. De eerste aanroep van `draw` (regel **12**) tekent een cirkel aan de linkerkant, de tweede aanroep aan de rechterkant.

De methode `fancyCircle` heeft maar één verantwoordelijkheid, namelijk het tekenen van cirkels voor bepaalde coördinaten en radius. Je ziet hier een aantal `StdDraw` methoden gebruikt worden.

-   `StdDraw.setPenColor`

    Stel de kleur in voor de handelingen die gaan volgen.

-   `StdDraw.filledCircle`

    Teken een cirkel met een *vulkleur*, de kleur die met `setPenColor` is gezet.

-   `StdDraw.circle`

    Teken een cirkel met een *randkleur*, de kleur die met `setPenColor` is gezet.

Kleuren voor het zetten met `setPenColor` zijn *constanten*, je kan deze waarden herkennen aan het gebruik van hoofdletters (dit is een conventie), Bijvoorbeeld

-   `StdDraw.BLACK`
-   `StdDraw.CYAN`
-   `StdDraw.YELLOW`

De methode `main` accepteert een enkele parameter `n`, het aantal niveau's waar cirkels voor moet worden getekend. Naast het aantal niveau's zet ook de initiële waarden voor de aanroep, bijvoorbeeld de `x` en `y` waarden voor het middelpunt van de eerste cirkel en de `radius`. Denk hier terug aan de coordinaten van het canvas, de ruimte waar de cirkels in gaan worden getekend.

```{note}
Je zal in de documentatie voor `StdDraw` ook de methoden `setXscale` en `setYscale` vinden. Verandert de grootte van het `StdDraw` canvas venster wanneer je `setXscale` of `setYscale` aanroept? Nee, het instellen van de schaal verandert de *resolutie* van het venster, niet de grootte van het venster.
```

### Uitvoeren

De volgende commandoregel voor het uitvoeren van `NestedCircles.java` zal **niet** werken

```console
> java NestedCircles.java 4
```

Dit komt omdat methoden worden gebruikt uit een externe bibliotheek en je zal dit Java moeten laten weten door het standaard *classpath* (de lokaties op het bestandssysteem waar Java naar klassen zoekt) uit te breiden met de lokatie waar `stdlib` te vinden is

```console
> java -cp lib/stdlib.jar NestedCircles.java 4
```

Je kan een *wildcard* gebruiken, bijvoorbeeld om alle bibliotheken in een directory aan het classpath toe te voegen

```console
> java -cp lib/*.jar NestedCircles.java 4
```

In dit geval kan dit zelfs worden verkort tot het volgende omdat de directory `lib/` alleen maar *jar* bibliotheken bevat en geen andere typen bestanden

```console
> java -cp lib/* NestedCircles.java 4
```

```{note}
De optie `-cp` kan je meerdere keren opgeven voor verschillende lokaties. Een alternatieve syntax is om een combinatie van lokaties als één argument aan `-cp` mee te geven , bijvoorbeeld `lib/*:other_lib/*`. Je zal hier echter tegen subtiele verschillen per besturingssysteem aanlopen, op UNIX zal je `:` (dubbele punt) als scheidingsteken voor lokaties moeten gebruiken, op Windows `;` (punt komma).

Het zijn dit soort details die IDE's als IntelliJ voor jou regelen door op basis van een *configuratie* een correcte Java aanroep van een programma te genereren, voor jouw specifieke besturingssysteem.
```

## Opdracht

Schrijf een programma `NestedSquares.java` dat een geheel getal `n` als command-line argument accepteert en een recursief vierkant patroon van orde `n` tekent. De vulling van de vierkanten is Hanze oranje, deze kleur hebben wij al voor jou gedefineerd.


```{figure} images/squares_combined.png
---
name: nested_squares
---
Geneste vierkanten met diepte 1 tot en met 4
```

Organiseer je programma als volgt:

```java
import java.awt.Color;

public class NestedSquares {

    // Hanze oranje, gebruik deze als vulkleur voor een vierkant
    public static final Color HANZE_ORANGE = new Color(238, 127, 0);

    // Tekent een vierkant gecentreerd op (x, y) met de gegeven zijdelengte
    // met een lichtgrijze achtergrond en een zwarte rand.
    public static void fancySquare(double x, double y, double length) {
        // ....
    }

    // Tekent een recursief vierkant patroon van orde n, gecentreerd op (x, y)
    // met de gegeven zijdelengte.
    public static void draw(int n, double x, double y, double length) {
        // ...
    }

    // Accepteert een integer command-line argument n en tekent een recursief
    // vierkant patroon van orde n, gecentreerd op (0.5, 0.5) met zijde lengte 0.5.
    public static void main(String[] args) {
        // ...
    }
```

De volgende regel zal je misschien opvallen:

```java
public static final Color HANZE_ORANGE = new Color(238, 127, 0);
```

Hier wordt een property (of veld) van de klasse gedefinieerd van type `Color` met de naam `HANZE_ORANGE`. De *access modifier* `final` geeft aan dat deze waarde niet meer kan worden gewijzigd (deze waarde is *unmutable*). De klasse `StdDraw` heeft deze kleur niet gedefinieerd en om deze reden hebben wij het toegevoegd aan deze klasse. Je gebruikt het als volgt:

```java
StdDraw.setPenColor(HANZE_ORANGE);
```

Copyright © 1999–2021, [Robert Sedgewick](http://www.cs.princeton.edu/~rs/) en [Kevin Wayne](http://www.cs.princeton.edu/~wayne).