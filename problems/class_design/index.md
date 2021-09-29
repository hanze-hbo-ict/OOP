---
source: https://www.cs.princeton.edu/courses/archive/spring14/cos233/assignments/rational/
---

# Class Design

Het doel van deze opdracht is om je weer op weg te helpen met het programmeren in Java en je eraan te herinneren hoe je nieuwe datatypes (klassen) kunt maken en gebruiken. In het bijzonder implementeert je een klasse met rationale getallen en een clientprogramma dat deze gebruikt om rationele benaderingen van $e$ te berekenen .

## Het ontwikkelen van een rationeel getal gegevenstype.

Rationale getallen zijn getallen die kunnen worden weergegeven als de verhouding van twee gehele getallen, dat wil zeggen, elk getal $p/q$ waarbij $p$ en $q$ gehele getallen zijn, is een rationaal getal. Java benadert niet-gehele rationale getallen met behulp van floats of doubles, maar deze typen bieden onnauwkeurige representaties. Voor deze opdracht representeer je rationale getallen met een nieuwe klasse `Rational`.

Deze klasse moet de volgende constructor hebben:

```java
public Rational (long numerator, long denominator)
```

en de volgende methoden:

```java
/**
 * Voeg het Rational object b toe aan het object
 * en geef een nieuwe Rational terug met de som.
 */
public Rational add(Rational b)

/**
 * Vermenigvuldig het Rational object b met het object
 * en geef een nieuwe Rational terug met het product.
 */
public Rational multiply(Rational b)

/**
 * Trek het Rational object b af van het object en geef
 * een nieuwe Rational terug met het verschil.
 */
public Rational subtract(Rational b)

/**
 * Deel het object door het Rational object b en geef
 * een nieuwe Rational terug met het resultaat.
 */
public Rational divide(Rational b)

/**
 * Geeft de reciproke van het rationale getal terug.
 */
public Rational reciprocal()

/**
 * Geeft -1 keer het opgeslagen rationale getal terug.
 */
public Rational negate()

/**
 * Geeft een string representatie terug van het rationale getal.
 * Als de noemer 1 is, druk dan alleen de teller af.
 */
public String toString()
```

Je kunt dit zien als de interface die je gaat gebruiken om te communiceren met jouw rationale getallen gegevenstype . Het doel is om de mogelijke waarden van variabelen met het type en de methoden die dergelijke variabelen manipuleren nauwkeurig te uit te schrijven. In dit geval zeggen we dat `Rational` getallen paren van `long` gehele getallen zijn, en dat we functies zullen hebben voor het *initialiseren* ervan, ze *afdrukken*, *optellen/vermenigvuldigen/aftrekken/delen* van twee en het resultaat in een derde plaatsen en het wederkerige van een van hen ontkennen/vinden en het resultaat in een nieuw Rational plaatsen .

Typisch gebruik van deze klasse zou ongeveer kunnen gaan als:

```java
Rational a = new Rational (2, 3);
Rational b = nuw Rational(-1, 3);
Rationele sum = a.add(b);
System.out.println(sum); // drukt 1/3 af
System.out.println(a.negate()); // afdrukken -2/3
```

Eerst moet u deze klasse implementeren in een Java-bestand met de naam Rational.java . Wees consistent in uw methoden en zorg ervoor dat ze de hierboven gedefinieerde interface volgen. Denk goed na over hoe u omgaat met negatieve getallen en nul. Merk op dat delen door nul zal resulteren in een compilerfout.

Terwijl u aan de code voor de klas werkt, maakt u een clientprogramma met de naam RationalClient.java . Als u niet begrijpt wat "cliënt" betekent, lees dan paragraaf 2.2 nog eens door . In de belangrijkste methode, de ontwikkeling van enkele eenvoudige voorbeelden om de functionaliteit van de testen Rational klasse.

Zodra u ervan overtuigd bent dat uw code correct is, schrijft u een methode, public Rational approx_e(int N) , in uw clientprogramma dat de Taylor- reeksuitbreiding gebruikt:


e = 1/0! + 1/1! + 1/2! +1/3! + 1/4! + 1/5! + . . .

om de eerste N-termen van de rationele benadering van e te berekenen . Als u problemen heeft met de faculteit, kunt u terugkijken op paragraaf 2.3 over recursie; het is oké om de code te gebruiken die je daar vindt. Druk de waarde af die u krijgt nadat elke term aan de benadering is toegevoegd. De uitvoer voor N = 6 moet zijn:
1/1 2/1 5/2 32/12 780/288 93888/34560.
Verbetering van de rationele Rationele klasse.   Er zijn verschillende problemen met onze implementatie van de rationale-getalklasse. Wat gebeurt er met de waarden als we een nauwkeurigere benadering van e proberen te berekenen , bijv. N rond 10? Het vreemde gedrag dat u waarneemt, is het gevolg van overloop . De compiler zal u niet vertellen wanneer de teller of noemer buiten het bereik van gehele getallen valt die lang kunnen worden opgeslagen, dus u moet altijd voorzichtig zijn bij het uitvoeren van numerieke berekeningen.

Er zijn een paar relatief eenvoudige wijzigingen die we kunnen aanbrengen in de klasse Rational om de overloop uit te stellen voor nog een aantal termen van de benadering. Merk eerst op dat onze rationale getallen niet altijd in hun eenvoudigste vorm worden opgeslagen. In de vierde term in het bovenstaande voorbeeld zijn zowel de teller als de noemer deelbaar door 4, dus we slaan het resultaat liever 8/3 op in plaats van 32/12.

U kunt dit probleem oplossen door de klasse Rational te wijzigen om alleen rationale getallen met teller en noemer relatief priem op te slaan en terug te geven. Voeg een methode toe die het algoritme van Euclides implementeert om de grootste gemene deler van twee getallen aan de klasse te berekenen, en gebruik deze om deze voorwaarde af te dwingen. Bedenk in welk type methode de grootste gemene delercode zou moeten zijn. U hoeft niet veel code in Rational.java te veranderen om dit te laten werken.

Nadat u de relevante methoden in Rational.java opnieuw hebt geïmplementeerd , berekent u de benadering van e opnieuw . Is de benadering verbeterd?

Onthoud dat de manier waarop de methoden van Rational worden geïmplementeerd niet uitmaakt voor programma's die de Rational- klasse gebruiken (dwz clientprogramma's), zolang de interface maar behouden blijft. Dit is een belangrijk voordeel van modulair en objectgeoriënteerd programmeren; clientcode is geïsoleerd van de details van de implementatie. U hoeft niets te veranderen in RationalClient.java .

Extra krediet. (Optioneel)   Zelfs als we de rationale getallen in gereduceerde vorm opslaan, kunnen de producten gevormd door de rationale rekenkundige functies overlopen. Dit leidt tot foutieve resultaten, zelfs als het resultaat kan worden weergegeven. Bijvoorbeeld, a/b × c/d is gelijk aan de verlaagde waarde van ac/bd , maar ofwel ac of bd kan overlopen voor de reductie, ook al vormt het gereduceerde antwoord geen probleem. (De naïeve methode voor het berekenen van 20/33 × 77/50 = 14/15 zou een variabele overlopen die slechts twee getallen kan opslaan.) Op dezelfde manier is a/b + c/d gelijk aan de gereduceerde waarde van (ad + bc )/bd , maar ofwel ad, bc , of bd kan voor de reductie overlopen, ook al vormt het gereduceerde antwoord geen probleem. 7/20 + 7/30 = 7/12 zou bijvoorbeeld tussenliggende waarden tot 600 opleveren.

Schrijf een klasse met de naam RationalBetter die de berekening van rationals mogelijk maakt die kunnen worden weergegeven, maar die tot overflow zouden leiden als de naïeve rekenkundige methoden worden gebruikt. Zorg ervoor dat u uw aanpak uitlegt in opmerkingen en de readme.txt . Hoewel het een goed idee is, mag u geen Java-bibliotheken zoals java.math.BigInteger gebruiken . Zelfs als u het niet helemaal kunt oplossen, dient u eventuele verbeteringen die u aanbrengt in.

Leveringen.   Rational.java , RationalClient.java en optioneel RationalBetter.java samen met het bestand readme.txt .

Zorg ervoor dat u de vragen in het readme.txt- bestand zorgvuldig beantwoordt, aangezien uw antwoorden worden beoordeeld. [Link naar readme.txt-sjabloon]

Vergeet niet uw code te becommentariëren. Geen opmerkingen = Punten af.

```java
// COS126 book solution

public class Euclid {

    // recursive implementation
    public static int gcd(int p, int q) {
        if (q == 0) return p;
        else return gcd(q, p % q);
    }

    // non-recursive implementation
    public static int gcd2(int p, int q) {
        while (q != 0) {
            int temp = q;
            q = p % q;
            p = temp;
        }
        return p;
    }

    public static void main(String[] args) {
        int p = Integer.parseInt(args[0]);
        int q = Integer.parseInt(args[1]);
        int d  = gcd(p, q);
        int d2 = gcd2(p, q);
        StdOut.println("gcd(" + p + ", " + q + ") = " + d);
        StdOut.println("gcd(" + p + ", " + q + ") = " + d2);
    }
}
```

---
Copyright © 2014 Tony Capra, R. Sedgewick, A. LaPaugh, and S. Arora.