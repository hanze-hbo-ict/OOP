# Condities

## Korting

Tijdens een uitverkoop wordt in een winkel een korting van 10% toegepast op aankopen van meer dan €10,00. Schrijf een programma `DiscountPrices.java` dat vraagt naar het bedrag van een aankoop, en dan de afgeprijsde prijs berekent. Het aankoopbedrag wordt ingevoerd in centen (als een geheel getal), bijvoorbeeld

```console
Voer het bedrag van de aankopen in: 2000
Afgeprijsde prijs: 1800
```

## Order checker

Bob's IJzerwaren Discounter rekent met de volgende prijzen:

-   5 cent per bout
-   3 cent per moer
-   1 cent per sluitring

Schrijf een programma `OrderChecker.java` dat de gebruiker vraagt naar het aantal bouten, moeren en sluitringen in zijn aankoop en dan het totaal berekent en afdrukt.

Als extra functie controleert het programma het volgorde. Een correcte bestelling moet

-   minstens evenveel moeren als bouten bevatten
-   minstens tweemaal zoveel sluitringen als bouten bevatten

Als dit niet het geval is dan heeft de bestelling een fout. Bij een fout schrijft het programma "Controleer de volgorde: te weinig moeren" of "Controleer de volgorde: te weinig sluitringen", al naar gelang het geval. Beide foutmeldingen worden geschreven als de bestelling beide fouten heeft. Als er geen fouten zijn, schrijft het programma "Bestelling is OK". In alle gevallen wordt de totaalprijs in centen (van het opgegeven aantal stuks) uitgeschreven. Bijvoorbeeld

```console
Aantal bouten: 12
Aantal moeren: 8
Aantal ringen: 24

Controleer de bestelling: te weinig moeren

Totale kosten: 108
```

## Tanken of scheuren

Het bekende *Al's Last Chance Gas station* ligt aan Route 190 aan de rand van Death Valley, Verenigde Staten. Er is geen ander benzinestation in een omtrek van 320 kilometer. Schrijf een programma `LastChanceGas.java` om bestuurders te helpen beslissen of ze moeten tanken. Het programma vraagt naar:

-   De inhoud van de benzinetank, in liters.
-   De aanduiding van de benzinemeter in procenten (vol = 100, driekwart vol = 75, enzovoort).
-   Het aantal kilometer per liter van de auto.

Het programma schrijft dan "Tanken!" of "Rijd door" afhankelijk van of de auto de 320 kilometer kan halen met de resterende benzine in de tank. Bijvoorbeeld,

```
Tankinhoud: 48
Benzinemeter: 30
Kilometers per liter: 15
Tanken!
```

## Millenniumbug

Schrijf een programma `Millennium.java` dat een gebruiker vraagt om zijn geboortejaar, als twee cijfers (bijvoorbeeld "62") en om het huidige jaar, ook als twee cijfers (bijvoorbeeld "99"). Het programma moet de leeftijd van de gebruiker correct in jaren uitschrijven.

```console
Geboortejaar: 62
Huidig jaar: 99
Uw leeftijd: 37
```

Het programma moet bepalen of een tweecijferige waarde zoals "62" overeenkomt met een jaar in de 20e eeuw ("1962") of in de 21e eeuw. Hier is een voorbeeld van het programma waar "00" wordt gebruikt om het jaar 2000 aan te duiden:

```console
Geboortejaar: 62
Huidig jaar: 00
Uw leeftijd: 38
```

Veronderstel dat leeftijden niet negatief zijn. Nog een voorbeeld van het programma:

```console
Geboortejaar: 27
Huidig jaar: 07
Uw leeftijd: 80
```

In het volgende voorbeeld kan de leeftijd van de persoon 6 of 106 zijn, afhankelijk van de aanname. Neem aan dat de leeftijd altijd kleiner dan of gelijk aan 100 zal zijn.

```
Geboortejaar: 01
Huidig jaar: 07
Uw leeftijd: 6
```

```{note}
De [millenniumbug](https://nl.wikipedia.org/wiki/Millenniumbug) (of het Y2K probleem) was een daadwerkelijk probleem dat in 20e-eeuwse computersystemen ontstond doordat bij het opslaan van de datum soms alleen de laatste twee cijfers van het jaar werden gebruikt om ruimte (geheugen) te besparen!
```
---
Copyright © [Bradley Kjel](http://chortle.ccsu.edu/)