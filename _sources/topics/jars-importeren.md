# Externe bibliotheken gebruiken

Vaak wil je in je applicatie gebruik maken van een stuk progammacode die door iemand anders is gemaakt. Veel personen, organisaties en bedrijven publiceren dergelijke code door middel van sites zoals [maven]() of [gradle](), waarmee dergelijke bibliotheken automatisch aan je project worden toegevoegd (zogenaamde [dependecy managers]()). Maar vaak kom je op internet ook gewoon een stuk code tegen die in een zogenaamde *Java Archive*, een *jar* is verpakt. Deze moet je dan met de hand aan je project toevoegen.

We laten die even zien aan de hand van `StdLib`, die je ook bij de practica nodig hebt.

Download [stdlib.jar](https://introcs.cs.princeton.edu/java/stdlib/stdlib.jar) en zet hem ergens neer waar je hem weer terug kunt vinden. Maak een nieuw project aan in IntelliJ. Klik op `File->Project Structure` en selecteer in het venster wat nu verschijnt op `Libraries`.

![Project Structure](../images/jar-toevoegen-1.png)

![Libraries](../images/jar-toevoegen-2.png)

Klik op het plusje linksboven en selecteer daar `Java`. Navigeer nu naar de `stdlib.jar` die je zojuist hebt gedownload. Klik `Ok` om de jar toe te voegen aan de huidige module.

Maak nu, om de boel te testen, een klasse met een `main` aan en zet daarin de onderstaande code (naar [de testcode uit de documentatie zelf](https://introcs.cs.princeton.edu/java/stdlib/javadoc/StdDraw.html)):

```java

  public static void main(String[] args) {
           StdDraw.setPenRadius(0.05);
           StdDraw.setPenColor(StdDraw.BLUE);
           StdDraw.point(0.5, 0.5);
           StdDraw.setPenColor(StdDraw.MAGENTA);
           StdDraw.line(0.2, 0.2, 0.8, 0.2);
       }

```

Als het goed is, compileert dit programma zonder problemen en krijg je, wanneer je het runt, een balkje en een cirkel te zien.

![Het eindresultaat](../images/jar-toevoegen-3.png)

