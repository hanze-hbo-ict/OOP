# Rekenmachine

Gegeven is de code voor een simpele klasse voor een rekenmachine.

```java
public class Calculation {
    private double[] operands;
    private char operator;

    public Calculation(double[] operands, char operator) {
        this.operands = operands;
        this.operator = operator;
        if (operands.length != 2) {
            throw new IllegalArgumentException("operands");
        }
    }

    public double calculate() {
        if (operator == '+') {
            return operands[0] + operands[1];
        } else {
            return operands[0] - operands[1];
        }
    }

    public String toString() {
        return operands[0] + " " + operator + " " + operands[1];
    }
}
```

De bijbehorende `main`-functie ziet er als volgt uit:

```java
public static void main(String[] args) {
    Calculation a = new Calculation(new double[]{2.0, 3.0}, '+');
    System.out.println(a + " = " + a.calculate());
}
```

# Opgave 1

Zoals je ziet is deze klasse nog niet compleet. Voeg, om even met
deze klasse te oefenen, nog de operators `*` (vermenigvuldigen) en `/` (delen) toe.
Test deze operators ook in de methode `main`.

# Opgave 2

Naast de klassieke 4 operatoren die we nu hebben geïmplementeerd,
ondersteunen rekenmachines ook vaak de operator machtsverheffen.
In veel programmeertalen wordt hiervoor het teken `**` gebruikt. Omdat
onze klasse een `char` gebruikt als operator, kan dit niet; gebruik daarom `^`.
Je mag de ingebouwde methode `Math.pow` gebruiken voor je implementatie.
Test vervolgens deze operator in de methode `main`.

# Opgave 3

Naast de algemene operator machtsverheffen hebben rekenmachines vaak speciale
knoppen voor kwadrateren (x²) en worteltrekken. Deze operators zijn anders
dan de eerdere operatoren, omdat ze maar een enkele operand hebben. Implementeer
deze operatoren en test ze in de methode `main`. Gebruik voor worteltrekken de ingebouwde methode
`Math.sqrt`.

# Strategy pattern

We hebben gezien dat we steeds meer takken aan het `if`-statement moeten toevoegen
voor de opgaves. Bovendien moeten we operator-specifieke logica toevoegen aan de
constructor. Dit is op grotere schaal niet handig. We zullen daarom het *strategy
pattern* toepassen. We gaan een interface maken voor operators, zodat we niet meer
aan de limiet van een `char` gebonden zijn, waardoor elke operator zijn eigen
berekeningen kan maken en kan aangeven wat zijn *ariteit* is, het aantal operanden wat
hij heeft (dit is bijvoorbeeld 2 voor optellen, maar 1 voor worteltrekken).

De interface ziet er als volgt uit:

```java
public interface Operator {
    int arity();
    double calculate(double[] operands);
}
```

Een voorbeeldimplementatie is de operator voor optellen, `Sum`:

```java
public class Sum implements Operator {

    @Override
    public int arity() {
        return 2;
    }

    @Override
    public double calculate(double[] operands) {
        return operands[0] + operands[1];
    }

    @Override
    public String toString() {
        return "+";
    }
}
```

Merk op dat we naast de twee interfacemethodes ook `Object.toString` overriden
zodat we kunnen aangeven hoe de operator weergegeven moet worden.

# Opgave 4

Pas de klasse `Calculation` aan zodat deze objecten van het type `Operator` gebruikt
als operator in plaats van een `char`. Laat de berekening uitgevoerd worden
door de operator zelf, en pas ook de controle op de arraygrootte in de constructor en
de methode `toString` aan om met `Operator` en zijn methodes te werken.

Een voorbeeldaanroep van de vernieuwde versie in de `main`-methode is als volgt:

```java
Calculation a = new Calculation(new double[]{2.0, 3.0}, new Sum());
System.out.println(a + " = " + a.calculate());
```

Je ziet dat nu `new Sum()` wordt gebruikt in plaats van `'+'`.

# Opgave 5

Implementeer de overige operators die je eerder hebt geïmplementeerd als klassen
die `Operator` implementeren. Pas ook de methode `main` aan om ze te testen.

# Opgave 6

Naast de eerder geïmplementeerde operatoren ondersteunen rekenmachines ook
de zogeheten *trigonometrische* operatoren `sin`, `cos` en `tan` die gebruikt kunnen
worden bij berekeningen van hoeken in driehoeken. Deze operatoren hebben
allemaal slechts één operand. Implementeer deze operatoren als klassen die
de interface `Operator` implementeren. Je hoeft deze operatoren niet
verder te doorgronden; je mag voor de berekeningen de methodes `Math.sin`, `Math.cos`
en `Math.tan` gebruiken. Pas ook de methode `main` aan om deze operatoren te testen.
