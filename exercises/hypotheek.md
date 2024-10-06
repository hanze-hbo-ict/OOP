# Overervering

## Inleiding

Dit practicum is een inleiding in overerving. Overerving wil zeggen dat een klasse eigenschappen overneem van zijn ouder-klasse (*parent class*).

## Hypotheek

Een lening voor de financiering van een huis wordt in de volksmond ook wel een hypotheek genoemd.

Een hypotheek bestaat uit één of meerdere leningdelen.

Elk leningdeel heeft een bedrag, een rentepercentage en looptijd.

De looptijd wordt uitgedrukt in maanden en is standaard 360 maanden (30 jaar).

Het rentepercentage kan in werkelijkheid veranderen. Om het eenvoudig te houden, is het in deze opgave gedurende de looptijd een vast percentage.

Het bedrag kan gedurende de looptijd lager worden doordat er wordt afgelost. De verplichte maandelijkse aflossing is afhankelijk van het soort leningdeel. Daarnaast is het altijd mogelijk om extra af te lossen.

Hoewel er verschillende soorten leningdelen zijn, hebben ze altijd bovenstaande eigenschappen. De verschillen tussen soorten leningdelen heeft vooral te maken met hoe wordt bepaald welk bedrag maandelijks wordt afgelost. De meest eenvoudige soort is aflossingsvrij, waarbij er geen verplichte maandelijkse aflossing is.

Financieel adviseurs gebruiken software om inzichtelijk te maken wat de maandlasten van een hypotheek zijn. Met klassen voor een hypotheek en voor verschillende leningdelen kunnen veel verschillende hypotheken worden ondersteund.

## De klasse `Aflossingsvrij`

Onderstaande code bevat een klasse voor een aflossingsvrij leningdeel. Bestudeer de code om een goed beeld te krijgen van hoe deze werkt. De klasse is lang, maar de methodes zijn kort en eenvoudig.

```{code-block} java
public class Aflossingsvrij {

    private double bedrag; // oorspronkelijke bedrag
    private double resterendBedrag; // resterend bedrag
    private double rentePercentage; // Jaarlijks rentepercentage
    private int looptijd; // oorspronkelijke looptijd
    private int resterendeLooptijd; // resterende looptijd

    /**
     * Constructor
     * @param bedrag Bedrag van het leningdeel
     * @param rentePercentage Rentepercentage
     * @param looptijd Looptijd uitgedrukt in maanden
     */
    public Aflossingsvrij(double bedrag, double rentePercentage, int looptijd) {
        this.rentePercentage = rentePercentage;
        this.bedrag = bedrag;
        this.resterendBedrag = bedrag;
        this.looptijd = looptijd;
        this.resterendeLooptijd = looptijd;
    }

    /**
     * Constructor met standaard looptijd van 30 jaar
     * @param bedrag Bedrag van het leningdeel
     * @param rentePercentage Rentepercentage
     */
    public Aflossingsvrij(double bedrag, double rentePercentage) {
        this(bedrag, rentePercentage, 360); // standaard looptijd is 30 jaar
    }

    public double getRentePercentage() {
        return rentePercentage;
    }

    public double getBedrag() {
        return bedrag;
    }

    public double getResterendBedrag() {
        return resterendBedrag;
    }

    public int getLooptijd() {
        return looptijd;
    }

    public int getResterendeLooptijd() {
        return resterendeLooptijd;
    }

    /**
     * Af te lossen bedrag deze maand
     * @return bedrag aan aflossing deze maand
     */
    public double berekenMaandlastAflossing() {
        return 0; // geen standaard aflossing
    }

    /**
     * De te betalen rente deze maand
     * @return bedrag aan rente in de huidige termijn
     */
    public double berekenMaandlastRente() {
        return ( resterendBedrag / 100 * rentePercentage ) / 12;
    }

    /**
     * De totale maandlast bestaat uit maandelijkse rente en vaste maandelijkse aflossing
     * @return totale maandlast
     */
    public double berekenMaandlast() {
        return berekenMaandlastRente() + berekenMaandlastAflossing();
    }

    /**
     * Bedrag aflossen
     * Deze methode wordt gebruikt voor de verplichte maandelijkse aflossing
     * maar kan ook worden gebruikt voor extra aflossingen.
     * @param aflossing bedrag aan aflossing
     */
    public void aflossen(double aflossing) {
        resterendBedrag = resterendBedrag - aflossing;
        if (resterendBedrag < 0) {
            resterendBedrag = 0;
        }
    }

    /**
     * Naar volgende maand gaan
     */
    public void volgendeMaand() {
        if (resterendeLooptijd > 0) {
            // Aflossing verwerken
            aflossen( berekenMaandlastAflossing() );
            // Resterende looptijd verlagen
            resterendeLooptijd--;
        }
    }

    /**
     * Naar volgend jaar gaan
     * door middel van 12 keer naar volgende maand gaan
     */
    public void volgendJaar() {
        for(int t = 0; t < 12; t++) {
            volgendeMaand();
        }
    }

    /**
     * Retourneert true als hypotheek nog een resterende looptijd heeft (actief is).
     * @return true als hypotheek nog actief is
     */
    public boolean isActief() {
        return resterendeLooptijd > 0;
    }

}
```

Neem de klasse `Aflossingsvrij` over in je IntelliJ.

Maak een klasse `Main` met een main-methode met de volgende code om het leningdeel te testen:

```{code-block} java
Aflossingsvrij leningdeel = new Aflossingsvrij(150000, 4.5); // Leningdeel 150.000 euro 4,5%
while( leningdeel.isActief() ) {
    System.out.printf("%d maanden € %.2f [maandbedrag rente + aflossing : € %.2f + € %.2f = € %.2f]\n",
            leningdeel.getResterendeLooptijd(), leningdeel.getResterendBedrag(),
            leningdeel.berekenMaandlastRente(), leningdeel.berekenMaandlastAflossing(),
            leningdeel.berekenMaandlast()
    );
    leningdeel.volgendJaar();
}
System.out.printf("Einde looptijd: € %.2f\n", leningdeel.getResterendBedrag());

```

Verwachte uitvoer:<br>

```{code-block}shell
360 maanden € 150000,00 [maandbedrag rente + aflossing : € 562,50 + € 0,00 = € 562,50]
348 maanden € 150000,00 [maandbedrag rente + aflossing : € 562,50 + € 0,00 = € 562,50]
...
24 maanden € 150000,00 [maandbedrag rente + aflossing : € 562,50 + € 0,00 = € 562,50]
12 maanden € 150000,00 [maandbedrag rente + aflossing : € 562,50 + € 0,00 = € 562,50]
Einde looptijd: € 150000,00
```

## De klasse `Lineair`

Lineair aflossen wil zeggen dat elke maand hetzelfde bedrag wordt afgelost, zodat aan het einde van de looptijd het leningdeel volledig is afgellost. Kenmerkt van linair aflossen is dat de  maandelijkse lasten steeds iets lager worden, omdat de te betalen rente afneemt. Het af te lossen bedrag wordt berekend door het resterende bedrag te delen door de resterende looptijd.

Maak de klasse `Lineair` door een kopie te maken van klasse `Aflossingsvrij`. Alleen de methode `berekenMaandlastAflossing` moet aangepast worden, op basis van de bovenstaande beschrijving.Test de klasse met behulp van de main-methode.

Verwachte uitvoer:<br>

```{code-block}shell
360 maanden € 150000,00 [maandbedrag rente + aflossing : € 562,50 + € 416,67 = € 979,17]
348 maanden € 145000,00 [maandbedrag rente + aflossing : € 543,75 + € 416,67 = € 960,42]
...
24 maanden € 10000,00 [maandbedrag rente + aflossing : € 37,50 + € 416,67 = € 454,17]
12 maanden € 5000,00 [maandbedrag rente + aflossing : € 18,75 + € 416,67 = € 435,42]
Einde looptijd: € 0,00
```

## Problemen van twee soortgelijke klassen

De klassen `Aflossingsvrij` en `Lineair` zijn soortgelijke klassen. Beide representeren een leningdeel. De code komt grotendeels overeen, wat resulteert in duplicate code. Als de opzet van de ene klasse verandert, dient dit waarschijnlijk ook in de andere klasse te gebeuren. Dit probleem wordt groter naarmate er meerdere soorten leningdelen bijkomen.

Een ander probleem is gebruik van het datatype: Bij het wijzigen van `Aflossingsvrij` naar `Lineair` in `main` moesten zowel het *datatype* van de declaratie als het *object* bij keyword `new` aangepast worden. Dit maakt het gebruik van arrays of collecties voor het opslaan van een lijst verschillende leningdelen moeilijk. Het is wenselijk om een datatype te kunnen gebruiken voor een leningdeel, ongeacht het specifieke soort leningdeel (aflossingsvrij of lineair).

De oplossing voor dit probleem is overerving. Overervaring wordt gerealiseerd met het keyword `extends`:

```{code-block} java
public class Lineair extends Aflossingsvrij { 
     ...
}
```

In dit geval overerft de klasse `Lineair` de klasse `Aflossingsvrij`. De klasse `Lineair` is de *child class*. De klasse `Aflossingsvrij` is hier de *parent class*. In plaats van *parent class* en *child class* worden ook wel de begrippen *superklasse* en *subklasse* gebruikt.

Pas de klasse-definitie `Lineair` aan zodat deze `Aflossingsvrij` overerft. verwijder alle code in de klasse uit klasse `Lineair`.

Om het correct werkend te krijgen moeten twee aanpassingen worden gedaan:

1. De klasse `Lineair` heeft constructors nodig
2. De methode `berekenMaandlastAflossing` moet geïmplementeerd worden, zodat er daadwerkelijk sprake is van lineaire aflossing.

De constructors van `Lineair` zijn als volgt:

```{code-block} java
public Lineair(double bedrag, double rentePercentage, int looptijd) {
    super(bedrag, rentePercentage, looptijd);
}

public Lineair(double bedrag, double rentePercentage) {
    super(bedrag, rentePercentage);
}
```

Het enige wat deze constructors doen is de constructor van de parent class (of superklasse) aanroepen. Dit voorkomt dubbele code.

Alle publieke reguliere methodes van de *parent class* zijn ook beschikbaar in de *child class*.

De implementatie van `berekenMaandlastAflossing` is als volgt:

```{code-block} java

 /**
 * Af te lossen bedrag deze maand
 * @return bedrag aan aflossing deze maand
 */
@Override
public double berekenMaandlastAflossing() {
    return getResterendBedrag() / getResterendeLooptijd();
}

Mogelijk heb je in de vorige versie van `Lineair` de properties `resterendBedrag` en `resterendeLooptijd` rechtstreeks gebruikt. Dit is nu niet meer mogelijk, omdat deze properties `private` zijn.

Er zijn twee mogelijke oplossingen voor dit probleem. De hierboven gebruikte oplossing is het gebruik van beschikbare *getters*. Een alternatief is gebruik van access-modifier *protected*.

Test de nieuwe versie van `Lineair`.

## Problemen van incorrecte overerving

Ondanks dat het probleem van duplicate code is opgelost, is deze overerving niet geheel correct. Hoewel het technisch werkt, is het ontwerp slecht.

Overervaring creëert een "is-a"-relatie. Als klasse `Lineair` de klasse `Aflossingsvrij` overerft, dan is `Lineair` impliciet `Aflossingsvrij`.

Daardoor is de volgende code mogelijk:
```{code-block} java
Aflossingsvrij leningdeel = new Lineair(150000, 4.5);
```

Dit voorbeeld maakt zichtbaar dat het niet correct is. Immers, lineair aflossen is niet aflossingsvrij.

De relatie ligt anders: lineair en aflossingsvrij zijn beide een soort leningdeel. Om dit te implementeren moeten beide klassen de klasse *Leningdeel* overervaren.

Realiseer met door de volgende stappen:
1. Hernoem *Aflossingsvrij* naar *Leningdeel*
2. Maak een nieuwe klasse *Aflossingsvrij* die *Leningdeel* overerft. Voorzie deze klasse van de benodigde constructors.
3. Mogelijk overerft de klasse *Lineair* al *Leningdeel* doordat de editor dit automatisch voor je doet. Indien dit nog niet het geval is, voer deze wijziging dan zelf door.

Test de nieuwe klassen in main, waarbij de variabele *leningdeel* gedeclareerd kan worden met *Leningdeel*:
Daardoor is de volgende code mogelijk:
```{code-block} java
Leningdeel leningdeel = new Lineair(150000, 4.5);
```

## Ongewenste instantiëring

Soms is het niet wenselijk dat van een bepaalde klasse objecten worden gemaakt (ook instantiëring genoemd). Dit is vaak het geval bij een overkoepelende superklasse en is ook hier het geval.

Van *Leningdeel* kan een object worden gemaakt:
```{code-block} java
Leningdeel leningdeel = new Leningdeel(150000, 4.5);
```

Deze zal zich gedragen als aflossingsvrij, maar het schept verwarring. De klasse *Leningdeel* is bedoeld om gebruikt te worden als superklasse, niet als klasse om objecten van te maken.

Dit kan voorkomen worden met het keyword *abstract*:
```{code-block} java
public abstract class Leningdeel
```

In dat geval zal het instantiëren van *Leningdeel* niet meer mogelijk zijn, waardoor expliciet gekozen moet worden voor *Aflossingsvrij* of *Lineair*.

Een abstract klasse is een klasse die wel overerft kan worden, maar niet kan worden geïnstantiëerd.

## Abstracte methodes

Binnen een abstracte klasse, kunnen methoden *abstract* worden gemaakt met het keyword `abstract`. Daarmee wordt een methode gedefiniëerd maar niet geïmplementeerd.

Een methode waarbij dit wenselijk is, is de methode *berekenMaandlastAflossing*. Het meest onderscheidende kenmerk tussen verschillende soorten leningdelen is het bedrag wat maandelijks wordt afgelost en hoe dit bedrag tot stand komt. Daarom is het vreemd dat *Leningdeel* al een standaard implementatie bevat.

Het ligt meer voor de hand om implementaties uitsluitend in de subklassen te doen.

Controleer of de variabele *leningdeel* is gedeclareerd als type *Leningdeel*. Verwijder de methode *berekenMaandlastAflossing* uit de klasse *Leningdeel*. Wat gebeurt er?

De klasse *Leningdeel* moet een methode *berekenMaandlastAflossing* bevatten. Daarom geeft het verwijderen van de methode *berekenMaandlastAflossing* problemen. Maar implementatie van deze methode is niet wenselijk. Oplossing is het abstract maken van deze methode met keyword *abstract*:
```{code-block} java
abstract public double berekenMaandlastAflossing();
```

Voer deze wijziging door. Het is noodzakelijk om ook in de klasse *Aflossingsvrij* een implementatie te maken van *berekenMaandlastAflossing*.

## Annuïteiten

Annuïtair aflossen wil zeggen dat elke maand hetzelfde bedrag wordt betaald, zodanig aan het einde van de looptijd het leningdeel volledig is afgelost. Kenmerkt van linair aflossen is dat de (bruto) lasten maandelijks gelijk blijven. Elke maand wordt minder rente betaald en meer aflossing, maar het totaalbedrag is steeds hetzelfde.

Deze klasse is aanzienlijk lastiger dan de andere twee soorten leningdelen, omdat er een ingewikkelde formule is voor het berekenen van het te betalen bedrag.

Bij aflossingsvrij en lineair is het gemakkelijk om de maandelijkse aflossing te berekenen in de methode `berekenMaandlastAflossing`. Bij annuïtair is dit het vaste maandbedrag met aftrek van de die maand te betalen rente.

Dit wordt als volgt geïmplementeerd:
```{code-block} java
@Override
public double berekenMaandlastAflossing() {
    return berekenMaandlast() - berekenMaandlastRente();
}
```

Vervolgens dient in de methode *berekenMaandlast* het vaste maandelijkse bedrag worden berekend, door deze methode te `overriden` in *Annuitair*.

De formule voor een vast maandbedrag bij een annuïtaire lening is als volgt:

vast bedrag = ( r / ( 1 - ( (1 + r) ^ -aantaltermijnen ) ) ) x bedrag

r is fractie van het rentepercentage, percentage / 100. Om een vast maandbedrag te berekenen dient de rente gedeeld te worden door 12. Kortom, *r = (getRentePercentage() / 100) / 12*

Let op het negatieve exponent in de formule! Hint: Math.pow

Maak de klasse `Annuitair`.

Test klasse met behulp van de main-methode.

Verwachte uitvoer (obv. EUR 150.000 en 4,5%):
360 maanden € 150000,00 [maandbedrag rente + aflossing : € 562,50 + € 197,53 = € 760,03]
348 maanden € 147580,16 [maandbedrag rente + aflossing : € 553,43 + € 206,60 = € 760,03]
...
24 maanden € 17412,74 [maandbedrag rente + aflossing : € 65,30 + € 694,73 = € 760,03]
12 maanden € 8901,86 [maandbedrag rente + aflossing : € 33,38 + € 726,65 = € 760,03]
0 maanden € 0,00

## Volledige hypotheek

Doordat er verschillende soorten leningdelen beschikbaar zijn, kunnen hypotheken samengesteld worden. Een hypotheek bestaat uit 1 of meer leningdelen

Dit zou kunnen met een array of ArrayList, maar het is wenselijk om methoden beschikbaar te hebben om bijvoorbeeld het (totaal) resterende bedrag op te vragen of de totale maandlast. Dat kan eenvoudig gerealiseerd worden met een klasse *Hypotheek*

Voor een klasse Hypotheek zijn twee opties:


Optie 1:
```{code-block} java
public class Hypotheek1 extends ArrayList<Leningdeel> {
    
    // de rest

}
```

Optie 2:
```{code-block} java
public class Hypotheek {

    private ArrayList<Leningdeel> leningdelen;

    // de rest
}
```
Welke van de twee heeft de voorkeur? Probeer een onderbouwing te vinden waarom...

Optie 1 heeft betrekking op een *is-a*-relatie. Dat is problematisch, want een hypotheek is geen arraylist. Daarnaast is een ongewenst neveneffect dat *alle* publieke methodes die via ArrayList beschikbaar zijn ook beschikbaar worden via Hypotheek.

In optie 2 vindt geen overerving plaats (behalve van `Object`) maar is de lijst leningdelen een property van hypotheek. Dit wordt *compositie* genoemd en definieert een *has-a*-relatie. Dat is in dit geval passend.

Per situatie moet overwogen worden of er gebruik wordt gemaakt van *overerving* of *compositie*.

Dit is een eerste opzet van klasse `Hypotheek`:

```{code-block} java
public class Hypotheek {

    private ArrayList<Leningdeel> leningdelen;

    /**
     * Voegt leningdeel toe aan hypotheek
     * @param leningdeel Toe te voegen leningdeel
     */
    public void voegLeningdeelToe(Leningdeel leningdeel) {
        // Nog maken...
    }

    /**
     * Berekent het totaalbedrag van alle leningdelen
     * @return totaalbedrag van alle leningdelen
     */
    public double getBedrag() {
        double bedrag = 0;
        for(Leningdeel leningdeel : leningdelen) {
            bedrag = bedrag + leningdeel.getBedrag();
        }
        return bedrag;
    }

    /**
     * Berekent het totaal resterende bedrag van alle leningdelen
     * @return totaal resterende bedrag van alle leningdelen
     */
    public double getResterendBedrag() {
        return -1; // Nog maken...
    }

    /**
     * Berekent het totaal af te lossen bedrag deze maand van alle leningdelen
     * @return totaal af te lossen bedrag deze maand van alle leningdelen
     */
    public double berekenMaandlastAflossing() {
        return -1; // Nog maken...
    }

    /**
     * Berekent de totaal te betalen rente deze maand van alle leningdelen
     * @return totaal te betalen rente deze maand van alle leningdelen
     */
    public double berekenMaandlastRente() {
        return -1; // Nog maken...
    }

    /**
     * De totale maandlast bestaat uit maandelijkse rente en vaste maandelijkse aflossing
     * @return totale maandlast
     */
    public double berekenMaandlast() {
        return berekenMaandlastRente() + berekenMaandlastAflossing();
    }

    /**
     * Naar volgende maand gaan (dit doen voor alle leningdelen)
     */
    public void volgendeMaand() {
        // Nog maken
    }

    /**
     * Naar volgend jaar gaan
     * door middel van 12 keer naar volgende maand gaan
     */
    public void volgendJaar() {
        for(int t=0; t < 12; t++) {
            volgendeMaand();
        }
    }

    /**
     * Retourneert true als tenminste één leningdeel nog een resterende looptijd heeft (actief is).
     * @return true als hypotheek nog actief is
     */
    public boolean isActief() {
        // Let op! Hypotheken met leningdelen met verschillende looptijden zijn mogelijk.
        // Daaruit volgt dat er lopende hypotheken bestaan met leningdelen die niet meer actief zijn.
        // Retourneer true als tenminste één leningdeel actief is
        return false; // Nog maken
    }

}
```

Maak de klasse `Hypotheek` af.

Test deze met de onderstaande code in main, waar op de plaats van ... nog wat ingevuld moet worden..

```{code-block} java
/*
Hypotheek van EUR 291.000, looptijd 30 jaar, bestaande uit twee leningdelen
- Lineair EUR 224.000 5,2% rente
- Aflossingsvrij EUR 67.000 5.5% rente
*/
Leningdeel leningdeel1 = ...
Leningdeel leningdeel2 = ...
System.out.println(leningdeel1.getResterendBedrag());
System.out.println(leningdeel2.getResterendBedrag());

Hypotheek hypotheek = new Hypotheek();
System.out.println(hypotheek.getResterendBedrag());

hypotheek.voegLeningdeelToe(leningdeel1);
hypotheek.voegLeningdeelToe(leningdeel2);

int jaar=1;
while(hypotheek.isActief()) {
    System.out.printf("%de jaar: € %.2f [maandbedrag rente + aflossing : € %.2f + € %.2f = € %.2f]\n",
            jaar, hypotheek.getResterendBedrag(),
            hypotheek.berekenMaandlastRente(), hypotheek.berekenMaandlastAflossing(),
            hypotheek.berekenMaandlast()
    );
    hypotheek.volgendJaar();
    jaar++;
}
System.out.printf("Einde looptijd: %.2f\n", hypotheek.getResterendBedrag());

```

Het verwachte resultaat is:

```{code-block}shell
1e jaar: € 291000,00 [maandbedrag rente + aflossing : € 1277,75 + € 622,22 = € 1899,97]
2e jaar: € 283533,33 [maandbedrag rente + aflossing : € 1245,39 + € 622,22 = € 1867,62]
...
29e jaar: € 81933,33 [maandbedrag rente + aflossing : € 371,79 + € 622,22 = € 994,02]
30e jaar: € 74466,67 [maandbedrag rente + aflossing : € 339,44 + € 622,22 = € 961,66]
Einde looptijd: € 67000,00
```



