---
source: https://walker.cs.grinnell.edu/courses/207.fa18/labs/lab-library-books.shtml
author:  Henry M. Walker <walker@cs.grinnell.edu>
---

# Bibliotheek

![Trinity College Library](images/trinity-college-library.png)

## Doel

Oefenen met:

-   overerving
-   abstracte klassen
-   interfaces

## Inleiding

In deze opgave ga je een klassenhiërarchie uitwerken die boeken in een bibliotheek representeert. Zie {numref}`book_uml` voor een schematische weergave van de relevante klassen.

```{figure} images/diagram.png
:name: book_uml

Klassendiagram bibliotheekboeken
```

De klasse `Book` modelleert informatie die gemeenschappelijk is voor alle boeken.

De klasse `LibraryBook` is een `Book`, maar bibliotheekboeken hebben ook een nummercode ("call number"), en het nummercode maakt het mogelijk om boeken te ordenen op de planken. De ordening gaat mogelijk worden gemaakt door een methode `compareTo` die is gespecificeerd in de `java.lang.Comparable` interface.

Bovendien, omdat veel bibliotheekboeken kunnen circuleren (worden uitgeleend en teruggebracht), heeft elk bibliotheekboek een uitleenstatus (bijvoorbeeld op de plank, uitgeleend, permanent in de collectie).

Een `ReferenceBook` is een type bibliotheekboek (een naslagwerk) dat is ondergebracht in een specifieke collectie (bijvoorbeeld in een mediatheek), en deze boeken woren *niet* uitgeleend.

Een `CirculatingBook` staat op de planken tot het wordt uitgeleend, en het boek wordt weer op de planken geplaatst als het wordt teruggebracht.

## De klasse `Book` en subklassen

Schema {numref}`book_uml` geeft naast de klassen ook beknopt weer welke velden en methoden moeten worden geimplementeerd. Een meer gedetailleerde beschrijving van deze klassen volgt.

### De klasse `Book`

De klasse `Book` modelleert informatie die alle boeken gemeen hebben. Elk boek heeft

-   Velden
    -   een auteur
    -   een titel
    -   een ISBN- of internationaal standaardboeknummer met een uniek nummer dat wordt gebruikt door uitgevers en boekhandels.
-   Constructors en methoden
    -   een constructor zonder parameters voor het zetten van *default* waarden
    -   een constructor die 3 parameters gebruikt voor een auteur, titel en ISBN-nummer
    -   *getters* en *setters*
    -   `toString` moet een reeks veldgegevens bevatten in een indeling die geschikt is om af te drukken

Binnen de klasse `Book` en de bijbehorende subklassen kunnen deze velden direct worden gebruikt, maar gebruik door andere klassen en objecten moet worden gedaan via getters en setters.

### De klasse `LibraryBook`

De klasse `LibraryBook` modelleert informatie die gebruikelijk is voor *bibliotheekboeken*. Naast auteur, titel en ISBN hebben bibliotheekboeken nummercodes, en bibliotheekboeken worden op volgorde van nummercode in de rekken opgeslagen. Bovendien kunnen veel bibliotheekboeken uitgeleend worden (circuleren). Naast velden en methoden van boeken, heeft elk bibliotheekboek

-   Velden
    -   nummercode
-   Constructors en methoden
    -   een constructor met 4 parameters voor een auteur, titel, ISBN-nummer en nummercode
    -   getters en setters
    -   `checkout` verwerkt het uitchecken van een boek door een klant ("patron"). Een vervaldatum wordt ook geregistreerd.
    -   `returned` zorgt voor de verwerking wanneer een boek wordt teruggegeven nadat het is uitgelend.
    -   `circulationStatus` geeft aan of het boek op de planken staat, gecontroleerd is, of niet in omloop is in de naslagwerkcollectie.
    -   `compareTo` maakt vergelijking/ordening van bibliotheekboeken mogelijk, volgens het formaat van de `Comparable` interface
    -   `toString` van `Book` wordt aangevuld met een circulatiestatus en nummercode

Aangezien `checkout`, `returned` en `circulationStatus` afhankelijk zijn van subklassen (d.w.z. of het boek in omloop is of zich in de naslagwerkenverzameling bevindt), zijn deze methoden *abstract*: ze zijn  gedefinieerd maar niet geïmplementeerd.

Hoewel bibliotheekboeken kunnen worden gerangschikt op nummercode, zijn deze nummercode's niet aanwezig in `Book`. Dus, `LibraryBook` kan de `Comparable` interface implementeren, maar `Book` niet.

Omdat sommige methoden wel gedefinieerd maar niet geïmplementeerd zijn, is `LibraryBook` een *abstracte* klasse.

### De klasse `ReferenceBook`

De klasse `ReferenceBook` modelleert een naslagwerk. Naslagwerken zijn ondergebracht in een specifieke collectie en naslagwerken circuleren niet (worden niet uitgeleend).

Naast velden en methoden van bibliotheekboeken, heeft een naslagwerk

-   Velden
    -   collectie
-   Constructors en methoden
    -   een constructor die 5 parameters gebruikt voor een auteur, titel, ISBN-nummer, nummercode en collectie
    -   getters en setters
    -   uitlenen is niet toegestaan voor naslagwerken, dus zal de methode "naslagwerk kan niet worden uitgeleend" moeten afdrukken
    -   teruggave van naslagwerken is niet mogelijk dus zal het "naslagwerk kan niet worden uitgeleend, teruggave onmogelijk" moeten afdrukken
    -   `circulationStatus` moet "niet-uitleenbaar naslagwerk" teruggeven.
    -   `toString` van `LibraryBook` moet worden aangevuld met de collectie-informatie

Met de methoden `checkout`, `returned` en `circulationStatus` geïmplementeerd voor `LibraryBook` is dit nu een volledig geïmplementeerde klasse.

### De klasse `CirculatingBook`

De klasse `CirculatingBook` modelleert boeken die kunnen worden uitgeeend. Wanneer een boek wordt uitgeleend wordt informatie opgeslagen over de klant die het boek heeft geleend en wanneer het moet worden teruggebracht. Naast de velden en methodes van bibliotheekboeken, heeft een `CirculatingBook`

-   Velden
    -   `currentHolder` (de eventuele persoon die het boek heeft uitgeleend)
    -   `dueDate` (wanneer het boek moet worden teruggebracht)
-   Constructors en methoden
    -   een constructor met 4 parameters voor een auteur, titel, ISBN-nummer en nummercode. Bij aanroep moeten `currentHolder` en `dueDate` op `null` worden gezet.
    -   getters en setters
    -   `checkout` verwerkt wanneer een boek wordt uitgeleend, waarbij de naam van de klant wordt opgeslagen en de datum waarop het boek moet worden teruggegeven.
    -   `returned` verwerkt wanneer een boek wordt teruggebracht (`currentHolder` en `dueDate` worden op `null` gezet).
    -   `circulationStatus` moet de naam van `currentHolder` en `dueDate` teruggeven, als het boek is uitgeleend, of "boek beschikbaar op de planken" als het boek beschikbaar is.
    -   `toString` van `LibraryBook` moet worden aangevuld met de huidige houder en de vervaldatum, indien van toepassing.

### De interface `Comparable`

Veel Java-klassen verwachten een imlementatie van de `Comparable` interface. De klasse `Collections` bevat bijvoorbeeld methoden voor het sorteren en doorzoeken van een `ArrayList` met `Comparable` elementen. Door een `compareTo`-methode te definiëren kunnen toepassingen van de klasse `LibraryBook` dus veel extra bewerkingen gebruiken zonder veel extra werk!

```{tip}
De klasse `String` implementeert ook de interface `Comparable`, bedenk hoe je dit gegeven kan gebruiken in jouw oplossing!
```

## Opgave

Download het projectbestand <a href="../../projects/library.zip">library.zip</a> en pak het uit. Implementeer in dit project de klassen zoals hierboven zijn beschreven, gebruik ook het schema in {numref}`book_uml` als hulpmiddel.

-   de klasse `Book`
-   de abstracte klasse `LibraryBook`, inclusief
    -   `String` veld `callNumber` (nummercode)
    -   getters en setters
    -   abstracte methoden met de volgende signatuur:

        ```java
        abstract String circulationStatus();
        abstract void checkout(String patron, String dueDate);
        abstract void returned();
        ```

    -   geïmplementeerde constructor

        ```java
        LibraryBook(String author, String title, String isbn, String callNum)
        ```

    -   geïmplementeerde methoden

        ```java
        /**
        * Implementation of Comparable's compareTo method
        *
        * @param lib:  Library object being compared
        * @return 0 if call numbers of this and that match
        *         < 0 if call number of this comes before call number of lib
        *         > 0 otherwise
        */
        public int compareTo(LibraryBook that)

        /**
        * @return title, author, ISBN, call number as a String for printing
        */
        public String toString()
        ```

        Merk op dat `toString` de abstracte methode `circulationStatus` kan aanroepen, hoewel de details van `circulationStatus` zullen worden geïmplementeerd in subklassen.

-   de klasse `ReferenceBook`
-   de klasse `CirculatingBook`

### Testen

De klasse `Library` is gegeven, je kan deze klasse gebruiken voor het schrijven van tests en voor het controleren of je de interface `Comparable` correct hebt geïmplementeerd. Zie figuur {numref}`lib_uml` voor een schematische weergave van deze klasse.

```{figure} images/library.png
:name: lib_uml

De klasse `Library`
```

Het is aan te raden verdere testcases te schrijven voor belangrijke methoden, bijvoorbeeld om de correcte werking van de methoden `checkout`, `returned` en `circulationStatus` te controleren.
