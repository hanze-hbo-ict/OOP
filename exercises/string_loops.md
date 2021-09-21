# Strings en lussen

## ABC

Een woord is zogezegd "abecedarisch" als de letters in het woord
in alfabetische volgorde voorkomen.

Bijvoorbeeld, de volgende zijn allemaal abecedarische woorden:

> accent, accept, afkoop, afloop, agnost, begijn, bekort, beloop, bemost, chintz, chloor, dekkop, dekmos, dikkop, dikoor, eenoor, effort, floppy, glossy, abelmos, accijns, beknopt, bennoot, bijknop, bijloop, bijnoot, deinoor, deeghouw, knoop

Schrijf een methode `isAbecedarian` die een `String` accepteert en een
`booleaan` teruggeeft dat aangeeft of het woord abecedarisch is.

## Dubbelwoorden

Men zegt dat een woord een *dubbelwoord* is als elke letter die voorkomt
in het woord precies twee keer voorkomt. Hier zijn enkele voorbeelden van dubloenen
in het woordenboek:

> dodo, enen, jojo, lala, mama, mimi, papa, bonbon, dumdum, inging, kerker, tamtam, tenten, verver, beriberi, couscous, genegene, taaitaai

Schrijf een methode `isDoubloon` die een `String` accepteert en controleert of het
een dubbelwoord is. Om hoofdletters te negeren, roep je de `toLowerCase` methode aan voor je controleert.

```{note}
De opgaven ABC en Dubbelwoorden kan je ook in het boek terugvinden in [hoofdstuk 6](https://books.trinket.io/thinkjava2/chapter6.html).
```

## Schaakstukken

♔ ♕ ♖ ♗ ♘ ♙ ♚ ♛ ♜ ♝ ♞ ♟

In [Unicode](https://unicode.org) worden karakters door numerieke *code points* gerepresenteerd. Schaakstukken zijn ook [gedefinieerd](https://en.wikipedia.org/wiki/Chess_symbols_in_Unicode) en kunnen als karakters worden gebruikt. Het is een oplopende reeks waar 9812 staat voor de witte koning en 9823 de zwarte pion. Doorloop met een lus deze reeks en print ze als `char` achterelkaar op het scherm.

