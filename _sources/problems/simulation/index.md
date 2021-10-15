---
source: https://people.cs.umass.edu/~liberato/courses/2021-spring-compsci186/assignments/12-war/
author: Marc Liberatore
year: 2021
---

# Simulaties

![Aces](images/aces.png)

## Doel:

-   Een programma schrijven om een kaartspel te simuleren.
-   Oefenen met het kiezen en gebruiken van relevante datastructuren.
-   Oefenen met het opdelen van programma in afzonderlijke methoden.
-   Oefenen met het schrijven van unittests.
-   Testen van code met behulp van unittests.

In deze opgaven ga je de volgende twee klassen uitbreiden:

-   `War.java`
-   `WarTest.java`

Het begin van deze twee klassen kan je vinden in het projectbestand <a href="../../projects/simulation.zip">simulation.zip</a>. Download dit bestand, pak het uit en importeer het in jouw IDE (het bevat een [Maven](https://maven.apache.org/) configuratiebestand).

## Achtergrond

In deze opgave ga je een versie schrijven van het kaartspel [oorlogje](https://nl.wikipedia.org/wiki/Oorlogje_(kaartspel)) (of "War", in het Engels) om de uitkomst van het spel te kunnen *simuleren*.

```{note}
In hoofdstukken 12 ([Arrays of Objects](https://books.trinket.io/thinkjava2/chapter12.html)) tot en met 14 ([Extending Classes](https://books.trinket.io/thinkjava2/chapter14.html)) worden kaartspellen als voorbeeld gebruikt en hoe deze objectgeoriënteerd kunnen worden vormgegeven.

Objectoriëntatie is een programmeerparadigma waar abstractie en modularisatie centraal staat en dit zie je uitgedrukt worden in klassen als `Card`, `Deck` en `Pile` die ieder een eigen verantwoordelijkheid hebben en in samenhang met elkaar werken. Het kunnen aanwijzen van klassen en deze uitwerken is niet altijd even eenvoudig, laat staan het bepalen hoe deze met elkaar interacteren.

Deze opgave reduceert deze complexiteit tot data, en handelingen op data. Lees de hoofdstukken uit het boek vooral door (en de bijbehorende oppgaven!), we hopen dat je met deze opgave een beter begrip krijgt van het vormgeven van data en handelingen op deze data en hoe je dit uiteindelijk objectgeoriënteerd kan uitwerken.
```

Het doel van deze opdracht is om met gebruik van bekende datastructuren als `ArrayList` data vorm te geven en te bepalen welke methoden noodzakelijke zijn om de spelregels van spel oorlogje uit te kunnen drukken.

## Inleiding

[Oorlogje](https://nl.wikipedia.org/wiki/Oorlogje_(kaartspel)) is een kaartspel voor twee spelers, dat gewoonlijk gespeeld wordt met een standaard spel speelkaarten van 52 kaarten. Het is ook een interessant probleem voor verschillende andere toepassingen, in deze opdracht ga je een simulatie implementeren van een versie van oorlogje gebaseerd op een tekstuele beschrijving van het spel.

Deze versie van oorlogje is *deterministisch*, dat wil zeggen dat er **geen** willekeur in het spel is. De winnaar kan volledig bepaald worden op basis van de startstapel. Simulaties zijn een manier om de uitkomsten van zowel *deterministische* als *niet-deterministische* situaties te vinden. Niet-deterministische simulaties worden meestal vele malen uitgevoerd, en de resultaten worden op een of andere manier samengevoegd (bijvoorbeeld om de meest waarschijnlijke uitkomst te vinden, of de mediane uitkomst, een gemiddelde, etc.).

In tegenstelling tot vorige opdrachten en oefeningen is deze keer *geen* volledige set van unittests in het project beschikbaar om te helpen met geautomatiseerd testen of bij het ontwerpproces. Je zult de regels van het spel uit de tekst die volgt moeten vertalen naar code, moeten beslissen of en hoe je het programma opdeelt in methodes, en je eigen tests moeten schrijven.

## Het spel

Het spel oorlogje wordt gespeeld door de stapel kaarten onder twee spelers te verdelen. Elke speler speelt een kaart en deze twee kaarten worden met elkaar vergeleken in een "gevecht". De kaart met de hoogste waarde (of rang, want de kleuren doen er niet toe) wint de strijd, en de speler van de winnende kaart neemt beide kaarten (de "oorlogsbuit") en legt ze onder aan zijn of haar stapel.

In geval van gelijke stand wordt de "oorlog" verklaard. Elke speler deelt nog drie kaarten uit als extra buit. Daarna speelt elke speler nog een kaart. De winnaar van deze strijd neemt alle 10 kaarten (of meer, in geval van herhaalde gelijke stand).

Herhaal dit proces totdat een speler geen kaarten meer heeft en tot verliezer wordt uitgeroepen.

## De spelregels

De kaarten worden voorgesteld als gehele getallen. In een klassiek spel oorlogje variëren de waarden van 2 tot 14, maar jouw implementatie gaat werken met het type `int` en een niet-negatief aantal kaarten.

### Het delen van de kaarten

De vorm van het initiële "kaartspel" is een `ArrayList<Integer>`, en deze collectie (of *stapel*) van kaarten moet worden uitgedeeld aan de twee spelers, A en B. Het uitdelen van de kaarten houdt in dat de kaarten afwisselend aan elke speler worden gegeven, dat wil zeggen, de eerste kaart aan speler A, de tweede aan speler B, de derde aan speler A, enzovoort. Elke speler legt in deze volgorde de kaarten op de eigen stapel.

```{figure} images/stack.png
:name: stack

De boven- en onderkant van een stapel kaarten
```

Bijvoorbeeld, als de beginstapel de waarden `[2, 3, 4, 5]` bevat en we delen alle kaarten uit, dan zou de stapel van speler A de waarden `[2, 4]` bevatten en die van speler B de waarden `[3, 5]`. De "bovenkant" van elk van deze stapels is de linkerkant, dat wil zeggen, de eerstvolgende kaart die speler A zal spelen is 2 (zie {numref}`stack`).

### Strijd

De spelers gaan vervolgens een reeks gevechten aan. Om een gevecht te beginnen, nemen ze elk de bovenste kaart van hun stapel en leggen ze die op een tijdelijke "aflegstapel", in de volgorde A's kaart en dan B's kaart. Als beide spelers geen kaarten op hun stapel hebben voordat ze een kaart op de aflegstapel leggen, is het gelijkspel (en is het spel afgelopen). Als slechts één van de spelers geen kaarten in zijn stapel heeft, dan verliest deze speler (en is het spel afgelopen).

Als de waarde van een kaart numeriek groter is dan die van de ander, dan wint de speler die deze kaart heeft uitgespeeld. De inhoud van de aflegstapel wordt toegevoegd, in volgorde, aan de onderkant van de stapel van de winnaar (en de aflegstapel wordt vervolgens leeggemaakt). Als er slechts twee kaarten zijn, komt de kaart van speler A altijd voor de kaart van speler B, ongeacht welke speler het gevecht heeft gewonnen.

Om het eerste gevecht te beginnen, zou speler A een 2 spelen en speler B een 3. Hun kaartenreeksen zouden dan respectievelijk uit `[4]` en `[5]` bestaan, tot het gevecht beslist is. Speler B wint dit gevecht, en zou dus de twee kaarten, in de aangegeven volgorde, aan zijn stapel toevoegen. Speler A's kaartspel is nog steeds `[4]`, en speler B's kaartspel is nu `[5, 2, 3]`. Ze spelen het volgende gevecht, B wint opnieuw, en A's kaartspel is nu leeg. Bij het begin van het volgende gevecht heeft A geen kaarten meer en is de verliezer van het spel.

### Oorlog

De "oorlog" wordt verklaard als de strijd gaat tussen twee kaarten met gelijke waarde. In dit geval moet speler A moet nog eens *drie* kaarten, in volgorde, op de aflegstapel leggen, en B doet hetzelfde. De spelers strijden dan opnieuw. Merk op dat voordat deze tweede slag begint de stapel nu *acht* kaarten bevat, de twee van de eerste slag en de zes van de oorlog. Als een speler deze tweede slag wint, verzamelt hij alle tien kaarten (de vorige acht, plus de twee van deze slag), in volgorde, onderop de eigen stapel.

Als er nog een oorlog komt, dan zullen er 16 kaarten op de stapel liggen voor de derde slag (de twee van de eerste slag, de zes van de eerste oorlog, de twee van de tweede slag en de zes van de tweede oorlog) en een totaal van 18 kaarten die aan de winnaar van de derde slag worden toegekend. De oorlogen gaan door totdat een speler een slag wint, of het spel eindigt omdat één of beide spelers geen kaarten meer hebben.

Net als tijdens een veldslag is het gelijkspel als beide spelers niet in staat zijn om de vereiste drie kaarten tijdens dezelfde oorlog af te leggen. Als slechts één speler er niet in slaagt om drie kaarten af te leggen tijdens een oorlog, verliest deze.

Bijvoorbeeld, stel dat speler A `[2, 8, 9, 10, 5, 4]` heeft en speler B `[2, 6, 7, 11, 6, 4]`.

Eerst zou elke speler de bovenste kaart spelen, die beide 2 zijn. Dus de stapel met buit zou `[2, 2]` bevatten en er zou een oorlog ontstaan. Speler A voegt de bovenste drie kaarten van de stapel toe aan de buit, en speler B doet hetzelfde. De stapel met buit bevat nu `[2, 2, 8, 9, 10, 6, 7, 11]`. De stapel van speler A bevat `[5, 4]` en die van speler B `[6, 4]`.

Tijd voor de volgende slag. Beide spelers nemen de bovenste kaart van hun stapel en voegen deze toe aan de stapel met buit, die nu `[2, 2, 8, 9, 10, 6, 7, 11, 5, 6]` bevat. Speler B wint deze slag (5 tegen 6), en voegt dus de hele stapel buit toe aan de eigen stapel. Speler A's stapel is nu maar `[4]`, en speler B's stapel is nu `[4, 2, 2, 8, 9, 10, 6, 7, 11, 5, 6]`.

De volgende slag veroorzaakt weer een oorlog, maar speler A zal zonder kaarten komen te zitten en dus verliezen.

Neem nu het voorbeeld van A's stapel met `[5, 2, 3]` en dat van B met `[5, 4]`. Ook al heeft A meer kaarten dan B, ze zullen allebei geen kaarten meer hebben tijdens de oorlog en het spel zal eindigen in een gelijkspel.

### Technisch gelijkspel

Het spel ga je in een simulatie spelen en (praktisch) zal je een grens moeten trekken voor gelijkspel: als na de 1000ste slag in een oorlogsspel geen van beide spelers heeft gewonnen, dan wordt het spel gelijkspel verklaard (want we hebben niet de hele dag de tijd!)

## Opgave

Implementeer de methode `findWinner` in `War.java` en voeg andere methoden toe waar nodig. Het is mogelijk om andere klassen toe te voegen aan de directory `src/main/java`, maar dat zal voor deze opgave *niet* nodig zijn.

Een voorbeeld van methoden die je kan implementeren zijn terugkerende handelingen voor stapels kaarten, bijvoorbeeld de kaart van de bovenkant van de stapel trekken en kaarten aan de onderkant toevoegen. Deze handelingen zouden goede kandidaten zijn voor op zichzelf staande methoden, bijvoorbeeld

```java
public int drawCard(ArrayList<Integer> stack)  // take and return from top

public void addCard(ArrayList<Integer> stack, int card)  // add to bottom
```

De parameter `stack` kan hier een stapel van een speler zijn waar je gebruik maakt van de *immutabiliteit* van een `ArrayList` object: het object zelf wijzigt niet maar de elementen daarvan kunnen wél worden aangepast.

Andere onderdelen waar je bij stil zal moeten staan zijn de velden van de klasse, oftwel de *data*, bijvoorbeeld de stapels kaarten van spelers A en B.

````{tip}
Je leest in de signatuur van de methode `findWinner` dat het een `int` als resultaat geeft. De *betekenis* van deze returnwaarde kan je lezen in de meegeleverde unittest `WarTest.java` waar je uit kan afleiden dat `0` staat voor gelijkspel, `1` dat speler A heeft gewonnen en `-1` dat speler B heeft gewonnen.

De waarden `1`, `0` en `-1` zijn een abstracte notaties van mogelijke eindsituaties, en zijn niet heel duidelijk voor ons (althans, de *intentie* is niet direct duidelijk). Je kan deze waarden zien als *constanten*, waarden die nadat ze zijn geinitialiseerd niet meer kunnen veranderen. Java kent hier het *keyword* `final` voor en je zou deze waarden als volgt als velden aan de klasse kunnen toevoegen

```java
private final int WIN_A = 1;
private final int DRAW = 0;
private final int WIN_B = -1;
```

Let op, de conventie is om waarden die een constante vertegenwoordigen met hoofletters te schrijven. Het gemak (en duidelijkheid!) is nu dat je in het geval dat bijvoorbeeld speler B wint met een *naam* het resultaat kan teruggeven (`return WIN_B`) in plaats van een *waarde* (`return -1`).
````

### Uitvoeren

Het zal je zijn opgevallen dat `findWinner` een *statische* methode is (net als de speciale methode `main`). Statische methoden zijn als functies, ze kunnen direct worden aangeroepen op de klasse zelf zonder dat daar een *instantie* van de klasse voor nodig is.

Je kan deze opdracht uitvoeren met alleen maar statische methoden, of je kan een `War` object maken en instantiëren en de methodes daarvan aanroepen. Met andere woorden, behandel `findWinner` zoals je de methode `main` in een programma zou behandelen. We raden deze laatste aanpak voor deze opgave aan en als je hier voor kiest zou de klasse en de methode `findWinner` er ongeveer als volgt uit kunnen zien:

```java
class War {
    private ArrayList<Integer> deck;

    public War(ArrayList<Integer> deck) {
        this.deck = deck;
    }

    public int simulateGame() {
        /// ...
    }

    public static int findWinner(ArrayList<Integer> deck) {
        War w = new War(deck);
        return w.simulateGame();
    }

    public static void main(String[] args) {
        // create a deck

        // print the result
    }
}
```

### Testen

Het is aan te raden om extra unittests te schrijven om je stapsgewijs te helpen  naar de juiste oplossing toe te werken. Hier zijn enkele eenvoudige gevallen die je kan overwegen, om je op weg te helpen zijn de eerste vier al opgenomen in de meegeleverde unittest .

-   Een leeg startspel.
-   Een kaartspel met één kaart.
-   Een kaartspel met twee kaarten, waarvan de eerste kaart meer waard is.
-   Een kaartspel met twee kaarten, tweede kaart met hogere waarde.
-   Een kaartspel met twee kaarten, gelijke waarde.
-   Startdecks die resulteren in de voorbeelden die in de opdrachtbeschrijving worden gegeven.
-   Een aangepaste versie van het bovenstaande waarbij de andere speler wint.
-   Een kaartspel dat resulteert in een technisch gelijkspel.
-   Een kaartspel dat resulteert in een gelijkspel tijdens een oorlog.
-   Een startspel dat resulteert in een opeenvolging van een gevecht, oorlog en gevecht met minstens drie oorlogen.
-   Een startspel dat resulteert in een oorlog waarbij speler A wint omdat speler B geen kaarten meer heeft tijdens de oorlog.
-   Een startspel dat resulteert in een oorlog waarbij speler B wint omdat speler A geen kaarten meer heeft tijdens de oorlog.

## Tot slot

De implemenatie van `War` kan in minder dan 100 regels geschreven worden, en zal voornamelijk bestaan uit `if` / `then` / `else` statements en `while` en `for` lussen. Deze zullen zijn verdeeld over een aantal methoden, samen met een klein aantal instantie variabelen om de huidige staat van het spel bij te houden.

Je hoeft *geen* recursie te gebruiken in deze opdracht, en verwacht dat je twee keer zoveel regels code zal schrijven voor de tests dan voor de implementatie van de klasse!
