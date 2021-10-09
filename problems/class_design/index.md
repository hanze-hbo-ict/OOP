---
source: https://www.cs.princeton.edu/courses/archive/spring14/cos233/assignments/rational/
---

# Klassen ontwerpen

Doel:

-   Het ontwerpen van klassen
-   Typen gebruiken als parameter en als returnwaarde

In deze opgave ga je twee klassen schrijven:

-   `Rational.java`
-   `RationalClient.java`

## Rationale getallen

Rationale getallen zijn getallen die kunnen worden weergegeven als de verhouding van twee gehele getallen, dat wil zeggen, elk getal $p/q$ waarbij $p$ en $q$ gehele getallen zijn is een rationaal getal. Je zal hier breuken in herkennen, en breuken zijn rationale getallen. Java benadert niet-gehele rationale getallen met behulp van `float` of `double`, maar deze typen bieden onvoldoende nauwkeurigheid, zeker waar het gaat om grotere getallen. In deze opgave ga je rationale getallen representeren met een klasse `Rational`.

```{attention}
Naast het ontwerpen van een klasse gaat deze opgave ook over de beperkingen van primitieve typen waar ze onvoldoende ruimte bieden om grotere getallen te representeren. Als oplossing zal je snel denken aan het type `BigInteger` waar je kennis mee hebt gemaakt, maar je mag deze **niet** gebruiken! In plaats daarvan ga je een andere methode gebruiken om de onnauwkeurigheid van primitieve typen voor dit probleem te *beperken*.
```

## De klasse `Rational`

De klasse `Rational` heeft de volgende constructor

```java
public Rational (long numerator, long denominator)
```

en de volgende methoden:

```java
/**
 * Voeg het Rational object b toe aan het object
 * en geef een nieuwe Rational terug met de som.
 */
public Rational add(Rational b)

/**
 * Vermenigvuldig het Rational object b met het object
 * en geef een nieuwe Rational terug met het product.
 */
public Rational multiply(Rational b)

/**
 * Trek het Rational object b af van het object en geef
 * een nieuwe Rational terug met het verschil.
 */
public Rational subtract(Rational b)

/**
 * Deel het object door het Rational object b en geef
 * een nieuwe Rational terug met het resultaat.
 */
public Rational divide(Rational b)

/**
 * Geeft true terug als het gelijk is aan een ander
 * Rational object, anders false
 */
public boolean equals(Rational that)

/**
 * Geeft een string representatie terug van het rationale getal.
 * Als de noemer 1 is, druk dan alleen de teller af.
 */
public String toString()
```

De klasse `Rational` bevat een tweetal `long` velden (`numerator` en `denominator`), en deze worden gezet in de *constructor* bij het initialiseren van een nieuwe instantie van deze klasse.

Verder zie je methoden voor het vergelijken, optellen {eq}`frac_add`, aftrekken {eq}`frac_subtract`, vermenigvuldigen {eq}`frac_multiply` en delen {eq}`frac_divide` van rationale getallen. Let op, handelingen op twee rationale getallen geven altijd een nieuwe `Rational` terug, dit zie je ook terugkomen in de signatuur van deze methoden.

```{math}
:label: frac_add

\frac{a}{b} + \frac{c}{d} = \frac{a \times d + c \times b}{b \times d}
```

```{math}
:label: frac_subtract

\frac{a}{b} - \frac{c}{d} = \frac{a \times d - c \times b}{b \times d}
```

```{math}
:label: frac_multiply

\frac{a}{b} \times \frac{c}{d} = \frac{a \times c}{b \times d}
```

```{math}
:label: frac_divide

\frac{a}{b} \div \frac{c}{d} = \frac{a \times d}{b \times c}
```

Een typisch gebruik van deze klasse zou ongeveer als volgt zijn:

```java
Rational a = new Rational (2, 3);
Rational b = new Rational(-1, 3);
Rational sum = a.add(b);
System.out.println(sum);  // prints 1/3
```

Let op, het bovenstaande voorbeeld zal voor jouw eerste versie van `Rational` de waarde `3/9` geven, later zal je een verbetering doorvoeren die de vereenvoudiging `1/3` als resultaat heeft.

Implementeer de klasse `Rational` op basis van de hierboven gegeven beschrijving. Bedenk ook hoe je omgaat met negatieve getallen en nul (delen door nul zal een `java.lang.ArithmeticException` fout geven).

## `Rational` gebruiken

Schrijf een programma `RationalCient.java` op dezelfde lokatie als `Rational.java`. Dit programma gaat het type `Rational` gebruiken.

```java
public static Rational approxE(int N)
```

Implementeer in `RationalClient` de methode `approxE` met de bovenstaande signatuur. In deze methode ga je een [Taylorreeks](https://nl.wikipedia.org/wiki/Taylorreeks) gebruiken om de eerste `N`-termen van de rationale benadering van $e$ te berekenen. Deze reeks is als volgt

$$
e = 1/0! + 1/1! + 1/2! +1/3! + 1/4! + 1/5! + \cdots
$$

Je zal hier ook een methode voor de berekening van de faculteit nodig hebben, een versie kan je vinden in de [inleiding](/topics/4a_recursie) over recursie. Print steeds de waarde die je krijgt nadat elke term aan de benadering is toegevoegd. De uitvoer voor `N` is 6 zal als volgt zijn:

```console
> javac RationalClient.java
> java RationalClient 6
1/1 2/1 5/2 32/12 780/288 93888/34560
```

````{warning}
Let op dat in dit geval het volgende niet zal werken

```console
java RationalClient.java 6
```

Tot nu toe is dit een gemakkelijke manier geweest om programma's uit te voeren maar het heeft een belangrijke beperking: het werkt aleen maar als een programma in een enkel bestand past. Dit is hier niet het geval omdat de klasse `Rational` die door `RationalClient` wordt gebruikt in een ander bestand is geschreven.

Vanwege deze beperking zal je `RationalClent.java` altijd eerst moeten compileren voordat je het kan uitvoeren.
````

## `Rational` verbeteren

Er zijn verschillende problemen met onze implementatie van de rationele getalklasse. Als we proberen een nauwkeurigere benadering van $e$ te berekenen, bijvoorbeeld `N` rond 10, wat gebeurt er met de waarden? Het vreemde gedrag dat je waarneemt is het resultaat van *overflow*. De compiler zal je niet vertellen wanneer de teller of noemer zich buiten het bereik van gehele getallen bevindt die in een `long` kunnen worden opgeslagen, dus je moet altijd voorzichtig zijn bij het uitvoeren van numerieke berekeningen.

Er zijn een paar relatief eenvoudige wijzigingen die we kunnen aanbrengen in de klasse `Rational` om overflow voor nog een aantal termen van de benadering te voorkomen. Merk ten eerste op dat onze rationele getallen niet altijd in hun meest eenvoudige vorm worden opgeslagen. In de vierde term in het bovenstaande voorbeeld zijn bijvoorbeeld zowel teller als noemer deelbaar door 4, dus we slaan het resultaat liever op als `8/3` in plaats van `32/12`.

Je kan dit probleem oplossen door de klasse `Rational` te wijzigen door alleen rationale getallen met teller en noemer [relatief priem](https://nl.wikipedia.org/wiki/Relatief_priem) op te slaan en terug te geven. Voeg aan de klasse een methode `gcd` (*greatest common divisor*) toe die het algoritme van Euclides implementeert om de grootste gemene deler van twee getallen te berekenen, en gebruik dit resultaat om deze voorwaarde af te dwingen.

````{admonition} Het algoritme van Euclides

Het algoritme berust erop dat de grootste gemene deler van twee gehele getallen ook de grootste gemene deler is van zowel het kleinste getal als van de rest die overblijft bij deling van het grootste getal door het kleinste. Zo ontstaat er een aflopend iteratief proces.

Je kan de grootste gemene deler (ggd) efficiënt berekenen met behulp van de volgende eigenschap, die geldt voor positieve gehele getallen `p` en `q`:

Als `p > q`, is de ggd van `p` en `q` gelijk aan de ggd van `q` en `p % q`.

Een recursieve uitwerking is als volgt

```java
// greatest common divisor
public int gcd(int p, int q) {
    if (q == 0) {
        return p;
    }

    return gcd(q, p % q);
}
```
````

Bereken de benadering van $e$ opnieuw nadat je de relevante methoden in de klasse `Rational` hebt aangepast. Is de benadering van $e$ verbeterd?

### Tot slot

Bedenk dat het niet van belang is hoe de methoden van `Rational` worden geïmplementeerd voor programma's die deze klasse gebruiken, zolang de *interface* maar gelijk blijft. Dat wil zeggen, zolang de *signatuur* van de methoden (methodenaam, parameters en returntype) gelijk blijft zijn geen wijzigingen op andere lokaties nodig (bijvoorbeeld in `RationalClient.java`). Dit is een belangrijk voordeel van modulair en objectgeoriënteerd programmeren, de clientcode blijft geïsoleerd van de details van de implementatie.

---
Copyright © 2014 Tony Capra, R. Sedgewick, A. LaPaugh, and S. Arora.