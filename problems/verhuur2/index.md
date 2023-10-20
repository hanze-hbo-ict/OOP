# Verhuur

In deze opgave gaan we verder met de verhuur-opgave.

Het project <a href="../../projects/rentals_3.zip">rentals_3.zip</a> bevat de klass `Verhuur`. Verder zijn de klassen `Auto`, `Fiets` en `HuurVoertuig` nodig. Deze moet je zelf toevoegen van je uitwerking van deel 2.

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