# Verhuur

![Dutch bike symbol](images/dutch_bike_symbol.png)

In opdracht van een verhuurder van auto’s en fietsen wordt een systeem ontwikkeld om bij te houden welke auto’s en fietsen de verhuurder in zijn bezit heeft.

## Deel 1

Gegevens van fietsen en auto’s worden opgeslagen in de klassen `Fiets` en `Auto`. Deze klassen zijn gegeven in project <a href="../../projects/rentals_1.zip">rentals_1.zip</a>.

a. Zowel auto als fiets hebben velden `merk` en `type`.
Deze velden vormen samen, met een spatie er tussen, de beschrijving. Bijvoorbeeld een auto van het merk Toyota en type Yaris heeft als omschrijving "Toyota Yaris".

Schrijf een *public* methode `getBeschrijving()`, die een string teruggeeft met merk en type, gescheiden door een spatie.

b. Zowel auto als fiets hebben de *public* methode `printInfo()`. Deze methode print één regel met informatie over de auto of fiets. Er wordt niets teruggegeven.
Voor fietsen:

```text
<merk> <type>, <frame>, <aantal versnellingen> versnellingen
```
frame: damesfiets of herenfiets.

Voorbeeld: De Batavus Winner N3 herenfiets met 3 versnellingen geeft als info-regel

```text
Batavus Winner N3, herenfiets, 3 versnellingen.
```
Voor auto's:

```text
<merk> <type> <kenteken>, <brandstoftype>, <aantal inzittenden> personen
```

brandstoftype: benzine, diesel, elektrisch

Voorbeeld: De Toyota Aygo benzineauto met kenteken 37LHG3, met 4 zitplaatsen, geeft als info-regel:

```text
Toyota Aygo 37LHG3, benzine, 4 personen
```

Schrijf de methode `printInfo()`.

c. Auto’s en fietsen moeten in één lijst (bijvoorbeeld `ArrayList`) gezet kunnen worden. Dit kan gerealiseerd worden door een klasse `HuurVoertuig` te maken, die *parentclass* wordt van de klassen `Fiets` en `Auto`.

Maak de klasse `HuurVoertuig`. Maak deze parentclass van `Fiets` en `Auto`.

Zet in klasse `HuurVoertuig` de voor fietsen en auto’s gemeenschappelijke velden merk, type en huurprijs. Verplaats de bijbehorende getters ook naar klasse `HuurVoertuig`.

Zorg ervoor dat vanuit de constructor van `Fiets` en `Auto` de velden `merk`, `type` en `huurprijs` een waarde krijgen. Ook in klasse `HuurVoertuig`  zijn deze velden `private`. Setters gebruiken is niet wenselijk. Maak daarom gebruik van een constructor in klasse `HuurVoertuig`.

## Deel 2

Het project <a href="../../projects/rentals_2.zip">rentals_2.zip</a> bevat de klasse `Verhuur`. Verder zijn de klassen `Auto`, `Fiets` en `HuurVoertuig` nodig. Deze moet je zelf toevoegen van jouw uitwerking van deel 1.

De klasse `Verhuur` is het begin van administratie van verhuurvoertuigen. Deze klasse is deels gerealiseerd.

a. In week 1 is de *public* methode `printInfo()` gerealiseerd. Deze methode print één regel met informatie over de auto of fiets. Er wordt niets teruggegeven.
Het is echter niet praktisch om `System.out.println()` te gebruiken in klassen die niet bedoeld zijn voor gebruikersinteractie.
Zorg ervoor dat het printen van objecten van `Auto` of `Fiets` exact hetzelfde resultaat oplevert als de aanroep van `printInfo()`. Dit doe je door de methode `toString()` te overriden. De methode `printInfo()` kan vervolgens verwijderd worden.

Gewenste resultaat:
Voor fietsen:

```text
<merk> <type>, <frame>, <aantal versnellingen> versnellingen
```

frame: damesfiets of herenfiets.

De Batavus Winner N3 herenfiets met 3 versnellingen geeft als info-regel

```text
Batavus Winner N3, herenfiets, 3 versnellingen
```

Voor auto's:

```text
<merk> <type> <kenteken>, <brandstoftype>, <aantal inzittenden> personen
```

brandstoftype: benzine, diesel, elektrisch

De Toyota Aygo benzineauto met kenteken 37LHG3, met 4 zitplaatsen, geeft als info-regel

```text
Toyota Aygo 37LHG3, benzine, 4 personen
```

b. De methoden `getAutos()` van klasse `Verhuur` geeft van de voertuigen een lijst terug met alleen de auto’s. Schrijf de implementatie van deze methode.

Doe hetzelfde voor `getFietsen()`, die een lijst teruggeeft met alleen de fietsen.

c. De methode `voegHuurvoertuigToe()` in klasse `Verhuur` controleert of het toe te voegen voertuig al voorkomt in de administratie. Dit gebeurt met `hashCode()` en `equals()`.

Deze controle functioneert niet als `hashCode()` en `equals()` niet in `Auto` en `Fiets` geïmplementeerd zijn. Override deze twee methodes in de klassen `Auto` en `Fiets`.

Voor de methode `hashCode()` kun je volstaan met het teruggeven van de waarde 1 (`return 1`). Dit zorgt ervoor dat equals elke keer wordt aangeroepen ter controle. Dit is niet optimaal maar voor deze opgave voldoende. Eventueel kun je met opgave e) als extra uitdaging de methode `hashCode()` optimaliseren.

De methode `equals()` moet alle velden controleren. Hoewel in werkelijkheid verschillende auto’s niet hetzelfde kenteken kunnen hebben, moet dit in deze opgave genegeerd worden. Controleer simpelweg of alle velden overeenkomen. Vergeet de algemene velden in klasse `HuurVoertuig` niet. Probeer op slimme manier gebruik te maken van overerving.

Algemene stappen in implementatie van `equals`:

1. Check of argument gelijk is aan `this` (met `==`). Zo ja, return `true` (er is dan sprake van hetzelfde object)
2. Check of argument instantie is van klasse. Zo nee, return `false`.
3. Cast argument naar klasse
4. Vergelijk alle relevante velden. Return `true` als ze allemaal gelijk zijn.

Je hoeft geen rekening te houden met `null` waarden.

d. [extra uitdaging]

De methode `meestVoorkomendeAutomerk()` in klasse `Verhuur` geeft het automerk terug die het meest voorkomt in de administratie. Alleen het merk, niet het type. Implementeer deze methode.

e. [extra uitdaging]

De methode `hashCode()` voor alle objecten dezelfde waarde terug laten geven, is niet optimaal. Dit is met kleine aantallen objecten niet merkbaar, maar bij grote aantallen wel. Daarom bevat Main een test die 20 miljoen auto’s en 20 miljoen fietsen genereert en toevoegt aan een `HashSet`. `HashSet` voegt klassen die identiek zijn niet toe, en maakt daarbij gebruik van `hashCode()` en `equals()`.

Met een niet-optimale methode `hashCode()` zal deze test ongeveer 10 seconden duren. Als een erg snelle computer wordt gebruikt, kan het zijn dat de test veel korter duurt. Verhoog in dat geval het aantal gegenereerde objecten in de loop naar bijvoorbeeld 40 miljoen.

Bestudeer onderstaand artikel en optimaliseer de methode `hashCode()`.
Als `hashCode()` geoptimaliseerd is, zal de tijdsduur van de test aanzienlijk afnemen. Baseer de hashcode op de integer-velden van `Fiets` en `Auto`. Probeer een zo groot mogelijke verbetering in prestatie te realiseren.

Artikel [Guide to hashCode() in Java](https://www.baeldung.com/java-hashcode).

<!--
## Deel 3

Deze opdracht is een vervolg van week 2. Daarom kan deze opdracht pas gedaan worden als je voor week 1 een voldoende score hebt behaald.

Het project <a href="../../projects/rentals_3.zip">rentals_3.zip</a> bevat de klassw `Verhuur`. Verder zijn de klassen `Auto`, `Fiets` en `HuurVoertuig` nodig. Deze moet je zelf toevoegen van jouw uitwerking van deel 2.

In deel 1 heb je ook met een klasse `Verhuur` gewerkt. Gebruik voor deze opgave de meegeleverde klasse `Verhuur`.

De klasse Main bevat code om de klassen te testen, voor elke opgaven. Deze is voor eigen gebruik, voor CodeGrade lever je de klassen Fiets, Auto, Voertuig, HuurVoertuig, HuurFiets, HuurAuto en Verhuur in. Eventueel ook VoertuigSorterBeschrijving in het geval opgave d ingeleverd wordt.


a. Om de klassen van voertuigen flexibeler te maken, kan gewerkt worden met algemene voertuig-klassen die geen code voor verhuur bevatten. Een interface kan gebruikt worden om huurvoertuig-klassen te maken.
Maak de klassen `Fiets` en `Auto` algemeen, zonder code voor huurvoertuigen.
Hiervoor moeten de volgende stappen worden uitgevoerd:

1. Hernoem de klasse `HuurVoertuig` naar `Voertuig`.
2. Geef de klassen `Auto` en `Fiets` als parent class `Voertuig` in plaats van `HuurVoertuig`.
2. Maak de klasse `Voertuig` *abstract*.
3. Vervang het veld `huurprijs` door een veld met naam `aanschafprijs`. Omdat aanschafprijzen grotere bedragen zijn, is een `float` niet nodig en wordt het datatype `int` gebruikt. Vergeet de getter niet aan tepassen.

b. Maak klassen voor huurvoertuigen door het generieke voertuig als parent class te gebruiken en een *interface* `HuurVoertuig` te implementeren.
Hiervoor moeten de volgende stappen worden uitgevoerd:
1. Maak een interface `HuurVoertuig` met één abstracte methode: `float berekenHuurprijs()`
2. Maak een klasse `HuurAuto`, die de interface `HuurVoertuig` implementeert, en met parentclass `Auto`.
Doe hetzelfde met `HuurFiets`, met parentclass `Fiets`.

De methode `berekenHuurprijs()` geeft de huurprijs terug, die als volgt wordt berekend:

Auto: aanschafprijs / 700 + 15.
Fiets: aanschafprijs / 180 + 5.

c. De klasse `Verhuur` heeft een methode `voegHuurvoertuigToe` om een voertuig toe te voegen. Het gebruikte argument is `Voertuig`. Daardoor kunnen er zowel reguliere voortuigen (`Auto`/`Fiets`) als huurvoertuigen (`HuurAuto`/`HuurFiets`) worden meegegeven. De methode bevat al een controle op identieke voortuigen, waardoor geen voertuigen dubbel worden toegevoegd. Breid de controle uit met een controle die er voor zorgt dat er alleen huurvoertuigen (objecten van een klasse die de interface `HuurVoertuig` implementeren) worden toegevoegd. Geef `false` terug als het niet om een huurvoertuig gaat.

d. De methode `sorterenAanschafprijs()` van `Verhuur` zorgt ervoor dat de lijst huurvoertuigen gesorteerd wordt op aanschafprijs (van laag naar hoog).
De implementatie van deze methode is al aanwezig. Uncomment de regel code om de methode te kunnen gebruiken.
Het sorteren van klassen met de methode `Collections.sort()`, die wordt aangeroepen vanuit `sorterenAanschafprijs()`, is mogelijk als de klassen in de lijst de interface `Comparable` implementeren.
Laat de klasse `Voertuig` de interface `Comparable<Voertuig>` implementeren (het stuk met de `<` en `>` hoort er ook bij).
Deze interface vereist dat de methode `public int compareTo(Voertuig voertuig)` geïmplementeerd wordt. Deze methode vergelijkt twee objecten met elkaar. Door een bepaalde waarde terug te geven, wordt aangegeven op welke volgorde de objecten in de sortering moeten komen. Afhankelijk daarvan bepaalt `Collections.sort()` de volgorde.
De exacte waarde is niet van belang. Het gaat om het positief of negatief zijn van de waarde. Bij een positieve waarde is het object ‘groter’ dan het object waarmee vergeleken wordt. Bij een negatieve waarde is het andersom.

e. [extra uitdaging]
De methode `sorterenBeschrijving()` sorteert de voertuigen op beschrijving, methode `getBeschrijving()`. Echter, voertuigen met dezelfde beschrijving (merk+type identiek) worden onderling gesorteerd op aanschafprijs.
Met behulp van de interface `Comparable` kan maar één sortering geïmplementeerd worden. Dit is al gebeurd in opgave d.
Er is echter nog een andere methode om te sorteren, die meer flexibiliteit biedt: De sort-methode van `ArrayList`. Deze methode krijgt als argument een instantie van een klasse die de interface `Comparator` implementeert.
Ook `Comparator` heeft één methode: `compare`, die een integer teruggeeft. Deze return-waarde werkt op dezelfde manier als bij `compareTo` van `Comparable` (zie vorige opgave).
De implementatie van deze methode is al aanwezig. Uncomment de regels code om de methode te kunnen gebruiken.
Maak de klasse `VoertuigSorterBeschrijving`, die nodig is voor het sorteren. De klasse moet de interface `Comparator<Voertuig>` implementeren en de methode `public int compare(Voertuig t1, Voertuig t2)`.

f. [extra uitdaging]
De methode `sorterenBeschrijvingFietsAuto()` sorteert de voertuigen opdezelfde manier als de methode `sorterenBeschrijving()`, met als verschil dat in de resultaten éérst de fietsen worden gesorteerd, en dan de auto’s. De volgorde is: alle fietsen gesorteerd op beschrijving (en prijs bij dezelfde beschrijving), en vervolgens alle auto’s gesorteerd op beschrijving (en prijs bij dezelfde beschrijving).
Implementeer `sorterenBeschrijvingFietsAuto()`. Maak gebruik van een innerclass (zie pagina 512 boek Programmeren in Java met BlueJ) of anonieme klasse.
Tip: Door slim gebruik te maken van overerving van de klasse VoertuigSorterBeschrijving kan de hoeveelheid code tot een minimum beperkt worden.
-->