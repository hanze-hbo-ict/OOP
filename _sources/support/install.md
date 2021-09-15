# Hello World in Java

## Installeer Java

Voor het compileren en uitvoeren van Java programma's is een **Java Development Kit** (JDK) nodig. Je zal Java SE Development Kit 11 (JDK 11) gaan gebruiken.

````{important}
Het kan zijn dat je al eerder een JDK hebt geïnstalleerd. Controleer of dit versie 11 (*of hoger*) is. Een eenvoudige manier om dit te controleren is om een *command line* te openen en het volgende commando uit te voeren

```console
> java -version
```

Indien je een foutbericht ziet, of als je niet weet hoe je het bovenstaande moet uitvoeren, volg dan de onderstaande installatiestappen voor jouw besturingssysteem.
````

````{tabbed} Windows
De JDK die wij aanbevelen is OpenJDK, een *open source* implementatie van Java SE (Standard Edition). Ga naar [AdoptOpenJDK](https://adoptopenjdk.net/) en download een versie voor jouw besturingssysteem.

-   Kies OpenJDK 11 LTS (*Long Term Support*).
-   Je kan kiezen voor een JVM (Java Virtual Machine), HotSpot is een goede keus.

:::{attention}
Let op het volgende bij installatie:

-   **Kies** voor `JAVA_HOME` aan het pad toe te laten toevoegen.
-   **Negeer** bij installatie de optie om Oracle licentiesleutels toe te voegen, indien dit wordt gevraagd.
:::
````

````{tabbed} macOS
Indien je een package manager als `brew` gebruikt kan je OpenJDK eenvoudig als volgt installeren:

```console
> brew install openjdk
```

Indien je geen package manager gebruikt, volg dan dezelfde instructies voor installatie als bij Windows.
````

````{tabbed} Linux
Op Linux distributies is OpenJDK eenvoudig te installeren met package managers als `apt` of `yum`. Voor Debian en afgeleide distributies (bijvoorbeeld Ubuntu of Linux Mint) installeer je als volgt de meest recente OpenJDK versie:

```console
> sudo apt-get install default-jdk
```
````

## Editor

Java programma's kunnen met elke teksteditor worden geschreven, wij raden IntelliJ IDEA aan, een ontwikkelomgeving (een IDE, of *Integrated Development Environment*) specifiek voor Java en op dit moment één van de meest gebruikte toepassingen voor het schrijven van Java programma's.

-   Ga naar [JetBrains](https://www.jetbrains.com/idea/download/) en download & installeer **IntelliJ IDEA Community Edition** voor jouw besturingssysteem.

```{admonition} Andere editors
Het kan bijvoorbeeld zijn dat je eerder met [Visual Studio Code](https://code.visualstudio.com/) (VSCode) hebt gewerkt en dit ook voor Java zou willen gebruiken. Je zal dan VSCode moeten uitbreiden met functionaliteit specifiek voor Java. Het [Java Extension Pack](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack) is in dit geval een bundel van nuttige Java extensies om aan VSCode toe te voegen.

Let op, in deze cursus zal in de voorbeelden en opgaven worden uitgegaan van IntelliJ als standaardeditor voor Java, maar dit is niet verplicht en je mag een andere editor of IDE gebruiken als je wilt (maar wordt niet door ons ondersteund!).
```

## Open een project in IntelliJ

Je gaat Java-programma's ontwikkelen in *IntelliJ IDEA Community Edition*.

IntelliJ ordent Java-programma's in projecten. In deze cursus komt elk project overeen met één programmeeropdracht. Een typisch project bevat Java-programma's, bijbehorende gegevensbestanden en cursus-specifieke instellingen (zoals compileropties, stijlregels en bibliotheken, of *class libraries*).

```{admonition} Ik begrijp dit niet!
Maak je geen zorgen als je nog niet weet wat bijvoorbeeld met *compileren*, *compileropties* of *class libraries* wordt bedoeld. De betekenis zal duidelijker worden naarmate de cursus vordert.
```

Voor elke opdracht ga je een startproject downloaden waarin jij jouw programmacode gaat schrijven.

-   Download het volgende project voor de eerste programmeeropdracht naar een handige locatie (zoals bijvoorbeeld het *Bureaublad*).

    <!-- use anchor since it refers to a build file -->
    -   <a href="../projects/hello.zip">hello.zip</a>

    Pak het project als volgt uit voor jouw besturingssysteem:

    ````{tabbed} Windows
    Om het zip-bestand uit te pakken, klik je er met de rechtermuisknop op en kies je *Alles uitpakken*. Hierdoor wordt een projectmap aangemaakt met de naam van de bijbehorende programmeeropdracht (in dit geval `hello`). Het zip-bestand kan je nu verwijderen.
    ````

    ````{tabbed} macOS
    **Dubbelklik** op het zip-bestand om het uit te pakken. Hierdoor wordt een projectmap aangemaakt met de naam van de bijbehorende programmeeropdracht (in dit geval `hello`). Het zip-bestand kan je nu verwijderen.
    ````

    ````{tabbed} Linux
    Pak het zip-bestand uit met het volgende commando:

    ```console
    > unzip -d hello hello.zip
    ```

    Hierdoor wordt een projectmap aangemaakt met de naam van de bijbehorende programmeeropdracht (in dit geval `hello`). Het zip-bestand kan je nu verwijderen.
    ````

-   Start IntelliJ:

-   Wanneer je IntelliJ voor de eerste keer start,

    -   kan *IntelliJ* he [JetBrains privacybeleid](https://www.jetbrains.com/company/privacy.html) weergeven. Scroll naar beneden en *accepteer*.
    -   kan *IntelliJ* vragen of je anonieme gebruiksstatistieken naar *JetBrains* wilt sturen. Kies de gewenste optie.
    -   zal *IntelliJ* een welkomstscherm tonen (*Welkom bij IntelliJ IDEA*).

-   Om een project te openen vanuit het welkomstscherm, klikt je op **Openen**

    ```{figure} images/intellij_welcome.png
    :name: intellij-welcome

    Intellij welkomstscherm
    ```

    Selecteer vervolgens de projectmap.

    ```{figure} images/intellij_select_project.png
    :name: intellij-select-project

    Selecteer de projectmap
    ```

    Wanneer je IntelliJ voor de eerste keer opstart kan het een minuut of twee duren om bestanden te *indexeren*, sommige functies (zoals automatisch importeren) zullen niet beschikbaar zijn totdat dit proces is voltooid.

    ```{warning}
    Klik niet op **Nieuw Project**, deze optie is bedoeld voor gevorderde gebruikers. Gebruik ook altijd **Openen**  met een projectmap, *niet* met een individueel bestand.
    ```

## Maak een programma in IntelliJ

Nu bent je klaar om uw eerste Java programma te schrijven. IntelliJ heeft veel gespecialiseerde programmeerhulpmiddelen, zoals regelnummering, syntax highlighting, bracket matching, auto indenting, auto formatting, auto importing, variable renaming, en continue code inspectie.

-   Om een nieuw Java programma te maken:

    -   Open *IntelliJ* en het project opnieuw (als je het in de vorige stap hebt gesloten).

    ```{figure} images/intellij_select_project_2.png
    :name: intellij-select-project_2

    Open het project
    ```

    -   Klik op de projectnaam in de *Project View* zijbalk (links), zodat deze gemarkeerd wordt. <!--TODO LIFT specifiek, maak algemeen -->

        <!-- TODO screenshot -->

    -   Selecteer de menu-optie LIFT → Nieuwe Java Klasse. Als daar om gevraagd wordt, typ dan **HelloWorld** als naam en klik op **OK**.

-   Maak in het hoofdvenster van de editor het Java-programma `HelloWorld.java` precies zoals het er hieronder uitziet. (IntelliJ genereert de grijze boilerplate code automatisch, eventueel met toevoeging van een course header block commentaar).

    ```{code-block} java
    ---
    emphasize-lines: 3
    ---
    public class HelloWorld {
        public static void main(String[] args) {
            System.out.println("Hello, World");
        }
    }
    ```

    Als je zelfs maar een puntkomma weglaat, zal het programma niet werken!

-   Terwijl je typt zal *IntelliJ* verschillende syntactische elementen in verschillende kleuren markeren. Wanneer je een haakje links typt, voegt *IntelliJ* het bijbehorende haakje rechts toe. Wanneer je een nieuwe regel begint, laat *IntelliJ* deze inspringen.

    <!-- TODO screenshot -->

-   Om het bestand op te slaan kies je de menuoptie **Bestand → Alles opslaan (Ctrl + S)**. Wanneer u het bestand opslaat, formatteert *IntelliJ* het (indien nodig) opnieuw.

    ```{tip}
    *IntelliJ* is zo ingesteld dat wijzigingen die je in jouw bestanden aanbrengt automatisch worden opgeslagen bij verschillende gebeurtenissen (zoals compileren, uitvoeren, sluiten van een bestand of project, of het afsluiten van de IDE). We raden nog steeds aan om **Bestand → Alles opslaan (Ctrl + S)** te gebruiken om uw code opnieuw te formatteren.
    ```

<!-- TODO meer algemeen beschrijven

## Compileren en uitvoeren

Nu is het tijd om jouw programma uit te voeren (te draaien, of "runnen"). Dit is het meest spannende gedeelte, waarbij de computer de instructies volgt die jij in jouw programma hebt gespecificeerd. Alvorens dit te doen, zal je het programma moeten *compileren* in een vorm die beter geschikt is om door een computer uit te coeren.

De commandline is een eenvoudig en krachtig manier om jouw programma's te besturen (bijv. commandline argumenten, *file redirection*, en piping). IntelliJ biedt een ingebouwde terminal voor eenvoudige toegang tot de commandoregel.

Selecteer de menu optie Beeld → Gereedschapsvenster → Terminal (Alt + 2).
Dit zal een terminal starten waar je commando's kunt typen. Je zult een opdrachtprompt zien die er ongeveer zo uitziet:

-   Selecteer het programma dat je wilt compileren en uitvoeren in de *Project View* zijbalk. Het programma zou nu in het hoofdvenster van de editor moeten verschijnen.

-   Om je programma te compileren, selecteer je de menu-optie LIFT → Hercompileer 'HelloWorld.java' (Ctrl + B). Als de compilatie slaagt, krijg je een bevestiging in de statusbalk (onderaan).

    <!-- TODO screenshot -- >

Als de compilatie mislukt opent een Recompile-paneel (onderaan), waarin de compileerfouten of waarschuwingen worden aangegeven. Controleer je programma zorgvuldig op typefouten en gebruik de foutmeldingen als leidraad.

-   Om je programma uit te voeren, selecteer je de menu-optie LIFT → Run 'HelloWorld' with Arguments (Ctrl + E). Aangezien dit programma geen command-line argumenten nodig heeft, klik OK.

### IntelliJ

### Commandline

-->