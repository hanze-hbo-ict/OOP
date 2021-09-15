# Methoden en condities

## Doel

-   Oefenen met het schrijven van methodes
-   Oefenen met conditionele statements
-   Een vooruitblik op *arrays*

## Inleiding

In deze opave ga je een rekenmachine schrijven voor eenvoudige bewerkingen als het optellen en aftrekken van getallen. Ook zal deze rekenmachine meer geavanceerde functionaliteit hebben, bijvoorbeeld het kunnen berekenen van de [afstand](https://nl.wikipedia.org/wiki/Afstand) tussen twee punten in een tweedimensionale ruimte (altijd handig!).

Deze opgave hoopt jou een voorbeeld te geven hoe een probleem in kleinere delen kan worden opgebroken, waar elk onderdeel een eigen verantwoordelijk heeft ([separation of concerns](https://en.wikipedia.org/wiki/Separation_of_concerns)), en hoe deze onderdelen met elkaar kunnen samenwerken (*compositie*).

## Rekenmachine

Maak een klasse `Calculator.java` met een `main` methode. In deze opgdracht ga je deze klasse verder aanvullen met de volgende methoden

```java
public static int getMenuOption()
public static double getOperand(String prompt)
public static double[] getPair()
public static double add(double[] values)
public static double subtract(double[] values)
public static double multiply(double[] values)
public static double divide(double[] values)
public static double random(double[] values)
public static double distance(double[] start, double[] stop)
```

## `getMenuOption`

De methode `getMenuOption` toont een menu aan de gebruiker en leest de gekozen optie in. Het programma start altijd met het tonen van dit keuzemenu. Als de gebruiker een geldige keuze heeft gemaakt moet de methode `getMenuOption` deze keuze teruggeven, geef de waarde 0 terug om aan te geven dat de gebruiker een ongeldige keus heeft gemaakt.

Een mogelijke uitvoer van de aanroep van deze methode kan zijn:

```console
> java Calculator.java
Menu
1 Optellen
2 Aftrekken
3 Vermenigvuldigen
4 Delen
5 Genereer een random getal
7 Bereken afstand
Wat zou je willen doen? 9
Helaas, 9 is geen optie
```

In dit voorbeeld heeft de gebruiker een ongeldige keus gemaakt.

## `getOperand`

De methode `getOperand` heeft maar één eenvoudige taak, namelijk een *prompt* tonen die de gebruiker vraagt een waarde in te vullen, deze input te lezen en het resultaat als een `double` terug te geven. Je zal hier de klasse `Scanner` moeten gebruiken.

Controleer ook hier of de input van de gebruiker correct is, met andere woorden, of de `String` input waarde kan worden omgezet naar een `double`.

```{tip}
Neem paragraaf 5.9 in [hoofdstuk 5](https://books.trinket.io/thinkjava2/chapter5.html) nog een keer door als je niet goed weet hoe je de controle op input moet afhandelen!
```

## `getPair`

Alle rekenoperaties van onze rekenmachine hebben twee *operanden* nodig, *x* en *y*. Deze methode verzamelt de twee waarden en zal daarvoor de methode `getOperand` *tweemaal* aanroepen.

Als je naar de signatuur van de methode kijkt zie je dat het een waarde met type `double[]` teruggeeft waar vooral het gebruik van de dubbele haken (`[]`) opvalt! Denk terug aan het college waar de signatuur van de methode `main` nader werd bekeken.

```java
public static void main(String[] args)
```

Het type `String[]` is hier een *array*, een collectie van waarden met type `String`'. De methode `getPair` gaat ook een collectie teruggeven, in dit geval een *array* met *twee* `double` waarden, *x* en *y*. Gebruik de volgende implementatie van deze methode in jouw code.

```java
public static double[] getPair() {
    double x = getOperand("Eerste waarde: ");
    double y = getOperand("Tweede waarde: ");

    double[] values = {x, y} // declare and initialise a double's array
    return values;
}
```

```{tip}
Veel methoden in deze klassen hebben een `double[]` als parameter en zullen de `x` en `y` waarde uit dit array moeten lezen. Een voorbeeld hoe je dit zou kunnen schrijven:

:::{code-block} java
double[] values = {1, 2};

double x = values[0];
double y = values[1]
:::
```

## Eenvoudige methoden

De rekenmachine kent een aantal "gewone" methoden, dit zijn

-   `add`
-   `subtract`
-   `multiply`
-   `divide`

Je zal deze methoden implementeren door gebruik maken van de standaard operatoren, bijvoorbeeld `+` en `-`. Controleer altijd of de waarden correct zijn, bijvoorbeeld de methode `divide` zal een getal niet kunnen delen door 0.

## Bijzondere methoden

De rekenmachine heeft ook een tweetal meer bijzondere methoden (althans, voor een rekenmachine!), dit zijn

-   `random`
-   `distance`

### `random`

Jouw methode `random` zal een waarde terug moeten geven die **groter of gelijk** is dan de beginwaarde en **kleiner** dan de eindwaarde. Je moet hier de methode `random` in de klasse `Math` voor gebruiken.

```{tip}
De methode `random` in de klasse `Math` genereert een `double` waarde groter of gelijk aan `0.0` en kleiner dan `1.0`. Hoe kan je dit gegeven gebruiken om een random getal voor een bepaalde reeks te genereren? Bedenk dat je de waarde die `Math.random` genereert als een fractie kan gebruiken voor de *lengte* van jouw reeks.
```

### `distance`

De methode `distance` berekent de afstand tussen twee punten in een ruimte op basis van de coördinaten $(x_1, y_1)$ en $(x_2, y_2)$ volgens de formule

$$
\text{distance} = \sqrt{(x_2 - x_1)^2 +(y_2 - y_1)^2}
$$

Implementeer deze methode en maak gebruik van methoden die je eerder hebt gedefiniëerd, bijvoorbeeld `add` en `multiply`. Uit de klasse `Math` mag je alleen de methode `sqrt` gebruiken.

```{note}
Weet je niet goed hoe je dit moet aanpakken? Lees dan paragraaf 4.9 in [hoofdstuk 4](https://books.trinket.io/thinkjava2/chapter4.html) nog eens door hoe je dit probleem stap voor stap zou kunnen oplossen en testen.
```

## De *flow* van het programma

Als het goed is heb je nu alle methoden geïmplementeerd (en getest!). Het begint natuurlijk in `main` met een aanroep van `getMenuOption`. Deze methode geeft de menukeuze als integer terug en op basis van deze waarde zal je

1.  de gebruiker moeten vragen om waarden voor `x` en `y` in te voeren,
2.  deze waarden om te zetten in een geschikt type,
3.  de bijbehorende rekenmethode aan te roepen,
4.  en tot slot het resultaat te printen

Een voorbeeld sessie kan als volgt verlopen:

```console
> java Calculator.java
Menu
1 Optellen
2 Aftrekken
3 Vermenigvuldigen
4 Delen
5 Genereer een random getal
7 Bereken afstand
Wat zou je willen doen? 4
Eerste waarde: 42
Tweede waarde: 2
Antwoord: 21.0
```

Je zal hier condities moeten schrijven waar je `if`-`else` statements voor kan gebruiken, maar misscien zijn `switch` statements ook geschikt?

## Power users

Jouw rekenmachine is een succes! Eén groep gebruikers bestookt jou met de vraag of ze niet via de command line alle opties in één keer kunnen invoeren. Ze kennen het menu uit het hoofd en vinden het omslachtig om steeds weer alle vragen te moeten beantwoorden en één voor één de waarden in te moeten typen. Je hebt hier te maken met *power users*!

Deze gebruikers zouden jouw rekenmachine graag als volgt willen gebruiken, bijvoorbeeld voor een deling

```console
> java Calculator.java 4 42.0 6.0
7.0
```
Het eerste argument is de gewenste operatie en alle volgende argumenten de waarden.

Jouw opdracht is om de rekenmachine uit te breiden met deze functionaliteit. Je zal gebruik moeten maken van het *array* `args` waar je steed zal moeten controleren of het aantal argumenten correct is door de property `length` van het object `args` te gebruiken, bijvoorbeeld

```java
if (args.length == 0) {
    // ...
}
```