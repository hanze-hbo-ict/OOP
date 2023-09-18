---
bron: http://nifty.stanford.edu/2020/dna/
data: https://cs50.harvard.edu/x/2021/psets/6/dna/
---

# Strings en lussen

![DNA](images/dna_forensics.png)

## Doel

-   Oefenen met het schrijven van lussen
-   Oefenen met strings
-   Verder gebruik van arrays

Download en pak het projectbestand <a href="../../projects/profiler.zip">profiler.zip</a> uit. Dit bestand bevat een klasse `Profile.java` die je verder zal gaan uitwerken en databestanden om jouw oplossing te testen.

## Inleiding

DNA, de drager van genetische informatie in levende wezens, wordt al tientallen jaren gebruikt in het strafrecht. Maar hoe werkt het opstellen van DNA-profielen precies? Hoe kunnen forensische onderzoekers aan de hand van een DNA-reeks vaststellen van wie het DNA is?

DNA is eigenlijk gewoon een opeenvolging van moleculen, nucleotiden genaamd, die in een bepaalde vorm zijn gerangschikt (een dubbele helix). Elke nucleotide van DNA bevat een van de vier basen: adenine (A), cytosine (C), guanine (G), of thymine (T).

Elke menselijke cel bevat miljarden van deze nucleotiden, gerangschikt in volgorde. Sommige delen van deze sequentie (d.w.z. het genoom) zijn hetzelfde, of lijken tenminste sterk op elkaar, bij bijna alle mensen, maar andere delen van de sequentie vertonen een grotere genetische diversiteit en variëren dus meer binnen de bevolking.

Eén plaats waar DNA de neiging heeft een hoge genetische diversiteit te hebben is in de Short Tandem Repeats (STR's). Een STR is een korte sequentie van DNA-basen die de neiging heeft talloze keren aansluitend te worden herhaald op specifieke plaatsen in het DNA. Het aantal keren dat een bepaalde STR wordt herhaald varieert sterk van mens tot mens. In de DNA-monsters hieronder, bijvoorbeeld, heeft Alice de STR AGAT vier keer herhaald in haar DNA, terwijl Bob dezelfde STR vijf keer heeft herhaald.

![STR](images/strs.png)

Het gebruik van meerdere STR's in plaats van slechts één kan de nauwkeurigheid van DNA-profilering verbeteren. Als de waarschijnlijkheid dat twee mensen hetzelfde aantal herhalingen hebben voor een enkele STR 5% is, en de analist kijkt naar 10 verschillende STR's, dan is de waarschijnlijkheid dat twee DNA-monsters puur toevallig overeenkomen ongeveer 1 op 1 quadriljoen (ervan uitgaande dat alle STR's onafhankelijk van elkaar zijn). Dus als twee DNA-monsters overeenkomen in het aantal herhalingen voor elk van de STR's, dan kan de analist er vrij zeker van zijn dat ze van dezelfde persoon afkomstig zijn.

CODIS, de [DNA-database](https://www.fbi.gov/services/laboratory/biometric-analysis/codis/codis-and-ndis-fact-sheet) van de FBI, gebruikt 20 verschillende STR's als onderdeel van het DNA-profielproces (in Europa worden tien van deze STR’s gebruikt). In Nederland beheert het Nederlands Forensisch Instituut (NFI) verschillende [DNA-databases](https://dnadatabase.forensischinstituut.nl/dna-databaseen).

### Database

Hoe zou zo'n DNA-database er uit kunnen zien? In zijn eenvoudigste vorm zou je je een DNA database kunnen voorstellen als een CSV (*comma separated values*) bestand, waarin elke rij overeenkomt met een individu, en elke kolom met een bepaalde STR.

```text
name,AGAT,AATG,TATC
Alice,28,42,14
Bob,17,22,19
Charlie,36,18,25
```

De gegevens in bovenstaand bestand suggereren dat Alice ergens in haar DNA de sequentie AGAT 28 keer achtereenvolgens herhaald heeft, de sequentie AATG 42 keer herhaald, en TATC 14 keer herhaald. Bob, ondertussen, heeft diezelfde drie STR's respectievelijk 17 keer, 22 keer en 19 keer herhaald. En Charlie heeft dezelfde drie STR's die respectievelijk 36, 18 en 25 keer worden herhaald.

Dus als je een DNA-reeks hebt, hoe kun je dan bepalen van wie die is? Wel, stel je voor dat je in de DNA-reeks zoekt naar de langste opeenvolgende reeks herhaalde AGAT's en ontdekt dat de langste reeks 17 herhalingen lang is. Als je dan ontdekt dat de langste reeks AATG's 22 herhalingen lang is, en de langste reeks TATC's 19 herhalingen lang is, dan zou dat een vrij goed bewijs zijn dat het DNA van Bob is. Het is natuurlijk ook mogelijk dat wanneer je de tellingen voor elk van de STR's neemt, het niet overeenkomt met iemand in je DNA-database, in welk geval je geen overeenkomst hebt.

In de praktijk weten analisten op welk chromosoom en op welke plaats in het DNA een STR zal worden gevonden, zodat zij hun zoekactie kunnen beperken tot slechts een klein gedeelte van het DNA. Wij negeren dit detail in deze opgave.

## Opdracht

Jouw taak is een programma te schrijven dat een DNA-sequentie en een CSV-bestand met STR-tellingen voor een lijst van personen inleest en vervolgens bepaalt aan wie het DNA (waarschijnlijk) toebehoort.

Vul de klasse `Profile.java` aan, een programma dat identificeert aan wie een DNA-sequentie toebehoort (deze kan je vinden in het projectbestand).

```java
import java.util.Arrays;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.IOException;

public class Profile {

    public static void main(String[] args) {
        // ...
    }

    /**
     * Read a file and return an array of lines
     *
     * @param filename The filename (path) to read
     * @return         An array of lines read
     */
    public static String[] readLines(String filename) {
        String[] data;

        try {
            Path path = Paths.get(filename);
            data = Files.readString(path).strip().split("\n");
        } catch (IOException e) {
            System.out.println("Read error: " + e.getMessage());
            data = new String[0];
        }

        return data;
    }
}
```

```{important}
De import statements zoals gegeven zijn voldoende om het probleem op te lossen, importeer **geen** andere klassen.
```

-   Het programma moet als eerste commandoregelargument de naam van een CSV-bestand vragen dat de STR-tellingen voor een lijst van personen bevat en als tweede commandoregelargument de naam van een tekstbestand dat de te identificeren DNA-sequentie bevat, bijvoorbeeld

    ```console
    > java Profile.java data.csv sequence.txt
    Alice
    ```

-   Jouw programma moet het CSV-bestand openen en de inhoud in het geheugen lezen door gebruik de maken van de methode `readLines`. Je mag aannemen dat de eerste rij van het CSV-bestand de kolomnamen zijn. De eerste kolom zal de woord `name` zijn en de overige kolommen zullen de STR-sequenties zelf zijn.

-   Jouw programma moet de DNA-sequentie openen en de inhoud in het geheugen lezen door gebruik te maken van de methode `readLines`.

-   Voor elk van de STR's (vanaf de eerste regel van het CSV-bestand) moet uw programma de langste reeks opeenvolgende herhalingen van de STR in de te identificeren DNA-sequentie berekenen.

-   Als de STR-tellingen precies overeenkomen met een van de personen in het CSV-bestand, moet jouw programma de naam van de overeenkomende persoon afdrukken.
    -   Je kunt ervan uitgaan dat de STR-tellingen met niet meer dan één persoon overeenkomen.

-   Als de STR-tellingen niet exact overeenkomen met een van de personen in het CSV-bestand moet het programma "No match" afdrukken.


## Mogelijke stappen

### Bestanden inlezen

Een eerste stap zou het CSV-bestand inlezen en verwerken kunnen zijn. De methode `readLines` zal de regels van het bestand inlezen en als `String[]` array teruggeven. Bijvoorbeeld, de inhoud

```text
name,AGAT,AATG,TATC
Alice,5,2,8
Bob,3,7,4
Charlie,6,1,5
```

zal per regel worden ingelezen en zal een array met 4 elementen bevatten:

```java
{
    "name,AGAT,AATG,TATC",
    "Alice,5,2,8",
    "Bob,3,7,4",
    "Charlie,6,1,5"
}
```

Hoe kan je nu de gegevens die je nodig hebt uit deze regels halen? Breek dit probleem op en en implementeer de volgende methoden:

```java
 public static String[] getNames(String[] lines)
 public static int[][] getValues(String[] lines)
 public static String[] getStrs(String[] lines)
```

Elk van deze methoden accepteert de ingelezen bestandsregels `lines` en elk zal een deel van de data uit de tabel als volgt moeten inlezen


```{figure} images/table.png
---
name: data-table-methods
---
CSV-database en bijbehorende methoden
```

Let op, de STR's kunnen per database verschillen, verwacht dus niet dat elke database de waarden uit de bovenstaande figuur bevat (AGAT, AATG, TATC), wat je hier ziet is een voorbeeld!

````{tip}
Elke regel bevat kommagescheiden waarden, gebruik de string `split` methode om de afzonderlijke waarden op te halen. Bijvoorbeeld

```java
"Alice,5,2,8".split(",")
```

levert een `String[]` array op met 4 elementen ("Alice", "5", "2" en "8").
````

### De maximale herhaling van een STR

Tot slot zal je een methode moeten schrijven die het maximum aantal opeenvolgende herhalingen voor een STR bepaalt. Implementeer daarvoor de volgende methode

```java
public static int maxStrRepeat(String str, String sequence)
```

Deze methode heeft als eerste parameter een STR en als tweede parameter een DNA-sequentie. De laatste heb je als tweede argument meegegeven bij de aanroep van jouw programma en heb je eerder al met `readLines` ingelezen. De methode geeft uiteindelijk een `int` terug, het maximum aantal keer dat de STR opeenvolgend in de sequentie voorkomt.

### Combineren

Je zal nu alle methoden hebben om het probleen op te kunnen lossen.

-   bepaal de maximale herhalingen voor STR waarden in de database, gebruik hier de methode `getStrs` om elke STR te doorlopen en de waarde met `maxStrRepeat` te bepalen.
-   met `getValues` haal je de data op die je één voor één doorloopt en vergelijkt met de STR tellingen met die je eerder hebt gevonden.
-   met `getNames` haal je de namen op, als je een match hebt gevonden print je de bijbehorende naam, bij geen match print je "No match"

Bedenk dat je op index de bijbehorende naam voor de gevonden match kan vinden.

```{figure} images/name_data_index.png
---
name: name-data-index
---
Relatie namen en data
```

```{tip}
Arrays vergelijken kan niet met `==`, gebruik hier de methode `Arrays.equals` voor.
```

## Testen

Het projectbestand bevat een aantal STR-databases en DNA-sequenties om mee te testen.

1.  Het volgende geeft als antwoord **Bob**
    ```console
    java Profile.java databases/small.csv sequences/1.txt
    ```

2.  Het volgende geeft als antwoord **No match**
    ```console
    java Profile.java databases/small.csv sequences/2.txt
    ```

3.  Het volgende geeft als antwoord **No match**
    ```console
    java Profile.java databases/small.csv sequences/3.txt
    ```

4.  Het volgende geeft als antwoord **Alice**
    ```console
    java Profile.java databases/small.csv sequences/4.txt
    ```

5.  Het volgende geeft als antwoord **Lavender**
    ```console
    java Profile.java databases/large.csv sequences/5.txt
    ```
6.  Het volgende geeft als antwoord **Luna**
    ```console
    java Profile.java databases/large.csv sequences/6.txt
    ```

7.  Het volgende geeft als antwoord **Ron**
    ```console
    java Profile.java databases/large.csv sequences/7.txt
    ```

8.  Het volgende geeft als antwoord **Ginny**
    ```console
    java Profile.java databases/large.csv sequences/8.txt
    ```

9.  Het volgende geeft als antwoord **Draco**
    ```console
    java Profile.java databases/large.csv sequences/9.txt
    ```

10. Het volgende geeft als antwoord **Albus**
    ```console
    java Profile.java databases/large.csv sequences/10.txt
    ```

11. Het volgende geeft als antwoord **Hermione**
    ```console
    java Profile.java databases/large.csv sequences/11.txt
    ```

12. Het volgende geeft als antwoord **Lily**
    ```console
    java Profile.java databases/large.csv sequences/12.txt
    ```

13. Het volgende geeft als antwoord **No match**
    ```console
    java Profile.java databases/large.csv sequences/13.txt
    ```

14. Het volgende geeft als antwoord **Severus**
    ```console
    java Profile.java databases/large.csv sequences/14.txt
    ```

15. Het volgende geeft als antwoord **Sirius**
    ```console
    java Profile.java databases/large.csv sequences/15.txt
    ```

16. Het volgende geeft als antwoord **No match**
    ```console
    java Profile.java databases/large.csv sequences/16.txt
    ```

17. Het volgende geeft als antwoord **Harry**
    ```console
    java Profile.java databases/large.csv sequences/17.txt
    ```

18. Het volgende geeft als antwoord **No match**
    ```console
    java Profile.java databases/large.csv sequences/18.txt
    ```

19. Het volgende geeft als antwoord **Fred**
    ```console
    java Profile.java databases/large.csv sequences/19.txt
    ```

20. Het volgende geeft als antwoord **No match**
    ```console
    java Profile.java databases/large.csv sequences/20.txt
    ```

---
Copyright © 2020 Brian Yu, David J. Malan