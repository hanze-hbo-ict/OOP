# Strings en lussen

## ABC

Een woord is zogezegd "abecedarisch" als de letters in het woord in alfabetische volgorde voorkomen. De volgende woorden zijn bijvoorbeeld allemaal abecedarische woorden:

> accent, accept, afkoop, afloop, agnost, begijn, bekort, beloop, bemost, chintz, chloor, dekkop, dekmos, dikkop, dikoor, eenoor, effort, floppy, glossy, abelmos, accijns, beknopt, bennoot, bijknop, bijloop, bijnoot, deinoor, deeghouw, knoop

Schrijf een methode `isAbecedarian` die een `String` accepteert en een `boolean` teruggeeft die aangeeft of het woord abecedarisch is.

## Dubbelwoorden

Men zegt dat een woord een *dubbelwoord* is als elke letter die voorkomt in het woord precies twee keer voorkomt. Hier zijn enkele voorbeelden van dubbelwoorden:

> dodo, enen, jojo, lala, mama, mimi, papa, bonbon, dumdum, inging, kerker, tamtam, tenten, verver, beriberi, couscous, genegene, taaitaai

Ook veel (maar lang niet alle) palindromen zijn dubbelwoorden:

> hannah, neen, raar, redder, parteretrap

Schrijf een methode `isDoubloon` die een `String` accepteert en controleert of het
een dubbelwoord is. Om hoofdletters te negeren, roep je de [`toLowerCase`](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html#toLowerCase--) methode aan van de string voor je controleert.

```{note}
De opgaven ABC en Dubbelwoorden kan je ook in het boek terugvinden in [hoofdstuk 6](https://books.trinket.io/thinkjava2/chapter6.html).
```

## Schaakstukken

♔ ♕ ♖ ♗ ♘ ♙ ♚ ♛ ♜ ♝ ♞ ♟

In [Unicode](https://unicode.org) worden karakters door numerieke *code points* gerepresenteerd. Schaakstukken zijn ook [gedefinieerd](https://en.wikipedia.org/wiki/Chess_symbols_in_Unicode) en kunnen als karakters worden gebruikt. Het is een oplopende reeks die begint met 9812 (witte koning) en eindigt op 9823 (zwarte pion). Doorloop deze reeks met een lus en print elke waarde als een `char`.
