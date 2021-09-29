# Hello World

## Doel

-   Een eerste kennismaking met programmeren in Java
-   Het gebruiken van IntelliJ voor het schrijven, compileren uitvoeren van Java programma's
<!--
-   Het inleveren van jouw werk in GradeScope
-->

## Inleiding

Om te beginnen zal je Java en een programmeeromgeving op jouw computer moeten instellen. Volg de [stap-voor-stap](support/install) instructies zorgvuldig.

Ten tweede, alle opdrachten vereisen dat je een project zip-bestand downloadt. Gebruik de projectmap `hello` die je na de installatie van IntelliJ hebt gedownload. Het is een goed idee om die map ergens veilig op te slaan, samen met alle mappen die je voor volgende opdrachten in deze module aanmaakt.

Ten derde, lees hoofdstuk [1](https://books.trinket.io/thinkjava2/chapter1.html), [2](https://books.trinket.io/thinkjava2/chapter2.html) en [3](https://books.trinket.io/thinkjava2/chapter3.html) van het tekstboek{cite}`Downey_Allen_B_2019-12-24`.

## Opdracht

-   Implementeer de volgende *vijf* programma's:

    *   `HelloWorld.java`
    *   `HiFour.java`
    *   `Ordered.java`
    *   `GreatCircle.java`
    *   `RGBtoCYMK.java`

<!--
-   De volgende twee programma's zijn **optionele** uitdagingen:
    *   `DeluxeOrdered.java`
    *   `DeluxeRGBtoCYMK.java`
-->

### `HelloWorld.java`

Jouw eerste taak is het schrijven van het `HelloWorld` programma. Kies in IntelliJ *File > New > Java Class*. Geef het bestand de naam `HelloWorld` en typ dan het eerste programma van iedereen in: `HelloWorld.java`.

<!--
![](images/image7.png)
-->

```{note}
*Ik begrijp al het jargon in `HelloWorld.java` niet!*  Maak je geen zorgen, je zult de betekenis van alles in het programma in de loop van de cursus ontdekken. Java heeft veel boilerplate code nodig om te beginnen. Lees steeds de relevante hoofdstukken van het boek en stel vragen tijdens het practicum.
```

### `HiFour.java`

Deze oefening demonstreert het gebruik van het `String` datatype en command-line argumenten. Schrijf een programma `HiFour.java` dat vier voornamen als command-line argumenten accepteert en een juiste zin afdrukt met de namen in omgekeerde volgorde.

Voorbeelden:

```console
> java HiFour.java Alice Bob Carol Dave
Hi Dave, Carol, Bob, and Alice.

> java HiFour.java Alejandro Bas Chantal Deshi
Hi Deshi, Chantal, Bas, and Alejandro.
```

```{attention}
Als ik `HiFour` uitvoer, zie ik de volgende boodschap:

> `Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 0`

Wat betekent dit? Ben je vergeten een command-line argument te typen toen je het programma uitvoerde?
```

### `Ordered.java`

Deze oefening demonstreert het gebruik van de gegevenstypen `int` en `boolean`. Schrijf een programma `Ordered.java` dat drie integer command-line argumenten accepteert, `x`, `y`, en `z`. _Definieer_ een `boolean` variabele waarvan de waarde `true` is als de drie waarden in strikt oplopende volgorde staan (x < y < z) of in strikt aflopende volgorde (x > y > z), en anders `false`. Druk vervolgens deze `boolean` waarde af. Je mag **geen** `if` statements gebruiken.

Voorbeelden:

```console
> java Ordered.java 10 17 49
true

> java Ordered.java 49 17 10
true

> java Ordered.java 10 49 17
false
```

```{info}
Hoe krijg ik Java zo ver dat het `true` of `false` afdrukt zonder een `if-else` statement? Als `b` een `boolean` variabele is, dan zal `System.out.println(b)` `true` of `false` afdrukken, afhankelijk van de waarde.
```

<!--
### `DeluxeOrdered.java`

Dit is een **optionele** opgave.

Dit programma, `DeluxeOrdered.java`, voert dezelfde operatie uit als `Ordered.java`. Het accepteert drie `int` command-line argumenten, `x`, `y`, en `z`, en drukt `true` af als de drie waarden ofwel in strikt oplopende volgorde staan (x < y < z) of in strikt aflopende volgorde (x > y > z) en `false` anders. De **uitdaging** is om `DeluxeOrdered.java` te implementeren **zonder** gebruik te maken van de vier vergelijkingsoperatoren `<`, `<=`, `>`, `>=` en `if` statements.

-->

### `GreatCircle.java`

Deze oefening demonstreert het gebruik van het gegevenstype `double` en Java's [Math](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/Math.html) bibliotheek. De afstand van de grote cirkel is de kortste afstand tussen twee punten op het oppervlak van een bol als je gedwongen bent om langs het oppervlak te reizen. Schrijf een programma `GreatCircle.java` dat vier dubbele command-line argumenten `x1`, `y1`, `x2`, en `y2` (de breedtegraad en lengtegraad, in graden, van twee punten op het aardoppervlak) accepteert en de grootcirkelafstand (in zeemijlen) tussen deze punten afdrukt. Gebruik de volgende formule, die is afgeleid van de sferische wet van cosinussen:

$$
distance = 60 \times \arccos{(\sin{x_1} \sin{x_2} + \cos{x_1} \cos{x_2} \cos{(y_1 - y_2}))}
$$

<!--
![](images/image1.png)
-->

Deze formule gebruikt *graden*, terwijl Java's trigonometrische functies *radialen* gebruiken. Gebruik `Math.toRadians()` en `Math.toDegrees()` om tussen de twee te converteren. Ter referentie, een zeemijl (ongeveer 1.151 gewone mijlen) is 1/60 van een graad van een boog langs een meridiaan van de Aarde, en dit is de reden voor de 60 in de formule.

Voorbeelden:

```console
> java GreatCircle.java 40.35 74.65 48.87 -2.33 // Princeton to Paris
3185.1779271158425 nautical miles

> java GreatCircle.java 48.87 -2.33 40.35 74.65 // Paris to Princeton
3185.1779271158425 nautical miles
```

```{attention}
Mijn uitvoer voor `GreatCircle` komt overeen met de voorbeelduitvoer in de opdrachtspecificatie, behalve in de allerlaatste twee cijfers. Waarom is er deze kleine discrepantie? Is mijn antwoord fout? Heb je vermenigvuldigd met 60 (om de cirkelboog om te zetten naar zeemijlen) voor of na het omzetten van de hoek van radialen naar graden? Computers werken met beperkte precisie, dus algebraïsch gelijkwaardige formules kunnen licht verschillende antwoorden opleveren.
```

### `RGBtoCMYK.java`

Deze oefening demonstreert het gebruik van type-omzettingen. Er worden verschillende formaten gebruikt om kleur weer te geven. Het primaire formaat voor LCD-schermen, digitale camera's en webpagina's - bekend als het *RGB-formaat* - specificeert bijvoorbeeld het niveau van rood (R), groen (G) en blauw (B) op een gehele schaal van 0 tot en met 255. Het primaire formaat voor het publiceren van boeken en tijdschriften - bekend als het CMYK formaat - specificeert het niveau van cyaan (C), magenta (M), geel (Y), en zwart (K) op een reële schaal van 0.0 tot en met 1.0.

Schrijf een programma `RGBtoCMYK.java` dat converteert van RGB formaat naar CMYK formaat. Je programma moet drie gehele command-line argumenten accepteren, rood, groen en blauw, de RGB waarden afdrukken, en vervolgens de equivalente CMYK waarden afdrukken met behulp van de volgende wiskundige formules.

Je mag in deze opdracht **geen** if-statements gebruiken, maar je mag aannemen dat de commandoregel-argumenten niet allemaal tegelijk nul zijn.

Onthoud dat `Math.max(x, y)` het maximum van `x` en `y` oplevert.

$$
white = \max{\left\{\frac{red}{255}, \frac{green}{255}, \frac{blue}{255}  \right\}}
$$

$$
cyan = \left( white - \frac{red}{255} \right) \div white
$$

$$
magenta = \left( white - \frac{green}{255} \right) \div white
$$

$$
yellow = \left( white - \frac{blue}{255} \right) \div white
$$

$$
black = 1 - white
$$

CMYK is een subtractieve kleurmenging, omdat de primaire kleuren van wit licht worden afgetrokken om de resulterende kleur te produceren: cyaan absorbeert rood, magenta absorbeert groen, en geel absorbeert blauw.

Voorbeelden:

```console
// indigo

> java RGBtoCMYK.java 75 0 130
red     = 75
green   = 0
blue    = 130
cyan    = 0.423076923076923
magenta = 1.0
yellow  = 0.0
black   = 0.4901960784313726

// orange

> java RGBtoCMYK.java 255 143 0
red     = 255
green   = 143
blue    = 0
cyan    = 0.0
magenta = 0.4392156862745098
yellow  = 1.0
black   = 0.0
```
<!--
### `DeluxeRGBtoCMYK.java`

Dit is een **optionele** opgave.

Dit programma, `DeluxeRGBtoCMYK.java`, voert dezelfde bewerking uit als `RGBtoCMYK.java`, het converteert RGB waarden naar CMYK waarden. De **uitdaging** is om `RGBtoCMYK.java` te implementeren **zonder** gebruik te maken van `Math.max`, `Math.min`, of `if` statements.
-->

## Hello World

Hier is [Hello World](http://helloworldcollection.de) in meer dan 200 verschillende  programmeertalen!

---

Copyright © 1999–2021, [Robert Sedgewick](http://www.cs.princeton.edu/~rs/) en [Kevin Wayne](http://www.cs.princeton.edu/~wayne).