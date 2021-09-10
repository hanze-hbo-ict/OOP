# Variabelen en toekenningen

Waarden in de volgende programma's zijn "hard" gezet met declaraties of toekenningen, betere versies van deze programma's zouden de gebruiker vragen om deze waarden in te voeren. Later in deze cursus zul je leren hoe je dat moet doen.

Deze oefeningen vragen je om programma's verschillende keren uit te voeren met verschillende waarden. Dit is belangrijk om te doen! Experimenteren met je programma's is van belang om ze te begrijpen en een beter gevoel voor syntax te krijgen.

## Salaris

Gegeven is het volgende programma voor het berekenen van een salaris:

```java
class Payroll {
    public static void main(String[] args) {
        long   hoursWorked = 40;
        double payRate     = 10.0, taxRate = 0.10;
        System.out.println("Hours Worked: " + hoursWorked);
        System.out.println("Pay Amount  : " + (hoursWorked * payRate));
        System.out.println("Tax Amount  : " + (hoursWorked * payRate * taxRate));
    }
}
```

Je zal zien dat **drie** variabelen `hoursWorked`, `payRate` en `taxRate` worden *gedeclareerd* én tegelijkertijd *geïnitialiseerd* worden.

```{admonition} Boek
Lees 2.1 [*Declaring variables*](https://greenteapress.com/thinkjava7/html/chapter-02.html#sec21) en 2.2 [*Assigning variables*](https://greenteapress.com/thinkjava7/html/chapter-02.html#sec22) over het declareren en initialiseren (toekennen van waarden) van variabelen.
```

1.  Pas `Payroll.java` zo aan dat elke variabele op zichzelf wordt gedeclareerd en niet geïnitialiseerd is.

    Schrijf vervolgens drie toewijzingsverklaringen om aan elke variabele een waarde toe te kennen. Start het programma en controleer de uitvoer.

2.  Laten we nu iets breken: verwijder één van de declaraties uit het programma. Kun je het compileren?

3.  Verwijder nu een van de initialisaties uit het correcte programma. (Bijvoorbeeld, verwijder de tekens `"= 40"` uit de eerste declaratie. Probeer het programma te compileren en uit te voeren. Wanneer wordt een probleem ontdekt? Tijdens het compileren of het uitvoeren van het programma?

(opdracht_2)=
## Waarde van kwadratisch

Stel dat je geïnteresseerd ben in de waarde van de kwadratische formule

$$
3x^2 -8x + 4
$$

voor verschillende waarden van $x$.

Schrijf een programma dat een dubbele precisie variabele `x` heeft. Wijs er een waarde aan toe. Schrijf een statement dat een waarde berekent voor de vergelijking en sla het resultaat op in een andere dubbele precisie variabele. Schrijf tenslotte het resultaat uit, bijvoorbeeld

```console
Voor X = 4.0 is de waarde 20.0
```

Voer het programma uit met verschillende waarden voor `x` (bewerk het programma voor elke waarde van `x`) en onderzoek het resultaat. Gebruik waarden met decimalen, grote waarden, kleine waarden, negatieve waarden en nul. Los de vergelijking op met papier en potlood (gebruik de kwadradische formule). De kwadradische formule moet gelijk zijn aan nul bij `x = 2.0` en bij `x = 2/3`. Probeer deze waarden voor `x`. Zijn de resultaten precies goed?

```{Admonition} Boek
Lees 2.7 [Rounding Errors](https://greenteapress.com/thinkjava7/html/chapter-02.html#sec27) over zwevendepuntgetallen en het afronden van getallen.
```

## Waarden opnieuw toewijzen aan variabelen

Wijzig het vorige programma ([Waarde van kwadratisch](opdracht_2)) zodanig dat in één run van het programma de waarde van de kwadratische functie wordt berekend en uitgeschreven voor drie verschillende waarden van `x`: 0.0, 2.0 en 4.0 (of drie waarden naar keuze).

Schrijf het programma met slechts twee variabelen, `x` en `value` (de uitkomst van de formule voor `x`). Dit betekent natuurlijk dat je op verschillende plaatsen in het programma verschillende dingen in deze variabelen moet zetten.

Maak bij het schrijven van het programma gebruik van de functies "kopiëren" en "plakken" van je tekstverwerker om te voorkomen dat je dezelfde regels opnieuw moet typen.

```{hint}
Als aan een variabele een waarde is toekend betekent het niet dat de variabele daarmee onveranderlijk is geworden. Variabelen zijn "variabel", je kan na een eerste toekenning daar vervolgens nieuwe waarden aan toekennen, bijvoorbeeld

:::{code-block} java
x = 0.0;

// los de formule op voor x (0.0) en print het resultaat

x = 2.0;

// los nogmaals de formule op voor x (2.0) en print het resultaat
:::
```
---
Copyright © [Bradley Kjel](http://chortle.ccsu.edu/)
