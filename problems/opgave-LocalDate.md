# Opgave Klasse `LocalDate`

De klasse `LocalDate` representeert een datum in de plaatselijke tijdzone.

De *constructor* van `LocalDate` is niet *public*, waardoor het niet mogelijk is om met het keyword `new` instanties te maken van `LocalDate`.

De documentatie van `LocalDate` is [hier te vinden](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/time/LocalDate.html)

Onder "Method Summary" - "Static Methods" zijn methodes te vinden waarmee instanties van `LocalDate` worden gemaakt. Daarvan zijn `now` en `of` het belangrijkst.

## Voorbeeld

Zie het voorbeeld hieronder:

```{code-block} java
LocalDate vandaag = LocalDate.now();
LocalDate lustrum = LocalDate.of(2023, 10, 18); // Hanze lustrum 18 oktober 2023
System.out.println("Vandaag: " + vandaag);
System.out.println("Hanze lustrum '23: " + lustrum);
if (vandaag.isAfter(lustrum)) {
    System.out.println("Het Hanze lustrum feest is al geweest.");
} else {
    long d = ChronoUnit.DAYS.between(vandaag, lustrum);
    System.out.println("Over " + d + " dagen is het feest");
}
```

De uitvoer van `LocalDate` op het scherm (om precies te zijn: de `toString` methode van `LocalDate`) geeft geen 'mooie' datum, maar een standaard weergave in het *iso8601-formaat* YYYY-MM-DD.

## Werken met de klasse `LocalDate`

Maak de onderstaande opgaven. Zoek in de documentatie naar geschikte methodes. Als er wordt gevraagd om een datum op het scherm af te drukken, dan kun je volstaan met een standaard weergave. Als gevraagd wordt naar een weekdag dan is het voldoende om de weekdagen in het Engels af te drukken, zoals deze wordt teruggegeven door bijvoorbeeld de methode `getDayOfWeek`.

## Kleine opgaven

We beginnen met wat eenvoudige opgaven om op te warmen. Druk de antwoorden van de onderstaande vragen af:

- Op welke weekdag valt 10 januari 1965?
- Op welke weekdag viel nieuwjaarsdag (1 januari) in het huidige kalenderjaar?
- Wat is de datum vijf weken na vandaag?
- Hoeveel dagen is het geleden dat Nederland het Europees kampioenschap voetbal won (op 25 juni 1988)?

## Huidige collegejaar

Een collegejaar loopt van 1 september tot 1 september van het jaar daarop. Om welk collegejaar het gaat wordt vaak aangegeven met jaartallen. Zo wordt het collegejaar dat begint op 1 september 2023 aangegeven met '23-'24.

Zet het huidige collegejaar op het scherm. Bedenk een methode om het programma te testen, zodat je zeker weet dat het programma over bijvoorbeeld 9 maanden ook nog de het juiste collegejaar aangeeft.

## Kerst

Kerst valt elk jaar op 25 en 26 december. Zet op het scherm hoeveel dagen het nog duurt, voordat het kerst is (eerste kerstdag).
Als het nu eerste of tweede kerstdag is, zet dan op het scherm dat het nu kerst is.

## Sinterklaas

Sinterklaas is elk jaar op 5 december. Zet op het scherm de eerstvolgende 10 datums waarop Sinterklaas plaatsvindt. Zet bij elke datum ook op welke weekdag het plaatsvindt. 
Als het vandaag Sinterklaas is, dan telt deze mee met de 10.

## Prinsjesdag

Prinsjesdag is elk jaar op de derde dinsdag van september. Zet op het scherm de eerstvolgende 5 datums waarop prinsjesdag plaatsvindt.
Als het vandaag prinsjesdag is, dan telt deze mee met de 5 datums op het scherm.

