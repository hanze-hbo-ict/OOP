# Opgave klasse `OptionalInt`

Deze opgave gaat over de klasse `OptionalInt`. Deze klasse is handig als het mogelijk moet zijn om een integer-waarde terug te geven waarbij het ook mogelijk is dat er geen waarde aanwezig is (`empty`).

Naast `OptionalInt` bevat Java ook `OptionalLong`, `OptionalDouble` en de generieke `Optional<T>`.

## Casus: *Break-even* punt berekenen

Er is sprake van een *break-even* punt wanneer er geen winst en geen verlies wordt gemaakt.

Stel dat de kosten voor het maken van een product 80 euro per stuk bedragen. Behalve deze variabele kosten moet er 1000 gereserveerd worden voor de vaste lasten. Het product wordt verkocht voor 100 euro. Per stuk wordt dan 20 euro winst gemaakt ten opzichte van de variabele kosten (€100 - €80 = €20). Om geen verlies meer te maken moeten minimaal 50 stuks worden verkocht (immers €1000 / 20 stuks = 50).

Met de volgende methode wordt het break-even punt berekend van verkoop van een product aan de hand van vaste kosten, de kosten per stuk en opbrengst per stuk:

```{code-block} java
public static int berekenBreakeven(double vasteKosten, double kostenPerEenheid, double opbrengstPerEenheid) {
    double winstPerEenheid = opbrengstPerEenheid - kostenPerEenheid;
    return (int)Math.ceil(vasteKosten / winstPerEenheid);
}
```

De volgende hulp-methode wordt gebruikt om het break-even punt op een nette manier weer te geven:

```{code-block} java
public static void printBreakeven(double vasteKosten, double kostenPerEenheid, double opbrengstPerEenheid) {
   int n=berekenBreakeven(vasteKosten, kostenPerEenheid, opbrengstPerEenheid);
   System.out.println("Break-even punt: "+n+" eenheden.");
}
```

## De klasse `OpgaveOptionalInt`

Maak een klasse `OpgaveOptionalInt` met daarin de methodes `berekenBreakeven` en `printBreakeven`. Maak een `main` methode waarin je de onderstaande testcode zet. Klopt het resultaat?


```{code-block} java
printBreakeven( 1000, 80, 100 ); // 50
printBreakeven( 12000, 0.75, 1.30 ); // 21819
```


## Geen break-even punt

Wat is het resultaat van de volgende test-aanroep?

```{code-block} java
printBreakeven( 2500, 12, 10.5 );
```

Is dit resultaat reëel/valide?

Pas de methode `printBreakeven` zodanig aan dat in het geval van geen break-even punt op het scherm "Geen break-even punt" wordt afgedrukt.

## Ongeldige waardes

Als een uitkomst niet reëel of valide is, dan heeft dit vaak te maken met ongeldige invoerwaardes. Het afhandelen van ongeldige argumenten is geen onderwerp van deze opgave. De argumenten zijn in dit geval juist wel geldig. Er zijn reële situaties denkbaar waarbij de kostprijs hoger is dan de opbrengst.

Het break-even punt is negatief omdat de variabele koste hoger zijn dan de opbrengst per stuk. De uitkomst is niet reëel, want het is normaal gesproken niet mogelijk om een negatief aantal producten te verkopen. Wat is in dat geval wenselijk om te retourneren?

Als een integer geretourneerd moet worden, dan zijn alleen gehele getallen mogelijk als resultaat. De getallen 0 en hoger zijn break-even punten. Eventueel zou een negatief getal gebruikt kunnen worden in het geval er geen break-even punt is. Probleem is dit een enigszins merkwaardig resultaat is, omdat het de suggestie wekt dat het aantal producten negatief kan zijn. Stel dat een programmeur hier geen rekening mee houdt, en bijvoorbeeld gemiddelden gaat berekenen, dan kunnen er ongemerkt vreemde uitkomsten onstaan.

Een ideale oplossing zou de mogelijkheid zijn om aan te geven dat er *geen uitkomst* is. Hoewel dit in sommige gevallen met `None` of `null` mogelijk is en wordt gedaan (met een omweg ook in Java) hebben deze waardes strikt genomen niet dezelfde betekenis als geen waarde. Het niet-primitieve datatype `OptionalInt` biedt de mogelijkheid om naast een bepaalde integer-waarde aan te geven dat er geen waarde is.

## OptionalInt gebruiken

De documentatie van OptionalInt is te vinden op [de documentatie van Oracle](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/OptionalInt.html). Pas de methode `berekenBreakeven` zo aan dat in plaats van een `int` een `OptionalInt` wordt geretourneerd.

Als er geen break-even punt is, dan is deze `OptionalInt` empty (maak geen gebruik van `null`). Onder 'Static Methods' in de documentatie vind je de methodes om instanties te maken van `OptionalInt`. 

Pas ook `printBreakeven` aan, zodat deze gebruik maakt van de `OptionalInt`.

![De statische methoden van `OptionalInt`](../images/opionalint-documentatie.png)





