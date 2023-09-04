# Grote getallen

## Machtsverheffing

Schrijf een recursieve methode `pow` die een `double` `x` en een `int` `n` accepteert en $x^n$ teruggeeft.

```{hint}
Een recursieve definitie van deze bewerking is $x^n = x \cdot x^{n-1}$.
Onthoud ook dat alles wat tot de macht nul verheven is, 1 is.
```

Optionele uitdaging: je kunt deze methode efficiënter maken, als $n$ even is, door $x^n = \left( x^{n/2} \right)^2$ te gebruiken.

## Faculteit

De faculteit van een getal is het product van de getallen 1 tot en met $n$. De recursieve uitwerking is als volgt

```java
public static int factorial(int n) {
    if (n == 1) {
        return 1;

    return n * factorial(n - 1);
}
```

1.  Maak een programma `Big.java` en herschrijf daar de recursieve versie van `factorial` naar een *iteratieve* versie met behulp van een `for`-lus.

2.  Houd een tabel bij van de gehele getallen van 0 tot 30 samen met hun faculteit. Op een bepaald punt rond 15 zul je waarschijnlijk zien dat de antwoorden niet meer juist zijn. Waarom niet?

3.  Converteer `factorial` zodat het de berekening uitvoert met het type `BigInteger` en een `BigInteger` als resultaat teruggeeft. Je kan parameter parameter type laten staan, het zal nog steeds een geheel getal (`int`) zijn.

4.  Probeer de tabel opnieuw bij te houden met jouw aangepaste `factorial` methode. Is het correct tot 30? Hoe hoog kun je het laten gaan?

5.  Optioneel: bij de vorige opgave zal je tegen hetzelfde probleem aanlopen zodra de getallen groter worden. Pas jouw recursieve methode `pow` aan zodat het ook het type `BigInteger` gebruikt.

```{note}
De opgave Machtsverheffing kan je in het boek vinden in [hoofdstuk 9](https://books.trinket.io/thinkjava2/chapter6.html), de opgave Faculteit in [hoofdstuk 8](https://books.trinket.io/thinkjava2/chapter6.html).
```
